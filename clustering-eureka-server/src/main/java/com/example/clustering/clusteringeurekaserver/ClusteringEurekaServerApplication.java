package com.example.clustering.clusteringeurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ClusteringEurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClusteringEurekaServerApplication.class, args);
    }
}
