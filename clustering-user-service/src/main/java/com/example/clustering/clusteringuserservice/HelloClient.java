package com.example.clustering.clusteringuserservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("CLUSTERING-ZUUL-SERVER")
public interface HelloClient {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    String hello();
}
