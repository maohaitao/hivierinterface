package com.sf.common.util;

import com.google.gson.JsonObject;
import com.sf.common.model.CommonRequest;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * 描述：
 * 创建时间：15/8/19
 * 作者：yanghui
 */
public class Request {
    public static JsonObject getData(HttpServletRequest request) {
        String handle = request.getParameter("handle");
        String data = request.getParameter("data");
        try {
            // 解压处理
            if (CommonRequest.HANDLE.equals(handle) && !StringUtils.isEmpty(data) && !data.startsWith("{")) {
                data = new String(CommonUtil.ungzip(data.getBytes("ISO-8859-1")), "UTF-8");
            }
        } catch (Exception e) {
            data = "{}";
        }
        return JsonUtil.parse(data);
    }
}
