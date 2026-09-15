package com.ruoyi.common.edoc;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.Base64;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.ruoyi.common.config.EdocProperties;
import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.sign.Md5Utils;

/**
 * edoc2 ECM 开放平台底层客户端。
 *
 * <p>参考 {@code edoc常用接口文档.txt}：
 * <ul>
 *   <li>每次主动调用接口都要在 HTTP Header 带 BASIC 认证
 *       （Base64(username:password)），由开放平台统一鉴权（含 IP 白名单）。</li>
 *   <li>POST JSON 接口需设置 Content-Type: application/json。</li>
 *   <li>token 通过集成登录接口获取，{@code userIdMD5 = MD5(userId)}。</li>
 * </ul>
 *
 * <p>内置能力：
 * <ul>
 *   <li>BASIC 认证 + token 缓存；token 失效后自动重新登录并重试一次。</li>
 *   <li>GET/POST JSON 通用调用。</li>
 *   <li>三步文件上传（10M 以内）：StartUploadFile → UploadFileBlock → EndUploadFile。</li>
 *   <li>根据 fileId 下载文件到本地。</li>
 * </ul>
 *
 * @author ruoyi
 */
@Component
public class EdocClient
{
    private static final Logger log = LoggerFactory.getLogger(EdocClient.class);

    @Autowired
    private EdocProperties props;

    /** 缓存的 token */
    private volatile String cachedToken;

    private final SSLSocketFactory sslSocketFactory;
    private final HostnameVerifier hostnameVerifier;

    public EdocClient()
    {
        this.sslSocketFactory = createTrustAllSocketFactory();
        this.hostnameVerifier = new TrustAllHostnameVerifier();
    }

    // ============================== token ==============================

    /**
     * 获取可用 token：优先用缓存，没有则登录。
     */
    public String getToken()
    {
        String t = cachedToken;
        if (t != null && !t.isEmpty())
        {
            return t;
        }
        return login();
    }

    /**
     * 强制重新登录，刷新缓存 token。
     *
     * @return 新 token
     */
    public synchronized String login()
    {
        if (!props.isEnabled())
        {
            throw new ServiceException("edoc 对接未启用（edoc.enabled=false）");
        }
        String userId = props.getUserId();
        String userIdMd5 = Md5Utils.hash(userId);
        String url;
        try
        {
            url = props.getTokenUrl() + "?userIdMD5=" + URLEncoder.encode(userIdMd5, "UTF-8");
        }
        catch (Exception e)
        {
            throw new ServiceException("edoc 登录地址编码失败: " + e.getMessage());
        }

        log.info("edoc 登录获取 token, userId={}", userId);
        HttpURLConnection conn = null;
        try
        {
            conn = openConnection(url, "GET", null, false);
            int code = conn.getResponseCode();
            String body = readAll(conn, code);
            if (code < 200 || code >= 300)
            {
                throw new ServiceException("edoc 登录失败, HTTP " + code + ", body=" + body);
            }
            JSONObject json = JSON.parseObject(body);
            // 文档：code=1 代表成功，0 代表失败
            Integer rc = json.getInteger("code");
            if (rc != null && rc == 1)
            {
                String token = json.getString("token");
                if (token == null || token.isEmpty())
                {
                    throw new ServiceException("edoc 登录返回 token 为空: " + body);
                }
                cachedToken = token;
                log.info("edoc 登录成功, token={}", maskToken(token));
                return token;
            }
            throw new ServiceException("edoc 登录失败: " + body);
        }
        catch (IOException e)
        {
            throw new ServiceException("edoc 登录网络异常: " + e.getMessage());
        }
        finally
        {
            if (conn != null)
            {
                conn.disconnect();
            }
        }
    }

    /**
     * 清除缓存的 token（登录过期等场景调用，下次请求会自动重新登录）。
     */
    public void clearToken()
    {
        cachedToken = null;
    }

    // ============================== 通用 JSON 调用 ==============================

