package com.ruoyi.common.domin;

import java.util.HashMap;

public class FebsResponse extends HashMap<String, Object>{
    private static final long serialVersionUID = -8713837118340960775L;
    /**
     * 成功状态码
     */
    public static final String SUCCESS_STATUS = "0000";
    /**
     * 失败状态码
     */
    public static final String FAIL_STATUS = "1000";
    /**
     * 系统错误异常
     */
    public static final String SYSTEM_ERROR_STATUS = "2000";
    /**
     * 参数异常
     */
    public static final String REQUEST_ERROR_STATUS = "2100";

    /**
     * token异常
     */
    public static final String AUTHENTICATION_EXCEPTION_STATUS = "2200";

    public FebsResponse message(String message) {


        this.put("message", message);
        return this;
    }

    public FebsResponse data(Object data) {


        this.put("data", data);
        return this;
    }

    public FebsResponse status(Object status) {


        this.put("status", status);
        return this;
    }

    @Override
    public FebsResponse put(String key, Object value) {


        super.put(key, value);
        return this;
    }
}
