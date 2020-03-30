package com.software2.foodtruckfinder.secure.repository;

import com.software2.foodtruckfinder.secure.model.Message;
import com.software2.foodtruckfinder.secure.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {

    @Query("SELECT m FROM Message m  WHERE m.sender=(:user) or m.receiver= (:user)")
    List<Message> findByUser(@Param("user") Long uid);

}
