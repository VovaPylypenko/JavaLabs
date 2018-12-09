package kpi.lab3;

import java.time.LocalTime;

class Controller {

    private TrainsModel trains;
    private View view;
    private ScannerInfo scanner;
    private Archiver archiver;
    private Logger2 logger;

    Controller(Logger2 logger) {
        this.trains = new TrainsModel(logger);
        this.view = new View(logger);
        this.scanner = new ScannerInfo(logger);
        this.logger = logger;
        this.archiver = new Archiver(logger);
    }

    void run() throws Exception2 {
        view.printMenu();
        while (menu());
    }

    private boolean menu() throws Exception2 {

        switch (scanner.scanneMenu()) {
            case 0: {
                view.printMenu();
                return true;
            }
            case 1: {
                logger.getLogger().info("Ask print all trains");
                view.printTrain(trains.getTrains(), "All trains!");
                return true;
            }
            case 2: {
                logger.getLogger().info("Ask print all trains with Seats Common");
                view.printTrain(trains.trainsWithSeatsCommon(), "trains with Seats Common");
                return true;
            }
            case 3: {
                logger.getLogger().info("Ask print trains in same place and after same time");
                Place place = scanner.scannePlace();
                LocalTime time = scanner.scanneTime();
                view.printTrain(trains.trainsInPlaceAfter(place,time),
                        "trains in " + place + " after " + time.getHour() + ':' + time.getMinute());
                return true;
            }
            case 4: {
                logger.getLogger().info("Ask archive trains to json file");
                archiver.archived(trains.getTrainsDB());
                return true;
            }
            case 5: {
                logger.getLogger().info("Ask read trains from json file");
                trains.setTrains(archiver.readArchive());
                return true;
            }
            case 6: {
                logger.getLogger().info("Ask end program");
                view.printEnd();
                return false;
            }
            default: {
                logger.getLogger().warn("Not correct input menu");
                throw new Exception2("Not correct input menu.", logger);
            }
        }
    }


}
