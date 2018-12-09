package kpi.lab3;

import java.time.LocalTime;
import java.util.ArrayList;

class TrainsDatabase {

    private ArrayList<Train> trains;

    public TrainsDatabase() {
        fillTrain();
    }

    public ArrayList<Train> getTrains() {
        return trains;
    }

    public ArrayList<Train> trainsWithSeatsCommon() {
        ArrayList<Train> trainsRes = (ArrayList<Train>) trains.clone();
        trainsRes.clear();
        for (Train train : trains)
            if (train.getSeatsCommon() > 0)
                trainsRes.add(train);
        return trainsRes;
    }

    public ArrayList<Train> trainsInPlaceAfter(Place place, LocalTime time) {
        ArrayList<Train> trainsRes = (ArrayList<Train>) trains.clone();
        trainsRes.clear();
        for (Train train : trains)
            if (train.getDestination().equals(place) && train.getDate().isAfter(time))
                trainsRes.add(train);
        return trainsRes;
    }

    private void fillTrain() {
         trains = new ArrayList<Train>() {
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
    }
}
