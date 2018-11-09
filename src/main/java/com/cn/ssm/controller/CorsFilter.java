package com.cn.ssm.controller;


import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CorsFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String strUri = request.getRequestURI();
        System.out.println(strUri);
        if(strUri.indexOf("login") > -1 ) {
            response.setHeader("Access-Control-Allow-Origin", "*");
        };
        filterChain.doFilter(request, response);
    }
}
