package com.software2.foodtruckfinder.secure.repository;

import com.software2.foodtruckfinder.secure.model.Truck;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface TruckRepository extends JpaRepository<Truck, Long> {


    boolean existsById(Long id);

    List<Truck> findByTypeIn(List<String> type);

    Optional<Truck> findById(Integer in);

    List<Truck> findTrucksByOwnerID(long userId);

}