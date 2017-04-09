package UkladyRownanLiniowych;

/**
 * Created by Szczepan on 02.04.2017.
 */
public class VectorOperations {
    public static void generateVectorB(double[] b) {
        for (int i = 0; i < Consts.N; i++) {
            b[i] = Math.sin((double) (i + 1) * (Consts.f + 1) / 50);
        }
    }

    public static void generateDiagonalVector(double[][] aMatrix, double[] diagonalVector) {
        for (int i = 0; i < Consts.N; i++) {
            diagonalVector[i] = aMatrix[i][i];
        }
    }

    public static void generateReverseVector(double[] diagonalVector) {
        for (int i = 0; i < Consts.N; i++) {
            diagonalVector[i] = 1 / diagonalVector[i];
        }
    }

    public static void subVectors(double[] ax, double[] b){
        for (int i =0; i < Consts.N; i++){
            ax[i] -= b[i];
        }
    }

    public static double generateNormEuc(double[] vector){
        double sum = 0;
        for (int i =0; i < Consts.N; i++){
            sum = sum + (vector[i] * vector[i]);
        }
        return Math.sqrt(sum);
    }

    public static void printVector(double[] bVector) {
        System.out.print("-----------------------------------\n");
        for (int i = 0; i < Consts.N; i++) {
            System.out.print(bVector[i] + "\n");
        }
        System.out.print("-----------------------------------\n");
    }
}
