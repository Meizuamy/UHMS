package org.uhms.getway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

import static com.google.common.hash.Hashing.md5;

@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
public class ZuulGetwaySpringApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZuulGetwaySpringApplication.class,args);
    }
}