    /**
     * 调用 /api/services/* 下的 GET 接口（token 自动拼到 query）。
     */
    public JSONObject getApi(String apiPath, Map<String, ?> query)
    {
        return callJsonApi("GET", apiPath, query, null);
    }

    /**
     * 调用 /api/services/* 下的 POST JSON 接口。
     */
    public JSONObject postApi(String apiPath, Object body)
    {
        return callJsonApi("POST", apiPath, null, body);
    }

    private JSONObject callJsonApi(String method, String apiPath, Map<String, ?> query, Object body)
    {
        // 最多尝试两次：第一次用缓存 token，若判定为 token 失效则重新登录后再试一次
        for (int attempt = 0; attempt < 2; attempt++)
        {
            String token = getToken();
            Map<String, Object> q = new LinkedHashMap<>();
            if (query != null)
            {
                q.putAll(query);
            }
            q.put("token", token);

            String url = buildGatewayUrl(apiPath, q);
            HttpTextResult result;
            try
            {
                result = doHttp(method, url, body == null ? null : JSON.toJSONString(body),
                        "application/json;charset=UTF-8", false);
            }
            catch (IOException e)
            {
                throw new ServiceException("edoc 接口[" + apiPath + "]网络异常: " + e.getMessage());
            }

            // HTTP 401/403 视为 token 失效
            if ((result.httpCode == 401 || result.httpCode == 403) && attempt == 0)
            {
                log.warn("edoc 接口[{}]返回 {}，判定 token 失效，重新登录后重试", apiPath, result.httpCode);
                clearToken();
                continue;
            }
            if (result.httpCode < 200 || result.httpCode >= 300)
            {
                throw new ServiceException("edoc 接口[" + apiPath + "]失败, HTTP "
                        + result.httpCode + ", body=" + result.text);
            }

            JSONObject json = result.text == null || result.text.isEmpty()
                    ? new JSONObject() : JSON.parseObject(result.text);

            // 业务层 token 失效：result 非 0 且 message 提示 token/登录
            if (attempt == 0 && isTokenInvalid(json))
            {
                log.warn("edoc 接口[{}]判定 token 失效：{}，重新登录后重试", apiPath, result.text);
                clearToken();
                continue;
            }
            return json;
        }
        throw new ServiceException("edoc 接口[" + apiPath + "]重试后仍失败");
    }

    /**
     * 判断业务返回是否为 token 失效（edoc2 错误码表未随文档提供，
     * 这里用 result/message 关键字兜底）。
     */
    private boolean isTokenInvalid(JSONObject json)
    {
        if (json == null)
        {
            return false;
        }
        Integer result = json.getInteger("result");
        // result=0 成功；部分接口 code=1 成功
        if (result != null && result == 0)
        {
            return false;
        }
        Integer code = json.getInteger("code");
        if (code != null && code == 1 && (result == null || result == 0))
        {
            return false;
        }
        String msg = json.getString("message");
        if (msg == null)
        {
            msg = json.getString("reason");
        }
        if (msg == null)
        {
            return false;
        }
        String lower = msg.toLowerCase();
        return lower.contains("token") || lower.contains("登录") || lower.contains("过期")
                || lower.contains("失效") || lower.contains("未登录") || lower.contains("login");
    }

    // ============================== 文件上传（推荐：WebCore + document/upload） ==============================

