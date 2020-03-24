package com.software2.foodtruckfinder.secure.repository;

import com.software2.foodtruckfinder.secure.model.Subscription;
import com.software2.foodtruckfinder.secure.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {


    Subscription findSubscriptionById(Long id);
}
