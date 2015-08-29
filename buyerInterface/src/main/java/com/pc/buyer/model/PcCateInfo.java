package com.pc.buyer.model;

import com.sf.common.reflection.annotations.pbdb_alias;
import com.sf.common.reflection.annotations.pbdb_ignore;

import java.util.Date;
import java.util.List;

/*  */
@pbdb_alias("pc_cate_info")
public class PcCateInfo {
    @pbdb_ignore
    private Integer id;//remark:;length:10; not null,default:null
    @pbdb_alias("cate_name")
    private String cateName;//remark:类名称;length:255; not null,default:null
    @pbdb_alias("cate_type")
    private Integer cateType;//remark:0根分类 1为子分类;length:10; not null,default:null
    @pbdb_alias("pre_id")
    private Integer preId;//remark:父类分类ID;length:10; not null,default:null
    @pbdb_alias("c_status")
    private Integer cStatus;//remark:状态 1可以用 2 停用;length:10; not null,default:null
    private Integer priority;//remark:优先级别 优先级别,越小越优先
    private String description;//remark:描述;length:65535; not null,default:null
    @pbdb_alias("create_time")
    private Date createTime;//remark:;length:10; not null,default:null
    @pbdb_ignore
    @pbdb_alias("update_time")
    private Date updateTime;//remark:;length:19; not null,default:CURRENT_TIMESTAMP

    private List<Integer> brandIds;

    public PcCateInfo() {
    }

    @Override
    public String toString() {
        return "PcCateInfo{" +
                "id=" + id +
                ", cateName='" + cateName + '\'' +
                ", cateType=" + cateType +
                ", preId=" + preId +
                ", cStatus=" + cStatus +
                ", priority=" + priority +
                ", description='" + description + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    public Integer getCateType() {
        return cateType;
    }

    public void setCateType(Integer cateType) {
        this.cateType = cateType;
    }

    public Integer getPreId() {
        return preId;
    }

    public void setPreId(Integer preId) {
        this.preId = preId;
    }

    public Integer getcStatus() {
        return cStatus;
    }

    public void setcStatus(Integer cStatus) {
        this.cStatus = cStatus;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public List<Integer> getBrandIds() {
        return brandIds;
    }

    public void setBrandIds(List<Integer> brandIds) {
        this.brandIds = brandIds;
    }
}