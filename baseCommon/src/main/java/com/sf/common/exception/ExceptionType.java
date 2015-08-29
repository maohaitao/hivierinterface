package com.sf.common.exception;

/**
 * @author hesin
 * @Created with： com.sf.common
 * @Des: 错误类型
 * @date 2015/8/13
 */
public enum ExceptionType {

    ETYPE_RUNTIME("runtime"),
    ETYPE_DB("db"),
    ETYPE_IO("io"),
    ETYPE_SERVICE("service"),
    ETYPE_COMMON("common");

    private String typename;

    private ExceptionType(String typename) {
        this.typename = typename;
    }

    public String getTypename() {
        return this.typename;
    }
}
