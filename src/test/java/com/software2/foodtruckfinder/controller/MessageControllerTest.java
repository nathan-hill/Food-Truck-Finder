package com.software2.foodtruckfinder.controller;

import com.software2.foodtruckfinder.secure.controller.MessageController;
import com.software2.foodtruckfinder.secure.model.Message;
import com.software2.foodtruckfinder.secure.model.NotificationRequest;
import com.software2.foodtruckfinder.secure.repository.MessageRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class MessageControllerTest {
    private MessageRepository mr;
    private MessageController mc;

    @BeforeEach
    void init(){
        mr = new MessageRepository() {
            @Override
            public void markAllAsRead(Long id) {

            }

            @Override
            public void deleteMessage(Long id){}

            @Override
            public void markMessageAsRead(Long mid) {

            }

            @Override
            public List<Message> findByReceiver(Long uid) {
                return new ArrayList<Message>();
            }

            @Override
            public Iterable<Message> findByIsReadFalseAndReceiver(Long id) {
                return new Iterable<Message>() {
                    @Override
                    public Iterator<Message> iterator() {
                        return null;
                    }
                };
            }

            @Override
            public List<Message> findAll() {
                return new ArrayList<Message>();
            }

            @Override
            public List<Message> findAll(Sort sort) {
                return null;
            }

            @Override
            public List<Message> findAllById(Iterable<Long> longs) {
                return null;
            }

            @Override
            public <S extends Message> List<S> saveAll(Iterable<S> entities) {
                return null;
            }

            @Override
            public void flush() {

            }

            @Override
            public <S extends Message> S saveAndFlush(S entity) {
                return null;
            }
            @Override
            public void deleteInBatch(Iterable<Message> entities) {

            }

            @Override
            public void deleteAllInBatch() {

            }

            @Override
            public Message getOne(Long aLong) {
                return null;
            }

            @Override
            public <S extends Message> List<S> findAll(Example<S> example) {
                return null;
            }

            @Override
            public <S extends Message> List<S> findAll(Example<S> example, Sort sort) {
                return null;
            }

            @Override
            public Page<Message> findAll(Pageable pageable) {
                return null;
            }

            @Override
            public <S extends Message> S save(S entity) {
                return null;
            }

            @Override
            public Optional<Message> findById(Long aLong) {
                return Optional.empty();
            }

            @Override
            public boolean existsById(Long aLong) {
                return true;
            }

            @Override
            public long count() {
                return 0;
            }

            @Override
            public void deleteById(Long aLong) {

            }

            @Override
            public void delete(Message entity) {

            }

            @Override
            public void deleteAll(Iterable<? extends Message> entities) {

            }

            @Override
            public void deleteAll() {

            }

            @Override
            public <S extends Message> Optional<S> findOne(Example<S> example) {
                return Optional.empty();
            }

            @Override
            public <S extends Message> Page<S> findAll(Example<S> example, Pageable pageable) {
                return null;
            }

            @Override
            public <S extends Message> long count(Example<S> example) {
                return 0;
            }

            @Override
            public <S extends Message> boolean exists(Example<S> example) {
                return false;
            }
        };
        mc = new MessageController(mr);
    }

    @Test
    @DisplayName("Add new message")
    void addNewBySub() throws CloneNotSupportedException {
        assertNotNull(mc.addNewMessage(new Message()));
    }

    @Test
    @DisplayName("Mark all as read test")
    void markAllAsRead(){
        ResponseEntity<?> re = mc.markAllMessagesAsRead(123l);
        assertEquals(re.getStatusCode(), HttpStatus.OK);
    }

    @Test
    @DisplayName("Mark message as read test")
    void markMessageRedTest(){
        ResponseEntity<?> re = mc.markMessageAsRead(123l);
        assertEquals(re.getStatusCode(), HttpStatus.OK);
    }

    @Test
    @DisplayName("get all Test")
   void getUnreadTest(){
        assertNotNull(mc.getAllMessages());
    }

    @Test
    @DisplayName("delete all test")
    void deleteAllTest(){
        assertTrue(mc.deleteAllMessages());
    }

    @Test
    @DisplayName("Find by User ID test")
    void findByUserTest(){
        Iterable<Message> im = mc.findMesssagesByUserId(123l);
        assertNotNull(im);
    }

    @Test
    @DisplayName("make message read test")
    void makeReadTest() throws CloneNotSupportedException {
        assertEquals(HttpStatus.OK, mc.markMessageAsRead(1243l).getStatusCode());
    }

    @Test
    @DisplayName("update message read test")
    void updateReadTest() throws CloneNotSupportedException {
        assertEquals(HttpStatus.OK, mc.updateMessage(new Message()).getStatusCode());
    }
}
