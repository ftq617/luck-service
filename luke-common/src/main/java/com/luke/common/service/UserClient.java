package com.luke.common.service;

import com.luke.common.service.fallback.UserClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "luke-user",fallback = UserClientFallback.class)
public interface UserClient {

    String module="/luke-user";
    String GetData=module+"/get";
    String GetOther=module+"/other";

    //支持restFul风格

    @GetMapping(GetData)  //get 请求必须要加 @RequestParam注解，否则会转换成 post请求
    String getUser(@RequestParam("id") String id);

    @PostMapping(GetOther)  //基本对象要用@RequestParam，否则不能传值 ，封装对象要用 @RequestBody ,
    String getUserDetail(@RequestParam("id") String id);
}
