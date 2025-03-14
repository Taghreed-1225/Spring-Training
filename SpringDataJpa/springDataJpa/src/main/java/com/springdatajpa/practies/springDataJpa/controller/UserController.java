package com.springdatajpa.practies.springDataJpa.controller;


import com.springdatajpa.practies.springDataJpa.entity.User;
import com.springdatajpa.practies.springDataJpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/users")
    public List<User> getUsers(){
       return userService.findAll();
    }

    @GetMapping("/user")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/userp")
    public Page<User> getAllUsersP(@RequestParam(defaultValue = "0")int page,
                                   @RequestParam(defaultValue = "2") int size){ // data comes 2 by 2
        return userService.getAllUsersPaginated(page, size);
    }

}
