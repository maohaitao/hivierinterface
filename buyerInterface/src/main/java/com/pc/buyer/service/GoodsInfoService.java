package com.pc.buyer.service;

import com.pc.buyer.model.GoodsInfo;

import java.util.Date;
import java.util.List;

/**
 * @author hesin
 * @Created with： com.pc.buyer.service
 * @Des: 商品业务信息
 * @date 2015/8/18
 */
public interface GoodsInfoService {

    //查询所有正常的商品
    public List<GoodsInfo> listAll();

    //查询单个商品详情
    public GoodsInfo getById(Integer id);

    //通过品牌ID查询对应的商品
    public List<GoodsInfo> getByBrandId(Integer brandid);

    //定时查询修改信息
    public boolean listUpdate(Date time);

    //查询下架的商品
    public boolean listCancel(Date time);

}