    /**
     * 上传文件（推荐方式，见文档 13.2）。
     *
     * <p>分两步：
     * <ol>
     *   <li>{@code POST /WebCore?token=}：提交上传请求（form 表单），返回 RegionId/RegionHash 等；</li>
     *   <li>{@code POST /document/upload?token=}：multipart/form-data 传输文件二进制流。</li>
     * </ol>
     * 第二步若服务端返回 {@code tag=true} 表示秒传，无需再传后续块（本方法一次性传整个文件）。
     *
     * @param folderId 目标文件夹 ID
     * @param fileName 文件名（含扩展名，如 xxx.pdf）
     * @param content  文件字节
     * @param remark   文件备注（可为空）
     * @return edoc2 文件 ID（data.FileId）
     */
    public long uploadFile(long folderId, String fileName, byte[] content, String remark)
    {
        if (content == null || content.length == 0)
        {
            throw new ServiceException("edoc 上传文件内容为空");
        }

        // token 失效时整体重试一次
        for (int attempt = 0; attempt < 2; attempt++)
        {
            String token = getToken();
            try
            {
                // ---- 第一步：发送上传请求 ----
                Map<String, String> form = new LinkedHashMap<>();
                form.put("module", "RegionDocOperationApi");
                form.put("fun", "CheckAndCreateDocInfo");
                form.put("folderId", String.valueOf(folderId));
                form.put("fileName", fileName);
                form.put("fileRemark", remark == null ? "" : remark);
                form.put("size", String.valueOf(content.length));
                form.put("attachType", "0");
                form.put("fileModel", "UPLOAD");
                form.put("fileMd5", md5Hex(content));
                form.put("isUpdateFileVersion", "false");

                String webcoreBase = trimTrailingSlash(props.getWebcoreUrl());
                String step1Url = webcoreBase + "/WebCore?token=" + enc(token);
                HttpTextResult step1 = doHttp("POST", step1Url,
                        buildFormUrlEncoded(form),
                        "application/x-www-form-urlencoded;charset=UTF-8", false);

                if ((step1.httpCode == 401 || step1.httpCode == 403) && attempt == 0)
                {
                    log.warn("edoc WebCore 返回 {}，token 失效，重新登录后重试", step1.httpCode);
                    clearToken();
                    continue;
                }
                if (step1.httpCode < 200 || step1.httpCode >= 300)
                {
                    throw new ServiceException("edoc WebCore 上传请求失败, HTTP "
                            + step1.httpCode + ", body=" + step1.text);
                }
                JSONObject step1Json = JSON.parseObject(step1.text);
                Integer result = step1Json.getInteger("result");
                if (result == null || result != 0)
                {
                    if (attempt == 0 && isTokenInvalid(step1Json))
                    {
                        clearToken();
                        continue;
                    }
                    throw new ServiceException("edoc WebCore 上传请求失败: " + step1.text);
                }
                JSONObject data = step1Json.getJSONObject("data");
                if (data == null)
                {
                    throw new ServiceException("edoc WebCore 返回 data 为空: " + step1.text);
                }
                Long fileId = data.getLong("FileId");
                Long regionId = data.getLong("RegionId");
                String regionHash = data.getString("RegionHash");
                Integer regionType = data.getInteger("RegionType");
                String regionUrl = data.getString("RegionUrl");

                // ---- 第二步：传输文件流 ----
                // RegionType=1 主区域：用当前站点；RegionType=2 分区域：用返回的 RegionUrl
                String uploadServer = (regionType != null && regionType == 2
                        && regionUrl != null && !regionUrl.isEmpty())
                        ? trimTrailingSlash(regionUrl) : webcoreBase;
                String step2Url = uploadServer + "/document/upload?token=" + enc(token);

                String uploadId = UUID.randomUUID().toString();
                HttpTextResult step2 = doMultipartUpload(step2Url, uploadId,
                        regionHash, regionId, fileName, content);

                if ((step2.httpCode == 401 || step2.httpCode == 403) && attempt == 0)
                {
                    log.warn("edoc document/upload 返回 {}，token 失效，重新登录后重试", step2.httpCode);
                    clearToken();
                    continue;
                }
                if (step2.httpCode < 200 || step2.httpCode >= 300)
                {
                    throw new ServiceException("edoc document/upload 失败, HTTP "
                            + step2.httpCode + ", body=" + step2.text);
                }
                JSONObject step2Json = JSON.parseObject(step2.text);
                String status = step2Json.getString("status");
                if ("Error".equalsIgnoreCase(status))
                {
                    throw new ServiceException("edoc 上传文件流出错: " + step2Json.getString("message"));
                }
                // status=End 或 tag=true 均表示完成
                if (fileId == null)
                {
                    fileId = step2Json.getLong("fileId");
                }
                if (fileId == null)
                {
                    throw new ServiceException("edoc 上传成功但未获取到文件 ID: " + step2.text);
                }
                log.info("edoc 文件上传成功, fileId={}, name={}, size={}, tag={}",
                        fileId, fileName, content.length, step2Json.get("tag"));
                return fileId;
            }
            catch (IOException e)
            {
                throw new ServiceException("edoc 上传网络异常: " + e.getMessage());
            }
        }
        throw new ServiceException("edoc 上传重试后仍失败");
    }

