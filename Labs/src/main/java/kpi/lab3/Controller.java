package kpi.lab3;

import java.time.LocalTime;
import java.util.Scanner;
import java.util.Vector;

class Controller {
    private Scanner scanner;
    private Vector<Train> trains;
    private View view;

    Controller(Vector<Train> trains, View view) {
        this.trains = trains;
        this.view = view;
    }

    void run(){
        scanner = new Scanner(System.in);
        try {
            view.print(trains);

            while (menu());

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    private boolean menu(){
        System.out.println("===Menu===");
        System.out.println(
                "1 - print all trains.\n" +
                "2 - print trains with Seats Common.\n" +
                "3 - print trains in Place After\n" +
                "also exit!");
        int s = scanner.nextInt();
        if (s == 1){
            view.print(trains, "All trains!");
            return true;
        }else if (s == 2){
            view.print(trainsWithSeatsCommon(trains), "trains with Seats Common");
            return true;
        }else if (s == 3){
            Place place = scannePlace();
            LocalTime time = scanneTime();
            view.print(trainsInPlaceAfter(trains,place,time),
                    "trains in " + place + " after " + time.getHour() + ':' + time.getMinute());
            return true;
        }else {
            System.out.println("***** End *****");
            return false;
        }
    }

    private Vector<Train> trainsWithSeatsCommon(Vector<Train> trains){
        Vector<Train> trainsRes = (Vector<Train>) trains.clone();
        trainsRes.clear();
        for (Train train : trains)
            if (train.getSeatsCommon() > 0)
                trainsRes.add(train);
        return trainsRes;
    }

    private Vector<Train> trainsInPlaceAfter(Vector<Train> trains, Place place, LocalTime time){
        Vector<Train> trainsRes = (Vector<Train>) trains.clone();
        trainsRes.clear();
        for (Train train : trains)
            if (train.getDestination().equals(place) && train.getDate().isAfter(time))
                trainsRes.add(train);
        return trainsRes;
    }

    private Place scannePlace(){
        System.out.println("Enter place:");
        Place place = null;
        while (place == null) {
            try {
                place = Place.valueOf(scanner.next());
            } catch (IllegalArgumentException iae) {
                System.out.println("Not correct Place");
            }
        }
        return place;
    }

    private LocalTime scanneTime(){
        System.out.println("Enter hour:");
        int hour = scanner.nextInt();
        System.out.println("Enter minute:");
        int minute = scanner.nextInt();
        return LocalTime.of(hour,minute);
    }
}
