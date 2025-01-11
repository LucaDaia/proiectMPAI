package com.example.demo.controller;

import com.example.demo.Service.UserService;
import com.example.demo.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="/api/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getUsers(){
    return userService.getUsers();
    }

    @GetMapping(path = "/{id}")
    public User getUserById(@PathVariable Integer id){
    return userService.getUserById(id);
    }

    @GetMapping(path= "/name/{name}")
    public User getUserByName(@PathVariable String name){
    return userService.getUserByName(name);
    }
}
