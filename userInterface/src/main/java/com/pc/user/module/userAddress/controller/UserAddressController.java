package com.pc.user.module.userAddress.controller;

import com.pc.user.model.UserAddress;
import com.pc.user.module.userAddress.service.UserAddressService;
import com.sf.common.model.CommonRequest;
import com.sf.common.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 描述：
 * 创建时间：15/8/20
 * 作者：yanghui
 */
@Controller
@RequestMapping(value = "/address")
public class UserAddressController {
    @Autowired
    private UserAddressService userAddressService;

    @RequestMapping(value = "/search")
    public void search(HttpServletRequest request, HttpServletResponse response) throws Exception {
        CommonRequest commonRequest = new CommonRequest(request, response);
        Integer userId = commonRequest.get("userId", 0);
        commonRequest.send(userAddressService.search(userId));
    }

    @RequestMapping(value = "/default")
    public void defaultAddress(HttpServletRequest request, HttpServletResponse response) throws Exception {
        CommonRequest commonRequest = new CommonRequest(request, response);
        Integer userId = commonRequest.get("userId", 0);
        commonRequest.send(userAddressService.getDefaultAddress(userId));
    }

    @RequestMapping(value = "/save")
    public void save(HttpServletRequest request, HttpServletResponse response) throws Exception {
        CommonRequest commonRequest = new CommonRequest(request, response);
        UserAddress userAddress = JsonUtil.fromJson(commonRequest.getJsonData(), UserAddress.class);
        commonRequest.send(userAddressService.save(userAddress));
    }
}
