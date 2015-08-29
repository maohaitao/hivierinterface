package com.sf.common.constant;

/**
 * Created by yanghui on 15-1-30. 错误码 规则
 * 1.10开头为通用错误代码,例如:1001
 * 2.20购物车业务错误代码
 */
public enum ResultErrorCode {

    /**
     * 请求成功
     */
    STATUS_CODE_SUCCESS(1),
    /**
     * 服务器处理异常
     */
    STATUS_CODE_SERVER_ERROR(-1),
    /**
     * 业务处理异常
     */
    STATUS_CODE_BUSINESS_ERROR(-2),
    /**
     * 请求参数错误
     */
    STATUS_CODE_PARAM_ERROR(-3),
    /**
     * 拒绝请求(用于拒绝不符合要求的请求)
     */
    REQUEST_ERROR_CODE_403(403, "拒绝服务"),
    /**
     * 服务器内部错误
     */
    REQUEST_ERROR_CODE_500(500, "服务器内部错误"),

    /**
     * 系统异常
     */
    SYSTEM_CODE(1000, "请求无法处理"),
    /**
     * 无效密钥
     */
    REQUEST_ACCESSKEY_SECRETKEY_ERROR(1001, "无效密钥"),
    /**
     * 无效用户
     */
    REQUEST_USER_ERROR(1002, "无效的用户"),
    /**
     * 无效的token
     */
    REQUEST_TOKEN_ERROR(1003, "无效的token"),
    //用户ID为null
    STATUS_CODE_PARAM_USERID_IS_NULL(2001, "userId 为空");
    private Integer code = 0;
    private String message;

    private ResultErrorCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    private ResultErrorCode(Integer code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
