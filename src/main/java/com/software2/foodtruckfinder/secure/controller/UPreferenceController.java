package com.software2.foodtruckfinder.secure.controller;


import com.software2.foodtruckfinder.secure.model.*;
import com.software2.foodtruckfinder.secure.repository.ScheduleRepository;
import com.software2.foodtruckfinder.secure.repository.TruckRepository;
import com.software2.foodtruckfinder.secure.repository.UPreferenceRepository;
import com.software2.foodtruckfinder.secure.service.UPreferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@CrossOrigin
@Controller // This means that this class is a Controller
@RequestMapping(path = "/v/upref")
public class UPreferenceController {

    @Autowired
    private UPreferenceRepository uprefRepository;
    @Autowired
    private TruckRepository truckRepository;
    @Autowired
    private ScheduleRepository scheduleRepository;
    @Autowired
    private UPreferenceService upService;

    //For Unit Tests
    public UPreferenceController(UPreferenceRepository ur) {
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

        for (UserPreferences uP : uprefRepository.findAll()) {
            if (uP.getId().equals(up.getId())) {
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
    UserPreferences findUPreferencesByID(Long id) {

        UserPreferences opt = uprefRepository.findUserPreferencesById(id);
        System.out.println("/getUPreferencesByID -> " + opt);
        if(opt == null){
            opt = new UserPreferences(id);
        }
        return opt;
    }

    @PutMapping(value = "/updateByUPreferences", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<UserPreferences> updateUPreferences(@RequestBody UserPreferences up) {

        if (uprefRepository.existsById(up.getId())) {
            UserPreferences n = new UserPreferences();
            n.setId(up.getId());
            n.setPrice(up.getPrice());
            n.setProximity(up.getProximity());
            n.setLikes(up.getLikes());

            UserPreferences generatedUser = uprefRepository.save(n);
            return new ResponseEntity<UserPreferences>(generatedUser, HttpStatus.OK);
        } else {
            return new ResponseEntity<UserPreferences>(new UserPreferences(), HttpStatus.BAD_REQUEST);
        }
    }

    //added should return list of dislikes whatever that is
    @GetMapping(path = "/getPreferred")
    public @ResponseBody
    ResponseEntity<List<Truck>> findTruckPreferences(@RequestParam("id") Long id, @RequestParam("lon") Double lon, @RequestParam("lat") Double lat) {
        List<Truck> trucks = upService.getPrioritizedTrucks(id, lon, lat);
        return new ResponseEntity<List<Truck>>(trucks, (trucks.size() == 0 ? (HttpStatus.BAD_REQUEST) : (HttpStatus.OK)));
    }

}
