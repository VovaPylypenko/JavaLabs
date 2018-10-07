package kpi.lab1;

import java.util.Scanner;

class Controller {

    private Matrix model;
    private View view;

    Controller(Matrix model, View view) {
        this.model = model;
        this.view = view;
    }

    void run(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Pylypenko Volodia IP-63\n");
        int i = 1;
        while (true) {
            System.out.println("\nEnter size:");
            i = scanner.nextInt();
            if (i<=0)
                break;
            model.overfillMatrix(i);
            view.printMatrix(model);
            view.printMatrix(model.turnСounterclockwise(), "new");
        }
    }
}
