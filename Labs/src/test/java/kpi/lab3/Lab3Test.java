package kpi.lab3;

import java.time.LocalTime;
import java.util.Vector;

import static org.junit.jupiter.api.Assertions.*;

class Lab3Test {

    @org.junit.jupiter.api.Test
    void addTrain(){
        Vector<Train> trains = new Vector<>();
        try {
        trains.add(new Train(Place.Kiev, 102, LocalTime.of(18, 0) ,0, 0,0, 200));
        trains.add(new Train(Place.Odesa, 88, LocalTime.of(11, 20) ,50, 0,100, 50));
        trains.add(new Train(Place.Kiev, 101, LocalTime.of(13, 30) ,100, 20,30, 0));
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(3,trains.size());
    }
}