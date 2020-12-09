package com.ds.controller;

import com.ds.annotation.CustomCache;
import com.ds.annotation.PermissionCheck;
import com.ds.dto.User;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author: xxxxx
 * @create: 2020-12-07
 */
@RestController("/")
public class HelloWorld {
    @PostMapping
    @ResponseBody
    public String test(@Valid @RequestBody User user){
        return user.toString();
    }

    @GetMapping
    @ResponseBody
    @PermissionCheck(resourceKey = "test")
    public String test(){
        return "Hello World Get";
    }

    @GetMapping("/cache")
    @CustomCache(key = "testKey")
    public Object testCustomCache() {
        return "don't hit cache";
    }
}
