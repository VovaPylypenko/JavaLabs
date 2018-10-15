package kpi.lab3;

import java.time.LocalTime;
import java.util.Vector;

public class Main {
    public static void main(String[] args){
        Controller inteface = new Controller(createFillTrains(), new View());
        inteface.run();
    }

    private static Vector<Train> createFillTrains(){
        Vector<Train> trains = new Vector<Train>(){
            @Override
            public synchronized String toString() {
                StringBuilder trainsStr = new StringBuilder();
                for (Train train : this)
                    trainsStr.append(train).append('\n');
                return trainsStr.toString();
            }
        };
        try {
            trains.add(new Train(Place.Kiev, 101, LocalTime.of(13, 30) ,100, 20,30, 0));
            trains.add(new Train(Place.Kiev, 102, LocalTime.of(18, 0) ,0, 0,0, 200));
            trains.add(new Train(Place.Odesa, 88, LocalTime.of(11, 20) ,50, 0,100, 50));
            trains.add(new Train(Place.Poltava, 99, LocalTime.of(13, 30) ,250, 0,0, 0));
            trains.add(new Train(Place.Rivne, 777, LocalTime.of(12, 0) ,50, 10,10, 150));
            trains.add(new Train(Place.Chernihiv, 313, LocalTime.of(13, 30) ,50, 10,100, 50));
            trains.add(new Train(Place.Donetsk, 121, LocalTime.of(11, 45) ,50, 30,100, 50));
            trains.add(new Train(Place.Chernihiv, 818, LocalTime.of(11, 45) ,90, 50,70, 20));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return trains;
    }
}
