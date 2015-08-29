package com.pc.buyer.service;

import com.pc.buyer.model.PcBannerInfo;

import java.util.List;

/**
 * @author hesin
 * @Created with： com.pc.buyer.service
 * @Des: banner/焦点业务处理
 * @date 2015/8/19
 */
public interface PcBannerInfoService {
    //查询所有的品牌
    public List<PcBannerInfo> listAll();

    //查询单个品牌
    public PcBannerInfo getById(String id);
}
