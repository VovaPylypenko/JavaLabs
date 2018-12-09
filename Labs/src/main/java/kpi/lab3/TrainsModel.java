package kpi.lab3;

import java.time.LocalTime;
import java.util.ArrayList;

class TrainsModel {

    private TrainsDB trains;
    private Logger2 logger;

    public TrainsModel(Logger2 logger) {
        trains = new TrainsDB(logger);
    }

    public ArrayList<Train> getTrains() {
        return trains.getAllTrains();
    }

    public TrainsDB getTrainsDB() {
        return trains;
    }

    public ArrayList<Train> trainsWithSeatsCommon() {
        return trains.getTrainsWithSeatsCommon();
    }

    public ArrayList<Train> trainsInPlaceAfter(Place place, LocalTime time) {
        return trains.getTrainsInPlaceAfter(place, time);
    }

    public TrainsModel setTrains(TrainsDB trains) {
        this.trains = trains;
        return this;
    }
}
