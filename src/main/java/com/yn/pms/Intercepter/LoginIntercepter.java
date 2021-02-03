package com.yn.pms.Intercepter;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author yn
 * @class pms
 * @describe 自定义拦截器 判断用户是否登录
 * @date 2021/1/27-15:26
 */
public class LoginIntercepter implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        //判断是否登录
        if (request.getSession().getAttribute("user")==null){
            //session里没有用户信息 就是没有登录
            try {
                response.sendRedirect("/login.html");
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                return false;
            }

        }else {
            //登录了 就放行
            return true;
        }
    }
}
