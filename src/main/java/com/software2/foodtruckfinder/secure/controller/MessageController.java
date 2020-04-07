package com.software2.foodtruckfinder.secure.controller;


import com.software2.foodtruckfinder.secure.model.*;
import com.software2.foodtruckfinder.secure.repository.MessageRepository;
import com.software2.foodtruckfinder.secure.repository.SubscriptionRepository;
import com.software2.foodtruckfinder.secure.repository.TruckRepository;
import com.software2.foodtruckfinder.secure.repository.UserRepository;
import com.software2.foodtruckfinder.secure.service.Email;
import com.software2.foodtruckfinder.secure.service.UPreferenceService;
import org.elasticsearch.search.aggregations.metrics.InternalHDRPercentiles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@Controller // This means that this class is a Controller
@RequestMapping(path = "/v/message") // This means URL's start with /demo (after Application path this is assigned to
public class MessageController {
    @Autowired
    private MessageRepository _mRepository;
    @Autowired
    private SubscriptionRepository _subRepository;
    @Autowired
    private UserRepository _userRepository;
    @Autowired
    private TruckRepository _truckRepository;

    public MessageController(MessageRepository mr) {
        this._mRepository = mr;
    }

    @PostMapping(path = "/add")
    public @ResponseBody
    ResponseEntity<Message> addNewMessage(@RequestBody Message m) throws CloneNotSupportedException {
        Message n = new Message();
        n = m.clone();

        for (Message mess : _mRepository.findAll()) {
            if (mess.getId().equals(n.getId())) {
                return ResponseEntity.status(400).build();
            }
        }

        Message generatedM = _mRepository.save(n);
        return new ResponseEntity<Message>(generatedM, HttpStatus.OK);
    }

    @PostMapping(path = "/sendToAllByTruckId")
    public @ResponseBody
    void addNewMessageBySubscription(@RequestBody NotificationRequest n) throws CloneNotSupportedException {

        System.out.println(n.toString());

        //for each of the trucks to send the message to
        for (Long recipient : n.getTo()) {
            //get all of the people subscribed to that truck.
            Iterable<Subscription> subscriptions_for_truck = _subRepository.findByTruckId(recipient);
            for (Subscription s : subscriptions_for_truck) {
                //send them a message
                Truck from = _truckRepository.getOne(recipient);
                User to = _userRepository.getOne(s.getUid());

                Email e = new Email(to.getEmail(), from.getName(), n.message);
                e.send();

                //save a message to them.
                _mRepository.save(new Message(from.getName(), from.getId(), to.getId(), n.getMessage(), new Timestamp(System.currentTimeMillis()), "Notification", false));
            }

        }
    }

    @PostMapping(path="/markAllAsRead")
    public ResponseEntity<?> markAllMessagesAsRead(@RequestParam("id") Long id){

        _mRepository.markAllAsRead(id);

        return new ResponseEntity<Boolean>(true, HttpStatus.OK);
    }

    @PostMapping(path="/markMessageAsRead")
<<<<<<< HEAD
    public ResponseEntity<?> markMessageAsRead(@RequestBody Long id){
=======
    public ResponseEntity<?> markMessageAsRead(@RequestParam("id") Long id){
>>>>>>> bfbbd696ec6d9b565622935e21517eb97dc1fc4c
        _mRepository.markMessageAsRead(id);

        return new ResponseEntity<Boolean>(true, HttpStatus.OK);
    }

    @GetMapping(path="/getUnreadMessagesByUser")
    public ResponseEntity<?> getUnreadMessages(@RequestBody Long id){
        return new ResponseEntity<List<Message>>(UPreferenceService.iteratorToList(_mRepository.findByIsReadFalseAndReceiver(id).iterator()), HttpStatus.OK);
    }

    @GetMapping(path = "/")
    public @ResponseBody
    Iterable<Message> getAllMessages() {
        // This returns a JSON or XML with the users
        return _mRepository.findAll();
    }

    @DeleteMapping(path = "/delete")
    public @ResponseBody
    Boolean deleteAllMessages() {
        _mRepository.deleteAll();
        return true;
    }

    //should be all you need to get all messages that are associated with a user
    @GetMapping(path = "/getMessagesbyUserID")
    public @ResponseBody
    Iterable<Message> findMesssagesByUserId(@RequestParam("id") Long id) {
        System.out.println(id);
        Iterable<Message> m =_mRepository.findByReceiver(id);
        m.forEach(System.out::println);
        return m;
    }

    @PutMapping(value = "/makeMessageRead", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Message> updateMessageAsRead(@RequestParam Message m) throws CloneNotSupportedException {

        if (_mRepository.existsById(m.getId())) {
            Message n = new Message();
            m.setRead(true);
            n = m.clone();


            Message generatedM = _mRepository.save(n);
            return new ResponseEntity<Message>(generatedM, HttpStatus.OK);
        } else {
            return null;
        }
    }

    @GetMapping(path = "/getUnreadMessagesbyUserID")
    public @ResponseBody
    int findUnreadByUserId(Long user_id){
        Iterable<Message> messIt = _mRepository.findByReceiver(user_id);
        int count = 0;
        for (Message m : messIt ){
            if(!m.getRead()){
                count = count + 1;
            }
        }
        return count;
    }



    @PutMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Message> updateMessage(@RequestBody Message m) throws CloneNotSupportedException {

        if (_mRepository.existsById(m.getId())) {
            Message n = new Message();
            n = m.clone();

            Message generatedM = _mRepository.save(n);
            return new ResponseEntity<Message>(generatedM, HttpStatus.OK);
        } else {
            return null;
        }
    }
}
