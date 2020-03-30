package com.software2.foodtruckfinder.secure.controller;

import com.software2.foodtruckfinder.secure.model.Schedule;
import com.software2.foodtruckfinder.secure.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@CrossOrigin
@Controller // This means that this class is a Controller
@RequestMapping(path = "/v/schedule")
public class ScheduleController {
    @Autowired
    private ScheduleRepository scheduleRepository;

    public ScheduleController(ScheduleRepository sr) {
        this.scheduleRepository = sr;
    }

    @PostMapping(path = "/add")
    public @ResponseBody
    ResponseEntity<Schedule[]> addNewSchedule(@RequestBody Schedule[] days) throws CloneNotSupportedException {
        List<Schedule> generated = new ArrayList<>();

        Schedule temp = new Schedule();
        for (Schedule s : days) {
            temp = s.clone();

            System.out.println(s.toString() + "\n" + temp.toString());

            generated.add(scheduleRepository.save(temp));
        }

        return new ResponseEntity<Schedule[]>(
                generated.toArray(new Schedule[generated.size()]), HttpStatus.OK);
    }

    @DeleteMapping(path = "/delete")
    public @ResponseBody
    Boolean deleteAllSchedules() {
        scheduleRepository.deleteAll();
        return true;
    }

    @GetMapping(path = "/getScheduleByID")
    public @ResponseBody
    List<Schedule> findScheduleByID(Integer id){
        return scheduleRepository.findByTruckID(id);
    }

    @GetMapping(path = "/getSingleScheduleByID")
    public @ResponseBody
    Schedule findSingleScheduleByID(Long id) {
        return scheduleRepository.findByid(id);
    }

    @PostMapping(path = "/update")
    public @ResponseBody
    ResponseEntity<Schedule[]> updateSchedule(@RequestBody Schedule[] days) throws CloneNotSupportedException {
        if(scheduleRepository.existsById(days[0].getId())) {
            List<Schedule> generated = new ArrayList<>();

            Schedule temp = new Schedule();
            for (Schedule s : days) {
                temp = s.clone();

                generated.add(scheduleRepository.save(temp));
            }

            return new ResponseEntity<Schedule[]>(
                    generated.toArray(new Schedule[generated.size()]), HttpStatus.OK);
        }
        else {
            return null;
        }
    }


}
