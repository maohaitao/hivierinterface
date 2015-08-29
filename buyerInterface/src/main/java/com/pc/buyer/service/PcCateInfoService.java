package com.pc.buyer.service;

import com.pc.buyer.model.PcCateInfo;

import java.util.List;

/**
 * @author hesin
 * @Created with： com.pc.buyer.service
 * @Des: 品牌对应的品类
 * @date 2015/8/18
 */
public interface PcCateInfoService {

    //查询所有正常的品类
    public List<PcCateInfo> listAll();

    //查询单个品类
    public PcCateInfo getById(String id);
}
