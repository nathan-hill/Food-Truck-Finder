package com.software2.foodtruckfinder.secure.controller;

import com.software2.foodtruckfinder.secure.model.*;
import com.software2.foodtruckfinder.secure.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@Controller // This means that this class is a Controller
@RequestMapping(path = "/v/trucks/")
public class FoodTruckController {

    @Autowired
    private TruckRepository truckRepository;

    @Autowired
    private MenuRepository mRepository;

    @Autowired
    private SubscriptionRepository subRepository;

    @Autowired
    private ReviewRepository revRepository;

    @Autowired
    private MessageRepository _mRepository;

    @Autowired
    private ScheduleRepository _scheduleRepository;


    public FoodTruckController(TruckRepository truckRepository) {
        this.truckRepository = truckRepository;
    }

    @PostMapping(path = "add")
    public @ResponseBody
    ResponseEntity<Truck> addNewTruck(@RequestBody Truck newTruck) {
        
        System.out.println(newTruck);
        Truck n = new Truck();
        n.setName(newTruck.getName());
        n.setDescription(newTruck.getDescription());
        n.setOwnerID(newTruck.getOwnerID());
        n.setMenu(null);

        if(n.getName() == "" || n.getOwnerID() == null){
            // do nothing
            System.out.println("test 1");
            return new ResponseEntity<>(new Truck(), HttpStatus.BAD_REQUEST);
        }else{
            System.out.println("test 2");
            for (Truck truck: truckRepository.findAll()) {
                if(truck.getName().equals(newTruck.getName())){
                    return ResponseEntity.status(400).build();
                }
            }

            Truck generatedTruck = truckRepository.save(n);
            return new ResponseEntity<Truck>(generatedTruck, HttpStatus.OK);
        }
    }

    @GetMapping(path = "")
    public @ResponseBody
    Iterable<Truck> getAllTrucks() {
        // This returns a JSON or XML with the trucks
        return truckRepository.findAll();
    }

    @DeleteMapping(path = "delete")
    public @ResponseBody
    Boolean deleteAllTrucks() {
        truckRepository.deleteAll();
        return true;
    }

    @GetMapping(path = "findTruckByID")
    public @ResponseBody
    Optional<Truck> findByTruckId(Long id){
        return truckRepository.findById(id);
    }

    @GetMapping(path = "findTrucksByOwnerID")
    public @ResponseBody
    List<Truck> findTrucksByOwnerID(@RequestParam("id") long id){
        List<Truck> trucks = truckRepository.findTrucksByOwnerID(id);
        for(Truck t : trucks){
            t.setMenu(null);
        }
        return trucks;
    }

    @GetMapping(path = "GetMenuDTOsByTruckID")
    public @ResponseBody
    List<MenuDTO> getMenuDTOsByTruckID(@RequestParam("id") long id){
        List<Truck> trucks = truckRepository.findTrucksByOwnerID(id);
        List<MenuDTO> d = new ArrayList<MenuDTO>();
        for(Truck t : trucks){
            d.add(getMenuDTOByTruckID(t.getId()));
        }
        return d;
    }

    @GetMapping(path = "GetMenuDTOByTruckID")
    public @ResponseBody
    MenuDTO getMenuDTOByTruckID(@RequestParam("id") long id){
        Menu m = mRepository.findBytruckid(id);
        MenuDTO d = new MenuDTO();
        Truck t = truckRepository.findTruckById(id);
        d.setMenu(m.getText());
        d.setId(id);
        d.setCost(t.getCost());
        d.setDescription(t.getDescription());
        d.setName(t.getName());
        d.setOwnerID(t.getOwnerID());
        d.setType(t.getType());
        return d;
    }

    @GetMapping(path = "findMenuByTruckID")
    public @ResponseBody
    Menu findMenuByTruckID(@RequestParam("id") long id){
        return mRepository.findBytruckid(id);
    }

    @GetMapping(path = "findNameByTruckID")
    public @ResponseBody
    String findNameByTruckID(@RequestParam("id") long id){
        return truckRepository.findNameByid(id);
    }

    @PutMapping(value = "updateByTruck", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Truck> updateTruck(@RequestBody Truck tdets) {

        System.out.println(tdets.getOwnerID());

        if(truckRepository.existsById(tdets.getId())){
            Truck newT = new Truck();
            newT.setId(tdets.getId());
            newT.setDescription(tdets.getDescription());
            newT.setName(tdets.getName());
            newT.setOwnerID(tdets.getOwnerID());
            newT.setType(tdets.getType());
            newT.setCost(tdets.getCost());
            newT.setMenu(tdets.getMenu());

            Truck generatedTruck = truckRepository.save(newT);
            return new ResponseEntity<Truck>(generatedTruck, HttpStatus.OK);
        }else{
            return null;
        }
    }

    @DeleteMapping(path = "/removeTruck")
    public @ResponseBody
    Boolean removeTruck(Long truckid) {

        mRepository.deleteBytruckid(truckid);

        List<Review> reviews = revRepository.findReviewsByTruckid(truckid);
        for(Review r : reviews){
            revRepository.deleteById(r.getId());
        }
        List<Subscription> subscriptions = (List<Subscription>) subRepository.findByTruckId(truckid);
        for(Subscription subs: subscriptions){
            subRepository.deleteById(subs.getId());
        }

        List<Message> messages = _mRepository.findBySender(truckid);
        for(Message m: messages){
            _mRepository.deleteMessage(m.getId());
        }

        List<Schedule> schedules = _scheduleRepository.findByTruckID(truckid);
        for(Schedule s: schedules){
            _scheduleRepository.deleteById(s.getId());
        }

        truckRepository.deleteTruck(truckid);

        return true;
    }





}