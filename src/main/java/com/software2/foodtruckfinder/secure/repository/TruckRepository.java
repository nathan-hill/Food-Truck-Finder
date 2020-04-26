package com.software2.foodtruckfinder.secure.repository;

import com.software2.foodtruckfinder.secure.model.Truck;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface TruckRepository extends JpaRepository<Truck, Long> {

    @Modifying(flushAutomatically = true)
    @Transactional
    @Query("delete from Truck where id = :tid")
    void deleteTruck(@Param("tid") Long tid);


    boolean existsById(Long id);

    List<Truck> findByTypeIn(List<String> type);

    Optional<Truck> findById(Integer in);

    List<Truck> findTrucksByOwnerID(long ownerID);

    String findNameByid(long tid);
}