package com.rouna.service.main.config.mybatis;

import com.rouna.service.main.config.mybatis.interceptor.PaginationInterceptor;
import org.apache.ibatis.plugin.Interceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import java.util.Properties;

@RefreshScope
@Configuration
@MapperScan("com.rouna")
public class MyBatisConfig extends CachingConfigurerSupport {


	@Bean
	public Interceptor getInterceptor(){
		PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
		Properties properties = new Properties();
		properties.setProperty("databaseType","mysql");
		paginationInterceptor.setProperties(properties);
		return paginationInterceptor;
	}


}
