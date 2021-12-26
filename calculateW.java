
public class calculateW {
    public double[][] weight(double[][] g, double[][] y, int num_center, int rows) {
        int khooshe = 4 * num_center;
        double[][] weigh = new double[khooshe][num_center];
        double landa = 0.01;
        transpose t = new transpose();
        double[][] transp = new double[khooshe][rows];
        transp = t.trans(g, rows, khooshe);
        double[][] I = new double[khooshe][khooshe];
        int i = 0;
        int j = 0;
        for (i = 0; i < khooshe; i++) {
            for (j = 0; j < khooshe; j++) {
                I[i][j] = 0;
            }
        }
        for (i = 0; i < khooshe; i++) {
            I[i][i] = 1;
        }

        inverse inver = new inverse();
        double inv[][] = new double[khooshe][khooshe];
        double[][] multi = new double[khooshe][khooshe];
        multiply mu = new multiply();
        multi = mu.multiplyMatrix(transp, g, khooshe, rows, khooshe);
        double[][] sum = new double[khooshe][khooshe];


        for (i = 0; i < khooshe; i++) {
            for (j = 0; j < khooshe; j++) {
                sum[i][j] = I[i][j] + multi[i][j];

            }

        }
        inv = inver.invert(sum);


        double[][] mult2 = new double[khooshe][rows];

        mult2 = mu.multiplyMatrix(inv, transp, khooshe, khooshe, rows);
        weigh = mu.multiplyMatrix(mult2, y, khooshe, rows, num_center);


        return weigh;
    }
}
