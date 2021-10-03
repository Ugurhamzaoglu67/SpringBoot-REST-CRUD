package com.ugurhmz.controller;


import com.ugurhmz.model.User;
import com.ugurhmz.repository.UserRepository;
import com.ugurhmz.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ugurv1/")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    // CREATE USER
    @PostMapping("/save-user")
    public User postUser(@RequestBody User user) {
        return userService.saveUser(user);
    }


    // CREATE USERS LIST
    @PostMapping("/save-users-list")
    public List<User> postUsersList(@RequestBody List<User> usersList){
        return userService.saveUserList(usersList);
    }


    // READ USER
    @GetMapping("/{user-Id}/user")
    public User findUserById(@PathVariable("user-Id") Long userId){
        return userService.getUserById(userId);
    }


    // READ USERS LIST
    @GetMapping("/get-users-list")
    public List<User> findAllUsers(){
        return userService.getUserList();
    }


}
