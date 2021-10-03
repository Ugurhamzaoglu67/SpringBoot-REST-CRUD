package com.ugurhmz.services;


import com.ugurhmz.exception.ResourceNotFoundException;
import com.ugurhmz.model.User;
import com.ugurhmz.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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


    // READ USER
    public User getUserById(Long id){
       User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id+" User Not Found!!"));
        System.out.println("user : "+user);
       return user;
    }

    // READ USER FIRST NAME
    public User getUserByFirstName(String firstName) {
        User user = userRepository.findByName(firstName);
        return user;

    }



    // GET USERS LIST
    public List<User> getUserList(){
        List<User> usersList = userRepository.findAll();
        System.out.println(usersList);
        return usersList;
    }



    // UPDATE USER
    public User updateUser(Long userId, User user){
        User existingUser = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException(userId+" User Not Found!!"));

        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        System.out.println("User updated successfully");
        return userRepository.save(existingUser);

    }



    // DELETE USER
    public ResponseEntity<Map<String, Boolean>> deleteUser(Long userId){

        //  Find user by id
        User user = userRepository.findById(userId)
                                    .orElseThrow(() -> new ResourceNotFoundException(userId+" User Not Found!!"));

        // delete directly user
        userRepository.delete(user);

        Map<String,Boolean> response = new HashMap<>();
        response.put("User successfully deleted.",Boolean.TRUE);

        return ResponseEntity.ok(response);
    }


}
