package com.ds.annotation.impl;

import com.ds.annotation.PermissionCheck;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: xxxxx
 * @create: 2020-12-07
 */
public class PermissionCheckInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HandlerMethod handlerMethod = (HandlerMethod)handler;
        PermissionCheck permission = handlerMethod.getMethodAnnotation(PermissionCheck.class);
        if(permission == null){
            permission = handlerMethod.getBeanType().getAnnotation(PermissionCheck.class);
        }

        //如果没有添加权限注解则直接跳过允许访问
        if (permission == null) {
            return true;
        }

        //获取注解中的值
        String resourceKey = permission.resourceKey();

        //TODO 权限校验一般需要获取用户信息，通过查询数据库进行权限校验
        //TODO 这里只进行简单演示，如果resourceKey为testKey则校验通过，否则不通过
        if ("testKey".equals(resourceKey)) {
            return true;
        }

        return false;
    }

}
