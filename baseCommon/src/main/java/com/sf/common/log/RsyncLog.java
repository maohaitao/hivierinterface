/**
 * @Title: RsyncLog.java
 * @Package com.g3.common
 * @Des: log
 * @author maohaitao
 * @version V1.0
 */
package com.sf.common.log;

import com.sf.common.AppContext;
import org.apache.log4j.MDC;

/**
 * @ClassName: RsyncLog
 */
public final class RsyncLog {

    static {
        System.setProperty("server", AppContext.SYS_SHORT_IP);
    }

    /**
     * @param key
     * @param value
     * @Title push
     * @Description 自定义参数
     */
    public static void push(String key, String value) {
        MDC.put(key, value);
    }

    /**
     * @param message 　消息
     * @Title debug
     * @Description 输出debug日志
     */
    public static void debug(String message) {
        LogService.debug(message);
    }

    /**
     * @param message 　消息
     * @Title info
     * @Description 输出info日志
     */
    public static void info(String message) {
        LogService.info(message);
    }

    /**
     * @param name    日志器
     * @param message 消息
     * @Title info
     * @Description 输出info日志
     */
    public static void info(String name, String message) {
        LogService.info(name, message);
    }

    /**
     * @param message
     * @param e
     * @Title error
     * @Description 输出error日志
     */
    public static void error(String message, Throwable e) {
        LogService.error(message, e);
    }

    /**
     * @param e
     * @Title error
     * @Description 输出error日志
     */
    public static void error(Exception e) {
        LogService.error(e);
    }

    /**
     * @param message
     * @Title error
     * @Description 输出error日志
     */
    public static void error(String message) {
        LogService.error(message);
    }

}
