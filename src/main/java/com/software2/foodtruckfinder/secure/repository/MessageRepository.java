package com.software2.foodtruckfinder.secure.repository;

import com.software2.foodtruckfinder.secure.model.Message;
import org.elasticsearch.common.inject.name.Named;
import org.hibernate.annotations.NamedQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {
    @Modifying(flushAutomatically = true)
    @Transactional
    @Query("update Message set isRead = true where receiver = id and isRead = false")
    void markAllAsRead(Long id);

    @Modifying(flushAutomatically = true)
    @Transactional
    @Query("update Message set isRead = true where id = mid")
    void markMessageAsRead(Long mid);

    List<Message> findByReceiver( Long uid );

    Iterable<Message> findByIsReadFalseAndReceiver(Long id);

}
