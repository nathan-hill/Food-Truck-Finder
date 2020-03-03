package com.software2.foodtruckfinder.secure.controller;

import com.software2.foodtruckfinder.secure.model.User;
import com.software2.foodtruckfinder.secure.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@Controller // This means that this class is a Controller
@RequestMapping(path = "/v/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping(path = "/add")
    public @ResponseBody
    ResponseEntity<User> addNewUser(@RequestBody User newUser) {
        User n = new User();
        n.setEmail(newUser.getEmail());
        n.setPassword(newUser.getPassword());

        for (User user: userRepository.findAll()) {
            if(user.getEmail().equals(newUser.getEmail())){
                return ResponseEntity.status(400).build();
            }
        }

        User generatedUser = userRepository.save(n);
        return new ResponseEntity<User>(generatedUser, HttpStatus.OK);
    }

    @GetMapping(path = "/")
    public @ResponseBody
    Iterable<User> getAllUsers() {
        // This returns a JSON or XML with the users
        return userRepository.findAll();
    }

    @DeleteMapping(path = "/delete")
    public @ResponseBody
    Boolean deleteAllUsers() {
        userRepository.deleteAll();
        return true;
    }
}