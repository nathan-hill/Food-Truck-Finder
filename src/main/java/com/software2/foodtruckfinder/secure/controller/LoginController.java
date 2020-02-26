package com.software2.foodtruckfinder.secure.controller;

import com.software2.foodtruckfinder.secure.model.User;
import com.software2.foodtruckfinder.secure.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@Controller // This means that this class is a Controller
@RequestMapping(path = "/v/login") // This means URL's start with /demo (after Application path this is assigned to
public class LoginController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping(path = "/")
    public @ResponseBody
    ResponseEntity<User> validateUser(@RequestBody User loginUser) {

        System.out.print(loginUser.getEmail() + " "  + loginUser.getEmail());
        // This returns a JSON or XML with the users
        Iterable<User> users = userRepository.findAll();
        for (User user : users) {
            System.out.println(" ?== " + user.getEmail() + " " + user.getPassword());
            if (user.getEmail().equals(loginUser.getEmail()) && user.getPassword().equals(loginUser.getPassword())) {
                return ResponseEntity.ok().body(user);
            }
        }
        return ResponseEntity.status(401).build();
    }
}