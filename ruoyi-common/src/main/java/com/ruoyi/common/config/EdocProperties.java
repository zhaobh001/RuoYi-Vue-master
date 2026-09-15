package com.ruoyi.common.config;

import javax.annotation.PostConstruct;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * edoc2 电子文档系统对接配置。
 *
 * <p>对应 {@code edoc常用接口文档.txt}。所有地址（gateway-url / token-url / ecm-url / webcore-url）
 * 均不在代码里写死，统一由 application.yml 的 {@code edoc.*} 配置——生产发布 URL 会调整，只改 yml 即可。
 * <ul>
 *   <li>gateway-url：业务接口网关（/api/services/* 前缀）；token-url：集成登录取 token（api-eis 网关）；</li>
 *   <li>ecm-url：下载 SDK 直连的 ECM 站点；webcore-url：上传两步（/WebCore、/document/upload）地址，
 *       实测挂在 api-edoc 网关下，留空回退 ecm-url；</li>
 *   <li>BASIC 应用账号与取 token 的用户标识由 auth-username/auth-password/user-id 配置。</li>
 * </ul>
 *
 * @author ruoyi
 */
@Component
@ConfigurationProperties(prefix = "edoc")
public class EdocProperties
{
    /** 是否启用 edoc 对接 */
    private boolean enabled = true;

    /**
     * edoc2 开放平台网关地址（/api/services/* 接口的统一前缀）。
     * 地址不在代码里写死，统一由 application.yml 的 {@code edoc.gateway-url} 配置（生产发布会调整）。
     */
    private String gatewayUrl = "";

    /**
     * 集成登录获取 token 的地址（在 api-eis 网关上，与业务网关不同）。
     * 统一由 application.yml 的 {@code edoc.token-url} 配置。
     */
    private String tokenUrl = "";

    /**
     * edoc2 ECM 站点地址（下载 SDK 直连）。
     * 统一由 application.yml 的 {@code edoc.ecm-url} 配置。
     */
    private String ecmUrl = "";

    /**
     * WebCore / document 上传地址前缀。
     * 统一由 application.yml 的 {@code edoc.webcore-url} 配置（实测 /WebCore、/document/upload
     * 挂在 api-edoc 网关下可达）；留空时回退 {@link #ecmUrl}。分区域上传时会被接口返回的 RegionUrl 覆盖。
     */
    private String webcoreUrl = "";

    /** 文件下载接口路径（挂在 ecmUrl 下） */
    private String downloadPath = "/document/download";

    /**
     * BASIC 认证用户名（开放平台分配的应用账号，网关应用级订阅授权）。
     * U96176 应用的网关订阅授权尚未开通（curl 实测 941），暂用已授权应用 dkwms 过网关
     * （2026-09-08 上传/下载实测通过）；取 token 的 edoc2 用户仍为 {@link #userId}=U96176。
     */
    private String authUsername = "dkwms";

    /** BASIC 认证密码（应用 dkwms） */
    private String authPassword = "ybkI)3866S9x3tF2R3DedrFT";

    /**
     * 用于获取 token 的用户标识。
     * 必须为 edoc2 的用户编号（员工工号或 WMS 专用账号 U96176），内部会做 MD5；
     * 不能用 BASIC 应用账号名（dkwms 不是 edoc2 用户）。
     * 2026-09-07 起使用 WMS 专用账号 U96176。留空时回退为 {@link #authUsername}。
     */
    private String userId = "U96176";

    /** 默认上传到的文件夹 ID（上传接口未显式指定时使用）；&le;0 时启动时按 defaultFolderName 自动查找/创建 */
    private long defaultFolderId = 0L;

    /**
     * 默认上传文件夹名称。当 {@link #defaultFolderId} 未配置（&le;0）时，
     * 系统会在根目录下按此名称查找已有文件夹，找不到则自动创建，
     * 并将解析出的 folderId 写回内存，供后续上传使用。
     */
    private String defaultFolderName = "WMS配送核验单";

    /** 连接超时（毫秒） */
    private int connectTimeout = 10000;

    /** 读取超时（毫秒） */
    private int readTimeout = 60000;

