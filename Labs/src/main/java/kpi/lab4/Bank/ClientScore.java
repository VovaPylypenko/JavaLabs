package kpi.lab4.Bank;

import kpi.lab4.Client;

import java.util.HashMap;
import java.util.Map;

public class ClientScore {

    private String userName;
    private String userID;
    private CreditCard creditCard;
    private double score;
    private boolean block;

    public ClientScore(String userName, String id) {
        this.userName = userName;
        this.userID = id;
        this.creditCard = null;
        block = Boolean.FALSE;
    }


    public void createCreditCard(long idCard, Client client) {
        creditCard = new CreditCard(idCard, client);
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public void doWithCash(double cash){
        score+=cash;
    }

    public void blockerCard(boolean used) {
        creditCard.blocker(used);
    }

    public void block() {
        block = Boolean.TRUE;
    }

    public void unblock() {
        block = Boolean.FALSE;
    }

    public void cancel() {
        creditCard = null;
        score = 0;
    }

    public boolean isBlock() {
        return block;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("++++++++++++++++++++++++++++++\nuser name: " + userName);
        stringBuilder.append("\nuser id: " + userID);
        stringBuilder.append("\nuser credit cart: \n" + creditCard);
        stringBuilder.append("\nuser score: " + score);
        stringBuilder.append("\nuser block: " + block);
        stringBuilder.append("\n++++++++++++++++++++++++++++++");
        return stringBuilder.toString();
    }
}
