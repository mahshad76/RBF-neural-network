
public class multiply {
    public static double[][] multiplyMatrix(double matrix1[][], double matrix2[][], int row,
                                            int column, int col) {
        double multiply[][] = new double[row][col];
        for (int a = 0; a < row; a++) {
            for (int b = 0; b < col; b++) {
                for (int k = 0; k < column; k++) {
                    multiply[a][b] += matrix1[a][k] * matrix2[k][b];

                }

            }

        }
        return multiply;
    }
}
