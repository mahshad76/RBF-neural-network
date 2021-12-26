
public class twoclass_fit {
    public double twoclass_fit(double[][] y, double[][] y_network, int rows, int num_center) {
        double error = 0;
        int i = 0;
        int j = 0;
        for (i = 0; i < rows; i++) {
            for (j = 0; j < num_center; j++) {
                if (y[i][j] == 1) {
                    if (y_network[i][j] < 0) {
                        error++;
                    }
                }
            }
        }


        error = 1 - (double)(error / rows);

        return error;
    }
}
