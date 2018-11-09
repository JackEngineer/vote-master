package com.cn.ssm.controller;


import java.io.PrintWriter;
import java.lang.reflect.Method;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


@Configuration
public class LoginInterceptor  implements HandlerInterceptor {


    // 如果需要向页面提供一些公用 的数据或配置一些视图信息，使用此方法实现 从modelAndView入手
    // TODO 在执行Handler返回modelAndView之前执行
    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response, Object object,
                           ModelAndView modelAndView) throws Exception {
        String name = request.getServletPath().toString();
        System.out.println("========"+name+"===>LoginInterceptor postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

    // TODO 在执行Handler之前执行
    // 用于用户认证校验、用户权限校验
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {
        //获取请求的URL
        String url = request.getRequestURI();
        if(url.indexOf("login")>=0){
            return true;
        }
        //获取Session
        HttpSession session = request.getSession();
        String username = (String)session.getAttribute("uname");
        if(username != null){
            return true;
        }else {
            PrintWriter out = response.getWriter();
            StringBuffer sb = new StringBuffer("{ "+"errorMessage"+": "+"请重新登录"+ "errorCode:" +"9" +"}");
            out.print(sb.toString());
            out.close();
            return false;
        }
    }
  }