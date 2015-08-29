package com.pc.buyer.service;

import com.pc.buyer.model.PcItemType;

import java.util.List;

/**
 * @author hesin
 * @Created with： com.pc.buyer.service
 * @Des: 分类项对应的分类列表 TODO 缓存处理
 * @date 2015/8/21
 */
public interface PcItemTypeService {

    //查询所有正常节点关联分类列表信息
    public List<PcItemType> listAll();

    //查询单个父亲节点关联信息所有分类列表
    public List<PcItemType> getParentId(Integer parentid);

}
