package com.software2.foodtruckfinder.secure.repository;

import com.software2.foodtruckfinder.secure.model.Review;
import com.software2.foodtruckfinder.secure.payload.ReviewAverages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    List<Review> findReviewsByTruckid(Long tid);

    @Query(value = "select avg(rating) as avg, truck.* from review join truck where review.truckid = truck.id group by truckid ;"
            , nativeQuery = true)
    List<ReviewAverages> getReviewAverages();

    List<Review> findReviewsByUserID(Long uid);
}
