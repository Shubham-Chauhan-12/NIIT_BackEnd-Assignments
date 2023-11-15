package com.practice.UserProductService.proxy;

import com.practice.UserProductService.domain.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "authentication-service2", url = "authentication-service2:8084")
public interface UserProxy {
    @PostMapping("api/v1/register")
    public ResponseEntity<?> register(@RequestBody User user);
}
