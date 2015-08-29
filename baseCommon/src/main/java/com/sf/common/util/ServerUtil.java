/**
 * @Title: ServerUtil.java
 * @Package com.pb.common.util
 * @author maohaitao
 * @date 2015年4月2日 下午6:14:14
 * @version V1.0
 */
package com.sf.common.util;

import com.sf.common.T;
import com.sf.common.log.LogService;
import com.sf.common.model.Phead;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * @author hesin
 * @ClassName: ServerUtil
 * @date 2015年4月2日 下午6:14:14
 */
public class ServerUtil {

    private ServerUtil() {

    }

    public static String getRequestParameterString(final HttpServletRequest request) {
        // 是否需要对数据进行处理
        String handle = request.getParameter("handle");
        StringBuilder builder = new StringBuilder();
        Enumeration<String> enumeration = request.getParameterNames();
        while (enumeration.hasMoreElements()) {
            String name = enumeration.nextElement();
            String value = request.getParameter(name);
            // 解压处理
            if (!CommonUtil.isNull(value) && "1".equals(handle) && isgzip(name) && !isNormalChar(value)) {
                value = parse(value);
                if (value.length() > 1024) {
                    // 参数值太大，打印日志时忽略
                    value = "[len:" + value.length() + "] " + value.substring(0, 1023) + "...";
                }
            }
            builder.append(name).append("=").append(value).append(", ");
        }
        if (builder.length() > 1) {
            // 去除最后一个逗号
            builder.deleteCharAt(builder.length() - 2);
        }

        return builder.toString();
    }

    public static Phead getRequestHead(final HttpServletRequest request) {
        String phead = getRequestValue(request, "phead");
        if (!T.isBlank(phead)) {
            return (Phead) T.toObject(phead, Phead.class);
        }

        return new Phead();
    }

    public static String getRequestValue(final HttpServletRequest request, String name) {
        // 是否需要对数据进行处理
        String handle = request.getParameter("handle");
        String value = request.getParameter(name);
        // 解压处理
        if (!CommonUtil.isNull(value) && "1".equals(handle) && isgzip(name) && !isNormalChar(value)) {
            return parse(value);
        }

        return value;
    }

    private static Boolean isgzip(String name) {
        return !("handle".equalsIgnoreCase(name) || "shandle".equalsIgnoreCase(name) || "funid".equalsIgnoreCase(name));
    }

    private static Boolean isNormalChar(String value) {
        if (CommonUtil.isNull(value)) {
            return true;
        }

        int i = value.charAt(0);
        if ((i >= 65 && i <= 90) || (i >= 97 && i <= 122) || (i >= 48 && i <= 57) || '{' == i) {
            return true;
        }

        return false;
    }

    protected static String parse(String param) {
        try {
            return new String(CommonUtil.ungzip(param.getBytes("ISO-8859-1")), "UTF-8");
        } catch (Exception e) {
            LogService.error("参数解析出错, param:" + param, e);
            return param;
        }
    }

}
