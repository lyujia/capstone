package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/test")
public class Testcontroller {
    @Autowired
    private UserService userService;

    @GetMapping
    //@ResponseBody
    public String test_get(){
        return "login";
    }

    @PostMapping
    @ResponseBody
    public String test_post(@RequestParam String username, @RequestParam String password){
        System.out.println("username :"+username);
        System.out.println("password :"+password);

        User findedUser = userService.findUserbyName(username);

        if(findedUser == null)return "로그인 실패";

        return findedUser.getPassword().equals( password) ? "로그인 성공" : "비밀번호를 확인하세요.";
    }

}
