package com.software2.foodtruckfinder.secure.controller;

import com.software2.foodtruckfinder.secure.model.Review;
import com.software2.foodtruckfinder.secure.model.Schedule;
import com.software2.foodtruckfinder.secure.model.UserPreferences;
import com.software2.foodtruckfinder.secure.repository.ReviewRepository;
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
    private ReviewRepository revRepository;

    public ReviewController(ReviewRepository ur) {
        this.revRepository = ur;
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

    @GetMapping(path = "/getReviewsByTruckId")
    public @ResponseBody
    List<Review> getReviewsByTruckId(@RequestParam Long truckid) {
        return revRepository.findReviewsByTruckid(truckid);
    }

    @DeleteMapping(path = "/delete")
    public @ResponseBody
    Boolean deleteAllReviews() {
        revRepository.deleteAll();
        return true;
    }

    @DeleteMapping(path = "/getReviewsByUser")
    public @ResponseBody
    List<Review> getReviewsByUser(Long uid) {
        return revRepository.findReviewsByUserID(uid);
    }
}