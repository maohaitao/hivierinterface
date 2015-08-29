package com.pc.buyer.service;

import com.pc.buyer.model.PcSrcType;

import java.util.List;

/**
 * @author hesin
 * @Created with： com.pc.buyer.service
 * @Des: 分类基础信息 TODO 增量更新数据
 * @date 2015/8/20
 */
public interface PcSrcTypeService {

    //查询所有分类项对应分类列表信息
    public List<PcSrcType> listAll();


    public PcSrcType getById(Integer id);

}
