/**
 * @Title: FlumeRequest.java
 * @Package com.pb.model
 * @author maohaitao
 * @date 2015年4月2日 下午6:23:06
 * @version V1.0
 */
package com.sf.common.model;

import javax.servlet.http.HttpServletRequest;

/**
 * @author maohaitao
 * @ClassName: FlumeRequest
 * @date 2015年4月2日 下午6:23:06
 */
public class FlumeRequest {

    private CommonRequest commonRequest;
    private HttpServletRequest servletRequest;
    private Phead phead;
    private long userid;
    private int type;
    private String opResult;

    /**
     * @Fields target : 统计对象
     */
    private String target;

    /**
     * @Fields remark : 备注
     */
    private String remark;

    public FlumeRequest() {

    }

    public FlumeRequest(CommonRequest commonRequest, Phead p, long userid, int type, String opResult) {
        this(commonRequest.getRequest(), p, userid, type, opResult);
        this.commonRequest = commonRequest;
    }

    public FlumeRequest(HttpServletRequest servletRequest, Phead p, long userid, int type, String opResult) {
        this.servletRequest = servletRequest;
        this.phead = p;
        this.userid = userid;
        this.type = type;
        this.opResult = opResult;
    }

    public FlumeRequest(CommonRequest commonRequest, String opResult) {
        this(commonRequest, null, opResult);
    }

    public FlumeRequest(CommonRequest commonRequest, HttpServletRequest servletRequest, String opResult) {
        this.commonRequest = commonRequest;
        this.servletRequest = servletRequest;
        this.opResult = opResult;
        if (this.servletRequest == null && commonRequest != null) {
            this.servletRequest = commonRequest.getRequest();
        }
    }

    /**
     * @return 获取commonRequest
     */
    public CommonRequest getCommonRequest() {
        return commonRequest;
    }

    /**
     * @param commonRequest
     * @Description 设置commonRequest
     */
    public void setCommonRequest(CommonRequest commonRequest) {
        this.commonRequest = commonRequest;
    }

    /**
     * @return 获取servletRequest
     */
    public HttpServletRequest getServletRequest() {
        if (servletRequest == null && commonRequest != null) {
            servletRequest = commonRequest.getRequest();
        }
        return servletRequest;
    }

    /**
     * @param servletRequest
     * @Description 设置servletRequest
     */
    public void setServletRequest(HttpServletRequest servletRequest) {
        this.servletRequest = servletRequest;
    }

    /**
     * @return 获取phead
     */
    public Phead getPhead() {
        return phead;
    }

    /**
     * @param phead
     * @Description 设置phead
     */
    public void setPhead(Phead phead) {
        this.phead = phead;
    }

    /**
     * @return 获取userid
     */
    public long getUserid() {
        return userid;
    }

    /**
     * @param userid
     * @Description 设置userid
     */
    public void setUserid(long userid) {
        this.userid = userid;
    }

    /**
     * @return 获取type
     */
    public int getType() {
        return type;
    }

    /**
     * @param type
     * @Description 设置type
     */
    public void setType(int type) {
        this.type = type;
    }

    /**
     * @return 获取opResult
     */
    public String getOpResult() {
        return opResult;
    }

    /**
     * @param opResult
     * @Description 设置opResult
     */
    public void setOpResult(String opResult) {
        this.opResult = opResult;
    }

    /**
     * @return 获取target
     */
    public String getTarget() {
        return target;
    }

    /**
     * @param target
     * @Description 设置target
     */
    public void setTarget(String target) {
        this.target = target;
    }

    /**
     * @return 获取remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     * @param remark
     * @Description 设置remark
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

}
