package com.pc.buyer.model;

import java.util.*;
import com.google.gson.annotations.Expose;
import com.sf.common.reflection.annotations.*;

/*  */
@pbdb_alias("goods_details")
public class GoodsDetails {
	@pbdb_ignore
	private Integer id;//remark:;length:10; not null,default:null
	@pbdb_alias("goods_id")
	@Expose
	private Integer goodsId;//remark:商品ID;length:10; not null,default:null
	@pbdb_alias("g_status")
	private Integer gStatus;//remark:状态 1 新建 2 审核 3 上线 4 下线;length:10; not null,default:1
	@Expose
	private String icon;//remark:商品年份 如:2015;length:255
	@Expose
	private String infourl;//remark:详情图文;length:255
	@Expose
	private String desc;//remark:详情描述;length:65535; not null,default:null
	@Expose
	private String other;//remark:其他信息;length:255
	@pbdb_alias("create_time")
	private Date createTime;//remark:;length:19; not null,default:null
	@pbdb_ignore
	@pbdb_alias("update_time")
	private Date updateTime;//remark:;length:19; not null,default:CURRENT_TIMESTAMP

	public GoodsDetails() {
	}

	public void setid(Integer id) {
		this.id = id;
	}

	public Integer getid() {
		return id;
	}

	public void setgoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}

	public Integer getgoodsId() {
		return goodsId;
	}

	public void setgStatus(Integer gStatus) {
		this.gStatus = gStatus;
	}

	public Integer getgStatus() {
		return gStatus;
	}

	public void seticon(String icon) {
		this.icon = icon;
	}

	public String geticon() {
		return icon;
	}

	public void setinfourl(String infourl) {
		this.infourl = infourl;
	}

	public String getinfourl() {
		return infourl;
	}

	public void setdesc(String desc) {
		this.desc = desc;
	}

	public String getdesc() {
		return desc;
	}

	public void setother(String other) {
		this.other = other;
	}

	public String getother() {
		return other;
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