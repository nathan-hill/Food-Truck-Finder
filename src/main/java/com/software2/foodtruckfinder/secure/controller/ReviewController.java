package com.software2.foodtruckfinder.secure.controller;


import com.software2.foodtruckfinder.secure.model.FoodTruckReviewDTO;
import com.software2.foodtruckfinder.secure.model.Review;
import com.software2.foodtruckfinder.secure.model.Truck;

import com.software2.foodtruckfinder.secure.model.User;
import com.software2.foodtruckfinder.secure.repository.ReviewRepository;
import com.software2.foodtruckfinder.secure.repository.TruckRepository;
import com.software2.foodtruckfinder.secure.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@Controller // This means that this class is a Controller
@RequestMapping(path = "/v/review")
public class ReviewController {

    @Autowired
    private TruckRepository truckRepository;

    private UserRepository userRepository;

    @Autowired
    private ReviewRepository revRepository;

    public ReviewController(ReviewRepository ur, UserRepository uRep) {
        this.revRepository = ur;
        this.userRepository = uRep;
    }

    @PostMapping(path = "/add")
    public @ResponseBody
    ResponseEntity<Review> addReview(@RequestBody Review newR) {
        Review n = new Review();
        n.setId(newR.getId());
        n.setUserID(newR.getUserID());
        n.setRating(newR.getRating());
        n.setDescription(newR.getDescription());
        n.setTruckid(newR.getTruckid());

        for (Review uP : revRepository.findAll()) {
            if (uP.getId().equals(newR.getId())) {
                return ResponseEntity.status(400).build();
            }
        }

        Review generatedRev = revRepository.save(n);
        return new ResponseEntity<Review>(generatedRev, HttpStatus.OK);
    }

    @PutMapping(value = "update", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Review> updateReview(@RequestBody Review r) {

        if (revRepository.existsById(r.getId())) {

            Review n = new Review();
            n.setId(r.getId());
            n.setDescription(r.getDescription());
            n.setUserID(r.getUserID());
            n.setRating(r.getRating());
            n.setTruckid(r.getTruckid());

            Review generatedReview = revRepository.save(n);
            return new ResponseEntity<Review>(generatedReview, HttpStatus.OK);
        } else {
            return null;
        }

    }

    @GetMapping(path = "/")
    public @ResponseBody
    Iterable<Review> getAllReviews() {
        // This returns a JSON or XML with the users
        return revRepository.findAll();
    }

    @DeleteMapping(path = "/delete")
    public @ResponseBody
    Boolean deleteAllReviews() {
        revRepository.deleteAll();
        return true;
    }

    @GetMapping(path = "/getReviewsByUser")
    public @ResponseBody
    List<Review> getReviewsByUser(Long uid) {
        return revRepository.findReviewsByUserID(uid);
    }

    @GetMapping(path = "/getReviewsByFT")
    public @ResponseBody
    List<Review> getReviewsByFT(Long ftid) {
        return revRepository.findReviewsByTruckid(ftid);
    }

    @GetMapping(path = "/getReviewsWithName")
    public @ResponseBody
    List<FoodTruckReviewDTO> getReviewsWithName() {
        List<Review> generated = revRepository.findAll();
        System.out.println(generated.size());
        List<FoodTruckReviewDTO> ftlist = new ArrayList<FoodTruckReviewDTO>();
        for(Review r : generated){
            String name = truckRepository.findTruckById(r.getTruckid()).getName();
            String customer = userRepository.findUserByid(r.getUserID()).getUsername();
            FoodTruckReviewDTO f = new FoodTruckReviewDTO();
            ftlist.add(f.copy(r, name, customer));
        }
        return ftlist;
    }

    @GetMapping(path = "/getReviewsByOwner")
    public @ResponseBody
    List<FoodTruckReviewDTO> getReviewsByOwner(@RequestParam("ownerid") Long ownerid) {
        List<Truck> trucks = truckRepository.findTrucksByOwnerID(ownerid);
        System.out.println(trucks.size());
        List<FoodTruckReviewDTO> reviews = new ArrayList<FoodTruckReviewDTO>();
        FoodTruckReviewDTO ftr = new FoodTruckReviewDTO();;
        for(Truck t : trucks){
            List<Review> r = revRepository.findReviewsByTruckid(t.getId());
            for(Review rw: r){
                User u = userRepository.findUserByid(rw.getUserID());
                reviews.add(ftr.copy(rw, t.getName(), u.getUsername()));
            }
        }
        return reviews;
    }

    @GetMapping(path = "/getReviewsByCustomer")
    public @ResponseBody
    List<FoodTruckReviewDTO> getReviewsByCustomer(Long uid) {
        List<Review> r = revRepository.findReviewsByUserID(uid);
        User u = userRepository.findUserByid(uid);
        List<FoodTruckReviewDTO> reviews = new ArrayList<FoodTruckReviewDTO>();
        FoodTruckReviewDTO ftr = new FoodTruckReviewDTO();

        System.out.println(u.getName());

        for(Review rw: r){
            Truck t = truckRepository.findTruckById(rw.getTruckid());
            System.out.println(t.getName());
            reviews.add(ftr.copy(rw, t.getName(), u.getUsername()));
        }

        return reviews;
    }

}