package com.software2.foodtruckfinder.controller;

import com.software2.foodtruckfinder.secure.controller.ReviewController;
import com.software2.foodtruckfinder.secure.model.Review;
import com.software2.foodtruckfinder.secure.model.User;
import com.software2.foodtruckfinder.secure.payload.ReviewAverages;
import com.software2.foodtruckfinder.secure.repository.ReviewRepository;
import com.software2.foodtruckfinder.secure.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class ReviewControllerTest {
    private ReviewRepository rr;
    private ReviewController rc;
    private UserRepository ur;

    @BeforeEach
    void init(){
        rr = new ReviewRepository() {
            @Override
            public List<Review> findAll() {
                return new ArrayList<Review>();
            }

            @Override
            public List<Review> findAll(Sort sort) {
                return null;
            }

            @Override
            public Page<Review> findAll(Pageable pageable) {
                return null;
            }

            @Override
            public List<Review> findAllById(Iterable<Long> longs) {
                return null;
            }

            @Override
            public long count() {
                return 0;
            }

            @Override
            public void deleteById(Long aLong) {

            }

            @Override
            public void delete(Review entity) {

            }

            @Override
            public void deleteAll(Iterable<? extends Review> entities) {

            }

            @Override
            public void deleteAll() {

            }

            @Override
            public <S extends Review> S save(S entity) {
                return null;
            }

            @Override
            public <S extends Review> List<S> saveAll(Iterable<S> entities) {
                return null;
            }

            @Override
            public Optional<Review> findById(Long aLong) {
                return Optional.empty();
            }

            @Override
            public boolean existsById(Long aLong) {
                return true;
            }

            @Override
            public void flush() {

            }

            @Override
            public <S extends Review> S saveAndFlush(S entity) {
                return null;
            }

            @Override
            public void deleteInBatch(Iterable<Review> entities) {

            }

            @Override
            public void deleteAllInBatch() {

            }

            @Override
            public Review getOne(Long aLong) {
                return null;
            }

            @Override
            public <S extends Review> Optional<S> findOne(Example<S> example) {
                return Optional.empty();
            }

            @Override
            public <S extends Review> List<S> findAll(Example<S> example) {
                return null;
            }

            @Override
            public <S extends Review> List<S> findAll(Example<S> example, Sort sort) {
                return null;
            }

            @Override
            public <S extends Review> Page<S> findAll(Example<S> example, Pageable pageable) {
                return null;
            }

            @Override
            public <S extends Review> long count(Example<S> example) {
                return 0;
            }

            @Override
            public <S extends Review> boolean exists(Example<S> example) {
                return false;
            }

            @Override
            public List<Review> findReviewsByTruckid(Long tid) {
                return new ArrayList<Review>();
            }

            @Override
            public List<ReviewAverages> getReviewAverages() {
                return null;
            }

            @Override
            public List<Review> findReviewsByUserID(Long uid) {
                return new ArrayList<Review>();
            }
        };

        ur = new UserRepository() {
            @Override
            public User findUserByid(Long id) {
                return null;
            }

            @Override
            public boolean existsById(Long id) {
                return false;
            }

            @Override
            public Optional<User> findByEmail(String email) {
                return Optional.empty();
            }

            @Override
            public Optional<User> findByUsernameOrEmail(String username, String email) {
                return Optional.empty();
            }

            @Override
            public List<User> findByIdIn(List<Long> userIds) {
                return null;
            }

            @Override
            public Optional<User> findByUsername(String username) {
                return Optional.empty();
            }

            @Override
            public Boolean existsByUsername(String username) {
                return null;
            }

            @Override
            public Boolean existsByEmail(String email) {
                return null;
            }

            @Override
            public void setNewPassword(String pass, Long id) {

            }

            @Override
            public List<User> findAll() {
                return null;
            }

            @Override
            public List<User> findAll(Sort sort) {
                return null;
            }

            @Override
            public List<User> findAllById(Iterable<Long> longs) {
                return null;
            }

            @Override
            public <S extends User> List<S> saveAll(Iterable<S> entities) {
                return null;
            }

            @Override
            public void flush() {

            }

            @Override
            public <S extends User> S saveAndFlush(S entity) {
                return null;
            }

            @Override
            public void deleteInBatch(Iterable<User> entities) {

            }

            @Override
            public void deleteAllInBatch() {

            }

            @Override
            public User getOne(Long aLong) {
                return null;
            }

            @Override
            public <S extends User> List<S> findAll(Example<S> example) {
                return null;
            }

            @Override
            public <S extends User> List<S> findAll(Example<S> example, Sort sort) {
                return null;
            }

            @Override
            public Page<User> findAll(Pageable pageable) {
                return null;
            }

            @Override
            public <S extends User> S save(S entity) {
                return null;
            }

            @Override
            public Optional<User> findById(Long aLong) {
                return Optional.empty();
            }

            @Override
            public long count() {
                return 0;
            }

            @Override
            public void deleteById(Long aLong) {

            }

            @Override
            public void delete(User entity) {

            }

            @Override
            public void deleteAll(Iterable<? extends User> entities) {

            }

            @Override
            public void deleteAll() {

            }

            @Override
            public <S extends User> Optional<S> findOne(Example<S> example) {
                return Optional.empty();
            }

            @Override
            public <S extends User> Page<S> findAll(Example<S> example, Pageable pageable) {
                return null;
            }

            @Override
            public <S extends User> long count(Example<S> example) {
                return 0;
            }

            @Override
            public <S extends User> boolean exists(Example<S> example) {
                return false;
            }
        };

        rc = new ReviewController(rr, ur);
    }

    @Test
    @DisplayName("addReview Test")
    void addTest(){

        assertEquals(HttpStatus.OK,
                rc.addReview(123l, 3, "mexican", 345l, "tom's")
                        .getStatusCode());

    }

    @Test
    @DisplayName("Update Test")
    void updateTest(){
        assertEquals(HttpStatus.OK, rc.updateReview(new Review()).getStatusCode());
    }

    @Test
    @DisplayName("findAll test")
    void findAllTest(){
        assertNotNull(rc.getAllReviews());
    }

    @Test
    @DisplayName("Delete Test")
    void deleteTest(){
        assertTrue(rc.deleteAllReviews());
    }

   @Test
    @DisplayName("get by user id test")
    void getByIdTest(){
        assertTrue(rc.getReviewsByUser(123l).isEmpty());
    }
}
