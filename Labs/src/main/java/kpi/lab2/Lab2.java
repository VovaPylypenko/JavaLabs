package kpi.lab2;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lab2{

    public String scanTextFromTerminal(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public double findAndAddAllNumbers(String str){
        Pattern pat=Pattern.compile("[-]?[0-9]+(.[0-9]+)?");
        Matcher matcher=pat.matcher(str);
        double sum = 0;
        while (matcher.find()) {
            sum +=Double.valueOf(String.valueOf(matcher.group()));
        }
        return sum;
    }
}
