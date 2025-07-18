package com.micrud.micrud.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class BalanceoController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/balanceado")
    public String testBalanceo() {
        String url = "http://micrud-service/api/test/public";
        return restTemplate.getForObject(url, String.class);
    }
}