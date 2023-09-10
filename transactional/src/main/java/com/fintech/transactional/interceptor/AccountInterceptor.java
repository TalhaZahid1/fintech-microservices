package com.fintech.transactional.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Configuration;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@Configuration
public class AccountInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate requestTemplate) {
        try {
            requestTemplate.header("Content-Type", "application/json");
            requestTemplate.header("Authorization", "jsontoken");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
