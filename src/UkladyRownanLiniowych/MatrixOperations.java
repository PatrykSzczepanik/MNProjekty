package UkladyRownanLiniowych;

/**
 * Created by Szczepan on 02.04.2017.
 */
public class MatrixOperations {
    public static void generateMatrixA(double[][] aMatrix, int a1, int a2, int a3) {
        aMatrix[0][0] = a1;
        aMatrix[0][1] = a2;
        aMatrix[0][2] = a3;
        aMatrix[1][0] = a2;
        aMatrix[1][1] = a1;
        aMatrix[1][2] = a2;
        aMatrix[1][3] = a3;
        aMatrix[Consts.N - 2][Consts.N - 4] = a3;
        aMatrix[Consts.N - 2][Consts.N - 3] = a2;
        aMatrix[Consts.N - 2][Consts.N - 2] = a1;
        aMatrix[Consts.N - 2][Consts.N - 1] = a2;
        aMatrix[Consts.N - 1][Consts.N - 3] = a3;
        aMatrix[Consts.N - 1][Consts.N - 2] = a2;
        aMatrix[Consts.N - 1][Consts.N - 1] = a1;
        for (int i = 2; i < Consts.N - 2; i++) {
            aMatrix[i][i - 2] = a3;
            aMatrix[i][i - 1] = a2;
            aMatrix[i][i] = a1;
            aMatrix[i][i + 1] = a2;
            aMatrix[i][i + 2] = a3;
        }
    }

    public static void generateUpperAndLowerMatrix(double[][] aMatrix, double[][] upperAndLower) {
        for (int i = 0; i < Consts.N; i++) {
            for (int j = 0; j < Consts.N; j++) {
                if (j == i) continue;
                upperAndLower[i][j] = aMatrix[i][j];
            }
        }
    }

    public static void generateMultipliedULandVectorB(double[][] upperAndLower, double[] reverseDiagonal, double[] bVector) {
        for (int i = 0; i < Consts.N; i++) {
            for (int j = 0; j < Consts.N; j++) {
                upperAndLower[i][j] *= -reverseDiagonal[i];
            }
            bVector[i] *= reverseDiagonal[i];
        }
    }

    public static void printMatrix(double[][] a) {
        System.out.print("====================================\n");
        for (int i = 0; i < Consts.N; i++) {
            for (int j = 0; j < Consts.N; j++) {
                System.out.print(a[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.print("====================================\n");
    }

    public static void multipleMatrixVector(double[][] a, double[] x, double[] ax){
        for (int i =0; i < Consts.N; i++){
            ax[i] = 0;
            for (int j = 0; j < Consts.N; j++){
                ax[i] += a[i][j] * x[j];
            }
        }
    }
}
