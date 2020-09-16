package com.divoter.orderserver.controller;

import com.divoter.orderserver.config.GrilConfig;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/gril")
public class GrilController {
    @Resource
    private GrilConfig grilConfig;

    @GetMapping
    public String print(){
        return "name:"+grilConfig.getName()+",age:"+grilConfig.getAge();
    }
}
