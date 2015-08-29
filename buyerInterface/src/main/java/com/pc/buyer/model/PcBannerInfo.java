package com.pc.buyer.model;

import com.google.gson.annotations.Expose;
import com.sf.common.reflection.annotations.pbdb_alias;
import com.sf.common.reflection.annotations.pbdb_ignore;

import java.util.Date;

/*  */
@pbdb_alias("pc_banner_info")
public class PcBannerInfo {

    @pbdb_ignore
    @Expose
    private Integer id;//remark:商铺ID;length:10; not null,default:null
    @pbdb_alias("b_name")
    @Expose
    private String bName;//remark:名称;length:100; not null,default:null

    @Expose
    private Integer priority;//remark:优先级别 优先级别,越小越优先
    @pbdb_alias("b_status")
    @Expose
    private Integer bStatus;//remark:状态 1 新建 2 审核中 3 审核通过 4 审核不通过 5 失效;length:10; not null,default:null
    @pbdb_alias("act_type")
    @Expose
    private Integer actType;//remark:操作处理：1 web view 2 intent 3 浏览器打开;length:10; not null,default:1
    @pbdb_alias("act_url")
    @Expose
    private String actUrl;//remark:商铺电话;length:255; not null,default:null
    @pbdb_alias("b_logo")
    @Expose
    private String bLogo;//remark:banner的图片地址;length:255; not null,default:null
    @Expose
    private String descrption;//remark:描述;length:65535
    @pbdb_alias("create_time")
    @Expose
    private Date createTime;//remark:商家进驻时间;length:19
    @pbdb_ignore
    @pbdb_alias("update_time")
    @Expose
    private Date updateTime;//remark:;length:19; not null,default:CURRENT_TIMESTAMP
    @Expose
    private String orther;//remark:其他信息;length:255

    public PcBannerInfo() {
    }

    @Override
    public String toString() {
        return "PcBannerInfo{" +
                "id=" + id +
                ", bName='" + bName + '\'' +
                ", priority=" + priority +
                ", bStatus=" + bStatus +
                ", actType=" + actType +
                ", actUrl='" + actUrl + '\'' +
                ", bLogo='" + bLogo + '\'' +
                ", descrption='" + descrption + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", orther='" + orther + '\'' +
                '}';
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getbName() {
        return bName;
    }

    public void setbName(String bName) {
        this.bName = bName;
    }

    public Integer getbStatus() {
        return bStatus;
    }

    public void setbStatus(Integer bStatus) {
        this.bStatus = bStatus;
    }

    public Integer getActType() {
        return actType;
    }

    public void setActType(Integer actType) {
        this.actType = actType;
    }

    public String getActUrl() {
        return actUrl;
    }

    public void setActUrl(String actUrl) {
        this.actUrl = actUrl;
    }

    public String getbLogo() {
        return bLogo;
    }

    public void setbLogo(String bLogo) {
        this.bLogo = bLogo;
    }

    public String getDescrption() {
        return descrption;
    }

    public void setDescrption(String descrption) {
        this.descrption = descrption;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getOrther() {
        return orther;
    }

    public void setOrther(String orther) {
        this.orther = orther;
    }
}