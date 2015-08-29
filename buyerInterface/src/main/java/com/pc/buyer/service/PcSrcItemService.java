package com.pc.buyer.service;

import com.pc.buyer.model.PcSrcItem;

import java.util.List;

/**
 * @author hesin
 * @Created with： com.pc.buyer.service
 * @Des: 分类项service
 * @date 2015/8/20
 */
public interface PcSrcItemService {

    //查询所有正常分类项目
    public List<PcSrcItem> listAll();

    //查询单个分类项
    public PcSrcItem getById(Integer id);


    //查询单个分类项详情
    public PcSrcItem getByTypeId(Integer typeid);

//TODO 增量更新数据
}