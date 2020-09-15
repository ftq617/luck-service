package com.luke.gateway.controller;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: ConfigController
 * @Description:
 * @Author: Luke Fu
 * @Date: 2020/09/15 17:18
 **/
@RestController
@RefreshScope
public class ConfigController {

//    @Value("${config.info}")
//    private String configInfo;

//    @GetMapping("/configInfo")
//    public String getConfigInfo() {
//        return configInfo;
//    }
}

