package com.example.vkTest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.vkTest.model.User;
import com.example.vkTest.service.UserService;

@RestController
@RequestMapping("/api/new")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to the unprotected page";
    }

    @PostMapping("/user")
    public String addUser(@RequestBody User user) {
        userService.addUser(user);
        return "User is saved";
    }

}
