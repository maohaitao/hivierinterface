package com.pc.buyer.model;

import java.util.*;
import com.google.gson.annotations.Expose;
import com.sf.common.reflection.annotations.*;

/*  */
@pbdb_alias("pc_item_item")
public class PcItemItem {
	@pbdb_ignore
	@Expose
	private Integer id;//remark:商铺ID;length:10; not null,default:null
	@Expose
	private Integer childid;//remark:虚拟的资源ID;length:10; not null,default:-1
	@Expose
	private Integer parentid;//remark:分类节点ID 默认为0,为根节点;length:10
	@pbdb_alias("i_status")
	@Expose
	private Integer iStatus;//remark:状态  1 新建 2 上线 3 下线;length:10
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

	public PcItemItem() {
	}

	public void setid(Integer id) {
		this.id = id;
	}

	public Integer getid() {
		return id;
	}

	public void setchildid(Integer childid) {
		this.childid = childid;
	}

	public Integer getchildid() {
		return childid;
	}

	public void setparentid(Integer parentid) {
		this.parentid = parentid;
	}

	public Integer getparentid() {
		return parentid;
	}

	public void setiStatus(Integer iStatus) {
		this.iStatus = iStatus;
	}

	public Integer getiStatus() {
		return iStatus;
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

	public void setorther(String orther) {
		this.orther = orther;
	}

	public String getorther() {
		return orther;
	}
}