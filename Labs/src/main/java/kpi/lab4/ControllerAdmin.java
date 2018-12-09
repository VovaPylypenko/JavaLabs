package kpi.lab4;

import kpi.lab4.Bank.Bank;

class ControllerAdmin {

    private static Bank bank;
    private static ScannerInfo scannerInfo;
    private static View viewInfo;

    private void fillInfo() {
        bank.createAdmin(new Admin("Volodia Pylypenko", "123", viewInfo).setBank(bank));
        bank.createAdmin(new Admin("Kill Comm", "1234", viewInfo).setBank(bank));
    }

    ControllerAdmin(ScannerInfo scannerInfo, View view, Bank bank) {
        ControllerAdmin.scannerInfo = scannerInfo;
        ControllerAdmin.bank = bank;
        ControllerAdmin.viewInfo = view;
        fillInfo();
    }

    void menuAdmin() {
        Admin admin = null;
        String what2Do = "0";
        while (true){
            switch (what2Do){
                case "-1":
                    return;
                case "0":
                    printMenuAdmin();
                    break;
                case "1":
                    createAdmin();
                    break;
                case "2":
                    admin = authorisationAdmin();
                    break;
                case "3":
                    viewInfo.printInfo(printAllUsers(admin));
                    break;
                case "4":
                    blockUser();
                    break;
                default:
                    viewInfo.printInfo("Please, read menu before push wherever!");
            }
            what2Do = scannerInfo.scannerString("What next?");
        }
    }

    private void printMenuAdmin() {
        StringBuilder strMenu = new StringBuilder();
        strMenu.append( "-1 - return to main menu");
        strMenu.append("\n0 - print menu (this)");
        strMenu.append("\n1 - create admin");
        strMenu.append("\n2 - authorisation");
        strMenu.append("\n3 - print all users");
        strMenu.append("\n4 - block user");
        viewInfo.printInfo(strMenu.toString());
    }

    private void createAdmin() {
        String firstName = scannerInfo.scannerString("Enter first name:");
        String secondName = scannerInfo.scannerString("Enter second name:");
        String ID = scannerInfo.scannerString("Enter you ID(password):");
        Admin admin = new Admin(firstName + ' ' + secondName, ID, viewInfo);
        bank.createAdmin(admin);
    }

    private Admin authorisationAdmin() {
        String firstName = scannerInfo.scannerString("Enter first name:");
        String secondName = scannerInfo.scannerString("Enter second name:");
        String ID = scannerInfo.scannerString("Enter you ID(password):");
        return bank.authorisationAdmin(firstName + ' ' + secondName, ID);
    }

    private void blockUser() {
        String userName = scannerInfo.scannerString("Enter user name for block:");
        bank.blockUser(userName);
    }

    private String printAllUsers(Admin admin) {
        if (admin == null)
            return "You are not authorisation";
        return admin.printAllUsers();
    }
}
