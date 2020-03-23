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
    ResponseEntity<UserPreferences> addNewUPreferences(@RequestBody UserPreferences newP) {
        UserPreferences n = new UserPreferences();
        n.setId(newP.getId());
        n.setPrice(newP.getPrice());
        n.setProximity(newP.getProximity());
        n.setFoodLikes(newP.getFoodLikes());
        n.setDislikes(newP.getDislikes());

        for (UserPreferences uP: uprefRepository.findAll()) {
            if(uP.getId().equals(newP.getId())){
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

    @GetMapping(path = "getUPreferencesByID")
    public @ResponseBody
    UserPreferences findUPreferencesByID(Long id){
        return uprefRepository.findUserPreferencesByid(id);
    }

    @PutMapping(value = "updateByUPreferences", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<UserPreferences> updateUPreferences(@RequestBody UserPreferences uf) {

        if(uprefRepository.existsById(uf.getId())){
            UserPreferences n = new UserPreferences();
            n.setId(uf.getId());
            n.setPrice(uf.getPrice());
            n.setProximity(uf.getProximity());
            n.setFoodLikes(uf.getFoodLikes());
            n.setDislikes(uf.getDislikes());

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
        return uprefRepository.findDislikesByUser(id);
    }

    //added should return list of preferences whatever that is
    @GetMapping(path = "getLikesByID")
    public @ResponseBody
    List<String> findPreferencesByUser(Long id){
        return uprefRepository.findLikesByUser(id);
    }

    //added should return list of preferences whatever that is
    @GetMapping(path = "getProximityByID")
    public @ResponseBody
    Double findProximityByUser(Long id){
        return uprefRepository.findProximityByUser(id);
    }
    //added should return list of preferences whatever that is
    @GetMapping(path = "getPriceByID")
    public @ResponseBody
    Integer findPriceByUser(Long id){
        return uprefRepository.findPriceByUser(id);
    }
}
