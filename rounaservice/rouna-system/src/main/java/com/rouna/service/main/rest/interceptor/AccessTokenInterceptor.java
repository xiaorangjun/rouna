package com.rouna.service.main.rest.interceptor;

import com.rouna.service.main.api.RounaUserInfo;
import com.rouna.service.main.utils.JwtToken;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class AccessTokenInterceptor extends HandlerInterceptorAdapter {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        boolean flag = false;
        String accessToken = request.getHeader("XAuthorization");
        logger.info("Filter====>{}",accessToken);
        if (StringUtils.isNotBlank(accessToken)) {
            RounaUserInfo v = JwtToken.validToken(accessToken);
            if (v != null) {
               flag = true;
            }
        }
        if (!flag) {
            response.setStatus(HttpStatus.FORBIDDEN.value());
            response.getWriter().print("AccessToken ERROR");
        }
        return flag;
    }
}
