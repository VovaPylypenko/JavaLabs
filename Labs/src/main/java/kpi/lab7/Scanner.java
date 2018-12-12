package kpi.lab7;

class Scanner {

    private static java.util.Scanner scanner = new java.util.Scanner(System.in);

    static Integer Integer() {
        Integer num = null;
        do {
            num = Integer.valueOf(scanner.next());
        } while (num == null);
        return num;
    }

    static String String() {
        return scanner.next();
    }

}
