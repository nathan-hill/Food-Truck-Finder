package com.software2.foodtruckfinder.secure.repository;

import com.software2.foodtruckfinder.secure.model.User;
import com.software2.foodtruckfinder.secure.model.UserPreferences;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UPreferenceRepository extends JpaRepository<UserPreferences, Long> {

    UserPreferences findUserPreferencesById(Long id);

}
