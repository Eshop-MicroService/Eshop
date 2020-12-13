package com.eshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan(basePackages = "com.eshop.users.mapper")
@EnableFeignClients(basePackages = {"com.eshop.user.feign"})
public class OAuthApplication {
    public static void main(String[] args) {
        SpringApplication.run(com.eshop.OAuthApplication.class,args);
    }


    //http://localhost:9001/oauth/authorize?client_id=eshop&response_type=code&scop=app&redirect_uri=http://localhost
    //密码授权：http://localhost:9001/oauth/token?grant_type=password&username=eshop&password=12345678
    //授权码授权：http://localhost:9001/oauth/token?grant_type=authorization_code&code=9rs4sU&redirect_uri=http://localhost
    @Bean(name = "restTemplate")
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
    /***
     * 登录：
     * 参数传递：
     * 1.账号 username=eshop
     * 2.密码 password=12345678
     * 3.授权方式 grant_type=password
     *
     * 请求头传递：
     * Basic Base64(客户端id:客户端密钥) Authorization=Basic ZXNob3A6ZXNob3A=
     */
}

