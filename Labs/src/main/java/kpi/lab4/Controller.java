package kpi.lab4;

import kpi.lab4.Bank.Bank;

class Controller {
    private static View viewInfo = new View();
    private static ScannerInfo scannerInfo = new ScannerInfo(viewInfo);

    private static Bank bank = new Bank(viewInfo);

    private static ControllerClient controllerClient = new ControllerClient(scannerInfo, viewInfo, bank);
    private static ControllerAdmin controllerAdmin = new ControllerAdmin(scannerInfo, viewInfo, bank);

    void run() {
        menu();
    }

    private void menu() {
        String what2Do = "3";
        while (true) {
            switch (what2Do) {
                case "0":
                    return;
                case "1":
                    controllerClient.menuClient();
                    break;
                case "2":
                    controllerAdmin.menuAdmin();
                    break;
                case "3":
                    printMenu();
                    break;
                default:
                    viewInfo.printInfo("Please, read menu before push wherever!");
            }
            what2Do = scannerInfo.scannerString("What next?");
        }
    }

    private void printMenu() {
        StringBuilder strMenu = new StringBuilder();
        strMenu.append(  "0 - exit");
        strMenu.append("\n1 - print menu Client");
        strMenu.append("\n2 - print menu Admin");
        strMenu.append("\n3 - print menu (this)");
        viewInfo.printInfo(strMenu.toString());
    }
}
