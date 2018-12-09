package kpi.lab4.Bank;

import kpi.lab4.Admin;
import kpi.lab4.Client;
import kpi.lab4.View;

import java.util.*;

public class Bank {

    private View viewInfo;

    private Map<String, ClientScore> clientScores;
    private Set<Long> emptyID;

    private Map<String, Admin> adminsMap;

    public Bank(View view) {
        clientScores = new HashMap<>();
        emptyID = new HashSet<>();
        for (long j = 1; j <= 9999; j++)
            emptyID.add(j);
        adminsMap = new HashMap<>();
        viewInfo = view;
    }

    public void createPersonalScore(Client client) {
        if (clientScores.get(client.getID()) != null) {
            viewInfo.printInfo("You already have personal score.");
            return;
        }
        clientScores.put(client.getID(), new ClientScore(client.getUserName(), client.getID()));
    }

    public void createAdmin(Admin admin) {
        if (adminsMap.get(admin.getID()) != null) {
            viewInfo.printInfo(admin.getUserName() + " already have this admin.");
            return;
        }
        adminsMap.put(admin.getUserName() + admin.getID(), admin);
    }

    public Admin authorisationAdmin(String adminName, String adminPass) {
        return adminsMap.get(adminName + adminPass);
    }

    public void createCreditCard(Client client) {

        if (clientScores.get(client.getID()) == null) {
            viewInfo.printInfo("Before u mast create personal score.");
            return;
        }
        if (clientScores.get(client.getID()).getCreditCard() != null) {
            viewInfo.printInfo("You already have credit card.");
            return;
        }
        if (emptyID.isEmpty()){
            viewInfo.printInfo("Bank not have empty card for you. Sorry :(");
            return;
        }
        if (clientScores.get(client.getID()).isBlock())
            return;
        Iterator<Long> emptyCardID = emptyID.iterator();
        Long eID = emptyCardID.next();
        clientScores.get(client.getID()).createCreditCard(eID, client);
        emptyID.remove(eID);
    }

    public void addCash(double cash, String yourID) {
        if (clientScores.get(yourID) == null) {
            viewInfo.printInfo("no client score");
            return;
        }
        if (clientScores.get(yourID).getCreditCard() == null) {
            viewInfo.printInfo("no client score");
            return;
        }
        if (clientScores.get(yourID).isBlock()) {
            viewInfo.printInfo("score is block");
            return;
        }
        if (!clientScores.get(yourID).getCreditCard().isUsed()) {
            viewInfo.printInfo("credit card is block");
            return;
        }
        clientScores.get(yourID).doWithCash(cash);
    }

    public void sendCash(String id2Send, double cash, String yourID) {
        if (clientScores.get(yourID) == null) {
            viewInfo.printInfo("no client score");
            return;
        }
        if (clientScores.get(yourID).getCreditCard() == null) {
            viewInfo.printInfo("no client score");
            return;
        }
        if (clientScores.get(yourID).isBlock()) {
            viewInfo.printInfo("score is block");
            return;
        }
        if (clientScores.get(yourID).getCreditCard().isUsed()) {
            viewInfo.printInfo("credit card is block");
            return;
        }
        if (clientScores.get(id2Send) == null) {
            viewInfo.printInfo("no client score for send");
            return;
        }
        if (clientScores.get(id2Send).getCreditCard() == null) {
            viewInfo.printInfo("no client score for send");
            return;
        }
        if (clientScores.get(id2Send).isBlock()) {
            viewInfo.printInfo("score is block for send");
            return;
        }
        if (clientScores.get(id2Send).getCreditCard().isUsed()) {
            viewInfo.printInfo("credit card is block for send");
            return;
        }
        clientScores.get(id2Send).doWithCash(cash);
        clientScores.get(yourID).doWithCash(-1*cash);
    }

    public void sendCash(Client id2Send, double cash, String yourID) {
        sendCash(id2Send.getID(), cash, yourID);
    }

    public void blockerCard(String id, boolean used) {
        if (clientScores.get(id) == null) {
            viewInfo.printInfo("no client score");
            return;
        }
        if (clientScores.get(id).getCreditCard() == null) {
            viewInfo.printInfo("no client score");
            return;
        }
        clientScores.get(id).blockerCard(used);
    }

    public void blockUser(String id) {
        if (clientScores.get(id) == null) {
            viewInfo.printInfo("no client score");
            return;
        }
        if (clientScores.get(id).getCreditCard() == null) {
            viewInfo.printInfo("no client score");
            return;
        }
        clientScores.get(id).block();
    }

    public void cancel(String id) {
        if (clientScores.get(id) == null) {
            viewInfo.printInfo("no client score");
            return;
        }
        if (clientScores.get(id).getCreditCard() == null) {
            viewInfo.printInfo("no client score");
            return;
        }
        clientScores.get(id).cancel();
    }

    public void printCard(String id) {
        viewInfo.printInfo(clientScores.get(id).toString());
    }

    public String printAllUsers() {
        Set<ClientScore> clientScoresCollection = new HashSet<>(clientScores.values());
        StringBuilder stringBuilder = new StringBuilder();
        for (ClientScore cs :
                clientScoresCollection) {
            stringBuilder.append(cs.toString());
            stringBuilder.append('\n');
        }
        return stringBuilder.toString();
    }
}
