package com.software2.foodtruckfinder.secure.repository;

import com.software2.foodtruckfinder.secure.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityResult;
import javax.persistence.FieldResult;
import javax.persistence.SqlResultSetMapping;
import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

    Schedule findByid(Long id);

    boolean existsById(Long id);

    List<Schedule> findByTruckID(Long truckID);

    @Query(value = "select * from truck t, " +
            "(select  day, end_time, latitude, longitude, start_time, " +
            "truckid, is_open from schedule) s where s.truckid = t.id and day = :today ;"
            , nativeQuery = true)
    List<TruckLocation> getTrucksForToday(@Param("today") int today);

}
