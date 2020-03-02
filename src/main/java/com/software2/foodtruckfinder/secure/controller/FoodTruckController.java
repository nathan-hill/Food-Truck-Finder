package com.software2.foodtruckfinder.secure.controller;

import com.software2.foodtruckfinder.secure.model.Truck;
import com.software2.foodtruckfinder.secure.repository.TruckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@Controller // This means that this class is a Controller
@RequestMapping(path = "/v/trucks")
public class FoodTruckController {
    @Autowired
    private TruckRepository truckRepository;

    @PostMapping(path = "add")
    public @ResponseBody
    ResponseEntity<Truck> addNewTruck(@RequestBody Truck newTruck) {
        Truck n = new Truck();
        n.setName(newTruck.getName());
        n.setSchedule(newTruck.getSchedule());

        for (Truck truck: truckRepository.findAll()) {
            if(truck.getName().equals(newTruck.getName())){
                return ResponseEntity.status(400).build();
            }
        }

        Truck generatedTruck = truckRepository.save(n);
        return new ResponseEntity<Truck>(generatedTruck, HttpStatus.OK);
    }

    @GetMapping(path = "/")
    public @ResponseBody
    Iterable<Truck> getAllTrucks() {
        // This returns a JSON or XML with the trucks
        return truckRepository.findAll();
    }

    @DeleteMapping(path = "delete")
    public @ResponseBody
    Boolean deleteAllTrucks() {
        truckRepository.deleteAll();
        return true;
    }

    @GetMapping(path = "findTruckByID")
    public @ResponseBody
    Optional<Truck> findById(Integer integer){
        return truckRepository.findById(integer);
    }

    @GetMapping(path = "findTrucksByownerID")
    public @ResponseBody
    List<Truck> findTrucksByOwner(Long l){
        return truckRepository.findTrucksByOwnerID(l);
    }

}