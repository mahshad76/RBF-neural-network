
public class jahesh {
    public double[][] jahes(double[][] children, int child, int kk, int clm) {

        double n = Math.sqrt(clm - 1);
        double nerkh = 1 / n;
        double round = Math.exp(-nerkh * Math.random());
        int i = 0;
        int j = 0;
        for (i = 0; i < child; i++) {
            children[i][kk - 1] = children[i][kk - 1] * round;
            for (j = 0; j < kk - 1; j++) {
                children[i][j] = children[i][j] + (children[i][kk - 1] * Math.random());

            }
        }
        return children;

    }
}
