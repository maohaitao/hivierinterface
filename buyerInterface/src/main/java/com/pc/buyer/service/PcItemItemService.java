package com.pc.buyer.service;

import com.pc.buyer.model.PcItemItem;

import java.util.List;

/**
 * @author hesin
 * @Created with： com.pc.buyer.service
 * @Des: 节点之间的关联 TODO  缓存处理
 * @date 2015/8/21
 */
public interface PcItemItemService {

    //查询所有正常节点关联信息
    public List<PcItemItem> listAll();

    //查询单个父亲节点关联信息所有节点
    public List<PcItemItem> getParentId(Integer parentid);
}
