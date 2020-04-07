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

    @NotNull
    private long truckID;
    @NotNull
    private Integer day;
    private boolean monOpen;
    private LocalTime monStartTime;
    private LocalTime monEndTime;
    private Double monLongitude;
    private Double monLatitude;

    private boolean tueOpen;
    private LocalTime tueStartTime;
    private LocalTime tueEndTime;
    private Double tueLongitude;
    private Double tueLatitude;

    private boolean wedOpen;
    private LocalTime wedStartTime;
    private LocalTime wedEndTime;
    private Double wedLongitude;
    private Double wedLatitude;

    private boolean thuOpen;
    private LocalTime thuStartTime;
    private LocalTime thuEndTime;
    private Double thuLongitude;
    private Double thuLatitude;

    private boolean friOpen;
    private LocalTime friStartTime;
    private LocalTime friEndTime;
    private Double friLongitude;
    private Double friLatitude;

    private boolean satOpen;
    private LocalTime satStartTime;
    private LocalTime satEndTime;
    private Double satLongitude;
    private Double satLatitude;

    private boolean sunOpen;
    private LocalTime sunStartTime;
    private LocalTime sunEndTime;
    private Double sunLongitude;
    private Double sunLatitude;


    public boolean monOpen() {
        return monOpen;
    }

    public void setMonOpen(boolean open) {
        monOpen = open;
        if(monOpen == false){
            setMonEndTime(null);
            setMonStartTime(null);
            setMonLatitude(null);
            setMonLongitude(null);
        }
    }

    public Long getId() {
        return id;
    }
    public long getTruckID() {
        return truckID;
    }
    // public Integer getDay() {
    //     return day;
    // }
    public LocalTime getMonStartTime() {
        return monStartTime;
    }
    public LocalTime getMonEndTime() {
        return monEndTime;
    }
    public Double getMonLongitude() {
        return monLongitude;
    }
    public Double getMonLatitude() {
        return monLatitude;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setTruckID(long truckID) {
        this.truckID = truckID;
    }
    // public void setDay(Integer day) {
    //     this.day = day;
    // }
    public void setMonStartTime(LocalTime startTime) {
        this.monStartTime = startTime;
    }
    public void setMonEndTime(LocalTime endTime) {
        this.monEndTime = endTime;
    }
    public void setMonLongitude(Double longitude) {
        this.monLongitude = longitude;
    }
    public void setMonLatitude(Double latitude) {
        this.monLatitude = latitude;
    }
    @Override
    public String toString() {
        return "Schedule{" +
                "id=" + id +
                ", truckID=" + truckID +
                // ", day=" + day +
                ", monStartTime=" + monStartTime +
                ", monEndTime=" + monEndTime +
                ", monLongitude=" + monLongitude +
                ", monLatitude=" + monLatitude +
                '}';
    }

    @Override
    public Schedule clone() throws CloneNotSupportedException {
        Schedule newClone = new Schedule();
        newClone.setMonLatitude(this.getMonLatitude());
        newClone.setMonLongitude(this.getMonLongitude());
        newClone.setMonOpen(this.monOpen());
        newClone.setId(this.getId());
        // newClone.setDay(this.getDay());
        newClone.setMonEndTime(this.getMonEndTime());
        newClone.setMonStartTime(this.getMonStartTime());
        newClone.setTruckID(this.getTruckID());

        return newClone;
    }
}
