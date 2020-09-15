package com.luke.system.controller;

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


    @GetMapping("/system")
    public String getConfigInfo() {
        return " system  !";
    }
}

