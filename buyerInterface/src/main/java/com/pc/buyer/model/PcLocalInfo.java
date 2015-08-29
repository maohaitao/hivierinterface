package com.pc.buyer.model;

import com.sf.common.reflection.annotations.pbdb_alias;
import com.sf.common.reflection.annotations.pbdb_ignore;

import java.util.Date;

/*  */
@pbdb_alias("pc_local_info")
public class PcLocalInfo {
    @pbdb_ignore
    private Integer id;//remark:逻辑/业务ID;length:10; not null,default:null
    @pbdb_alias("prov_id")
    private Integer provId;//remark:省份ID;length:10; not null,default:null
    @pbdb_alias("local_name")
    private String localName;//remark:地域名称(如:广州);length:24; not null,default:null
    @pbdb_alias("local_short")
    private String localShort;//remark:简写(如:gz);length:16; not null,default:null
    @pbdb_alias("nick_name")
    private String nickName;//remark:昵称(如:羊城,);length:32; not null,default:null
    private String descrption;//remark:描述;length:65535; not null,default:null
    @pbdb_alias("create_time")
    private Date createTime;//remark:;length:19; not null,default:null
    @pbdb_ignore
    @pbdb_alias("update_time")
    private Date updateTime;//remark:;length:19

    public PcLocalInfo() {
    }

    public void setid(Integer id) {
        this.id = id;
    }

    public Integer getid() {
        return id;
    }

    public void setprovId(Integer provId) {
        this.provId = provId;
    }

    public Integer getprovId() {
        return provId;
    }

    public void setlocalName(String localName) {
        this.localName = localName;
    }

    public String getlocalName() {
        return localName;
    }

    public void setlocalShort(String localShort) {
        this.localShort = localShort;
    }

    public String getlocalShort() {
        return localShort;
    }

    public void setnickName(String nickName) {
        this.nickName = nickName;
    }

    public String getnickName() {
        return nickName;
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