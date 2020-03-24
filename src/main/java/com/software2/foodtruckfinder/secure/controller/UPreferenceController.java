package com.software2.foodtruckfinder.secure.controller;


import com.software2.foodtruckfinder.secure.model.Truck;
import com.software2.foodtruckfinder.secure.model.User;
import com.software2.foodtruckfinder.secure.model.UserPreferences;
import com.software2.foodtruckfinder.secure.repository.UPreferenceRepository;
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
@RequestMapping(path = "/v/upref")
public class UPreferenceController {

    @Autowired
    private UPreferenceRepository uprefRepository;

    public UPreferenceController(UPreferenceRepository ur){
        this.uprefRepository = ur;
    }

    @PostMapping(path = "/add")
    public @ResponseBody
    ResponseEntity<UserPreferences> addNewUPreferences(@RequestBody UserPreferences up) {
        UserPreferences n = new UserPreferences();
        n.setId(up.getId());
        n.setPrice(up.getPrice());
        n.setProximity(up.getProximity());
        n.setLikes(up.getLikes());

        for (UserPreferences uP: uprefRepository.findAll()) {
            if(uP.getId().equals(up.getId())){
                return ResponseEntity.status(400).build();
            }
        }

        UserPreferences generatedUser = uprefRepository.save(n);
        return new ResponseEntity<UserPreferences>(generatedUser, HttpStatus.OK);
    }

    @GetMapping(path = "/")
    public @ResponseBody
    Iterable<UserPreferences> getAllUPreferences() {
        // This returns a JSON or XML with the users
        return uprefRepository.findAll();
    }

    @DeleteMapping(path = "/delete")
    public @ResponseBody
    Boolean deleteAllUPreferences() {
        uprefRepository.deleteAll();
        return true;
    }

    @GetMapping(path = "/getUPreferencesByID")
    public @ResponseBody
    UserPreferences findUPreferencesByID(Long id){
        System.out.println(id);
        return uprefRepository.findUserPreferencesById(id);
    }

    @PutMapping(value = "updateByUPreferences", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<UserPreferences> updateUPreferences(@RequestBody UserPreferences up) {

        if(uprefRepository.existsById(up.getId())){
            UserPreferences n = new UserPreferences();
            n.setId(up.getId());
            n.setPrice(up.getPrice());
            n.setProximity(up.getProximity());
            n.setLikes(up.getLikes());

            UserPreferences generatedUser = uprefRepository.save(n);
            return new ResponseEntity<UserPreferences>(generatedUser, HttpStatus.OK);
        }else{
            return null;
        }
    }

    //added should return list of dislikes whatever that is
    @GetMapping(path = "getDislikesByID")
    public @ResponseBody
    List<String> findDislikesByUser(Long id){
        return uprefRepository.findDislikesById(id);
    }

    //added should return list of preferences whatever that is
    @GetMapping(path = "getLikesByID")
    public @ResponseBody
    List<String> findPreferencesByUser(Long id){
        return uprefRepository.findLikesById(id);
    }

    //added should return list of preferences whatever that is
    @GetMapping(path = "getProximityByID")
    public @ResponseBody
    Double findProximityByUser(Long id){
        return uprefRepository.findProximityById(id);
    }
    //added should return list of preferences whatever that is
    @GetMapping(path = "getPriceByID")
    public @ResponseBody
    Integer findPriceByUser(Long id){
        return uprefRepository.findPriceById(id);
    }
}
