package com.example.clustering.clusteringzuulserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@EnableZuulProxy
@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class ClusteringZuulServerApplication {

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping("/")
    public String hello() {
        List<ServiceInstance> list = discoveryClient.getInstances("clustering-zuul-server");
        ServiceInstance service = list.get(0);

        return "Connected Info -> "+ service.getServiceId()+":"+service.getHost()+":"+service.getPort();
    }

    public static void main(String[] args) {
        SpringApplication.run(ClusteringZuulServerApplication.class, args);
    }
}
