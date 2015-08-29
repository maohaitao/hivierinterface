package com.pc.buyer.model;

import com.google.gson.annotations.Expose;
import com.sf.common.reflection.annotations.pbdb_alias;
import com.sf.common.reflection.annotations.pbdb_ignore;

import java.util.Date;

/*  */
@pbdb_alias("pc_brand_info")
public class PcBrandInfo {
    @pbdb_ignore
    @Expose
    private Integer id;//remark:逻辑/业务ID;length:10; not null,default:null
    @Expose
    @pbdb_alias("brand_name_cn")
    private String brandNameCn;//remark:品牌中文名;length:255; not null,default:null
    @pbdb_alias("brand_name_en")
    @Expose
    private String brandNameEn;//remark:品牌英文名;length:255; not null,default:null
    @Expose
    private String descrption;//remark:描述;length:65535; not null,default:null
    @pbdb_alias("brand_style")
    @Expose
    private String brandStyle;//remark:品牌类型;length:255
    @pbdb_alias("b_status")
    private Integer bStatus;//`b_status` int(2) NULL DEFAULT 1 COMMENT '状态 1 正常 2下线',
    @pbdb_alias("avg_price")
    @Expose
    private Double avgPrice;//remark:人均消费;length:8
    @pbdb_alias("logo_url")
    @Expose
    private String logoUrl;//remark:logo图标;length:255; not null,default:null
    @pbdb_alias("web_url")
    @Expose
    private String webUrl;//remark:网址;length:255
    @Expose
    private Double popularity;//remark:人气;length:4
    @Expose
    private String other;//remark:其他信息;length:255
    @pbdb_alias("create_time")
    @Expose
    private Date createTime;//remark:;length:19
    @pbdb_ignore
    @pbdb_alias("update_time")
    private Date updateTime;//remark:;length:19; not null,default:CURRENT_TIMESTAMP

    public PcBrandInfo() {
    }

    @Override
    public String toString() {
        return "PcBrandInfo{" +
                "id=" + id +
                ", brandNameCn='" + brandNameCn + '\'' +
                ", brandNameEn='" + brandNameEn + '\'' +
                ", descrption='" + descrption + '\'' +
                ", brandStyle='" + brandStyle + '\'' +
                ", bStatus=" + bStatus +
                ", avgPrice=" + avgPrice +
                ", logoUrl='" + logoUrl + '\'' +
                ", webUrl='" + webUrl + '\'' +
                ", popularity=" + popularity +
                ", other='" + other + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }

    public Integer getbStatus() {
        return bStatus;
    }

    public void setbStatus(Integer bStatus) {
        this.bStatus = bStatus;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrandNameCn() {
        return brandNameCn;
    }

    public void setBrandNameCn(String brandNameCn) {
        this.brandNameCn = brandNameCn;
    }

    public String getBrandNameEn() {
        return brandNameEn;
    }

    public void setBrandNameEn(String brandNameEn) {
        this.brandNameEn = brandNameEn;
    }

    public String getDescrption() {
        return descrption;
    }

    public void setDescrption(String descrption) {
        this.descrption = descrption;
    }

    public String getBrandStyle() {
        return brandStyle;
    }

    public void setBrandStyle(String brandStyle) {
        this.brandStyle = brandStyle;
    }

    public Double getAvgPrice() {
        return avgPrice;
    }

    public void setAvgPrice(Double avgPrice) {
        this.avgPrice = avgPrice;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }

    public Double getPopularity() {
        return popularity;
    }

    public void setPopularity(Double popularity) {
        this.popularity = popularity;
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