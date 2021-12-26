

import java.util.ArrayList;
import java.util.Random;

public class calculateG {
    public double[][] calculate(int num_center, double[][] datas, int rows, int clm, ArrayList<Double> kromoz) {
        double[][] sigma = new double[num_center][clm - 1];
        double[][] cluster_center = new double[num_center][clm - 1];
        int i = 0;
        int j = 0;
        int v = 0;
        for (i = 0; i < num_center; i++) {
            for (j = 0; j < clm - 1; j++) {
                cluster_center[i][j] = kromoz.get(v);
                v++;
                sigma[i][j] = kromoz.get(v);
                v++;

            }
        }


        double[][] G = new double[rows][num_center];
        double gama = kromoz.get(v);


        int y = 0;
        double b = 0;


        for (j = 0; j < num_center; j++) {
            for (i = 0; i < rows; i++) {
                ////calculate sigma
                for (y = 0; y < clm - 1; y++) {
                    b = datas[i][y] - cluster_center[j][y];
                    b = b / sigma[j][y];
                    b = Math.pow(b, 2);
                }
                Math.exp(-gama * b);
                G[i][j] = b;


            }


        }


        return G;

    }
}
