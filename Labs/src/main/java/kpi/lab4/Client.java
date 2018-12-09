package kpi.lab4;

import kpi.lab4.Bank.Bank;

public class Client extends Person{

    private View viewInfo;

    public Client(String userName, String ID, View view) {
        super(userName, ID);
        viewInfo = view;
    }

    public void createClientScore() {
        if (getBank() == null) {
            viewInfo.printInfo("You not choose bank.");
            return;
        }
        getBank().createPersonalScore(this);
    }

    public void createCreditCard() {
        if (getBank() == null) {
            viewInfo.printInfo("You not choose bank.");
            return;
        }
        getBank().createCreditCard(this);
    }

    public void addCash(double cash) {
        if (getBank() == null) {
            viewInfo.printInfo("You not choose bank.");
            return;
        }
        getBank().addCash(cash, getID());
    }

    public void makeOrder(Order order) {
        if (getBank() == null) {
            viewInfo.printInfo("You not choose bank.");
            return;
        }
        getBank().sendCash(order.getSeller(), order.getPrice(), getID());
    }

    public void sendCash(String client, double cash) {
        if (getBank() == null) {
            viewInfo.printInfo("You not choose bank.");
            return;
        }
        getBank().sendCash(client, cash, getID());
    }

    public void blocked() {
        if (getBank() == null) {
            viewInfo.printInfo("You not choose bank.");
            return;
        }
        getBank().blockerCard(getID(), false);
    }

    public void unblocked() {
        if (getBank() == null) {
            viewInfo.printInfo("You not choose bank.");
            return;
        }
        getBank().blockerCard(getID(), true);
    }

    public void cancel() {
        getBank().cancel(getID());
    }

    public void printCard() {
        if (getBank() == null) {
            viewInfo.printInfo("You not choose bank.");
            return;
        }
        getBank().printCard(getID());
    }

    public String getUserName() {
        return super.getUserName();
    }

    public Client setUserName(String userName) {
        super.setUserName(userName);
        return this;
    }

    public String getID() {
        return super.getID();
    }

    public Client setID(String ID) {
        super.setID(ID);
        return this;
    }

    public Bank getBank() {
        return super.getBank();
    }

    public Client setBank(Bank bank) {
        super.setBank(bank);
        return this;
    }
}