    /**
     * 构造 multipart/form-data 请求体并发送文件二进制流。
     */
    private HttpTextResult doMultipartUpload(String url, String uploadId, String regionHash,
                                             Long regionId, String fileName, byte[] content)
            throws IOException
    {
        String boundary = "----RuoYiEdocBoundary" + System.currentTimeMillis();
        String CRLF = "\r\n";
        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        writeFormField(bos, boundary, "uploadId", uploadId, CRLF);
        writeFormField(bos, boundary, "regionHash", regionHash == null ? "" : regionHash, CRLF);
        writeFormField(bos, boundary, "regionId", regionId == null ? "" : String.valueOf(regionId), CRLF);
        writeFormField(bos, boundary, "fileName", fileName, CRLF);
        writeFormField(bos, boundary, "size", String.valueOf(content.length), CRLF);
        writeFormField(bos, boundary, "fileMd5", md5Hex(content), CRLF);
        writeFormField(bos, boundary, "chunkSize", String.valueOf(content.length), CRLF);
        writeFormField(bos, boundary, "blockSize", String.valueOf(content.length), CRLF);
        writeFormField(bos, boundary, "isUpdateFileVersion", "false", CRLF);

        // 文件二进制部分
        StringBuilder sb = new StringBuilder();
        sb.append("--").append(boundary).append(CRLF);
        sb.append("Content-Disposition: form-data; name=\"file\"; filename=\"")
                .append(safeHeaderFileName(fileName)).append("\"").append(CRLF);
        sb.append("Content-Type: application/octet-stream").append(CRLF).append(CRLF);
        bos.write(sb.toString().getBytes(StandardCharsets.UTF_8));
        bos.write(content);
        bos.write(CRLF.getBytes(StandardCharsets.UTF_8));

        // 结束边界
        bos.write(("--" + boundary + "--" + CRLF).getBytes(StandardCharsets.UTF_8));
        byte[] body = bos.toByteArray();

        HttpURLConnection conn = openConnection(url, "POST",
                "multipart/form-data; boundary=" + boundary, false);
        conn.setFixedLengthStreamingMode(body.length);
        try (OutputStream os = conn.getOutputStream())
        {
            os.write(body);
        }
        try
        {
            HttpTextResult r = new HttpTextResult();
            r.httpCode = conn.getResponseCode();
            r.text = readAll(conn, r.httpCode);
            return r;
        }
        finally
        {
            conn.disconnect();
        }
    }

    private static void writeFormField(ByteArrayOutputStream bos, String boundary,
                                       String name, String value, String CRLF) throws IOException
    {
        StringBuilder sb = new StringBuilder();
        sb.append("--").append(boundary).append(CRLF);
        sb.append("Content-Disposition: form-data; name=\"").append(name).append("\"").append(CRLF);
        sb.append(CRLF).append(value == null ? "" : value).append(CRLF);
        bos.write(sb.toString().getBytes(StandardCharsets.UTF_8));
    }

