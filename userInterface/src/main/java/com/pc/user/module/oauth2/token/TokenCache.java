package com.pc.user.module.oauth2.token;

import java.util.HashMap;
import java.util.Map;

/**
 * 描述：
 * 创建时间：15/8/24
 * 作者：yanghui
 */
public class TokenCache {
    private final static Map<String, Token> tokenMap = new HashMap<String, Token>();

    public static void add(String accessToken, Integer expiresIn, Integer userId) {
        Token token = new Token();
        token.setToken(accessToken);
        token.setExpiresIn(expiresIn);
        token.setUserId(userId);
        tokenMap.put(accessToken, token);
    }

    public static Token getToken(String accessToken) {
        return tokenMap.get(accessToken);
    }
}
