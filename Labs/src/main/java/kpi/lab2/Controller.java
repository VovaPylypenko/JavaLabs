package kpi.lab2;

import java.util.Scanner;

class Controller {

    private NumberReader numberReader;
    private View view;

    Controller(NumberReader numberReader, View view) {
        this.numberReader = numberReader;
        this.view = view;
    }

    void run(){
        final String text = "Hello, 11.30o`clock lab 2";
        String cText = "y";
        Scanner scanner = new Scanner(System.in);
        while (!cText.equals("n")){
            String textInput = scanTextFromTerminal();
            if (textInput.isEmpty())
                view.print(text, numberReader.findAndAddAllNumbers(text));
            else
                view.print(textInput, numberReader.findAndAddAllNumbers(textInput));
            System.out.println("Contine?");
            cText = scanner.nextLine();
        }
    }

    private String scanTextFromTerminal(){
        System.out.println("Enter line.");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
