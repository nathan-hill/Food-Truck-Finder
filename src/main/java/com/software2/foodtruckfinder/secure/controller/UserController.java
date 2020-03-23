package com.software2.foodtruckfinder.secure.controller;

import com.software2.foodtruckfinder.secure.model.Truck;
import com.software2.foodtruckfinder.secure.model.User;
import com.software2.foodtruckfinder.secure.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@Controller // This means that this class is a Controller
@RequestMapping(path = "/v/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    public UserController(UserRepository ur){
        this.userRepository = ur;
    }

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

    @GetMapping(path = "getUserByID")
    public @ResponseBody
    User findUserByID(Long id){
        return userRepository.findUserByid(id);
    }

    @PutMapping(value = "updateByUser", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<User> updateUser(@RequestBody User udets) {

        if(userRepository.existsById(udets.getId())){
            User newUser = new User();
            newUser.setId(udets.getId());
            newUser.setEmail(udets.getEmail());
            newUser.setName(udets.getName());
            newUser.setPassword(udets.getPassword());
            newUser.setUsername(udets.getUsername());

            User generatedUser = userRepository.save(newUser);
            return new ResponseEntity<User>(generatedUser, HttpStatus.OK);
        }else{
            return null;
        }
    }

    //added should return list of dislikes whatever that is
    @GetMapping(path = "getDislikesByID")
    public @ResponseBody
    List<String> findDislikesByUser(Long id){
        return userRepository.findDislikesById(id);
    }

    //added should return list of preferences whatever that is
    @GetMapping(path = "getPreferencesByID")
    public @ResponseBody
    List<String> findPreferencesByUser(Long id){
        return userRepository.findPreferencesById(id);
    }




}