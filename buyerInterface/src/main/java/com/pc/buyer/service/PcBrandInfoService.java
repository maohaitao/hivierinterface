package com.pc.buyer.service;

import com.pc.buyer.model.PcBrandInfo;

import java.util.Date;
import java.util.List;

/**
 * @author hesin
 * @Created with： com.pc.buyer.service
 * @Des: 品牌接口
 * @date 2015/8/18
 */
public interface PcBrandInfoService {
    //查询所有的品牌
    public List<PcBrandInfo> listAll();

    //查询单个品牌
    public PcBrandInfo getById(Integer id);

    //定时更新品牌
    public boolean listUpdate(Date time);

    //查询取消合作的品牌
    public boolean listCancel(Date time);
}
