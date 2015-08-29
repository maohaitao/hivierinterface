package com.pc.user.module.shopCart.service.impl;

import com.google.gson.JsonArray;
import com.pc.user.model.ShopCart;
import com.pc.user.module.shopCart.service.ShopCartService;
import com.sf.common.constant.ResultErrorCode;
import com.sf.common.util.JsonUtil;
import com.sf.common.util.Result;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 描述：
 * 创建时间：15/8/19
 * 作者：yanghui
 */
@Service
public class ShopCartServiceImpl implements ShopCartService {
    @Override
    public Result search(Integer userId) {
        Result result = new Result();
        if (userId == null || userId == 0) {
            return result.paramError(ResultErrorCode.STATUS_CODE_PARAM_USERID_IS_NULL);
        }
        Map<Integer, Cart> cartMap = new HashMap<Integer, Cart>();
        List<ShopCart> shopCartList = new ArrayList<ShopCart>();

        List<Cart> cartList = new ArrayList<Cart>();
        ShopCart shopCart1 = new ShopCart();
        shopCart1.setId(1);
        shopCart1.setBuyerId(1);
        shopCart1.setBuyerName("米奇丁当1");
        shopCart1.setColor("红色");
        shopCart1.setGoodsId(1001);
        shopCart1.setGoodsName("米奇丁当连衣裙1");
        shopCart1.setGoodsImage("http://image.baidu.com/search/detail?ct=503316480&z=undefined&tn=baiduimagedetail&ipn=d&word=google&step_word=&ie=utf-8&in=&cl=2&lm=-1&st=undefined&cs=2197559911,3502857023&os=716429324,1880812731&pn=0&rn=1&di=74882413870&ln=1000&fr=&fmq=1439971177427_R&ic=undefined&s=undefined&se=&sme=&tab=0&width=&height=&face=undefined&is=0,0&istype=0&ist=&jit=&bdtype=0&gsm=0&objurl=http%3A%2F%2Fimg3.cache.netease.com%2Ftech%2F2010%2F5%2F6%2F201005060155332f5a5.jpg");
        shopCart1.setNumber(2);
        shopCart1.setPrice(188.00);
        shopCart1.setSize("M");


        ShopCart shopCart2 = new ShopCart();
        shopCart2.setId(2);
        shopCart2.setBuyerId(2);
        shopCart2.setBuyerName("米奇丁当2");
        shopCart2.setColor("红色");
        shopCart2.setGoodsId(1001);
        shopCart2.setGoodsName("米奇丁当连衣裙2");
        shopCart2.setGoodsImage("http://image.baidu.com/search/detail?ct=503316480&z=undefined&tn=baiduimagedetail&ipn=d&word=google&step_word=&ie=utf-8&in=&cl=2&lm=-1&st=undefined&cs=2197559911,3502857023&os=716429324,1880812731&pn=0&rn=1&di=74882413870&ln=1000&fr=&fmq=1439971177427_R&ic=undefined&s=undefined&se=&sme=&tab=0&width=&height=&face=undefined&is=0,0&istype=0&ist=&jit=&bdtype=0&gsm=0&objurl=http%3A%2F%2Fimg3.cache.netease.com%2Ftech%2F2010%2F5%2F6%2F201005060155332f5a5.jpg");
        shopCart2.setNumber(2);
        shopCart2.setPrice(181.00);
        shopCart2.setSize("M");


        ShopCart shopCart3 = new ShopCart();
        shopCart3.setId(3);
        shopCart3.setBuyerId(2);
        shopCart3.setBuyerName("米奇丁当3");
        shopCart3.setColor("红色");
        shopCart3.setGoodsId(1001);
        shopCart3.setGoodsName("米奇丁当连衣裙3");
        shopCart3.setGoodsImage("http://image.baidu.com/search/detail?ct=503316480&z=undefined&tn=baiduimagedetail&ipn=d&word=google&step_word=&ie=utf-8&in=&cl=2&lm=-1&st=undefined&cs=2197559911,3502857023&os=716429324,1880812731&pn=0&rn=1&di=74882413870&ln=1000&fr=&fmq=1439971177427_R&ic=undefined&s=undefined&se=&sme=&tab=0&width=&height=&face=undefined&is=0,0&istype=0&ist=&jit=&bdtype=0&gsm=0&objurl=http%3A%2F%2Fimg3.cache.netease.com%2Ftech%2F2010%2F5%2F6%2F201005060155332f5a5.jpg");
        shopCart3.setNumber(2);
        shopCart3.setPrice(191.00);
        shopCart3.setSize("M");

        shopCartList.add(shopCart1);
        shopCartList.add(shopCart2);
        shopCartList.add(shopCart3);
        for (ShopCart shopCart : shopCartList) {
            if (cartMap.containsKey(shopCart.getBuyerId())) {
                cartMap.get(shopCart.getBuyerId()).getGoods().add(shopCart);
            } else {
                Cart cart = new Cart();
                cart.setBuyerId(shopCart.getBuyerId());
                cart.setBuyerName(shopCart.getBuyerName());
                cart.getGoods().add(shopCart);
                cartMap.put(shopCart.getBuyerId(), cart);
            }
        }
        for (Map.Entry<Integer, Cart> entry : cartMap.entrySet()) {
            cartList.add(entry.getValue());
        }

        result.put("shopCarts", JsonUtil.toJsonTree(cartList));
        return result.success();
    }

    @Override
    public Result add(ShopCart shopCart) {
        Result result = new Result();
        if (shopCart.getUserId() == 0 || shopCart.getGoodsId() == 0 || shopCart.getNumber() == 0) {
            return result.paramError(ResultErrorCode.STATUS_CODE_PARAM_ERROR);
        }

        result.put("id", 1);
        return result.success();
    }


    @Override
    public Result delete(String shopCartIds) {
        Result result = new Result();
        if (shopCartIds == null) {
            return result.paramError(ResultErrorCode.STATUS_CODE_PARAM_ERROR);
        }
        return result.success();
    }

    @Override
    public Result updateNumber(Integer UserId, Integer shopCartId, Integer number) {
        Result result = new Result();
        if (UserId == 0 || shopCartId == 0 || number == 0) {
            return result.paramError(ResultErrorCode.STATUS_CODE_PARAM_ERROR);
        }

        return result.success();
    }

    class Cart {
        private Integer buyerId;
        private String buyerName;
        private List<ShopCart> goods = new ArrayList<>();

        public Integer getBuyerId() {
            return buyerId;
        }

        public void setBuyerId(Integer buyerId) {
            this.buyerId = buyerId;
        }

        public String getBuyerName() {
            return buyerName;
        }

        public void setBuyerName(String buyerName) {
            this.buyerName = buyerName;
        }

        public List<ShopCart> getGoods() {
            return goods;
        }

        public void setGoods(List<ShopCart> goods) {
            this.goods = goods;
        }
    }
}
