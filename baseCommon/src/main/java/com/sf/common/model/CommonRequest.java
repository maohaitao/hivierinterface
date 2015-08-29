/**
 * @Title: CommonRequest.java
 * @Package com.pb.model
 * @author maohaitao
 * @date 2015年4月2日 下午6:15:34
 * @version V1.0
 */
package com.sf.common.model;

import com.google.gson.JsonObject;
import com.sf.common.T;
import com.sf.common.util.CommonUtil;
import com.sf.common.util.JsonUtil;
import com.sf.common.util.Request;
import com.sf.common.util.Result;
import org.apache.http.Consts;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;

/**
 * @author maohaitao
 * @ClassName: CommonRequest
 * @date 2015年4月2日 下午6:15:34
 */
public class CommonRequest {
    public static String HANDLE = "1";
    private JsonObject jsonData;
    private Phead phead;
    private HttpServletRequest request;
    private HttpServletResponse response;

    public CommonRequest() {
    }

    public CommonRequest(HttpServletRequest request, JsonObject jsonData) {
        this.request = request;
        parse(jsonData);
    }

    public CommonRequest(HttpServletRequest request, HttpServletResponse response) {
        this(request, Request.getData(request));
        this.response = response;
    }

    public String get(String name) {
        return T.stringValue(request.getParameter(name), JsonUtil.getValue(jsonData, name));
    }

    public int get(String name, int defaultValue) {
        return T.integerValue(get(name), defaultValue);
    }

    public long get(String name, long defaultValue) {
        return T.longValue(get(name), defaultValue);
    }

    /**
     * @return 获取jsonData
     */
    public JsonObject getJsonData() {
        return jsonData;
    }

    /**
     * @param jsonData
     * @Description 设置jsonData
     */
    public void setJsonData(JsonObject jsonData) {
        this.jsonData = jsonData;
    }

    /**
     * @return 获取request
     */
    public HttpServletRequest getRequest() {
        return request;
    }

    /**
     * @param request
     * @Description 设置request
     */
    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    public HttpServletResponse getResponse() {
        return response;
    }

    public void setResponse(HttpServletResponse response) {
        this.response = response;
    }

    @Override
    public String toString() {
        return "CommonRequest{" +
                "jsonData=" + jsonData +
                ", phead=" + phead +
                ", request=" + request +
                '}';
    }

    private void parse(JsonObject jsobject) {
        if (jsobject != null) {
            JsonObject jsonPhead = jsobject.getAsJsonObject("phead");
            if (jsonPhead != null) {
                phead = JsonUtil.fromJson(jsonPhead, Phead.class);
            }
            jsonData = jsobject.getAsJsonObject("data");
        }
    }

    public void send(Result result) throws Exception {
        if (response != null) {
            response.setContentType("application/json;charset=UTF-8");
            OutputStream out = response.getOutputStream();
            String shandle = request.getParameter("shandle");
            byte[] bytes;
            if (CommonRequest.HANDLE.equals(shandle)) {// 压缩
                bytes = CommonUtil.gzip(result.toString().getBytes("UTF-8"));
            } else {
                bytes = result.toString().getBytes(Consts.UTF_8);
            }
            out.write(bytes);
            out.flush();
        }
    }
}
