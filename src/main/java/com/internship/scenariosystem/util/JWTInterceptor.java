package com.internship.scenariosystem.util;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;


import com.internship.scenariosystem.model.Manage;
import com.internship.scenariosystem.repo.ManageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

// 验证请求拦截器
public class JWTInterceptor implements HandlerInterceptor {
    @Autowired
    ManageRepo manageRepo;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        String token = request.getHeader("token");
        // 如果没有映射到方法上，直接通过
        if (!(handler instanceof HandlerMethod)) {
            return true; // 放行
        }
        HandlerMethod handlerMethod = (HandlerMethod)handler;
        Method method = handlerMethod.getMethod();
        // 检查方法上加NeedLogin注释没，如果没有直接放行
        if (!method.isAnnotationPresent(NeedLogin.class)) {
            return true;
        }
        NeedLogin needLogin = method.getAnnotation(NeedLogin.class);
        if (needLogin.required()) {
            if (token == null) {
                System.out.println("token为空");
                // 没有token
                throw new RuntimeException("401");
            }
            // 获取token中的userId
            String userId;
            try {
                userId = JWT.decode(token).getAudience().get(0);
            } catch (JWTDecodeException j) {
                throw new RuntimeException("401");
            }

            // 根据userId取用户
            Manage manage = manageRepo.getById(Integer.parseInt(userId));
            if (manage == null) {
                throw new RuntimeException("401");
            }

            System.out.print(manage);
            System.out.print("username=" + manage.getManage_name());

            JWTVerifier jwtVerify = JWT.require(Algorithm.HMAC256(manage.getManage_password())).build();
            try {
                // 验证token
                jwtVerify.verify(token);
            } catch (JWTVerificationException e) {
                throw new RuntimeException("401");
            }
        }

        return true;
    }
}
