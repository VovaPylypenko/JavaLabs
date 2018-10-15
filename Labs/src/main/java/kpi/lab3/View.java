package kpi.lab3;

public class View {

    void print(Object trains, String details){
        System.out.println("Trains(" + details + "):\n" + trains.toString());
    }
    void print(Object trains){
        System.out.println("Trains:\n" + trains.toString());
    }

}
