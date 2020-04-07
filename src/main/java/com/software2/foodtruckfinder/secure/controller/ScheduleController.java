package com.software2.foodtruckfinder.secure.controller;

import com.software2.foodtruckfinder.secure.model.Message;
import com.software2.foodtruckfinder.secure.model.Schedule;
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
    ResponseEntity<Schedule> addNewSchedule(@RequestBody Schedule sc) throws CloneNotSupportedException {
        List<Schedule> generated = new ArrayList<>();

        Schedule temp = new Schedule();
        temp = sc.clone();
        for (Schedule s : _scheduleRepository.findAll()) {
            if (s.getId().equals(temp.getId())) {
                return ResponseEntity.status(400).build();
            }
        }

        Schedule generatedS = _scheduleRepository.save(temp);
        return new ResponseEntity<Schedule>(generatedS, HttpStatus.OK);
    }

    @DeleteMapping(path = "/delete")
    public @ResponseBody
    Boolean deleteAllSchedules() {
        _scheduleRepository.deleteAll();
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
    Schedule findScheduleByID(Long id) {
        return _scheduleRepository.findByid(id);
    }

    @PostMapping(path = "/update")
    public @ResponseBody
    ResponseEntity<Schedule> updateSchedule(@RequestBody Schedule days) throws CloneNotSupportedException {
        if(_scheduleRepository.existsById(days.getId())) {
            List<Schedule> generated = new ArrayList<>();

            Schedule temp = new Schedule();
            temp = days.clone();

            removeFromDB(days.getId());
            generated.add(_scheduleRepository.save(temp));
            Schedule generatedS = _scheduleRepository.save(temp);
            return new ResponseEntity<Schedule>(generatedS, HttpStatus.OK);
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
