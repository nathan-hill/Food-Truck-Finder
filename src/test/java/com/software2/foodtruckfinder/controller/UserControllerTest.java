package com.software2.foodtruckfinder.controller;

import com.software2.foodtruckfinder.secure.controller.UserController;
import com.software2.foodtruckfinder.secure.model.User;
import com.software2.foodtruckfinder.secure.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class UserControllerTest {

    UserController uc;

    @BeforeEach
    void init(){

        uc = new UserController(new UserRepository() {
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
            public List<User> findAll() {
                return new List<User>() {
                    @Override
                    public int size() {
                        return 0;
                    }

                    @Override
                    public boolean isEmpty() {
                        return false;
                    }

                    @Override
                    public boolean contains(Object o) {
                        return false;
                    }

                    @Override
                    public Iterator<User> iterator() {
                        return null;
                    }

                    @Override
                    public Object[] toArray() {
                        return new Object[0];
                    }

                    @Override
                    public <T> T[] toArray(T[] a) {
                        return null;
                    }

                    @Override
                    public boolean add(User user) {
                        return false;
                    }

                    @Override
                    public boolean remove(Object o) {
                        return false;
                    }

                    @Override
                    public boolean containsAll(Collection<?> c) {
                        return false;
                    }

                    @Override
                    public boolean addAll(Collection<? extends User> c) {
                        return false;
                    }

                    @Override
                    public boolean addAll(int index, Collection<? extends User> c) {
                        return false;
                    }

                    @Override
                    public boolean removeAll(Collection<?> c) {
                        return false;
                    }

                    @Override
                    public boolean retainAll(Collection<?> c) {
                        return false;
                    }

                    @Override
                    public void clear() {

                    }

                    @Override
                    public User get(int index) {
                        return null;
                    }

                    @Override
                    public User set(int index, User element) {
                        return null;
                    }

                    @Override
                    public void add(int index, User element) {

                    }

                    @Override
                    public User remove(int index) {
                        return null;
                    }

                    @Override
                    public int indexOf(Object o) {
                        return 0;
                    }

                    @Override
                    public int lastIndexOf(Object o) {
                        return 0;
                    }

                    @Override
                    public ListIterator<User> listIterator() {
                        return null;
                    }

                    @Override
                    public ListIterator<User> listIterator(int index) {
                        return null;
                    }

                    @Override
                    public List<User> subList(int fromIndex, int toIndex) {
                        return null;
                    }
                };
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
            public User findUserByid(Long id) {
                return null;
            }

            @Override
            public boolean existsById(Long aLong) {
                return false;
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
        });
    }

    @DisplayName("null addNewUser Test")
    @Test
    void nullAddNewTest(){
        assertThrows(NullPointerException.class, ()->uc.addNewUser(null));
    }

    /**
    @DisplayName("valid addNewUser Test")
    @Test
    void validAddNewTest(){
        assertNotNull(uc.addNewUser(new User("name", "username", "email", "password")));
    }
     **/

    @DisplayName("getAllUsers Test")
    @Test
    void getAllTest(){
        assertNotNull(uc.getAllUsers());
    }

    @DisplayName("deleteAllUsers Test")
    @Test
    void deleteAllTest(){
        assertTrue(uc.deleteAllUsers());
    }
}
