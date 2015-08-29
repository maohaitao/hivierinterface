package com.pc.buyer.model;

import com.sf.common.reflection.annotations.pbdb_alias;
import com.sf.common.reflection.annotations.pbdb_ignore;

import java.util.Date;

/*  */
@pbdb_alias("pc_province_info")
public class PcProvinceInfo {
    @pbdb_ignore
    private Integer id;//remark:逻辑/业务ID;length:10; not null,default:null
    @pbdb_alias("prov_name")
    private String provName;//remark:省份名称(如:广东);length:24; not null,default:null
    @pbdb_alias("prov_short")
    private String provShort;//remark:简写(如:gd);length:16; not null,default:null
    @pbdb_alias("nick_name")
    private String nickName;//remark:简称(如:粤);length:16
    private String country;//remark:国家;length:32; not null,default:null
    private String descrption;//remark:描述;length:65535; not null,default:null
    @pbdb_alias("create_time")
    private Date createTime;//remark:;length:19; not null,default:null
    @pbdb_ignore
    @pbdb_alias("update_time")
    private Date updateTime;//remark:;length:19

    public PcProvinceInfo() {
    }

    public void setid(Integer id) {
        this.id = id;
    }

    public Integer getid() {
        return id;
    }

    public void setprovName(String provName) {
        this.provName = provName;
    }

    public String getprovName() {
        return provName;
    }

    public void setprovShort(String provShort) {
        this.provShort = provShort;
    }

    public String getprovShort() {
        return provShort;
    }

    public void setnickName(String nickName) {
        this.nickName = nickName;
    }

    public String getnickName() {
        return nickName;
    }

    public void setcountry(String country) {
        this.country = country;
    }

    public String getcountry() {
        return country;
    }

    public void setdescrption(String descrption) {
        this.descrption = descrption;
    }

    public String getdescrption() {
        return descrption;
    }

    public void setcreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getcreateTime() {
        return createTime;
    }

    public void setupdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getupdateTime() {
        return updateTime;
    }
}