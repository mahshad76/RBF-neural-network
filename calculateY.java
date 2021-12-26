
public class calculateY {
    public double[][] cal(double[][] data, int rows, int clm, int clas) {
        double[][] y = new double[rows][clas];
        int i = 0;
        int j = 0;
        for (i = 0; i < rows; i++) {
            for (j = 0; j < clas; j++) {
                y[i][j] = -1;
            }
        }
        j = clm - 1;
        i = 0;
        int s = 0;
        for (i = 0; i < rows; i++) {
            s = (int) data[i][j];

            y[i][s] = 1;


        }


        return y;
    }
}
