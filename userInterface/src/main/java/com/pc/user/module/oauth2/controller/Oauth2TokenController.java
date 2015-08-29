package com.pc.user.module.oauth2.controller;

import com.pc.user.module.oauth2.request.OAuthPasswordTokenRequest;
import com.pc.user.module.oauth2.service.Oauth2TokenService;
import com.sf.common.model.CommonRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 描述：
 * 创建时间：15/8/24
 * 作者：yanghui
 */
@Controller
@RequestMapping(value = "/oauth")
public class Oauth2TokenController {

    @Autowired
    private Oauth2TokenService oauth2TokenService;

    @RequestMapping(value = "/token")
    public void token(HttpServletRequest request, HttpServletResponse response) throws Exception {
        CommonRequest commonRequest = new CommonRequest();
        commonRequest.setRequest(request);
        commonRequest.setResponse(response);
        OAuthPasswordTokenRequest oauthRequest = new OAuthPasswordTokenRequest(request);
        commonRequest.send(oauth2TokenService.getToken(oauthRequest));
    }


}