    /** 下载临时文件目录（留空时使用 ${ruoyi.profile}/edoc-temp） */
    private String tempDir = "";

    /** 本地文件保留天数，超过该天数的文件会被定时清理（以 edoc 永久存储为准，本地仅暂存） */
    private int tempRetentionDays = 15;

    /**
     * 启动校验：所有 edoc 地址必须由 application.yml 显式配置，不在代码里写死。
     * 未启用时跳过；启用但地址缺失则快速失败，避免运行时才报晦涩的网络错误。
     */
    @PostConstruct
    public void validate()
    {
        if (!enabled)
        {
            return;
        }
        requireUrl(gatewayUrl, "edoc.gateway-url");
        requireUrl(tokenUrl, "edoc.token-url");
        requireUrl(ecmUrl, "edoc.ecm-url");
        // webcore-url 留空时回退 ecm-url（上传），不强制
    }

    private static void requireUrl(String value, String key)
    {
        if (value == null || value.trim().isEmpty())
        {
            throw new IllegalStateException("edoc 已启用但 " + key + " 未配置，请在 application.yml 中配置该地址");
        }
    }

    public boolean isEnabled()
    {
        return enabled;
    }

    public void setEnabled(boolean enabled)
    {
        this.enabled = enabled;
    }

    public String getGatewayUrl()
    {
        return gatewayUrl;
    }

    public void setGatewayUrl(String gatewayUrl)
    {
        this.gatewayUrl = gatewayUrl;
    }

    public String getTokenUrl()
    {
        return tokenUrl;
    }

    public void setTokenUrl(String tokenUrl)
    {
        this.tokenUrl = tokenUrl;
    }

    public String getEcmUrl()
    {
        return ecmUrl;
    }

    public void setEcmUrl(String ecmUrl)
    {
        this.ecmUrl = ecmUrl;
    }

    public String getWebcoreUrl()
    {
        return (webcoreUrl == null || webcoreUrl.trim().isEmpty()) ? ecmUrl : webcoreUrl;
    }

    public void setWebcoreUrl(String webcoreUrl)
    {
        this.webcoreUrl = webcoreUrl;
    }

    public String getDownloadPath()
    {
        return downloadPath;
    }

    public void setDownloadPath(String downloadPath)
    {
        this.downloadPath = downloadPath;
    }

    public String getAuthUsername()
    {
        return authUsername;
    }

    public void setAuthUsername(String authUsername)
    {
        this.authUsername = authUsername;
    }

    public String getAuthPassword()
    {
        return authPassword;
    }

    public void setAuthPassword(String authPassword)
    {
        this.authPassword = authPassword;
    }

    public String getUserId()
    {
        return (userId == null || userId.trim().isEmpty()) ? authUsername : userId;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    public long getDefaultFolderId()
    {
        return defaultFolderId;
    }

    public void setDefaultFolderId(long defaultFolderId)
    {
        this.defaultFolderId = defaultFolderId;
    }

    public String getDefaultFolderName()
    {
        return (defaultFolderName == null || defaultFolderName.trim().isEmpty())
                ? "WMS配送核验单" : defaultFolderName;
    }

    public void setDefaultFolderName(String defaultFolderName)
    {
        this.defaultFolderName = defaultFolderName;
    }

    public int getConnectTimeout()
    {
        return connectTimeout;
    }

    public void setConnectTimeout(int connectTimeout)
    {
        this.connectTimeout = connectTimeout;
    }

    public int getReadTimeout()
    {
        return readTimeout;
    }

    public void setReadTimeout(int readTimeout)
    {
        this.readTimeout = readTimeout;
    }

    public String getTempDir()
    {
        if (tempDir == null || tempDir.trim().isEmpty())
        {
            return RuoYiConfig.getProfile() + "/edoc-temp";
        }
        return tempDir;
    }

    public void setTempDir(String tempDir)
    {
        this.tempDir = tempDir;
    }

    public int getTempRetentionDays()
    {
        return tempRetentionDays;
    }

    public void setTempRetentionDays(int tempRetentionDays)
    {
        this.tempRetentionDays = tempRetentionDays;
    }
}
