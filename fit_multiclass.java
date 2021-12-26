
public class fit_multiclass {
    public double fit(double[][] y, double[][] y_network, int rows, int num_center) {

        transpose tr = new transpose();
        double minus[][] = new double[rows][num_center];
        double minus_t[][] = new double[num_center][rows];
        int i = 0;
        int j = 0;
        for (i = 0; i < rows; i++) {
            for (j = 0; j < num_center; j++) {
                minus[i][j] = y_network[i][j] - y[i][j];
            }
        }

        minus_t = tr.trans(minus, rows, num_center);
        multiply mm = new multiply();

        double[][] matri = new double[num_center][num_center];
        matri = mm.multiplyMatrix(minus_t, minus, num_center, rows, num_center);
        double err = 0;

        for (i = 0; i < num_center; i++) {
            for (j = 0; j < num_center; j++) {
                err = err +matri[i][j] ;
            }
        }
        err = err * 0.5;
        //System.out.println(err);
        err = (double) 1 / err;



        return err;
    }
}
