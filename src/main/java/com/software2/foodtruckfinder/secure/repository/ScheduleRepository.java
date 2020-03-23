package com.software2.foodtruckfinder.secure.repository;

import com.software2.foodtruckfinder.secure.model.Schedule;
import com.software2.foodtruckfinder.secure.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<User, Long>  {

    Schedule findByid(Long id);

    boolean existsById(Long id);

    List<Schedule> findByTruck(Integer truckID);

}
