package kpi.lab2;

public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller(new NumberReader(), new View());
        controller.run();
    }
}
