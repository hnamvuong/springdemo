package com.vuongtq.springdemo.service;

import com.vuongtq.springdemo.entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    UserEntity createUser(UserEntity user);
    UserEntity findByUserNameAndUserEmail(String userName, String userEmail);

    // get all limit offset
    Page<UserEntity> findAllUsers(Pageable pageable);

    // get search limit offset
    Page<UserEntity> findByUserName(String userName, Pageable pageable);
}
