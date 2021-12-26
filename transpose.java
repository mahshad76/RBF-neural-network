
public class transpose {
    public double[][] trans(double[][] in, int rw, int cl) {
        double[][] tr = new double[cl][rw];
        for (int i = 0; i < rw; i++) {
            for (int j = 0; j < cl; j++) {
                tr[j][i] = in[i][j];
            }
        }


        return tr;
    }
}
