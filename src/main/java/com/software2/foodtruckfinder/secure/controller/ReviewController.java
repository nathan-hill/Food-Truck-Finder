package com.software2.foodtruckfinder.secure.controller;

import com.software2.foodtruckfinder.secure.model.Review;
import com.software2.foodtruckfinder.secure.model.UserPreferences;
import com.software2.foodtruckfinder.secure.repository.ReviewRepository;
import com.software2.foodtruckfinder.secure.repository.UPreferenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

        for (Review uP : revRepository.findAll()) {
            if (uP.getId().equals(newR.getId())) {
                return ResponseEntity.status(400).build();
            }
        }

        Review generatedRev = revRepository.save(n);
        return new ResponseEntity<Review>(generatedRev, HttpStatus.OK);
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

    @DeleteMapping(path = "/getReviewsByUser")
    public @ResponseBody
    List<Review> getReviewsByUser(Long uid) {
        return revRepository.findReviewsByUserID(uid);
    }
}