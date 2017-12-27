package com.rouna.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Created by Administrator on 2017/12/8.
 */
@SpringBootApplication
@EnableEurekaServer
public class MainEurekaServerApplication {
    public static void main(String[] args){
        SpringApplication.run(MainEurekaServerApplication.class,args);
    }
}
