package com.pc.user.interceptor;

import com.pc.user.module.oauth2.token.Token;
import com.pc.user.module.oauth2.token.TokenCache;
import com.sf.common.constant.ResultErrorCode;
import com.sf.common.util.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2015/4/23.
 *
 * @author hesin
 *         日志拦截
 */
public class Interceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(Interceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        if (!request.getRequestURI().contains("/oauth/token")) {
//            Result result = new Result();
//            Token token = TokenCache.getToken(request.getParameter("token"));
//            if (token == null || !token.isValid()) {
//                result.businessError(ResultErrorCode.REQUEST_TOKEN_ERROR);
//                send(response, result);
//                return false;
//            }
//            if (request.getParameter("data") == null) {
//                result.businessError(ResultErrorCode.REQUEST_ERROR_CODE_403);
//                send(response, result);
//                return false;
//            }
//            request.setAttribute("userId", token.getUserId());
//        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        if (ex != null) {
            Result result = new Result();
            result.businessError(ResultErrorCode.SYSTEM_CODE);
            //调试模式显示错误信息
            if (logger.isDebugEnabled()) {
                result.setMessage(ex.getMessage());
            }
            send(response, result);
        }
    }

    private void send(HttpServletResponse response, Result result) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(result.toString());
    }
}
