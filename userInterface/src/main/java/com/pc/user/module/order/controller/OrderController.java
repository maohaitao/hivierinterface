package com.pc.user.module.order.controller;

import com.pc.user.module.order.service.OrderService;
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
@RequestMapping(value = "/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/confirm")
    public void confirm(HttpServletRequest request, HttpServletResponse response) throws Exception {
        CommonRequest commonRequest = new CommonRequest(request, response);
        String shopCartIds = commonRequest.get("shopCartIds");
        commonRequest.send(orderService.orderConfirm(shopCartIds));
    }
}
