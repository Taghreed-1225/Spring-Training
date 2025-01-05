package com.adminPanel.app.controller;

import com.adminPanel.app.config.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @Autowired
    private Config config;

    @GetMapping("/test")
    public String test(){

        return "Hello spring Boot";
    }

    @Value("${myapp.description.fullDescription}")
    private String full_desc;
    @GetMapping("/test1")
    public String test1(){
        return full_desc ;
    }

    @GetMapping("/test2")
    public String test2(){
        return config.getDescription().getFullDescription();
    }
}
