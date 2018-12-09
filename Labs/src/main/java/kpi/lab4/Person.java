package kpi.lab4;

import kpi.lab4.Bank.Bank;

public class Person {
    private String userName;
    private String ID;

    private static Bank bank = null;

    public Person(String userName, String ID) {
        this.userName = userName;
        this.ID = ID;
    }

    public String getUserName() {
        return userName;
    }

    public Person setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getID() {
        return ID;
    }

    public Person setID(String ID) {
        this.ID = ID;
        return this;
    }

    public Bank getBank() {
        return bank;
    }

    public Person setBank(Bank bank) {
        Person.bank = bank;
        return this;
    }
}
