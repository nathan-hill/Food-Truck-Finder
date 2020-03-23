package com.software2.foodtruckfinder.secure.repository;

import com.software2.foodtruckfinder.secure.model.User;
import com.software2.foodtruckfinder.secure.model.UserPreferences;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UPreferenceRepository extends JpaRepository<UserPreferences, Long> {


    List<String> findDislikesByUser(Long id);

    List<String> findLikesByUser(Long id);

    UserPreferences findUserPreferencesByid(Long id);

    Double findProximityByUser(Long id);

    Integer findPriceByUser(Long id);
}
