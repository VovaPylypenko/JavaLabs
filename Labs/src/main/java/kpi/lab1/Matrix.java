package kpi.lab1;

import java.text.DecimalFormat;
import java.text.Format;
import java.util.Arrays;
import java.util.Random;

public class Matrix {

    private float A[][];

    Matrix() {
    }

    Matrix(int n) {
        A = fillMatrix(n);
    }

    private float[][] fillMatrix(int size) {
        Random random = new Random();
        float[][] a = new float[size][size];
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                a[i][j] = random.nextFloat() * 100 - 50;
        return a;
    }

    void overfillMatrix(int size) {
        A = fillMatrix(size);
    }

    Matrix turnСounterclockwise() {
        int size = A[0].length;
        for (int i = 0; i < size / 2; i++)
            for (int j = i; j < size-i-1; j++) {
                float temp = A[i][j];
                A[i][j] = A[j][size-1-i];
                A[j][size-1-i] = A[size-1-i][size-1-j];
                A[size-1-i][size-1-j] = A[size-1-j][i];
                A[size-1-j][i] = temp;
            }
        return this;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        DecimalFormat decimalFormat = new DecimalFormat("##.##");

        for (float i[] : A) {
            for (float ii : i)
                stringBuilder.append(String.format("%6s", decimalFormat.format(ii))).append(" ");
            stringBuilder.append('\n');
        }
        return stringBuilder.toString();
    }
}
