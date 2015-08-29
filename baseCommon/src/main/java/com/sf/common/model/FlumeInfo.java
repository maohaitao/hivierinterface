/**
 * @Title: FlumeInfo.java
 * @Package com.pb.model
 * @author maohaitao
 * @date 2015年4月2日 下午5:56:22
 * @version V1.0
 */
package com.sf.common.model;

/**
 * @author maohaitao
 * @ClassName: FlumeInfo
 * @date 2015年4月2日 下午5:56:22
 */
public class FlumeInfo {

    public FlumeInfo() {

    }

    public FlumeInfo(String target, String remark) {
        this.target = target;
        this.remark = remark;
    }

    /**
     * @Fields target : 统计对象
     */
    private String target;

    /**
     * @Fields remark : 备注
     */
    private String remark;

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
