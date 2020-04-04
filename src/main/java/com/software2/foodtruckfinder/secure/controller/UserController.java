package com.software2.foodtruckfinder.secure.controller;

import com.software2.foodtruckfinder.secure.model.User;
import com.software2.foodtruckfinder.secure.payload.UserUserPreferenceCombo;
import com.software2.foodtruckfinder.secure.repository.UPreferenceRepository;
import com.software2.foodtruckfinder.secure.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.software2.foodtruckfinder.secure.model.UserPreferences;

import java.time.Instant;
import java.util.Optional;


@CrossOrigin
@Controller // This means that this class is a Controller
@RequestMapping(path = "/v/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UPreferenceRepository userPreferencesRepository;

    public UserController(UserRepository ur) {
        this.userRepository = ur;
    }

    @PostMapping(path = "/add")
    public @ResponseBody
    ResponseEntity<User> addNewUser(@RequestBody User newUser) {
        User n = new User();
        n.setEmail(newUser.getEmail());
        n.setPassword(newUser.getPassword());

        for (User user : userRepository.findAll()) {
            if (user.getEmail().equals(newUser.getEmail())) {
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

    @GetMapping(path = "/getUserByID")
    public @ResponseBody
    User findUserByID(Long id) {
        System.out.println("/getUserByID -> " + id);
        return userRepository.findUserByid(id);
    }

    @PutMapping(value = "/updateByUser", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Object updateUser(@RequestBody UserUserPreferenceCombo userUserPreferenceCombo) {
        try {
            //unpack the data
            User user = userUserPreferenceCombo.user;
            UserPreferences userPreferences = userUserPreferenceCombo.preferences;

            System.out.println("user -> " + userUserPreferenceCombo.user.toString());
            System.out.println("preferences -> " + userUserPreferenceCombo.preferences.toString());

            //retrieve reference of the old user from database
            User storedUser = userRepository.getOne(user.getId());
            User generatedUser = null;

            //update the new user
            storedUser.setEmail(user.getEmail());
            storedUser.setName(user.getName());
            storedUser.setUsername(user.getUsername());
            userRepository.save(storedUser);

            //get the stored preferences
            if (!userPreferencesRepository.findById(user.getId()).isPresent()) {
                userPreferencesRepository.save(new UserPreferences(user.getId()));
            }
            UserPreferences storedUserPreferences = userPreferencesRepository.getOne(user.getId());

            //build the new preferences
            storedUserPreferences.setLikes(userPreferences.getLikes());
            storedUserPreferences.setPrice(userPreferences.getPrice());
            storedUserPreferences.setProximity(userPreferences.getProximity());

            System.out.println(storedUserPreferences.toString());

            //save the new preferences
            UserPreferences generatedUPreferences = userPreferencesRepository.save(storedUserPreferences);

            return new ResponseEntity<UserUserPreferenceCombo>(new UserUserPreferenceCombo(storedUser, storedUserPreferences), HttpStatus.OK);

        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(e.toString());
        }
    }
}
