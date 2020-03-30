package com.software2.foodtruckfinder.secure.controller;


import com.software2.foodtruckfinder.secure.model.Message;
import com.software2.foodtruckfinder.secure.model.Subscription;
import com.software2.foodtruckfinder.secure.repository.MessageRepository;
import com.software2.foodtruckfinder.secure.repository.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@Controller // This means that this class is a Controller
@RequestMapping(path = "/v/message") // This means URL's start with /demo (after Application path this is assigned to
public class MessageController {
    @Autowired
    private MessageRepository mRepository;
    @Autowired
    private SubscriptionRepository subRepository;

    public MessageController(MessageRepository mr) {
        this.mRepository = mr;
    }

    @PostMapping(path = "/add")
    public @ResponseBody
    ResponseEntity<Message> addNewMessage(@RequestBody Message m) throws CloneNotSupportedException {
        Message n = new Message();
        n = m.clone();

        for (Message mess : mRepository.findAll()) {
            if (mess.getId().equals(n.getId())) {
                return ResponseEntity.status(400).build();
            }
        }

        Message generatedM = mRepository.save(n);
        return new ResponseEntity<Message>(generatedM, HttpStatus.OK);
    }

    @PostMapping(path = "/sendToAllByTruckSubscription")
    public @ResponseBody
    void addNewMessageBySubscription(@RequestBody Message m, Long truckid) throws CloneNotSupportedException {

        for(Subscription s : subRepository.findReviewsByTruckID(truckid)){
            Message n = new Message();
            n = m.clone();
            n.setReceiver(s.getUid());
            Message generatedM = mRepository.save(n);
        }
    }



    @GetMapping(path = "/")
    public @ResponseBody
    Iterable<Message> getAllMessages() {
        // This returns a JSON or XML with the users
        return mRepository.findAll();
    }

    @DeleteMapping(path = "/delete")
    public @ResponseBody
    Boolean deleteAllMessages() {
        mRepository.deleteAll();
        return true;
    }

    //should be all you need to get all messages that are associated with a user
    @GetMapping(path = "/getMessagesbyUserID")
    public @ResponseBody
    Iterable<Message> findMesssagesByUserId(Long user_id) {
        return mRepository.findByUser(user_id);
    }




    @PutMapping(value = "update", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Message> updateMessage(@RequestBody Message m) throws CloneNotSupportedException {

        if (mRepository.existsById(m.getId())) {
            Message n = new Message();
            n = m.clone();

            Message generatedM = mRepository.save(n);
            return new ResponseEntity<Message>(generatedM, HttpStatus.OK);
        } else {
            return null;
        }
    }
}
