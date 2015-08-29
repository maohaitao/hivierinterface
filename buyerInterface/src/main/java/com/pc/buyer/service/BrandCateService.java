package com.pc.buyer.service;

import com.pc.buyer.model.BrandCate;

import java.util.List;

/**
 * @author hesin
 * @Created with： com.pc.buyer.service
 * @Des: 品类对应的品牌
 * @date 2015/8/18
 */
public interface BrandCateService {

    //查询所有正常的品类信息
    public List<BrandCate> listAll();

    //查询单个商品对应品类信息
    public List<BrandCate> getById(String id);
}
