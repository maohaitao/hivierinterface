package com.pc.user.module.oauth2.service;

import com.pc.user.module.oauth2.request.OAuthPasswordTokenRequest;
import com.pc.user.module.oauth2.token.TokenCache;
import com.sf.common.constant.ResultErrorCode;
import com.sf.common.util.JsonUtil;
import com.sf.common.util.Result;
import org.apache.oltu.oauth2.as.issuer.MD5Generator;
import org.apache.oltu.oauth2.as.issuer.OAuthIssuer;
import org.apache.oltu.oauth2.as.issuer.OAuthIssuerImpl;
import org.apache.oltu.oauth2.as.response.OAuthASResponse;
import org.apache.oltu.oauth2.common.exception.OAuthSystemException;
import org.apache.oltu.oauth2.common.message.OAuthResponse;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Response;

/**
 * 描述：
 * 创建时间：15/8/24
 * 作者：yanghui
 */
@Service
public class Oauth2TokenService {
    private final static String clientId = "cgDhzWCYIpryQhwFwQgO7ikB2iXn9ZVME1tODmhD";
    private final static String clientSecret = "0OBQFWCWr_ArnL2cWOWcOdZJyMFoBnuTp-M3uhG3";

    private Integer validatorUserPassword(String username, String password) throws Exception {
        if (!StringUtils.isEmpty(username) && !StringUtils.isEmpty(password)) {
            return 1;
        }
        return null;
    }


    public Result getToken(OAuthPasswordTokenRequest oauthRequest) throws Exception {
        Result result = new Result();
        if (!clientId.equals(oauthRequest.getClientId()) || !clientSecret.equals(oauthRequest.getClientSecret())) {
            return result.businessError(ResultErrorCode.REQUEST_ACCESSKEY_SECRETKEY_ERROR);
        }
        Integer userId = validatorUserPassword(oauthRequest.getUsername(), oauthRequest.getPassword());
        if (userId == null || userId == 0) {
            return result.businessError(ResultErrorCode.REQUEST_USER_ERROR);
        }
        result.put("token", JsonUtil.parse(getToken(userId)));
        return result.success();
    }

    private String getToken(Integer userId) throws OAuthSystemException {
        OAuthIssuer oauthIssuerImpl = new OAuthIssuerImpl(new MD5Generator());
        String accessToken = oauthIssuerImpl.accessToken();
        Integer expiresIn = 3600;
        OAuthResponse oAuthResponse = OAuthASResponse
                .tokenResponse(HttpServletResponse.SC_OK)
                .setAccessToken(accessToken)
                .setExpiresIn(String.valueOf(expiresIn))
                .buildJSONMessage();
        Response response = Response.status(oAuthResponse.getResponseStatus()).entity(oAuthResponse.getBody()).build();
        TokenCache.add(accessToken, expiresIn, userId);
        return response.getEntity().toString();
    }
}
