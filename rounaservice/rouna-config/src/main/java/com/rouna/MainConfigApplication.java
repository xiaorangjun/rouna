package com.rouna;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Created by Administrator on 2017/12/8.
 */
@EnableEurekaClient
@SpringBootApplication
@EnableConfigServer
@EnableDiscoveryClient
public class MainConfigApplication {
    public static void main(String[] args){
        SpringApplication.run(MainConfigApplication.class,args);
    }

}
