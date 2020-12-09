package com.ds.annotation.impl;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author: xxxxx
 * @create: 2020-12-07
 */
@Configuration
public class PermissionCheckConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration registration = registry.addInterceptor(new PermissionCheckInterceptor());
        registration.addPathPatterns("/");
    }
}
