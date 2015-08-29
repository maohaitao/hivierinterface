package com.pc.buyer.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.sf.common.reflection.annotations.pbdb_alias;
import com.sf.common.reflection.annotations.pbdb_ignore;

import java.util.Date;

/*  */
@pbdb_alias("pc_src_item")
public class PcSrcItem {
    @pbdb_ignore
    @Expose
    @SerializedName("rid")
    private java.lang.Integer id;//remark:商铺ID;length:10; not null,default:null
    @pbdb_alias("type_id")
    private java.lang.Integer typeId;//remark:虚拟的资源ID;length:10
    @pbdb_alias("type_name")
    @Expose
    private java.lang.String typeName;//remark:节点名称;length:100; not null,default:null
    @Expose
    private java.lang.Integer datatype;//remark:数据类型 1 挂载分类 2 具体数据;length:10
    @Expose
    private java.lang.Integer moreid;//remark:是否展示更多 0 不展示 1展示;length:10
    @pbdb_alias("i_status")
    private java.lang.Integer iStatus;//remark:状态 1 新建 2 上线 3下线;length:10; not null,default:1
    @Expose
    private java.lang.Integer showtitle;//remark:是否展示标题:0否 1是;length:10; not null,default:0
    @Expose
    private java.lang.Integer layouts;//remark:排版格式 1横向 2纵向;length:10
    @Expose
    private java.lang.Integer seq;//remark:排序;length:10
    @Expose
    private java.lang.String background;//remark:背景图;length:255
    @Expose
    private java.lang.String cicon;//remark:小图标;length:255
    @Expose
    private java.lang.String icon;//remark:小图标;length:255
    @Expose
    private java.lang.Integer viewtype;//remark:动作类型：datatype=1 1 ：列表展现分类；2：tab栏展现分类；3：图标+文字并排排列展现(顶级分类)；4：按钮形式tab栏；datatype=2 1 ：双栏两列；2 ：格子排版；3:一栏一列；;length:10; not null,default:null
    private java.lang.String descrption;//remark:描述;length:65535
    @pbdb_alias("create_time")
    private java.util.Date createTime;//remark:商家进驻时间;length:19
    @pbdb_ignore
    @pbdb_alias("update_time")
    private java.util.Date updateTime;//remark:;length:19; not null,default:CURRENT_TIMESTAMP
    private java.lang.String orther;//remark:其他信息;length:255


    public PcSrcItem() {
    }

    @Override
    public String toString() {
        return "PcSrcItem{" +
                "id=" + id +
                ", typeId=" + typeId +
                ", typeName='" + typeName + '\'' +
                ", datatype=" + datatype +
                ", moreid=" + moreid +
                ", iStatus=" + iStatus +
                ", showtitle=" + showtitle +
                ", layouts=" + layouts +
                ", seq=" + seq +
                ", background='" + background + '\'' +
                ", cicon='" + cicon + '\'' +
                ", icon='" + icon + '\'' +
                ", viewtype=" + viewtype +
                ", descrption='" + descrption + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", orther='" + orther + '\'' +
                '}';
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

    public String getCicon() {
        return cicon;
    }

    public void setCicon(String cicon) {
        this.cicon = cicon;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Integer getDatatype() {
        return datatype;
    }

    public void setDatatype(Integer datatype) {
        this.datatype = datatype;
    }


    public Integer getMoreid() {
        return moreid;
    }

    public void setMoreid(Integer moreid) {
        this.moreid = moreid;
    }

    public Integer getiStatus() {
        return iStatus;
    }

    public void setiStatus(Integer iStatus) {
        this.iStatus = iStatus;
    }

    public Integer getShowtitle() {
        return showtitle;
    }

    public void setShowtitle(Integer showtitle) {
        this.showtitle = showtitle;
    }

    public Integer getLayouts() {
        return layouts;
    }

    public void setLayouts(Integer layouts) {
        this.layouts = layouts;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getViewtype() {
        return viewtype;
    }

    public void setViewtype(Integer viewtype) {
        this.viewtype = viewtype;
    }

    public String getDescrption() {
        return descrption;
    }

    public void setDescrption(String descrption) {
        this.descrption = descrption;
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