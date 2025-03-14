package com.springdatajpa.practies.springDataJpa.dao;

import com.springdatajpa.practies.springDataJpa.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepositry extends JpaRepository<User, Long> {

    @Query(value = "select * from user" , nativeQuery = true) // sql
    List<User> getAllUsers();



    Page<User> findAll(Pageable pageable);
}
