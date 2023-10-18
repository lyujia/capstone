package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepo;

    public User createUser(String username,String password){
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        return userRepo.save(user);
    }

    public User findUserbyName(String username){
        return userRepo.findByUsername(username);
    }
}
