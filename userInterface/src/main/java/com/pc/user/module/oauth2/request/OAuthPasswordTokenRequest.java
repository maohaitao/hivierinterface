package com.pc.user.module.oauth2.request;

import com.pc.user.module.oauth2.validator.PasswordValidator;
import org.apache.oltu.oauth2.as.request.AbstractOAuthTokenRequest;
import org.apache.oltu.oauth2.common.exception.OAuthProblemException;
import org.apache.oltu.oauth2.common.exception.OAuthSystemException;
import org.apache.oltu.oauth2.common.utils.OAuthUtils;
import org.apache.oltu.oauth2.common.validators.OAuthValidator;

import javax.servlet.http.HttpServletRequest;

/**
 * 描述：
 * 创建时间：15/8/24
 * 作者：yanghui
 */
public class OAuthPasswordTokenRequest extends AbstractOAuthTokenRequest {

    /**
     * Create an OAuth Token request from a given HttpSerlvetRequest
     *
     * @param request the httpservletrequest that is validated and transformed into the OAuth Token Request
     * @throws OAuthSystemException  if an unexpected exception was thrown
     * @throws OAuthProblemException if the request was not a valid Token request this exception is thrown.
     */
    public OAuthPasswordTokenRequest(HttpServletRequest request) throws OAuthSystemException, OAuthProblemException {
        super(request);
    }

    @Override
    protected OAuthValidator<HttpServletRequest> initValidator() throws OAuthProblemException, OAuthSystemException {
        return OAuthUtils.instantiateClass(PasswordValidator.class);
    }
}