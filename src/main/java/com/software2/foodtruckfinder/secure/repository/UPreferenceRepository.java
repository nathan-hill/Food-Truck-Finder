package com.software2.foodtruckfinder.secure.repository;

import com.software2.foodtruckfinder.secure.model.User;
import com.software2.foodtruckfinder.secure.model.UserPreferences;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UPreferenceRepository extends JpaRepository<UserPreferences, Long> {


    List<String> findDislikesById(Long id);

    List<String> findLikesById(Long id);

    UserPreferences findUserPreferencesById(Long id);

    Double findProximityById(Long id);

    Integer findPriceById(Long id);
}
