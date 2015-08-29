package com.pc.user.module.shopCart.service;

import com.pc.user.model.ShopCart;
import com.sf.common.util.Result;

/**
 * 描述：
 * 创建时间：15/8/19
 * 作者：yanghui
 */
public interface ShopCartService {
    //查询购物车
    public Result search(Integer UserId);
    //增加购物车
    public Result add(ShopCart shopCart);
    //删除购物车
    public Result delete(String shopCartIds);
    //修改购物车数量
    public Result updateNumber(Integer UserId, Integer shopCartId, Integer number);
}