    private String buildFormUrlEncoded(Map<String, String> form)
    {
        StringBuilder sb = new StringBuilder();
        boolean first = true;
        for (Map.Entry<String, String> e : form.entrySet())
        {
            if (e.getValue() == null)
            {
                continue;
            }
            if (!first)
            {
                sb.append('&');
            }
            sb.append(enc(e.getKey())).append('=').append(enc(e.getValue()));
            first = false;
        }
        return sb.toString();
    }

    private static String safeHeaderFileName(String fileName)
    {
        // multipart 文件名中避免换行、引号
        if (fileName == null)
        {
            return "file";
        }
        return fileName.replaceAll("[\\r\\n\"]", "_");
    }

    // ============================== 文件下载 ==============================

    /**
     * 根据 fileId 从 edoc2 下载文件，返回字节数组。
     *
     * <p>走 ECM 的 {@code /document/download} 接口（与上传的 /document/upload 对应），
     * token 作为 query 参数；token 失效时自动重新登录并重试一次。
     *
     * @param fileId 文件 ID
     * @return 文件字节
     */
    public byte[] downloadFile(long fileId)
    {
        for (int attempt = 0; attempt < 2; attempt++)
        {
            String token = getToken();
            String base = trimTrailingSlash(props.getEcmUrl());
            String path = props.getDownloadPath();
            String url = base + path + "?token=" + enc(token)
                    + "&fileId=" + fileId;

            HttpTextResult result;
            try
            {
                result = doHttp("GET", url, null, null, true);
            }
            catch (IOException e)
            {
                throw new ServiceException("edoc 下载文件网络异常, fileId=" + fileId + ", " + e.getMessage());
            }

            // 401/403 → token 失效重试
            if ((result.httpCode == 401 || result.httpCode == 403) && attempt == 0)
            {
                log.warn("edoc 下载返回 {}，token 失效，重新登录后重试, fileId={}", result.httpCode, fileId);
                clearToken();
                continue;
            }
            if (result.httpCode < 200 || result.httpCode >= 300)
            {
                throw new ServiceException("edoc 下载失败, fileId=" + fileId + ", HTTP "
                        + result.httpCode + ", body=" + (result.binary == null ? result.text
                                : result.binary.length + " bytes"));
            }
            if (result.binary == null || result.binary.length == 0)
            {
                throw new ServiceException("edoc 下载内容为空, fileId=" + fileId);
            }
            log.info("edoc 文件下载成功, fileId={}, size={}", fileId, result.binary.length);
            return result.binary;
        }
        throw new ServiceException("edoc 下载重试后仍失败, fileId=" + fileId);
    }

    /**
     * 下载文件到指定目录，文件名由调用方决定。
     */
    public File downloadToFile(long fileId, File targetFile)
    {
        byte[] data = downloadFile(fileId);
        try
        {
            File parent = targetFile.getParentFile();
            if (parent != null && !parent.exists())
            {
                parent.mkdirs();
            }
            Files.write(targetFile.toPath(), data);
            return targetFile;
        }
        catch (IOException e)
        {
            throw new ServiceException("edoc 下载文件写入失败: " + e.getMessage());
        }
    }

    // ============================== 业务辅助 ==============================

    /**
     * 判断指定文件夹下是否存在指定名字的文件夹，存在返回文件夹 ID，不存在返回 -1。
     */
    public long getFolderIdByName(long parentFolderId, String folderName)
    {
        Map<String, Object> q = new LinkedHashMap<>();
        q.put("folderName", folderName);
        q.put("folderId", parentFolderId);
        JSONObject resp = getApi("/api/services/Folder/GetFolderIdInFolderByfolderName", q);
        ensureApiSuccess(resp, "GetFolderIdInFolderByfolderName");
        Long id = resp.getLong("data");
        return id == null ? -1L : id;
    }

