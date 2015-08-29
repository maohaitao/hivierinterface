package com.pc.buyer.model;

import com.google.gson.annotations.Expose;
import com.sf.common.reflection.annotations.pbdb_alias;
import com.sf.common.reflection.annotations.pbdb_ignore;

import java.util.Date;

/*  */
@pbdb_alias("pc_src_type")
public class PcSrcType {
    @pbdb_ignore
    @Expose
    private java.lang.Integer id;//remark:商铺ID;length:10; not null,default:null
    @pbdb_alias("type_name")
    @Expose
    private java.lang.String typeName;//remark:节点名称;length:100; not null,default:null
    @Expose
    private java.lang.Integer seq;//remark:排序;length:10
    @Expose
    private java.lang.String background;//remark:背景图片;length:128
    @Expose
    private java.lang.Integer ishome;//remark:是否主页 0 否 1是;length:10
    @Expose
    private java.lang.String cicon;//remark:缩率图标;length:128
    @Expose
    private java.lang.String icon;//remark:小图标;length:255
    @Expose
    private java.lang.Integer moreid;//remark:是否展示更多 0 不展示 1展示;length:10
    @pbdb_alias("t_status")
    @Expose
    private java.lang.Integer tStatus;//remark:状态 1 新建 2 上线 3下线;length:10; not null,default:1
    @Expose
    private java.lang.Integer showtitle;//remark:是否展示标题:0否 1是;length:10; not null,default:0
    @pbdb_alias("create_time")
    @Expose
    private java.util.Date createTime;//remark:进驻时间;length:19
    @pbdb_ignore
    @pbdb_alias("update_time")
    @Expose
    private java.util.Date updateTime;//remark:;length:19; not null,default:CURRENT_TIMESTAMP
    @Expose
    private java.lang.String orther;//remark:其他信息;length:255

    public PcSrcType() {
    }

    @Override
    public String toString() {
        return "PcSrcType{" +
                "id=" + id +
                ", typeName='" + typeName + '\'' +
                ", seq=" + seq +
                ", background='" + background + '\'' +
                ", ishome=" + ishome +
                ", cicon='" + cicon + '\'' +
                ", icon='" + icon + '\'' +
                ", moreid=" + moreid +
                ", tStatus=" + tStatus +
                ", showtitle=" + showtitle +
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

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public Integer getIshome() {
        return ishome;
    }

    public void setIshome(Integer ishome) {
        this.ishome = ishome;
    }

    public String getCicon() {
        return cicon;
    }

    public void setCicon(String cicon) {
        this.cicon = cicon;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getMoreid() {
        return moreid;
    }

    public void setMoreid(Integer moreid) {
        this.moreid = moreid;
    }

    public Integer gettStatus() {
        return tStatus;
    }

    public void settStatus(Integer tStatus) {
        this.tStatus = tStatus;
    }

    public Integer getShowtitle() {
        return showtitle;
    }

    public void setShowtitle(Integer showtitle) {
        this.showtitle = showtitle;
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