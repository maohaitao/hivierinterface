/**
 * @Title: AppException.java
 * @Package com.pb.common.database.exception
 * @author maohaitao
 * @date 2015年4月14日 下午12:06:33
 * @version V1.0
 */
package com.sf.common.exception;

import com.sf.common.util.CommonUtil;

/**
 * @author hesin
 * @ClassName: AppException
 * @Des: 异常类
 * @date 2015年4月14日 下午12:06:33
 */
public class AppException extends Exception {
    private int errorCode;

    public AppException(int errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public AppException(int errorCode, String message, Throwable e) {
        super(message + ";" + e.getMessage(), e);
        this.errorCode = errorCode;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public String getExceptionStackStr() {
        return "errorCode:" + this.getErrorCode() + " message:" + this.getMessage() + " " + CommonUtil.getExceptionStackStr(this);
    }

    public String toString() {
        return this.getExceptionStackStr();
    }
}
