package com.pc.buyer.model;

import java.util.*;
import com.google.gson.annotations.Expose;
import com.sf.common.reflection.annotations.*;

/*  */
@pbdb_alias("goods_stock")
public class GoodsStock {
	@pbdb_ignore
	private Integer id;//remark:;length:10; not null,default:null
	@pbdb_alias("goods_id")
	private Integer goodsId;//remark:商品ID;length:10; not null,default:null
	@Expose
	private String size;//remark:尺码 S/M/L等;length:64
	private String color;//remark:颜色 红色/橙色等;length:128
	@Expose
	private Double price;//remark:价格，如果价格<=0时,取商品价格;length:10
	@Expose
	private Integer stock;//remark:库存;length:10
	private String desc;//remark:详情描述;length:65535; not null,default:null
	private String other;//remark:其他信息;length:255
	@pbdb_alias("create_time")
	private Date createTime;//remark:;length:19; not null,default:null
	@pbdb_ignore
	@pbdb_alias("update_time")
	private Date updateTime;//remark:;length:19; not null,default:CURRENT_TIMESTAMP

	public GoodsStock() {
	}

    @Override
    public String toString() {
        return "GoodsStock{" +
                "id=" + id +
                ", goodsId=" + goodsId +
                ", size='" + size + '\'' +
                ", color='" + color + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", desc='" + desc + '\'' +
                ", other='" + other + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
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