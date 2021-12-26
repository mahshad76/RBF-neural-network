import java.util.ArrayList;


import java.util.Random;

public class q_torno {
    public double[][] q(double[][] children, ArrayList<Double> fitne, int child, int kk, int mu, int iteration, int khooshe, double[][] data, int rows, int clm, int num_center) {
        int count = 0;
        int i = 0;
        int T = 0;
        int max_fit_index = 0;
        double max_fit = 0;
        ArrayList<Integer> bazmande = new ArrayList<>();
        Random r = new Random();
        while (count < mu) {
            int p1 = r.nextInt(child);
            int p2 = r.nextInt(child);
            if (fitne.get(p1) >= fitne.get(p2)) {
                for (i = 0; i < bazmande.size(); i++) {
                    if (p1 == bazmande.get(i)) {
                        T = 1;
                        break;

                    }
                }
                if (T == 0) {

                    bazmande.add(p1);


                    if (fitne.get(p1) > max_fit) {

                        max_fit = fitne.get(p1);


                        max_fit_index = p1;

                    }

                    count++;
                }
                T = 0;

            }


        }

        double newparent[][] = new double[mu][kk];
        for (i = 0; i < bazmande.size(); i++) {
            for (T = 0; T < kk; T++) {
                newparent[i][T] = children[bazmande.get(i)][T];


            }

        }
        if (iteration == 19) {
            ArrayList<Double> end = new ArrayList<>();
            for (i = 0; i < kk; i++) {
                end.add(children[max_fit_index][i]);


            }
            final_y f = new final_y();
            f.final_y(end, khooshe, data, rows, clm, num_center);


        }
        return newparent;
    }


}
