package com.pc.user.module.shopCart.controller;

import com.pc.user.model.ShopCart;
import com.pc.user.module.shopCart.service.ShopCartService;
import com.sf.common.model.CommonRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 描述：
 * 创建时间：15/8/19
 * 作者：yanghui
 */
@Controller
@RequestMapping(value = "/shopCart")
public class ShopCartController {
    @Autowired
    private ShopCartService shopCartService;

    @RequestMapping(value = "/search")
    public void search(HttpServletRequest request, HttpServletResponse response) throws Exception {
        CommonRequest commonRequest = new CommonRequest(request, response);
        Integer userId = commonRequest.get("userId", 0);
        commonRequest.send(shopCartService.search(userId));
    }

    @RequestMapping(value = "/add")
    public void add(HttpServletRequest request, HttpServletResponse response) throws Exception {
        CommonRequest commonRequest = new CommonRequest(request, response);
        Integer userId = commonRequest.get("userId", 0);
        Integer goodsId = commonRequest.get("goodsId", 0);
        Integer number = commonRequest.get("number", 0);


        ShopCart shopCart = new ShopCart();
        shopCart.setUserId(userId);
        shopCart.setGoodsId(goodsId);
        shopCart.setNumber(number);
        commonRequest.send(shopCartService.add(shopCart));
    }

    @RequestMapping(value = "/delete")
    public void delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
        CommonRequest commonRequest = new CommonRequest(request, response);
        String shopCartIds = commonRequest.get("shopCartIds");
        commonRequest.send(shopCartService.delete(shopCartIds));
    }

    @RequestMapping(value = "/editNumber")
    public void editNumber(HttpServletRequest request, HttpServletResponse response) throws Exception {
        CommonRequest commonRequest = new CommonRequest(request, response);
        Integer userId = commonRequest.get("userId", 0);
        Integer shopCartId = commonRequest.get("shopCartId", 0);
        Integer number = commonRequest.get("number", 0);
        commonRequest.send(shopCartService.updateNumber(userId, shopCartId, number));
    }
}
