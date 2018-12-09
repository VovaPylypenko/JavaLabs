package kpi.lab4;

import kpi.lab4.Bank.Bank;

import java.util.HashMap;
import java.util.Map;

class ControllerClient {

    private static Bank bank;
    private static ScannerInfo scannerInfo;
    private static View viewInfo;

    private static Map<String, Client> SHOP = new HashMap<>();
    private Client addShop(String name, String ID) {
        Client client = new Client(name, ID, viewInfo).setBank(bank);
        client.createClientScore();
        return client;
    }

    private void fillInfo() {
        // add shop
        SHOP.put("ATB", addShop("ATB-shop", "ATB"));
        SHOP.put("Silpo", addShop("Silpo-shop", "Silpo"));
        SHOP.put("Nous", addShop("Nous-shop", "Nous"));
        SHOP.put("Fora", addShop("Fora-shop", "Fora"));

        // add client
        Client client1 = new Client("Vova Pylypenko", "TT7859", viewInfo);
        client1.setBank(bank);
        client1.createClientScore();
        client1.createCreditCard();
        client1.addCash(9000);
        Client client2 = new Client("Anna Pylypenko", "TT7679", viewInfo);
        client2.setBank(bank);
        client2.createClientScore();
        client2.createCreditCard();
        client2.addCash(5000);
    }

    ControllerClient(ScannerInfo scannerInfo, View view, Bank bank) {
        ControllerClient.scannerInfo = scannerInfo;
        ControllerClient.bank = bank;
        ControllerClient.viewInfo = view;
        fillInfo();
    }

    void menuClient() {
        Client client = null;
        String what2Do = "0";
        while (!what2Do.equals("10")){
            switch (what2Do){
                case "-1":
                    return;
                case "0":
                    printMenuClient();
                    break;
                case "1":
                    client = authorisationClient();
                    break;
                case "2":
                    createScore(client);
                    break;
                case "3":
                    createCreditCard(client);
                    break;
                case "4":
                    addCash(client);
                    break;
                case "5":
                    sendCash(client);
                    break;
                case "6":
                    makeShop(client);
                    break;
                case "7":
                    blockCard(client);
                    break;
                case "8":
                    unblockCard(client);
                    break;
                case "9":
                    printBalance(client);
                    break;
                case "10":

                    break;
                default:
                    viewInfo.printInfo("Please, read menu before push wherever!");
                    return;
            }
            what2Do = scannerInfo.scannerString("What next?");
        }
    }

    private void printMenuClient() {
        StringBuilder strMenu = new StringBuilder();
        strMenu.append( "-1 - return to main menu");
        strMenu.append("\n0 - print menu (this)");
        strMenu.append("\n1 - authorisation");
        strMenu.append("\n2 - create personal score");
        strMenu.append("\n3 - create personal credit card");
        strMenu.append("\n4 - add cash to your balance");
        strMenu.append("\n5 - send cash");
        strMenu.append("\n6 - shopping");
        strMenu.append("\n7 - block credit card");
        strMenu.append("\n8 - unblock credit card");
        strMenu.append("\n9 - print my balance");
        viewInfo.printInfo(strMenu.toString());
    }

    private Client authorisationClient() {
        String firstName = scannerInfo.scannerString("Enter first name:");
        String secondName = scannerInfo.scannerString("Enter second name:");
        String ID = scannerInfo.scannerString("Enter you ID:");
        return new Client(firstName + ' ' + secondName, ID, viewInfo).setBank(bank);
    }

    private Boolean checkClient(Client client) {
        if (client == null) {
            viewInfo.printInfo("Not created client!");
            return true;
        }
        if (client.getBank() == null) {
            viewInfo.printInfo("You not choose bank.");
            return true;
        }
        return false;
    }

    private void createScore(Client client) {
        if (checkClient(client))
            return;
        client.createClientScore();
    }

    private void createCreditCard(Client client) {
        if (checkClient(client))
            return;
        client.createCreditCard();
    }

    private void addCash(Client client) {
        if (checkClient(client))
            return;
        double sum = 0;
        sum = scannerInfo.scanneDouble("Enter sum of cash what you want to push");
        if (sum>0)
            client.addCash(sum);
        else
            viewInfo.printInfo("not correct sum!");
    }

    private void sendCash(Client client) {
        if (checkClient(client))
            return;
        String who = scannerInfo.scannerString("Enter score for send:");
        double sum = 0;
        sum = scannerInfo.scanneDouble("Enter sum of cash what you want to send:");
        if (sum>0)
            client.sendCash(who, sum);
        else
            viewInfo.printInfo("not correct enter!");
    }

    private void makeShop(Client client) {
        if (checkClient(client))
            return;
        String detail = scannerInfo.scannerString("What are you buy?");
        String shopName = "";
        while (!SHOP.containsKey(shopName)) {
            shopName = scannerInfo.scannerString("In what shop?");
        }
        double sum = 0;
        sum = scannerInfo.scanneDouble("Enter sum of cash what you mast to pay.");
        Order order = new Order(SHOP.get(shopName), sum, detail);
        if (sum>0)
            client.makeOrder(order);
        else
            viewInfo.printInfo("not correct enter!");
    }

    private void blockCard(Client client) {
        if (checkClient(client))
            return;
        client.blocked();
    }

    private void unblockCard(Client client) {
        if (checkClient(client))
            return;
        client.unblocked();
    }

    private void printBalance(Client client) {
        if (checkClient(client))
            return;
        client.printCard();
    }

    private void cancel(Client client) {
        client.cancel();
    }
}