    /**
     * 创建文件夹。
     */
    public long createFolder(long parentFolderId, String name, String remark)
    {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("token", getToken());
        body.put("name", name);
        body.put("parentFolderId", parentFolderId);
        body.put("remark", remark == null ? "" : remark);
        JSONObject resp = postApi("/api/services/Folder/CreateFolder", body);
        ensureApiSuccess(resp, "CreateFolder");
        JSONObject data = resp.getJSONObject("data");
        if (data == null || data.getLong("folderId") == null)
        {
            throw new ServiceException("edoc 创建文件夹未返回 folderId: " + resp);
        }
        return data.getLong("folderId");
    }

    private void ensureApiSuccess(JSONObject resp, String api)
    {
        if (resp == null)
        {
            throw new ServiceException("edoc " + api + " 返回为空");
        }
        Integer result = resp.getInteger("result");
        // 登录类接口用 code=1；业务接口用 result=0
        if (result != null && result != 0)
        {
            throw new ServiceException("edoc " + api + " 失败: result=" + result
                    + ", message=" + resp.getString("message"));
        }
    }

    // ============================== HTTP 底层 ==============================

    private String buildGatewayUrl(String apiPath, Map<String, ?> query)
    {
        StringBuilder sb = new StringBuilder(trimTrailingSlash(props.getGatewayUrl()));
        if (!apiPath.startsWith("/"))
        {
            sb.append('/');
        }
        sb.append(apiPath);
        if (query != null && !query.isEmpty())
        {
            sb.append('?');
            boolean first = true;
            for (Map.Entry<String, ?> e : query.entrySet())
            {
                if (e.getValue() == null)
                {
                    continue;
                }
                if (!first)
                {
                    sb.append('&');
                }
                sb.append(enc(e.getKey())).append('=').append(enc(String.valueOf(e.getValue())));
                first = false;
            }
        }
        return sb.toString();
    }

    private HttpTextResult doHttp(String method, String url, String body, String contentType, boolean binary)
            throws IOException
    {
        HttpURLConnection conn = openConnection(url, method, contentType, binary);
        try
        {
            if (body != null)
            {
                byte[] bytes = body.getBytes(StandardCharsets.UTF_8);
                conn.setFixedLengthStreamingMode(bytes.length);
                try (OutputStream os = conn.getOutputStream())
                {
                    os.write(bytes);
                }
            }
            int code = conn.getResponseCode();
            HttpTextResult r = new HttpTextResult();
            r.httpCode = code;
            if (binary)
            {
                // 下载：只要 2xx 就读取字节流，否则尝试读错误文本
                if (code >= 200 && code < 300)
                {
                    try (InputStream is = conn.getInputStream())
                    {
                        r.binary = readBytes(is);
                    }
                }
                else
                {
                    r.text = readErrorAll(conn);
                }
            }
            else
            {
                r.text = readAll(conn, code);
            }
            return r;
        }
        finally
        {
            conn.disconnect();
        }
    }

    private HttpURLConnection openConnection(String url, String method, String contentType, boolean binary)
            throws IOException
    {
        URL u = new URL(url);
        HttpURLConnection conn = (HttpURLConnection) u.openConnection();
        if (conn instanceof HttpsURLConnection)
        {
            HttpsURLConnection https = (HttpsURLConnection) conn;
            if (sslSocketFactory != null)
            {
                https.setSSLSocketFactory(sslSocketFactory);
            }
            https.setHostnameVerifier(hostnameVerifier);
        }
        conn.setRequestMethod(method);
        conn.setConnectTimeout(props.getConnectTimeout());
        conn.setReadTimeout(props.getReadTimeout());
        conn.setRequestProperty("Authorization", buildBasicAuth());
        conn.setRequestProperty("Accept",
                binary ? "*/*" : "application/json, text/plain, */*");
        conn.setRequestProperty("User-Agent", "RuoYi-WMS/edoc-client");
        if (contentType != null)
        {
            conn.setRequestProperty("Content-Type", contentType);
        }
        conn.setDoInput(true);
        if ("POST".equalsIgnoreCase(method) || "PUT".equalsIgnoreCase(method))
        {
            conn.setDoOutput(true);
        }
        return conn;
    }

