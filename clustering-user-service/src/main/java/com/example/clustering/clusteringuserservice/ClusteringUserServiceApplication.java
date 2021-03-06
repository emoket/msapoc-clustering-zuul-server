package com.example.clustering.clusteringuserservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
@EnableFeignClients
public class ClusteringUserServiceApplication {

    @Autowired
    HelloClient client;

    @RequestMapping("/")
    public String hello() {
        return client.hello();
    }
    public static void main(String[] args) {
        SpringApplication.run(ClusteringUserServiceApplication.class, args);
    }
    @FeignClient("clustering-zuul-server")
    interface HelloClient {
        @RequestMapping(value = "/", method = RequestMethod.GET)
        String hello();
    }

}
