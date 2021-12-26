import com.sun.xml.internal.stream.events.NamedEvent;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class main {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanner = new Scanner(new File("C:\\Users\\mahnoosh\\Desktop/1class.txt"));
        int rows = 0;
        int clm = 0;
        double me=0;



        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            rows++;
            String[] splitStr = line.trim().split("\\s+");
            clm = splitStr.length;


            // process the line
        }

        Scanner s = new Scanner(new File("C:\\Users\\mahnoosh\\Desktop/1class.txt"));
        int ix = 0;
        int jj = 0;
        double[][] data = new double[rows][clm];
        while (s.hasNextLine()) {
            String line = s.nextLine();
            // rr++;
            String[] splitStr = line.trim().split("\\s+");
            for (jj = 0; jj < clm; jj++) {
                data[ix][jj] = Double.parseDouble(splitStr[jj]);


            }
            ix++;
            //cc=splitStr.length;


            // process the line
        }


        int num_center = 0;
        int i = 0;
        int j = clm - 1;
        int k = 0;
        int T = 0;
        int ll = 0;

        double[] CENT = new double[rows];
        for (i = 0; i < rows; i++) {
            CENT[i] = -1;
        }
        for (i = 0; i < rows; i++) {
            for (k = 0; k < rows; k++) {
                if (data[i][j] == CENT[k]) {
                    T = 1;
                    break;
                }

            }
            if (T == 0) {
                CENT[ll] = data[i][j];


                ll++;
                num_center = num_center + 1;


            }
            T = 0;
        }

        //double reg = (40 * rows) / 100;
        //if (reg <= num_center){
        //  a.calculate()
        //
        //  }
        ///////omadam bodo gereftam 3 barabare tedade clasa
        int khooshe = 4 * num_center;


//        Random rand = new Random();
        //      for (i = 0; i < khooshe; i++) {
        //        for (j = 0; j < clm - 1; j++) {
        //          cluster_center[i][j] = rand.nextInt();
        //    }
        //}
        //for (i = 0; i <khooshe; i++) {
        //  for (j = 0; j < clm - 1; j++) {
        //    sigma[i][j] = rand.nextInt();

        //}
        //}
        max_distance mx = new max_distance();
        double dist = 0;
        dist = mx.max(data, rows, clm);

        ES e = new ES();
        e.es(khooshe, clm, dist, num_center, rows, data);


    }

}
