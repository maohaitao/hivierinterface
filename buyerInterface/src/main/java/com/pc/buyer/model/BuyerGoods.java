package com.pc.buyer.model;

import com.sf.common.reflection.annotations.pbdb_alias;
import com.sf.common.reflection.annotations.pbdb_ignore;

import java.util.Date;

/*  */
@pbdb_alias("buyer_goods")
public class BuyerGoods {
    @pbdb_alias("goods_id")
    private Integer goodsId;//remark:商品ID;length:10; not null,default:null
    @pbdb_alias("buyer_id")
    private Integer buyerId;//remark:买手ID;length:10; not null,default:null
    private Integer type;//remark:商家属性：0代理，1直营，2加盟;length:10; not null,default:null
    @pbdb_alias("create_time")
    private Date createTime;//remark:;length:19
    @pbdb_ignore
    @pbdb_alias("update_time")
    private Date updateTime;//remark:;length:19; not null,default:CURRENT_TIMESTAMP

    public BuyerGoods() {
    }

    @Override
    public String toString() {
        return "BuyerGoods{" +
                "goodsId=" + goodsId +
                ", buyerId=" + buyerId +
                ", type=" + type +
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

    public Integer getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Integer buyerId) {
        this.buyerId = buyerId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
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