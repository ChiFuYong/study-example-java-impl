package com.chifuyong.jwt.springboot;

import com.chifuyong.jwt.springboot.interceptor.JwtInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * SpringBoot 启动类
 *
 * @date： 2020/11/23
 * @author: chify
 */
@SpringBootApplication
public class JwtApplication implements WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(JwtApplication.class);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //添加拦截器
        registry.addInterceptor(new JwtInterceptor())
                //所有接口拦截
                .addPathPatterns("/**")
                //登录接口放行
                .excludePathPatterns("/login");
    }
}
