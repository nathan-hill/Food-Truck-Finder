package com.software2.foodtruckfinder.secure.repo;

import com.software2.foodtruckfinder.secure.model.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.management.relation.Role;
import java.util.Optional;

/**
 * Created by rajeevkumarsingh on 02/08/17.
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName roleName);
}