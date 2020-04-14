package com.software2.foodtruckfinder.secure.repository;

import com.software2.foodtruckfinder.secure.model.Review;
import com.software2.foodtruckfinder.secure.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    List<Review> findReviewsByTruckID(Long tid);

    List<Review> findReviewsByUserID(Long uid);
}
