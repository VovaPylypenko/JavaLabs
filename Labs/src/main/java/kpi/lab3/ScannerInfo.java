package kpi.lab3;

import java.time.LocalTime;
import java.util.InputMismatchException;
import java.util.Scanner;

class ScannerInfo {

    private Scanner scanner;
    private Logger2 logger;

    ScannerInfo(Logger2 logger) {
        scanner = new Scanner(System.in);
        this.logger = logger;
    }

    private int scanneInt(String str, int intervalX, int intervalY, String error) throws Exception2 {
        System.out.println(str);
        int scanneInt = scanner.nextInt();
        if (intervalX <= scanneInt && scanneInt <= intervalY) {
            return scanneInt;
        }
        throw new Exception2(error, logger);
    }

    int scanneMenu(){
        int i = -1;
        while (i==-1) {
            try {
                i = scanneInt("Enter menu command", 0, 6, "Not correct input menu command.");
                logger.getLogger().info("input command : " + i);
            }catch (Exception2  exception2){
                System.out.println(exception2.getMessage());
            }
        }
        return i;
    }

    Place scannePlace() {
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


    LocalTime scanneTime() {
        int hour = -1;
        int minute = -1;
        while (hour == -1 || minute == -1) {
            try {
                hour = scanneInt("Enter hour:", 0, 23, "Not correct input hour.");
                minute = scanneInt("Enter minute:", 0, 59, "Not correct input minute.");
            } catch (Exception2 exception2) {
                System.out.println(exception2.getMessage());
            }
        }
        return LocalTime.of(hour, minute);
    }

}