    private String buildBasicAuth()
    {
        String raw = props.getAuthUsername() + ":" + props.getAuthPassword();
        return "BASIC " + Base64.getEncoder().encodeToString(raw.getBytes(StandardCharsets.UTF_8));
    }

    private static String readAll(HttpURLConnection conn, int code) throws IOException
    {
        InputStream is = (code >= 200 && code < 300) ? conn.getInputStream() : conn.getErrorStream();
        if (is == null)
        {
            return "";
        }
        try (InputStream in = is)
        {
            return new String(readBytes(in), StandardCharsets.UTF_8);
        }
    }

    private static String readErrorAll(HttpURLConnection conn)
    {
        try
        {
            InputStream is = conn.getErrorStream();
            if (is == null)
            {
                return "";
            }
            try (InputStream in = is)
            {
                return new String(readBytes(in), StandardCharsets.UTF_8);
            }
        }
        catch (Exception e)
        {
            return "";
        }
    }

    private static byte[] readBytes(InputStream is) throws IOException
    {
        ByteArrayOutputStream bos = new ByteArrayOutputStream(8192);
        byte[] buf = new byte[8192];
        int n;
        while ((n = is.read(buf)) != -1)
        {
            bos.write(buf, 0, n);
        }
        return bos.toByteArray();
    }

    private static String enc(String s)
    {
        try
        {
            return URLEncoder.encode(s, "UTF-8");
        }
        catch (Exception e)
        {
            return s;
        }
    }

    /** 计算字节数组的 MD5 十六进制（小写），用于上传秒传校验 */
    private static String md5Hex(byte[] data)
    {
        try
        {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            byte[] digest = md.digest(data);
            StringBuilder sb = new StringBuilder(digest.length * 2);
            for (byte b : digest)
            {
                String h = Integer.toHexString(b & 0xff);
                if (h.length() < 2)
                {
                    sb.append('0');
                }
                sb.append(h);
            }
            return sb.toString();
        }
        catch (NoSuchAlgorithmException e)
        {
            // JDK 内置 MD5，理论上不会缺失
            throw new ServiceException("MD5 算法不可用: " + e.getMessage());
        }
    }

    private static String trimTrailingSlash(String s)
    {
        if (s == null)
        {
            return "";
        }
        while (s.endsWith("/"))
        {
            s = s.substring(0, s.length() - 1);
        }
        return s;
    }

    private static String firstNonEmpty(String... values)
    {
        if (values == null)
        {
            return null;
        }
        for (String v : values)
        {
            if (v != null && !v.isEmpty())
            {
                return v;
            }
        }
        return null;
    }

    private static String maskToken(String token)
    {
        if (token == null || token.length() <= 8)
        {
            return "***";
        }
        return token.substring(0, 4) + "***" + token.substring(token.length() - 4);
    }

    private static SSLSocketFactory createTrustAllSocketFactory()
    {
        try
        {
            SSLContext sc = SSLContext.getInstance("TLS");
            sc.init(null, new TrustManager[] { new X509TrustManager()
            {
                public X509Certificate[] getAcceptedIssuers() { return new X509Certificate[0]; }
                public void checkClientTrusted(X509Certificate[] chain, String authType) { }
                public void checkServerTrusted(X509Certificate[] chain, String authType) { }
            }}, new java.security.SecureRandom());
            return sc.getSocketFactory();
        }
        catch (NoSuchAlgorithmException | KeyManagementException e)
        {
            log.warn("edoc 初始化 TrustAll SSL 失败: {}", e.getMessage());
            return null;
        }
    }

    private static class TrustAllHostnameVerifier implements HostnameVerifier
    {
        public boolean verify(String hostname, SSLSession session)
        {
            return true;
        }
    }

    private static class HttpTextResult
    {
        int httpCode;
        String text;
        byte[] binary;
    }
}
