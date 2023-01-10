package com.learning.enterprise.idempotent.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @Auther: zuowenzhi 2023/1/10 created
 * @Description: com.learning.enterprise.idempotent.config
 * @version: 1.0
 */
@Configuration
public class HandlerRegistry implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new IdemptentInterceptor()).addPathPatterns("/**");
    }
}


