package kpi.lab1;

import java.text.DecimalFormat;
import java.util.Random;

public class Matrix {
    private float A[][];
    private int N;

    Matrix(int n) {
        N = n;
        A = fillMatrix();
    }

    private float[][] fillMatrix(){
        Random random = new Random();
        float[][] a = new float[N][N];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                a[i][j] = random.nextFloat() * 100;
        return a;
    }

    void turnСounterclockwise(){
        float [][] newA = new float[N][N];

        for (int i = 0; i < N; i++)
            for (int j = 0;  j < N; j++) {
                newA[N - 1 - j][i] = A[i][j];
            }
        A = newA;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        for (float i[] : A) {
            for (float ii : i)
                stringBuilder.append(decimalFormat.format(ii)).append(" ");
            stringBuilder.append('\n');
        }
        return stringBuilder.toString();
    }
}
