package com.software2.foodtruckfinder.secure.controller;

import com.software2.foodtruckfinder.secure.model.Schedule;
import com.software2.foodtruckfinder.secure.model.ScheduleDTO;
import com.software2.foodtruckfinder.secure.payload.Rankings;
import com.software2.foodtruckfinder.secure.repository.TruckLocation;
import com.software2.foodtruckfinder.secure.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@CrossOrigin
@Controller // This means that this class is a Controller
@RequestMapping(path = "/v/schedule")
public class ScheduleController {
    @Autowired
    private ScheduleRepository _scheduleRepository;

    public ScheduleController(ScheduleRepository sr) {
        this._scheduleRepository = sr;
    }

    @PostMapping(path = "/add")
    public @ResponseBody
    ResponseEntity<Schedule[]> addNewSchedule(@RequestBody ScheduleDTO days) throws CloneNotSupportedException {
        List<Schedule> generated = new ArrayList<>();
        Schedule temp = new Schedule();

        temp = days.cloneMon();
        generated.add(_scheduleRepository.save(temp));
        temp = days.cloneTues();
        generated.add(_scheduleRepository.save(temp));
        temp = days.cloneW();
        generated.add(_scheduleRepository.save(temp));
        temp = days.cloneTh();
        generated.add(_scheduleRepository.save(temp));
        temp = days.cloneF();
        generated.add(_scheduleRepository.save(temp));
        temp = days.cloneSa();
        generated.add(_scheduleRepository.save(temp));
        temp = days.cloneSu();
        generated.add(_scheduleRepository.save(temp));

        return new ResponseEntity<Schedule[]>(
                generated.toArray(new Schedule[generated.size()]), HttpStatus.OK);
    }

    @DeleteMapping(path = "/delete")
    public @ResponseBody
    Boolean deleteAllSchedules() {
        _scheduleRepository.deleteAll();
        return true;
    }
    @DeleteMapping(path = "/removeByTruck")
    public @ResponseBody
    Boolean removeFromDBviaTruck(Long truckid) {
        List<Schedule> generated = findScheduleByID(truckid);
        for(int i = 0; i < 7; i++){
            _scheduleRepository.deleteById(generated.get(i).getId());
        }
        return true;
    }

    @DeleteMapping(path = "/remove")
    public @ResponseBody
    Boolean removeFromDB(Long schedid) {
        _scheduleRepository.deleteById(schedid);
        return true;
    }

    @GetMapping(path = "/getScheduleByID")
    public @ResponseBody
    List<Schedule> findScheduleByID(Long id){
        List<Schedule> generated = findScheduleByID(id);
        for(int i = 0; i < generated.size(); i ++){
            System.out.println(generated.get(i).toString());
        }
        return _scheduleRepository.findByTruckID(id);
    }

    @GetMapping(path = "/getScheduleDTOByID")
    public @ResponseBody
    ScheduleDTO findScheduleDTOByID(@RequestParam("id") Long id) throws CloneNotSupportedException {
        List<Schedule> generated = _scheduleRepository.findByTruckID(id);
        System.out.println(generated.stream().count());
        ScheduleDTO d = new ScheduleDTO();
        d.setAll(generated);
        return d;
    }

    @GetMapping(path = "/getSingleScheduleByID")
    public @ResponseBody
    Schedule findSingleScheduleByID(Long id) {
        return _scheduleRepository.findByid(id);
    }

    @PutMapping(path = "/update")
    public @ResponseBody
    ResponseEntity<Schedule[]> updateSchedule(@RequestBody ScheduleDTO days) throws CloneNotSupportedException {
        if(_scheduleRepository.existsById(days.getId())) {
            List<Schedule> generated = new ArrayList<>();

            // this sould remove all entries related to that truck from db
            removeFromDBviaTruck(days.getTruckID());

            Schedule temp = new Schedule();
            temp = days.cloneMon();
            generated.add(_scheduleRepository.save(temp));
            temp = days.cloneTues();
            generated.add(_scheduleRepository.save(temp));
            temp = days.cloneW();
            generated.add(_scheduleRepository.save(temp));
            temp = days.cloneTh();
            generated.add(_scheduleRepository.save(temp));
            temp = days.cloneF();
            generated.add(_scheduleRepository.save(temp));
            temp = days.cloneSa();
            generated.add(_scheduleRepository.save(temp));
            temp = days.cloneSu();
            generated.add(_scheduleRepository.save(temp));


            return new ResponseEntity<Schedule[]>(
                    generated.toArray(new Schedule[generated.size()]), HttpStatus.OK);
        }
        else {
            return null;
        }
    }

    @GetMapping(path="/getTrucksForToday")
    public @ResponseBody
    List<TruckLocation> getTrucksForToday(){
        SimpleDateFormat simpleDateformat = new SimpleDateFormat("EEEE"); // the day of the week spelled out completely
        List<TruckLocation> schedule = _scheduleRepository.getTrucksForToday(Rankings.dayOfWeekToInt(simpleDateformat.format(new Date()).toUpperCase()));

        return schedule;
    }
}