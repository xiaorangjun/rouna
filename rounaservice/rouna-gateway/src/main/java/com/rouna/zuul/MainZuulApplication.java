package com.rouna.zuul;

import com.rouna.zuul.filter.AccessTokenFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

/**
 * Created by Administrator on 2017/12/28.
 */
@SpringBootApplication
@EnableZuulProxy // 使用@EnableZuulProxy来开启Zuul的支持，如果你不想使用Zuul提供的Filter和反向代理的功能的话，此处可以使用@EnableZuulServer注解
public class MainZuulApplication {
    public static void main(String [] args){
        SpringApplication.run(MainZuulApplication.class,args);
    }

    @Bean
    public AccessTokenFilter accessFilter() {
        return new AccessTokenFilter();
    }
}
