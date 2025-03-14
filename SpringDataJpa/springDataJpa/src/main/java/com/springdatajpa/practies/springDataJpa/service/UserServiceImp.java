package com.springdatajpa.practies.springDataJpa.service;

import com.springdatajpa.practies.springDataJpa.dao.UserRepositry;
import com.springdatajpa.practies.springDataJpa.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImp implements UserService {

    @Autowired
    UserRepositry userRepositry;
    @Override
    public List<User> findAll() {
        return userRepositry.findAll();
    }

    @Override
    public List<User> getAllUsers() {
        return userRepositry.getAllUsers();
    }


    public Page<User> getAllUsersPaginated(int page ,int size ){
        Pageable pageable= PageRequest.of(page, size, Sort.by("username"));
         return userRepositry.findAll(pageable);
    }


}
