package com.pc.buyer.model;

import com.sf.common.reflection.annotations.pbdb_alias;
import com.sf.common.reflection.annotations.pbdb_ignore;

import java.util.Date;

/*  */
@pbdb_alias("brand_cate")
public class BrandCate {
    @pbdb_alias("cate_id")
    private Integer cateId;//remark:品类ID;length:10; not null,default:null
    @pbdb_alias("brand_id")
    private Integer brandId;//remark:;length:10; not null,default:null
    @pbdb_alias("c_status")
    private Integer cStatus;//remark:状态：1正常，0待定;length:10; not null,default:1
    @pbdb_alias("create_time")
    private Date createTime;//remark:;length:19
    @pbdb_ignore
    @pbdb_alias("update_time")
    private Date updateTime;//remark:;length:19; not null,default:CURRENT_TIMESTAMP

    public BrandCate() {
    }

    @Override
    public String toString() {
        return "BrandCate{" +
                "cateId=" + cateId +
                ", brandId=" + brandId +
                ", cStatus=" + cStatus +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }

    public Integer getCateId() {
        return cateId;
    }

    public void setCateId(Integer cateId) {
        this.cateId = cateId;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public Integer getcStatus() {
        return cStatus;
    }

    public void setcStatus(Integer cStatus) {
        this.cStatus = cStatus;
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
}