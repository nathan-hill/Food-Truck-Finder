package com.software2.foodtruckfinder.secure.repository;

import com.software2.foodtruckfinder.secure.model.Menu;
import com.software2.foodtruckfinder.secure.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotBlank;
import java.util.Optional;

public interface MenuRepository extends JpaRepository<Menu, Long> {

    Menu findBytruckid(Long truck);

    @Modifying(flushAutomatically = true)
    @Transactional
    @Query("delete from Menu where id = :mid")
    void deleteMenu(@Param("mid") Long mid);

    @Modifying(flushAutomatically = true)
    @Transactional
    @Query("delete from Menu where truckid = :tid")
    void deleteBytruckid(Long tid);

    boolean existsBytruckid(@NotBlank Long truckid);
}
