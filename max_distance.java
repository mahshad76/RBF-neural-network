
public class max_distance {
    public double max(double[][] data, int rows, int clm) {

        int i = 0;
        int j = 0;
        int m = 0;
        double sum = 0;
        double max = 0;
        for (i = 0; i < rows; i++) {
            for (j = 1; j < rows; j++) {
                for (m = 0; m < clm - 1; m++) {
                    double e = (data[i][m] - data[j][m]);
                    sum = sum + Math.pow(e, 2);

                }
                sum = Math.sqrt(sum);
                if (sum > max) {
                    max = sum;
                }
                sum = 0;
            }
        }

        return max;
    }
}
