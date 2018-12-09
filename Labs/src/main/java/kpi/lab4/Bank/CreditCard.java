package kpi.lab4.Bank;

import kpi.lab4.Client;

public class CreditCard {

    private long id;
    private String userName;
    //private double score;
    private double creditLimit;
    private boolean used;

    CreditCard(long id, Client client) {
        this.id = id;
        this.userName = client.getUserName();
        this.creditLimit = 5000;
        this.used = true;
    }

    void blocker(boolean used) {
        this.used = used;
    }

    public boolean isUsed() {
        return used;
    }

    @Override
    public String toString() {
        return "==========\nCreditCard: \n" +
                String.format("%04d", id)+
                '\n' + userName +
                "\nblocked: " + !used +
                "\n=========";
    }
}
