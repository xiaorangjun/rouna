package com.rouna.service.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;


/**
 * Created by Administrator on 2017/12/9.
 */
@SpringBootApplication(scanBasePackages = "com.rouna")
@EnableFeignClients(basePackages = "com.rouna")
@EnableEurekaClient
public class SystemMainApplication {




    public static void main(String[] args){
        SpringApplication.run(SystemMainApplication.class,args);
    }
}