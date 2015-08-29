package com.pc.buyer.model;

import com.google.gson.annotations.Expose;
import com.sf.common.reflection.annotations.pbdb_alias;
import com.sf.common.reflection.annotations.pbdb_ignore;

import java.util.Date;

/*  */
@pbdb_alias("pc_src_goods")
public class PcSrcGoods {
    @pbdb_ignore
    @Expose
    private Integer id;//remark:商铺ID;length:10; not null,default:null
    @pbdb_alias("src_id")
    @Expose
    private Integer srcId;//remark:虚拟的资源ID;length:10; not null,default:0
    @pbdb_alias("src_type")
    @Expose
    private Integer srcType;//remark:资源类型 1 item 2 type;length:10
    @pbdb_alias("goods_id")
    @Expose
    private Integer goodsId;//remark:资源ID;length:10; not null,default:null
    @Expose
    private Integer type;//remark:资源类型 1、商品 2 品类 3 品牌 4买手店铺;length:10
    @Expose
    private String thumb;//remark:缩率图;length:128
    @Expose
    private String icon;//remark:小图标;length:255
    @pbdb_alias("t_status")
    @Expose
    private Integer tStatus;//remark:状态 1 新建 2 上线 3下线;length:10; not null,default:1
    @Expose
    private Integer acttype;//remark:跳转类型 1 打开详情;length:10; not null,default:1
    @Expose
    private String actvalue;//remark:跳转地址;length:128
    @pbdb_alias("create_time")
    @Expose
    private Date createTime;//remark:进驻时间;length:19
    @pbdb_ignore
    @pbdb_alias("update_time")
    @Expose
    private Date updateTime;//remark:;length:19; not null,default:CURRENT_TIMESTAMP
    @Expose
    private String orther;//remark:其他信息;length:255

    public PcSrcGoods() {
    }

    @Override
    public String toString() {
        return "PcSrcGoods{" +
                "id=" + id +
                ", srcId=" + srcId +
                ", srcType=" + srcType +
                ", goodsId=" + goodsId +
                ", type=" + type +
                ", thumb='" + thumb + '\'' +
                ", icon='" + icon + '\'' +
                ", tStatus=" + tStatus +
                ", acttype=" + acttype +
                ", actvalue='" + actvalue + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", orther='" + orther + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSrcId() {
        return srcId;
    }

    public void setSrcId(Integer srcId) {
        this.srcId = srcId;
    }

    public Integer getSrcType() {
        return srcType;
    }

    public void setSrcType(Integer srcType) {
        this.srcType = srcType;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer gettStatus() {
        return tStatus;
    }

    public void settStatus(Integer tStatus) {
        this.tStatus = tStatus;
    }

    public Integer getActtype() {
        return acttype;
    }

    public void setActtype(Integer acttype) {
        this.acttype = acttype;
    }

    public String getActvalue() {
        return actvalue;
    }

    public void setActvalue(String actvalue) {
        this.actvalue = actvalue;
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

    public String getOrther() {
        return orther;
    }

    public void setOrther(String orther) {
        this.orther = orther;
    }
}