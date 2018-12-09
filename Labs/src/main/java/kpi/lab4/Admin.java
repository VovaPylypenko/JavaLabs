package kpi.lab4;

import kpi.lab4.Bank.Bank;

public class Admin extends Person {

    public Admin(String name, String ID, View view) {
        super(name,ID);
    }

    public Admin setBank(Bank bank) {
        super.setBank(bank);
        return this;
    }

    public String printAllUsers() {
        return super.getBank().printAllUsers();
    }

    public void blockUser(String id) {
        super.getBank().blockUser(id);
    }
}
