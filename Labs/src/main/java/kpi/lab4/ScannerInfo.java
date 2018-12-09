package kpi.lab4;

import java.util.Scanner;

public class ScannerInfo {
    private Scanner scanner;
    private View view;

    ScannerInfo(View view) {
        scanner = new Scanner(System.in);
        this.view = view;
    }

    double scanneDouble(String what) {
        view.printInfo(what);
        return scanner.nextDouble();
    }

    String scannerString(String what) {
        view.printInfo(what);
        return scanner.next();
    }

}
