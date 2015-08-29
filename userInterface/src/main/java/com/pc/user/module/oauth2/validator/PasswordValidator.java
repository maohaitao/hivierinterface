package com.pc.user.module.oauth2.validator;

import org.apache.oltu.oauth2.common.OAuth;
import org.apache.oltu.oauth2.common.validators.AbstractValidator;

import javax.servlet.http.HttpServletRequest;

/**
 * 描述：
 * 创建时间：15/8/24
 * 作者：yanghui
 */
public class PasswordValidator extends AbstractValidator<HttpServletRequest> {

    public PasswordValidator() {
        requiredParams.add(OAuth.OAUTH_USERNAME);
        requiredParams.add(OAuth.OAUTH_PASSWORD);
        enforceClientAuthentication = true;
    }

}