package com.pc.buyer.model;

import java.util.*;

import com.google.gson.annotations.Expose;
import com.sf.common.reflection.annotations.*;

/*  */
@pbdb_alias("goods_info")
public class GoodsInfo {
    @pbdb_ignore
    @Expose
    private Integer id;//remark:;length:10; not null,default:null
    @pbdb_alias("sku_id")
    @Expose
    private String skuId;//remark:商品SKUID;length:10; not null,default:null
    @Expose
    private java.lang.String icon;//remark:图片的icon;length:255
    @pbdb_alias("goods_name")
    @Expose
    private String goodsName;//remark:商品名称;length:255; not null,default:null
    @pbdb_alias("cate_id")
    @Expose
    private Integer cateId;//remark:大类名称;length:10; not null,default:null
    @pbdb_alias("g_status")
    private Integer gStatus;//remark:状态 1 新建 2 审核 3 上线 4 下线;length:10; not null,default:1
    @pbdb_alias("g_src")
    @Expose
    private Integer gSrc;//remark:商品来源,1专柜代购 2 官网 3 经销商 4 员工价格;length:10; not null,default:1
    @Expose
    private Integer serven;//remark:7天包退 0 否 1 是;length:10; not null,default:0
    @Expose
    private Integer invoice;//remark:是否有发票 0 否 1是;length:10; not null,default:0
    @pbdb_alias("brand_id")
    @Expose
    private Integer brandId;//remark:品牌ID;length:10; not null,default:null
    @pbdb_alias("guide_price")
    @Expose
    private Double guidePrice;//remark:贴牌指导价，精确到分;length:10; not null,default:null
    @pbdb_alias("final_price")
    @Expose
    private Double finalPrice;//remark:最终价格,精确;length:10; not null,default:0.00
    @pbdb_alias("pur_price")
    @Expose
    private Double purPrice;//remark:代购费用;length:10; not null,default:0.00
    @pbdb_alias("shipping_price")
    @Expose
    private Double shippingPrice;//remark:物流费用,默认免运费;length:10; not null,default:0.00
    @Expose
    private String color;//remark:;length:50; not null,default:null
    @Expose
    private int stock;//remark:;0 无库存状态 1 有库存状态
    @Expose
    private String material;//remark:;length:255; not null,default:null
    @Expose
    private String size;//remark:;length:10; not null,default:null
    @Expose
    private String season;//remark:季节;length:64
    @pbdb_alias("g_year")
    @Expose
    private String gYear;//remark:商品年份 如:2015;length:64
    @Expose
    private String description;//remark:商品描述;length:65535; not null,default:null
    @Expose
    private String other;//remark:其他信息;length:255
    @pbdb_alias("create_time")
    @Expose
    private Date createTime;//remark:;length:19; not null,default:null
    @pbdb_ignore
    @pbdb_alias("update_time")
    private Date updateTime;//remark:;length:19; not null,default:CURRENT_TIMESTAMP

    public GoodsInfo() {
    }

    @Override
    public String toString() {
        return "GoodsInfo{" +
                "id=" + id +
                ", skuId='" + skuId + '\'' +
                ", icon='" + icon + '\'' +
                ", goodsName='" + goodsName + '\'' +
                ", cateId=" + cateId +
                ", gStatus=" + gStatus +
                ", gSrc=" + gSrc +
                ", serven=" + serven +
                ", invoice=" + invoice +
                ", brandId=" + brandId +
                ", guidePrice=" + guidePrice +
                ", finalPrice=" + finalPrice +
                ", purPrice=" + purPrice +
                ", shippingPrice=" + shippingPrice +
                ", color='" + color + '\'' +
                ", stock=" + stock +
                ", material='" + material + '\'' +
                ", size='" + size + '\'' +
                ", season='" + season + '\'' +
                ", gYear='" + gYear + '\'' +
                ", description='" + description + '\'' +
                ", other='" + other + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSkuId() {
        return skuId;
    }

    public void setSkuId(String skuId) {
        this.skuId = skuId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Integer getCateId() {
        return cateId;
    }

    public void setCateId(Integer cateId) {
        this.cateId = cateId;
    }

    public Integer getgStatus() {
        return gStatus;
    }

    public void setgStatus(Integer gStatus) {
        this.gStatus = gStatus;
    }

    public Integer getgSrc() {
        return gSrc;
    }

    public void setgSrc(Integer gSrc) {
        this.gSrc = gSrc;
    }

    public Integer getServen() {
        return serven;
    }

    public void setServen(Integer serven) {
        this.serven = serven;
    }

    public Integer getInvoice() {
        return invoice;
    }

    public void setInvoice(Integer invoice) {
        this.invoice = invoice;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public Double getGuidePrice() {
        return guidePrice;
    }

    public void setGuidePrice(Double guidePrice) {
        this.guidePrice = guidePrice;
    }

    public Double getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(Double finalPrice) {
        this.finalPrice = finalPrice;
    }

    public Double getPurPrice() {
        return purPrice;
    }

    public void setPurPrice(Double purPrice) {
        this.purPrice = purPrice;
    }

    public Double getShippingPrice() {
        return shippingPrice;
    }

    public void setShippingPrice(Double shippingPrice) {
        this.shippingPrice = shippingPrice;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public String getgYear() {
        return gYear;
    }

    public void setgYear(String gYear) {
        this.gYear = gYear;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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