package com.software2.foodtruckfinder.secure.repository;

import com.software2.foodtruckfinder.secure.model.Truck;
import com.software2.foodtruckfinder.secure.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface TruckRepository extends CrudRepository<Truck, Integer> {

    //@Query("FROM Truck t WHERE t.id = :id")
    Optional<Truck> findById(@Param("id") Integer id);

    List<Truck> findTrucksByOwnerID(String userId);

}