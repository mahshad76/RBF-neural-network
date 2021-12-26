import java.util.ArrayList;


import java.util.Random;

public class ES {
    public void es(int khooshe, int clm, double dist, int num_center, int rows, double[][] data) {

        int i = 0;
        int mu = 1000;
        int j = 0;
        int kk = (2 * (clm - 1) * khooshe) + 2;
        double[][] koromozom = new double[mu][kk];

        Random rand = new Random();
        for (i = 0; i < mu; i++) {
            for (j = 0; j < kk; j++) {
                if (j == kk - 1) {
                    koromozom[i][j] = (Math.random()) * dist;

                    break;
                }
                koromozom[i][j] = rand.nextDouble();

            }


        }

        int iteration = 0;
        for (iteration = 0; iteration < 20; iteration++) {
            int child = 7 * mu;
            double[][] children = new double[child][kk];
            for (i = 0; i < child; i++) {
                int v = rand.nextInt((mu - 1) + 1);

                for (j = 0; j < kk; j++) {
                    children[i][j] = koromozom[v][j];


                }


            }

            jahesh jj = new jahesh();
            children = jj.jahes(children, child, kk, clm);
            double[][] g = new double[rows][khooshe];
            ArrayList<Double> kromoz = new ArrayList<>();
            int u = 0;

            calculateG a = new calculateG();
            ArrayList<Double> fitne = new ArrayList<>();
            for (u = 0; u < child; u++) {

                for (i = 0; i < kk; i++) {
                    kromoz.add(children[u][i]);


                }


                g = a.calculate(khooshe, data, rows, clm, kromoz);
                calculateY x = new calculateY();

                double[][] y = new double[rows][num_center];
                double[][] we = new double[khooshe][num_center];




                y = x.cal(data, rows, clm, num_center);
                calculateW w = new calculateW();
                we = w.weight(g, y, num_center, rows);
                multiply m1 = new multiply();
                double[][] y_network = new double[rows][num_center];
                y_network = m1.multiplyMatrix(g, we, rows, khooshe, num_center);
                    if (num_center == 2) {
                        double e = 0;
                        twoclass_fit two = new twoclass_fit();
                        e = two.twoclass_fit(y, y_network, rows, num_center);
                        fitne.add(e);



                    } else {
                        if (num_center > 2) {
                         //   multi_class multi = new multi_class();
                           // double hh = 0;
                            //hh = multi.multi_class(y, y_network, rows, num_center);
                            //fitne.add(hh);
                            fit_multiclass fi = new fit_multiclass();
                            fitne.add(fi.fit(y, y_network, rows, num_center));



                        }

                    }



            }
            q_torno q1 = new q_torno();
            koromozom = q1.q(children, fitne, child, kk, mu, iteration, khooshe, data, rows, clm, num_center);


        }


    }


}
