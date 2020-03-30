package com.software2.foodtruckfinder.secure.controller;
//
//import com.software2.foodtruckfinder.secure.model.Owner;
//import com.software2.foodtruckfinder.secure.model.Truck;
//import com.software2.foodtruckfinder.secure.model.User;
//import com.software2.foodtruckfinder.secure.repository.OwnerRepository;
//import com.software2.foodtruckfinder.secure.repository.TruckRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//
//@CrossOrigin
//@Controller // This means that this class is a Controller
//@RequestMapping(path = "/v/owners")
//public class OwnerController {
//    @Autowired
//    private OwnerRepository ownerRepository;
//
//    @PostMapping(path = "add")
//    public @ResponseBody
//    ResponseEntity<Owner> addNewOwner(@RequestBody Owner newOwner) {
//        Owner o = new Owner();
//        o.setId(newOwner.getId());
//        o.setName(newOwner.getName());
//        o.setUsername(newOwner.getUsername());
//        o.setEmail(newOwner.getEmail());
//        o.setPassword(newOwner.getPassword());
//
//        for (Owner owner: ownerRepository.findAll()) {
//            if(owner.getName().equals(o.getName())){
//                return ResponseEntity.status(400).build();
//            }
//        }
//
//        Owner generatedOwner = ownerRepository.save(o);
//        return new ResponseEntity<>(generatedOwner, HttpStatus.OK);
//    }
//
//    @GetMapping(path = "/")
//    public @ResponseBody
//    Iterable<Owner> getAllOwners() {
//        // This returns a JSON or XML with the users
//        return ownerRepository.findAll();
//    }
//
//    @DeleteMapping(path = "delete")
//    public @ResponseBody
//    Boolean deleteAllOwners() {
//        ownerRepository.deleteAll();
//        return true;
//    }
//
//    String findNameByID(Long id){
//        Owner t = ownerRepository.findOwnerByid(id);
//        return t.getName();
//    }
//
//    String findEmailByID(Long id){
//        Owner t = ownerRepository.findOwnerByid(id);
//        return t.getEmail();
//    }
//
//    String findUserNameByID(Long id){
//        Owner t = ownerRepository.findOwnerByid(id);
//        return t.getUsername();
//    }
//
//}
