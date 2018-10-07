package kpi.lab1;

class View {

    View() {
    }

    void printMatrix(Object matrix, String details){
        System.out.println("Matrix(" + details + "):\n" + matrix.toString());
    }
    void printMatrix(Object matrix){
        System.out.println("Matrix:\n" + matrix.toString());
    }
}
