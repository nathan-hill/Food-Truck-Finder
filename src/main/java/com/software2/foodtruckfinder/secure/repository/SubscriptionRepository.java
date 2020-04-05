package com.software2.foodtruckfinder.secure.repository;

import com.software2.foodtruckfinder.secure.model.Subscription;
import com.software2.foodtruckfinder.secure.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {

    Iterable<Subscription> findByTruckId(Long truckID);

    Subscription findSubscriptionById(Long id);

    Iterable<Subscription> findReviewsByTruckId(Long tid);
}
