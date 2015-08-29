package com.pc.buyer.model;

import java.util.*;
import com.google.gson.annotations.Expose;
import com.sf.common.reflection.annotations.*;

/*  */
@pbdb_alias("pc_buyer_info")
public class PcBuyerInfo {
	@pbdb_ignore
	@Expose
	private Integer id;//remark:商铺ID;length:10; not null,default:null
	@pbdb_alias("b_name")
	@Expose
	private String bName;//remark:买手名称;length:100; not null,default:null
	@pbdb_alias("s_name")
	@Expose
	private String sName;//remark:店铺名称;length:64
	@pbdb_alias("province_name")
	@Expose
	private String provinceName;//remark:省份;length:50; not null,default:null
	@pbdb_alias("city_name")
	@Expose
	private String cityName;//remark:城市;length:50; not null,default:null
	@Expose
	private String address;//remark:商户地址（精确到路之后更精确的地址）;length:65535; not null,default:null
	@pbdb_alias("avg_price")
	@Expose
	private Double avgPrice;//remark:人均价格;length:8
	@pbdb_alias("b_status")
	private Integer bStatus;//remark:状态 1 新建 2 审核中 3 审核通过 4 审核不通过 5 黑名单;length:10; not null,default:null
	@pbdb_alias("b_brand_type")
	@Expose
	private Integer bBrandType;//remark: 店铺类型:1 多品牌 2 单品 3 特色 4其他;length:10
	@pbdb_alias("b_type")
	@Expose
	private String bType;//remark:商铺类型(如:鞋类,眼镜\衣服);length:50
	@pbdb_alias("b_style")
	@Expose
	private String bStyle;//remark:店铺小风格;length:255
	@pbdb_alias("b_crowd")
	@Expose
	private String bCrowd;//remark:适合人群;length:64
	@pbdb_alias("b_phone")
	@Expose
	private String bPhone;//remark:商铺电话;length:20; not null,default:null
	@pbdb_alias("b_logo")
	@Expose
	private String bLogo;//remark:店铺的logo信息;length:255
	@Expose
	private Integer govauth;//remark:是否官网认证0 未认证 1 认证;length:10; not null,default:0
	@Expose
	private Integer genuineauth;//remark:正品认证 0 未认证 1 认证;length:10; not null,default:0
	@Expose
	private Integer shippingauth;//remark:官网物流认证 0未认证 1 认证;length:10; not null,default:0
	@Expose
	private String descrption;//remark:描述;length:65535
	@Expose
	private Double popularity;//remark:人气;length:4
	@pbdb_alias("create_time")
	@Expose
	private Date createTime;//remark:商家进驻时间;length:19
	@pbdb_ignore
	@pbdb_alias("update_time")
	private Date updateTime;//remark:;length:19; not null,default:CURRENT_TIMESTAMP
	@Expose
	private String other;//remark:其他信息;length:255

	public PcBuyerInfo() {
	}

    @Override
    public String toString() {
        return "PcBuyerInfo{" +
                "id=" + id +
                ", bName='" + bName + '\'' +
                ", sName='" + sName + '\'' +
                ", provinceName='" + provinceName + '\'' +
                ", cityName='" + cityName + '\'' +
                ", address='" + address + '\'' +
                ", avgPrice=" + avgPrice +
                ", bStatus=" + bStatus +
                ", bBrandType=" + bBrandType +
                ", bType='" + bType + '\'' +
                ", bStyle='" + bStyle + '\'' +
                ", bCrowd='" + bCrowd + '\'' +
                ", bPhone='" + bPhone + '\'' +
                ", bLogo='" + bLogo + '\'' +
                ", govauth=" + govauth +
                ", genuineauth=" + genuineauth +
                ", shippingauth=" + shippingauth +
                ", descrption='" + descrption + '\'' +
                ", popularity=" + popularity +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", other='" + other + '\'' +
                '}';
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

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getAvgPrice() {
        return avgPrice;
    }

    public void setAvgPrice(Double avgPrice) {
        this.avgPrice = avgPrice;
    }

    public Integer getbStatus() {
        return bStatus;
    }

    public void setbStatus(Integer bStatus) {
        this.bStatus = bStatus;
    }

    public Integer getbBrandType() {
        return bBrandType;
    }

    public void setbBrandType(Integer bBrandType) {
        this.bBrandType = bBrandType;
    }

    public String getbType() {
        return bType;
    }

    public void setbType(String bType) {
        this.bType = bType;
    }

    public String getbStyle() {
        return bStyle;
    }

    public void setbStyle(String bStyle) {
        this.bStyle = bStyle;
    }

    public String getbCrowd() {
        return bCrowd;
    }

    public void setbCrowd(String bCrowd) {
        this.bCrowd = bCrowd;
    }

    public String getbPhone() {
        return bPhone;
    }

    public void setbPhone(String bPhone) {
        this.bPhone = bPhone;
    }

    public String getbLogo() {
        return bLogo;
    }

    public void setbLogo(String bLogo) {
        this.bLogo = bLogo;
    }

    public Integer getGovauth() {
        return govauth;
    }

    public void setGovauth(Integer govauth) {
        this.govauth = govauth;
    }

    public Integer getGenuineauth() {
        return genuineauth;
    }

    public void setGenuineauth(Integer genuineauth) {
        this.genuineauth = genuineauth;
    }

    public Integer getShippingauth() {
        return shippingauth;
    }

    public void setShippingauth(Integer shippingauth) {
        this.shippingauth = shippingauth;
    }

    public String getDescrption() {
        return descrption;
    }

    public void setDescrption(String descrption) {
        this.descrption = descrption;
    }

    public Double getPopularity() {
        return popularity;
    }

    public void setPopularity(Double popularity) {
        this.popularity = popularity;
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

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }
}