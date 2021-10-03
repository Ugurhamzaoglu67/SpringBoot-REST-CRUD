package com.ugurhmz.services;


import com.ugurhmz.model.User;
import com.ugurhmz.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;



    // SAVE USER
    public User saveUser(User user) {
        System.out.println(user+" was saved...");
        return userRepository.save(user);
    }


    // SAVE LIST USERS
    public List<User> saveUserList(List<User> userList) {
        System.out.println("user list successfully saved...");
        return userRepository.saveAll(userList);
    }


    // GET USER LIST
    public List<User> getUserList(){
        System.out.println("All users listed...");
        return userRepository.findAll();
    }

}
