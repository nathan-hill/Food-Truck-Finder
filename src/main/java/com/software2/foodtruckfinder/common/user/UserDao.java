package com.software2.foodtruckfinder.common.user;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends CrudRepository<DAOUser, Integer> {
    UserDao findByUsername(String username);
}
