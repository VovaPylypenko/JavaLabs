package kpi.lab4;

public class View {

    public void printInfo(String message) {
        System.out.println(message);
    }

    public void printBalance(Client client) {
        if (client == null) {
            System.out.println("Not created client!");
            return;
        }
        client.printCard();
    }
}
