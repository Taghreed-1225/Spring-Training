package com.springdatajpa.practies.springDataJpa.service;

import com.springdatajpa.practies.springDataJpa.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {
    public List<User> findAll();

    List<User> getAllUsers();

    public Page<User> getAllUsersPaginated(int page , int size );
}
