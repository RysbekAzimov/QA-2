package com.example.QA2.service;

import com.example.QA2.entity.User;

import java.util.List;

public interface UserService {

    void createUser(String name);

    List<User> readAllUser();

    void updateUser(Long id, String name);

    void deleteUser(Long id);
}
