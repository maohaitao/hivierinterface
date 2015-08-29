package com.pc.buyer.service;

import com.pc.buyer.model.PcBuyerInfo;

import java.util.Date;
import java.util.List;

/**
 * @author hesin
 * @Created with： com.pc.buyer.service
 * @Des: 买手信息
 * @date 2015/8/18
 */
public interface PcBuyerInfoService {

    //查询所有正常买手信息
    public List<PcBuyerInfo> listAll();

    //查询单个买手详情
    public PcBuyerInfo getById(Integer id);

    //定时查询修改信息
    public boolean listUpdate(Date time);

    //查询失效的买手
    public boolean listCancel(Date time);
}
