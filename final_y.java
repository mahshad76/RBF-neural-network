import java.util.ArrayList;


public class final_y {
    public void final_y(ArrayList<Double> weighs, int khooshe, double[][] data, int rows, int clm, int num_center) {
        calculateG gg = new calculateG();
        double[][] gs = new double[rows][khooshe];
        gs = gg.calculate(khooshe, data, rows, clm, weighs);
        calculateY xx = new calculateY();
        double[][] y = new double[rows][num_center];
        y = xx.cal(data, rows, clm, num_center);
        calculateW w = new calculateW();
        double[][] we = new double[khooshe][num_center];
        we = w.weight(gs, y, num_center, rows);
        multiply m1 = new multiply();
        double[][] final_y_network = new double[rows][num_center];
        final_y_network = m1.multiplyMatrix(gs, we, rows, khooshe, num_center);

        int ii = 0;
        int jj = 0;

        System.out.print("Y MATRIX:");
        System.out.print('\n');
        for (ii = 0; ii < rows; ii++) {
            for (jj = 0; jj < num_center; jj++) {


                System.out.print(final_y_network[ii][jj]);
                 System.out.print(" ");
            }
              System.out.print('\n');
        }
        System.out.print('\n');
        if (num_center > 2) {

            double nn = 0;
            fit_multiclass aa = new fit_multiclass();
            nn = aa.fit(y, final_y_network, rows, num_center);
            System.out.print('\n');
            System.out.print("Error:");
            System.out.print('\n');
            double aaa=(double) 1 / nn;
            System.out.print(aaa);
        }
        if (num_center == 2) {
            double nn = 0;
            twoclass_fit aa = new twoclass_fit();
            nn = aa.twoclass_fit(y, final_y_network, rows, num_center);
            System.out.print('\n');
            System.out.print("error:");
            System.out.print('\n');
            System.out.print(1 - nn);

        }


    }
}
