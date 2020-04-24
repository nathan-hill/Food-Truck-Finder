package com.software2.foodtruckfinder.secure.model;


import com.sun.istack.NotNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class ScheduleDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private long truckID;

    // private Integer day;
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

    public Long getId() {
        return id;
    }

    public long getTruckID() {
        return truckID;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTruckID(long truckID) {
        this.truckID = truckID;
    }

    public boolean MonOpen() {
        return monOpen;
    }

    public void setMonOpen(boolean open) {
        monOpen = open;
        if (monOpen == false) {
            setMonEndTime(null);
            setMonStartTime(null);
            setMonLatitude(null);
            setMonLongitude(null);
        }
    }

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

    public boolean TueOpen() {
        return tueOpen;
    }

    public void setTueOpen(boolean open) {
        tueOpen = open;
        if (tueOpen == false) {
            setTueEndTime(null);
            setTueStartTime(null);
            setTueLatitude(null);
            setTueLongitude(null);
        }
    }

    public LocalTime getTueStartTime() {
        return tueStartTime;
    }

    public LocalTime getTueEndTime() {
        return tueEndTime;
    }

    public Double getTueLongitude() {
        return tueLongitude;
    }

    public Double getTueLatitude() {
        return tueLatitude;
    }

    public void setTueStartTime(LocalTime startTime) {
        this.tueStartTime = startTime;
    }

    public void setTueEndTime(LocalTime endTime) {
        this.tueEndTime = endTime;
    }

    public void setTueLongitude(Double longitude) {
        this.tueLongitude = longitude;
    }

    public void setTueLatitude(Double latitude) {
        this.tueLatitude = latitude;
    }

    public boolean WedOpen() {
        return wedOpen;
    }

    public void setWedOpen(boolean open) {
        wedOpen = open;
        if (wedOpen == false) {
            setWedEndTime(null);
            setWedStartTime(null);
            setWedLatitude(null);
            setWedLongitude(null);
        }
    }

    public LocalTime getWedStartTime() {
        return wedStartTime;
    }

    public LocalTime getWedEndTime() {
        return wedEndTime;
    }

    public Double getWedLongitude() {
        return wedLongitude;
    }

    public Double getWedLatitude() {
        return wedLatitude;
    }

    public void setWedStartTime(LocalTime startTime) {
        this.wedStartTime = startTime;
    }

    public void setWedEndTime(LocalTime endTime) {
        this.wedEndTime = endTime;
    }

    public void setWedLongitude(Double longitude) {
        this.wedLongitude = longitude;
    }

    public void setWedLatitude(Double latitude) {
        this.wedLatitude = latitude;
    }

    public boolean ThuOpen() {
        return thuOpen;
    }

    public void setThuOpen(boolean open) {
        thuOpen = open;
        if (thuOpen == false) {
            setThuEndTime(null);
            setThuStartTime(null);
            setThuLatitude(null);
            setThuLongitude(null);
        }
    }

    public LocalTime getThuStartTime() {
        return thuStartTime;
    }

    public LocalTime getThuEndTime() {
        return thuEndTime;
    }

    public Double getThuLongitude() {
        return thuLongitude;
    }

    public Double getThuLatitude() {
        return thuLatitude;
    }

    public void setThuStartTime(LocalTime startTime) {
        this.thuStartTime = startTime;
    }

    public void setThuEndTime(LocalTime endTime) {
        this.thuEndTime = endTime;
    }

    public void setThuLongitude(Double longitude) {
        this.thuLongitude = longitude;
    }

    public void setThuLatitude(Double latitude) {
        this.thuLatitude = latitude;
    }

    public boolean FriOpen() {
        return friOpen;
    }

    public void setFriOpen(boolean open) {
        friOpen = open;
        if (friOpen == false) {
            setFriEndTime(null);
            setFriStartTime(null);
            setFriLatitude(null);
            setFriLongitude(null);
        }
    }

    public LocalTime getFriStartTime() {
        return friStartTime;
    }

    public LocalTime getFriEndTime() {
        return friEndTime;
    }

    public Double getFriLongitude() {
        return friLongitude;
    }

    public Double getFriLatitude() {
        return friLatitude;
    }

    public void setFriStartTime(LocalTime startTime) {
        this.friStartTime = startTime;
    }

    public void setFriEndTime(LocalTime endTime) {
        this.friEndTime = endTime;
    }

    public void setFriLongitude(Double longitude) {
        this.friLongitude = longitude;
    }

    public void setFriLatitude(Double latitude) {
        this.friLatitude = latitude;
    }

    public boolean SatOpen() {
        return satOpen;
    }

    public void setSatOpen(boolean open) {
        satOpen = open;
        if (satOpen == false) {
            setSatEndTime(null);
            setSatStartTime(null);
            setSatLatitude(null);
            setSatLongitude(null);
        }
    }

    public LocalTime getSatStartTime() {
        return satStartTime;
    }

    public LocalTime getSatEndTime() {
        return satEndTime;
    }

    public Double getSatLongitude() {
        return satLongitude;
    }

    public Double getSatLatitude() {
        return satLatitude;
    }

    public void setSatStartTime(LocalTime startTime) {
        this.satStartTime = startTime;
    }

    public void setSatEndTime(LocalTime endTime) {
        this.satEndTime = endTime;
    }

    public void setSatLongitude(Double longitude) {
        this.satLongitude = longitude;
    }

    public void setSatLatitude(Double latitude) {
        this.satLatitude = latitude;
    }

    public boolean SunOpen() {
        return sunOpen;
    }

    public void setSunOpen(boolean open) {
        sunOpen = open;
        if (sunOpen == false) {
            setSunEndTime(null);
            setSunStartTime(null);
            setSunLatitude(null);
            setSunLongitude(null);
        }
    }

    public LocalTime getSunStartTime() {
        return sunStartTime;
    }

    public LocalTime getSunEndTime() {
        return sunEndTime;
    }

    public Double getSunLongitude() {
        return sunLongitude;
    }

    public Double getSunLatitude() {
        return sunLatitude;
    }

    public void setSunStartTime(LocalTime startTime) {
        this.sunStartTime = startTime;
    }

    public void setSunEndTime(LocalTime endTime) {
        this.sunEndTime = endTime;
    }

    public void setSunLongitude(Double longitude) {
        this.sunLongitude = longitude;
    }

    public void setSunLatitude(Double latitude) {
        this.sunLatitude = latitude;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "id=" + id +
                ", truckID=" + truckID +
                ", monOpen=" + monOpen +
                ", monStartTime=" + monStartTime +
                ", monEndTime=" + monEndTime +
                ", monLongitude=" + monLongitude +
                ", monLatitude=" + monLatitude +

                ", tueOpen=" + tueOpen +
                ", tueStartTime=" + tueStartTime +
                ", tueEndTime=" + tueEndTime +
                ", tueLongitude=" + tueLongitude +
                ", tueLatitude=" + tueLatitude +

                ", wedOpen=" + wedOpen +
                ", wedStartTime=" + wedStartTime +
                ", wedEndTime=" + wedEndTime +
                ", wedLongitude=" + wedLongitude +
                ", wedLatitude=" + wedLatitude +

                ", thuOpen=" + thuOpen +
                ", thuStartTime=" + thuStartTime +
                ", thuEndTime=" + thuEndTime +
                ", thuLongitude=" + thuLongitude +
                ", thuLatitude=" + thuLatitude +

                ", friOpen=" + friOpen +
                ", friStartTime=" + friStartTime +
                ", friEndTime=" + friEndTime +
                ", friLongitude=" + friLongitude +
                ", friLatitude=" + friLatitude +

                ", satOpen=" + satOpen +
                ", satStartTime=" + satStartTime +
                ", satEndTime=" + satEndTime +
                ", satLongitude=" + satLongitude +
                ", satLatitude=" + satLatitude +

                ", sunOpen=" + sunOpen +
                ", sunStartTime=" + sunStartTime +
                ", sunEndTime=" + sunEndTime +
                ", sunLongitude=" + sunLongitude +
                ", sunLatitude=" + sunLatitude +
                '}';
    }

    public Schedule cloneMon() throws CloneNotSupportedException {
        Schedule newClone = new Schedule();
        newClone.setId(this.getId());
        newClone.setTruckID(this.getTruckID());

        newClone.setLatitude(this.getMonLatitude());
        newClone.setLongitude(this.getMonLongitude());
        newClone.setOpen(this.MonOpen());
        newClone.setEndTime(this.getMonEndTime());
        newClone.setStartTime(this.getMonStartTime());
        newClone.setDay(0);
        return newClone;
    }

    public Schedule cloneTues() throws CloneNotSupportedException {
        Schedule newClone = new Schedule();
        newClone.setId(this.getId());
        newClone.setTruckID(this.getTruckID());
        newClone.setDay(1);
        newClone.setLatitude(this.getTueLatitude());
        newClone.setLongitude(this.getTueLongitude());
        newClone.setOpen(this.TueOpen());
        newClone.setEndTime(this.getTueEndTime());
        newClone.setStartTime(this.getTueStartTime());
        return newClone;
    }

    public Schedule cloneW() throws CloneNotSupportedException {
        Schedule newClone = new Schedule();
        newClone.setId(this.getId());
        newClone.setDay(2);
        newClone.setTruckID(this.getTruckID());
        newClone.setLatitude(this.getWedLatitude());
        newClone.setLongitude(this.getWedLongitude());
        newClone.setOpen(this.WedOpen());
        newClone.setEndTime(this.getWedEndTime());
        newClone.setStartTime(this.getWedStartTime());
        return newClone;
    }

    public Schedule cloneTh() throws CloneNotSupportedException {
        Schedule newClone = new Schedule();
        newClone.setId(this.getId());
        newClone.setDay(3);
        newClone.setTruckID(this.getTruckID());
        newClone.setLatitude(this.getThuLatitude());
        newClone.setLongitude(this.getThuLongitude());
        newClone.setOpen(this.ThuOpen());
        newClone.setEndTime(this.getThuEndTime());
        newClone.setStartTime(this.getThuStartTime());
        return newClone;
    }

    public Schedule cloneF() throws CloneNotSupportedException {

        Schedule newClone = new Schedule();
        newClone.setId(this.getId());
        newClone.setDay(4);
        newClone.setTruckID(this.getTruckID());
        newClone.setLatitude(this.getFriLatitude());
        newClone.setLongitude(this.getFriLongitude());
        newClone.setOpen(this.FriOpen());
        newClone.setEndTime(this.getFriEndTime());
        newClone.setStartTime(this.getFriStartTime());
        return newClone;
    }

    public Schedule cloneSa() throws CloneNotSupportedException {
        Schedule newClone = new Schedule();
        newClone.setId(this.getId());
        newClone.setDay(5);
        newClone.setTruckID(this.getTruckID());
        newClone.setLatitude(this.getSatLatitude());
        newClone.setLongitude(this.getSatLongitude());
        newClone.setOpen(this.SatOpen());
        newClone.setEndTime(this.getSatEndTime());
        newClone.setStartTime(this.getSatStartTime());
        return newClone;
    }


    public Schedule cloneSu() throws CloneNotSupportedException {
        Schedule newClone = new Schedule();
        newClone.setId(this.getId());
        newClone.setDay(6);
        newClone.setTruckID(this.getTruckID());
        newClone.setLatitude(this.getSunLatitude());
        newClone.setLongitude(this.getSunLongitude());
        newClone.setOpen(this.SunOpen());
        newClone.setEndTime(this.getSunEndTime());
        newClone.setStartTime(this.getSunStartTime());

        return newClone;
    }

    public void setAll(List<Schedule> s) throws CloneNotSupportedException {
        this.setId(s.get(0).getId());
        this.setTruckID(s.get(0).getTruckID());

        this.setMonLatitude(s.get(0).getLatitude());
        this.setMonLongitude(s.get(0).getLongitude());
        this.setMonOpen(s.get(0).getOpen());
        this.setMonEndTime(s.get(0).getEndTime());
        this.setMonStartTime(s.get(0).getStartTime());


        this.setTueLatitude(s.get(1).getLatitude());
        this.setTueLongitude(s.get(1).getLongitude());
        this.setTueOpen(s.get(1).getOpen());
        this.setTueEndTime(s.get(1).getEndTime());
        this.setTueStartTime(s.get(1).getStartTime());


        this.setWedLatitude(s.get(2).getLatitude());
        this.setWedLongitude(s.get(2).getLongitude());
        this.setWedOpen(s.get(2).getOpen());
        this.setWedEndTime(s.get(2).getEndTime());
        this.setWedStartTime(s.get(2).getStartTime());


        this.setThuLatitude(s.get(3).getLatitude());
        this.setThuLongitude(s.get(3).getLongitude());
        this.setThuOpen(s.get(3).getOpen());
        this.setThuEndTime(s.get(3).getEndTime());
        this.setThuStartTime(s.get(3).getStartTime());


        this.setFriLatitude(s.get(4).getLatitude());
        this.setFriLongitude(s.get(4).getLongitude());
        this.setFriOpen(s.get(4).getOpen());
        this.setFriEndTime(s.get(4).getEndTime());
        this.setFriStartTime(s.get(4).getStartTime());


        this.setSatLatitude(s.get(5).getLatitude());
        this.setSatLongitude(s.get(5).getLongitude());
        this.setSatOpen(s.get(5).getOpen());
        this.setSatEndTime(s.get(5).getEndTime());
        this.setSatStartTime(s.get(5).getStartTime());


        this.setSunLatitude(s.get(6).getLatitude());
        this.setSunLongitude(s.get(6).getLongitude());
        this.setSunOpen(s.get(6).getOpen());
        this.setSunEndTime(s.get(6).getEndTime());
        this.setSunStartTime(s.get(6).getStartTime());

    }
}