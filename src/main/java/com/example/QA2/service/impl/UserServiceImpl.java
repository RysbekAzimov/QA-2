package com.example.QA2.service.impl;

import com.example.QA2.entity.User;
import com.example.QA2.repository.UserRepository;
import com.example.QA2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Comparator;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    public UserRepository userRepository;

    public UserRepository getUserRepository() {
        return userRepository;
    }

    @Override
    public void createUser(String name) {
        User user = new User();
        user.setName(name);
        userRepository.save(user);
    }

    @Override
    public List<User> readAllUser() {
        List<User> users = userRepository.findAll();
        users.sort(Comparator.comparingLong(User::getId));
        return users;
    }

    @Override
    public void updateUser(Long id, String name) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Вопросник с id " + id + " не найден"));
        user.setName(name);
        userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Вопросник с id " + id + " не найден"));
        userRepository.delete(user);
    }
}