package com.pc.buyer.service;

import com.pc.buyer.model.PcItemItem;
import com.pc.buyer.model.PcSrcGoods;

import java.util.List;

/**
 * @author hesin
 * @Created with： com.pc.buyer.service
 * @Des: 分类对应的资源信息 TODO 增量更新数据
 * @date 2015/8/20
 */
public interface PcSrcGoodsService {

    //查询所有正常买手信息
    public List<PcSrcGoods> listAll();

    public PcSrcGoods getById(Integer id);

    //查询单个父亲节点关联信息所有节点
    public List<PcSrcGoods> getParentId(Integer parentid);
}
