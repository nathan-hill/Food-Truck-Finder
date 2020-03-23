package com.software2.foodtruckfinder.secure.controller;

import com.software2.foodtruckfinder.secure.model.Schedule;
import com.software2.foodtruckfinder.secure.model.Truck;
import com.software2.foodtruckfinder.secure.model.User;
import com.software2.foodtruckfinder.secure.repository.ScheduleRepository;
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
@RequestMapping(path = "/v/schedule")
public class ScheduleController {
    @Autowired
    private ScheduleRepository scheduleRepository;

    public ScheduleController(ScheduleRepository sr){
        this.scheduleRepository = sr;
    }

    // not sure how to add yet based on page.. Am I receiving each day?
    // Am I receiving all days at once? I need all 7 days to exist either way
    // in the database


//    @PostMapping(path = "/add")
//    public @ResponseBody
//    ResponseEntity<User> addNewSchedule(@RequestBody User newUser) {
//
//    }

    @DeleteMapping(path = "/delete")
    public @ResponseBody
    Boolean deleteAllSchedules() {
        scheduleRepository.deleteAll();
        return true;
    }

    @GetMapping(path = "getScheduleByID")
    public @ResponseBody
    List<Schedule> findScheduleByID(Integer id){
        return scheduleRepository.findByTruck(id);
    }

    @GetMapping(path = "getSingleScheduleByID")
    public @ResponseBody
    Schedule findSingleScheduleByID(Long id){
        return scheduleRepository.findByid(id);
    }

    // not sure how we should update yet
    // based on page

//    @PutMapping(value = "updateBy", produces = MediaType.APPLICATION_JSON_VALUE)
//    @ResponseStatus(HttpStatus.OK)
//    public ResponseEntity<User> updateUser(@RequestBody User udets) {
//
//        if(scheduleRepository.existsById(udets.getId())){
//            User newUser = new User();
//            newUser.setId(udets.getId());
//            newUser.setEmail(udets.getEmail());
//            newUser.setName(udets.getName());
//            newUser.setPassword(udets.getPassword());
//            newUser.setUsername(udets.getUsername());
//
//            User generatedUser = scheduleRepository.save(newUser);
//            return new ResponseEntity<User>(generatedUser, HttpStatus.OK);
//        }else{
//            return null;
//        }
//    }


}
