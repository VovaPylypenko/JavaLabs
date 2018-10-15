package kpi.lab2;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class NumberReader {

    NumberReader() {
    }

    double findAndAddAllNumbers(String str){
        double sum = 0;
        Matcher m = Pattern.compile("(?!=\\d\\.\\d\\.)([\\d.]+)").matcher(str);
        while (m.find())
            sum += Double.parseDouble(m.group(1));
        return sum;
    }
}
