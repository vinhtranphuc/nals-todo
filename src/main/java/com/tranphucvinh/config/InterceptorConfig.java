package com.tranphucvinh.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.tranphucvinh.interceptor.LogInterceptor;

@Configuration
public class InterceptorConfig extends WebMvcConfigurationSupport {
	@Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LogInterceptor());
    }
}
