package com.software2.foodtruckfinder.secure.model;

import com.sun.istack.NotNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.DayOfWeek;
import java.time.LocalTime;

@Entity
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //will have to set truckid
    @NotNull
    private long truckID;

    @NotNull
    private DayOfWeek day;

    //might have to change
    // should null the schedule if on this day the truck is closed
    @NotNull
    private boolean isOpen;

    private LocalTime startTime;

    private LocalTime endTime;

    //will have to change
    private String location;

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        if (isOpen() == false){
            this.endTime = null;
        }
        else{
            this.endTime = endTime;
        }
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        if (isOpen() == false){
            this.startTime = null;
        }
        else{
            this.startTime = startTime;
        }

    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        if (open == false){
            isOpen = open;
            setStartTime(null);
            setEndTime(null);
            setLocation(null);
        }

    }

    public DayOfWeek getDay() {
        return day;
    }

    public void setDay(DayOfWeek day) {
        this.day = day;
    }

    public long getTruckID() {
        return truckID;
    }

    public void setTruckID(long truckID) {
        this.truckID = truckID;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        if (isOpen() == false){
            this.location = null;
        }
        else{
            this.location = location;
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
