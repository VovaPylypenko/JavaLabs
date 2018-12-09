package kpi.lab3;

import java.util.ArrayList;

class View {

    private Logger2 logger;

    View(Logger2 logger) {
        this.logger = logger;
    }

    void printTrain(ArrayList<Train> trains, String details) {
        System.out.println("Trains(" + details + "):\n" + trains.toString());
    }

    void printMenu() {
        String menuStr = "===Menu===\n" +
                "0 - print menu.\n" +
                "1 - print all trains.\n" +
                "2 - print trains with Seats Common.\n" +
                "3 - print trains in Place After.\n" +
                "4 - archive data.\n" +
                "5 - read data from file.\n" +
                "6 - end prog.";
        logger.getLogger().info("print menu:\n" + menuStr);
        System.out.println(menuStr);
    }

    void printEnd() {
        System.out.println("***** End *****");
    }
}
