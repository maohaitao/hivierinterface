package com.pc.buyer.model;

import com.sf.common.reflection.annotations.pbdb_alias;
import com.sf.common.reflection.annotations.pbdb_ignore;

import java.util.Date;

/*  */
@pbdb_alias("goods_brand")
public class GoodsBrand {
    @pbdb_alias("goods_id")
    private Integer goodsId;//remark:;length:10; not null,default:null
    @pbdb_alias("brand_id")
    private Integer brandId;//remark:;length:10; not null,default:null
    @pbdb_alias("mb_status")
    private Integer mbStatus;//remark:状态：1正常，0待定;length:10; not null,default:1
    @pbdb_alias("create_time")
    private Date createTime;//remark:;length:19
    @pbdb_ignore
    @pbdb_alias("update_time")
    private Date updateTime;//remark:;length:19; not null,default:CURRENT_TIMESTAMP

    public GoodsBrand() {
    }

    @Override
    public String toString() {
        return "GoodsBrand{" +
                "goodsId=" + goodsId +
                ", brandId=" + brandId +
                ", mbStatus=" + mbStatus +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public Integer getMbStatus() {
        return mbStatus;
    }

    public void setMbStatus(Integer mbStatus) {
        this.mbStatus = mbStatus;
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