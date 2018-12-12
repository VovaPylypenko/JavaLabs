package kpi.lab7;

import java.util.Random;

public class Controller {

    private List<Integer> list;
    private View view;

    public Controller() {
        this.list = new List<>();
        view = new View();
    }

    private void printMenu() {
        view.print("==== Menu ====\n0-exit\n1-random generate\n2-add element\n3-print\n4-shift to right");
    }

    public void run(){
        while (true){
            printMenu();
            switch (Scanner.String()){
                case "0":
                    return;
                case "1":
                    randomGenerate();
                    break;
                case "2":
                    addElement();
                    break;
                case "3":
                    printList();
                    break;
                case "4":
                    shift2Right();
                    break;
            }
        }
    }

    private void randomGenerate() {
        view.print("Enter how math element mast be generate?:");
        int count = Scanner.Integer();
        Random random = new Random();
        for (int i = 0; i < count; i++)
            list.add(random.nextInt(100));
    }

    private void addElement() {
        view.print("Enter element for add:");
        list.add(Scanner.Integer());
    }

    private void printList() {
        view.print(list.toString());
    }

    private void shift2Right() {
        view.print("Enter how math element mast be shift?:");
        int n = Scanner.Integer();
        list.shift2Right(n);
    }
}
