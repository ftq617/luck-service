package com.luke.auth.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: ConfigController
 * @Description:
 * @Author: Luke Fu
 * @Date: 2020/09/15 17:18
 **/
@RestController
public class ConfigController {


    @GetMapping("/auth")
    public String getConfigInfo() {
        return " auth  !";
    }
}

