package com.software2.foodtruckfinder.secure.repository;

import com.software2.foodtruckfinder.secure.model.Truck;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface TruckRepository extends CrudRepository<Truck, Integer> {


    Truck findById(Integer in);

    List<Truck> findTrucksByOwnerID(String userId);

}