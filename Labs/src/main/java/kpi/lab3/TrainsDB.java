package kpi.lab3;

import java.time.LocalTime;
import java.util.ArrayList;

public class TrainsDB {

    private ArrayList<Train> trains;
    private Logger2 logger;

    public TrainsDB(Logger2 logger) {
        this.logger = logger;
        this.trains = new ArrayList<Train>() {
            @Override
            public synchronized String toString() {
                if (this.isEmpty())
                    return "No train";
                StringBuilder trainsStr = new StringBuilder();
                for (Train train : this)
                    trainsStr.append(train).append('\n');
                logger.getLogger().info("Train from DB: " + trainsStr.toString());
                return trainsStr.toString();
            }
        };
    }

    public void addTrain(Train train) {
        trains.add(train);
        logger.getLogger().info(train.toString());
    }

    public ArrayList<Train> getAllTrains() {
        return trains;
    }

    public ArrayList<Train> getTrainsWithSeatsCommon() {
        ArrayList<Train> trainsRes = (ArrayList<Train>) trains.clone();
        trainsRes.clear();
        for (Train train : trains)
            if (train.getSeatsCommon() > 0)
                trainsRes.add(train);
        return trainsRes;
    }

    public ArrayList<Train> getTrainsInPlaceAfter(Place place, LocalTime time) {
        ArrayList<Train> trainsRes = (ArrayList<Train>) trains.clone();
        trainsRes.clear();
        for (Train train : trains)
            if (train.getDestination().equals(place) && train.getDate().isAfter(time))
                trainsRes.add(train);
        return trainsRes;
    }

    public boolean isEmpty() {
        return trains.isEmpty();
    }
}
