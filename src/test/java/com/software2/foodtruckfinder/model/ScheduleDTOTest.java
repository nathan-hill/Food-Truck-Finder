package com.software2.foodtruckfinder.model;

import com.software2.foodtruckfinder.secure.model.Schedule;
import com.software2.foodtruckfinder.secure.model.ScheduleDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.beans.BeanProperty;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ScheduleDTOTest {
    private ScheduleDTO sd;

    private LocalTime start = LocalTime.now();
    private LocalTime end = LocalTime.now();

    private Double lat = 12.3;
    private Double lon = 32.1;

    @BeforeEach
    void init(){
        sd = new ScheduleDTO();
        sd.setId(1234l);
        sd.setTruckID(4321l);

        start = LocalTime.now();
        end = LocalTime.now();

        Double lat = 12.3;
        Double lon = 32.1;

        sd.setMonOpen(1);
        sd.setMonStartTime(start);
        sd.setMonEndTime(end);
        sd.setMonLatitude(lat);
        sd.setMonLongitude(lon);

        sd.setTueOpen(1);
        sd.setTueStartTime(start);
        sd.setTueEndTime(end);
        sd.setTueLatitude(lat);
        sd.setTueLongitude(lon);

        sd.setWedOpen(1);
        sd.setWedStartTime(start);
        sd.setWedEndTime(end);
        sd.setWedLatitude(lat);
        sd.setWedLongitude(lon);

        sd.setWedOpen(1);
        sd.setWedStartTime(start);
        sd.setWedEndTime(end);
        sd.setWedLatitude(lat);
        sd.setWedLongitude(lon);

        sd.setThuOpen(1);
        sd.setThuStartTime(start);
        sd.setThuEndTime(end);
        sd.setThuLatitude(lat);
        sd.setThuLongitude(lon);

        sd.setFriOpen(1);
        sd.setFriStartTime(start);
        sd.setFriEndTime(end);
        sd.setFriLatitude(lat);
        sd.setFriLongitude(lon);

        sd.setSatOpen(1);
        sd.setSatStartTime(start);
        sd.setSatEndTime(end);
        sd.setSatLatitude(lat);
        sd.setSatLongitude(lon);

        sd.setSunOpen(1);
        sd.setSunStartTime(start);
        sd.setSunEndTime(end);
        sd.setSunLatitude(lat);
        sd.setSunLongitude(lon);
    }

    @Test
    @DisplayName("get tests")
    void getTests(){
        assertAll(
                ()->assertEquals(1234l, sd.getId()),
                ()->assertEquals(4321l, sd.getTruckID()),
                ()->assertEquals(1, sd.MonOpen()),
                ()->assertEquals(start, sd.getMonStartTime()),
                ()->assertEquals(end, sd.getMonEndTime()),
                ()->assertEquals(lat, sd.getMonLatitude()),
                ()->assertEquals(lon, sd.getMonLongitude()),
                ()->assertEquals(1, sd.TueOpen()),
                ()->assertEquals(start, sd.getTueStartTime()),
                ()->assertEquals(end, sd.getTueEndTime()),
                ()->assertEquals(lat, sd.getTueLatitude()),
                ()->assertEquals(lon, sd.getTueLongitude()),
                ()->assertEquals(1, sd.WedOpen()),
                ()->assertEquals(start, sd.getWedStartTime()),
                ()->assertEquals(end, sd.getWedEndTime()),
                ()->assertEquals(lat, sd.getWedLatitude()),
                ()->assertEquals(lon, sd.getWedLongitude()),
                ()->assertEquals(1, sd.ThuOpen()),
                ()->assertEquals(start, sd.getThuStartTime()),
                ()->assertEquals(end, sd.getThuEndTime()),
                ()->assertEquals(lat, sd.getThuLatitude()),
                ()->assertEquals(lon, sd.getThuLongitude()),
                ()->assertEquals(1, sd.FriOpen()),
                ()->assertEquals(start, sd.getFriStartTime()),
                ()->assertEquals(end, sd.getFriEndTime()),
                ()->assertEquals(lat, sd.getFriLatitude()),
                ()->assertEquals(lon, sd.getFriLongitude()),
                ()->assertEquals(1, sd.SatOpen()),
                ()->assertEquals(start, sd.getSatStartTime()),
                ()->assertEquals(end, sd.getSatEndTime()),
                ()->assertEquals(lat, sd.getSatLatitude()),
                ()->assertEquals(lon, sd.getSatLongitude()),
                ()->assertEquals(1, sd.SunOpen()),
                ()->assertEquals(start, sd.getSunStartTime()),
                ()->assertEquals(end, sd.getSunEndTime()),
                ()->assertEquals(lat, sd.getSunLatitude()),
                ()->assertEquals(lon, sd.getSunLongitude())
        );
    }

    @Test
    @DisplayName("clone monday test")
    void cloneMonTest() throws CloneNotSupportedException {
        Schedule c = sd.cloneMon();
        assertAll(
                ()->assertEquals(c.getTruckID(), sd.getTruckID()),
                ()->assertEquals(c.getId(), sd.getId()),
                ()->assertEquals(0, c.getDay()),
                ()->assertEquals(c.getLongitude(), lon),
                ()->assertEquals(c.getLatitude(), lat),
                ()->assertEquals(c.getStartTime(), start),
                ()->assertEquals(c.getEndTime(), end)
        );
    }

    @Test
    @DisplayName("clone tuesday test")
    void cloneTueTest() throws CloneNotSupportedException {
        Schedule c = sd.cloneTues();
        assertAll(
                ()->assertEquals(c.getTruckID(), sd.getTruckID()),
                ()->assertEquals(c.getId(), sd.getId()),
                ()->assertEquals(1, c.getDay()),
                ()->assertEquals(c.getLongitude(), lon),
                ()->assertEquals(c.getLatitude(), lat),
                ()->assertEquals(c.getStartTime(), start),
                ()->assertEquals(c.getEndTime(), end)
        );
    }

    @Test
    @DisplayName("clone wednesday test")
    void cloneWedTest() throws CloneNotSupportedException {
        Schedule c = sd.cloneW();
        assertAll(
                ()->assertEquals(c.getTruckID(), sd.getTruckID()),
                ()->assertEquals(c.getId(), sd.getId()),
                ()->assertEquals(2, c.getDay()),
                ()->assertEquals(c.getLongitude(), lon),
                ()->assertEquals(c.getLatitude(), lat),
                ()->assertEquals(c.getStartTime(), start),
                ()->assertEquals(c.getEndTime(), end)
        );
    }

    @Test
    @DisplayName("clone thursday test")
    void cloneThuTest() throws CloneNotSupportedException {
        Schedule c = sd.cloneTh();
        assertAll(
                ()->assertEquals(c.getTruckID(), sd.getTruckID()),
                ()->assertEquals(c.getId(), sd.getId()),
                ()->assertEquals(3, c.getDay()),
                ()->assertEquals(c.getLongitude(), lon),
                ()->assertEquals(c.getLatitude(), lat),
                ()->assertEquals(c.getStartTime(), start),
                ()->assertEquals(c.getEndTime(), end)
        );
    }

    @Test
    @DisplayName("clone friday test")
    void cloneFriTest() throws CloneNotSupportedException {
        Schedule c = sd.cloneF();
        assertAll(
                ()->assertEquals(c.getTruckID(), sd.getTruckID()),
                ()->assertEquals(c.getId(), sd.getId()),
                ()->assertEquals(4, c.getDay()),
                ()->assertEquals(c.getLongitude(), lon),
                ()->assertEquals(c.getLatitude(), lat),
                ()->assertEquals(c.getStartTime(), start),
                ()->assertEquals(c.getEndTime(), end)
        );
    }

    @Test
    @DisplayName("clone saturday test")
    void cloneSatTest() throws CloneNotSupportedException {
        Schedule c = sd.cloneSa();
        assertAll(
                ()->assertEquals(c.getTruckID(), sd.getTruckID()),
                ()->assertEquals(c.getId(), sd.getId()),
                ()->assertEquals(5, c.getDay()),
                ()->assertEquals(c.getLongitude(), lon),
                ()->assertEquals(c.getLatitude(), lat),
                ()->assertEquals(c.getStartTime(), start),
                ()->assertEquals(c.getEndTime(), end)
        );
    }

    @Test
    @DisplayName("clone sunday test")
    void cloneSunTest() throws CloneNotSupportedException {
        Schedule c = sd.cloneSu();
        assertAll(
                ()->assertEquals(c.getTruckID(), sd.getTruckID()),
                ()->assertEquals(c.getId(), sd.getId()),
                ()->assertEquals(6, c.getDay()),
                ()->assertEquals(c.getLongitude(), lon),
                ()->assertEquals(c.getLatitude(), lat),
                ()->assertEquals(c.getStartTime(), start),
                ()->assertEquals(c.getEndTime(), end)
        );
    }


    @Test
    @DisplayName("set all test")
    void setAllTest() throws CloneNotSupportedException {
        Schedule sc = new Schedule();
        sc.setId(1234l);
        sc.setTruckID(4321l);
        sc.setOpen(1);
        sc.setStartTime(start);
        sc.setEndTime(end);
        sc.setLongitude(lon);
        sc.setLatitude(lat);

        List<Schedule> list = new ArrayList<>();

        for(int i=0; i<7; i++){
            list.add(sc);
        }

        sd.setAll(list);

        assertEquals(sd.getId(), sc.getId());
    }
}
