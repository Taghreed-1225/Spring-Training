package com.softwe3.dockerjava;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RequestMapping("api")
@RestController
public class Controller {

    @GetMapping("/getmsg")
    public String getmsg(){
        return "Hello World Taghreed";
    }
}
