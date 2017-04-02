package UkladyRownanLiniowych;

/**
 * Created by Szczepan on 02.04.2017.
 */
public class ResolvingMethods {
    public static void methodGauss(double[][] aMatrix, double[] bVector, double[] xVector) {
        //Pierwszy etap postepowania - eliminacja niewiadomych
        double mRatio;
        for (int i = 1; i < Consts.N; i++) {
            for (int j = i; j < Consts.N; j++) {
                mRatio = aMatrix[j][i - 1] / aMatrix[i - 1][i - 1];
                for (int k = i - 1; k < Consts.N; k++) {
                    aMatrix[j][k] -= (mRatio * aMatrix[i - 1][k]);
                }
                bVector[j] -= mRatio * bVector[i - 1];
            }
        }
        //Etap drugi - wyznaczanie wyniku z macierzy trojkatnej
        double temp;
        xVector[Consts.N - 1] = bVector[Consts.N - 1] / aMatrix[Consts.N - 1][Consts.N - 1];
        for (int i = Consts.N - 2; i >= 0; i--) {
            temp = bVector[i];
            for (int j = Consts.N - 1; j > i; j--) {
                temp -= aMatrix[i][j] * xVector[j];
            }
            xVector[i] = temp / aMatrix[i][i];
        }
    }

    public static void methodJacobi(double[][] aMatrix, double[] bVector, double[] xVector) {
        double[] tempVectorX = new double[Consts.N];
        double[] newVectorB = new double[Consts.N];
        double[] diagonalVector = new double[Consts.N];
        double[][] upperAndLower = new double[Consts.N][Consts.N];
        for (int i = 0; i < Consts.N; i++) {
            xVector[i] = 0;
            tempVectorX[i] = 0;
            newVectorB[i] = bVector[i];
        }

        //M = -D^1(L+U) :
        VectorOperations.generateDiagonalVector(aMatrix, diagonalVector);
        VectorOperations.generateReverseVector(diagonalVector);
        MatrixOperations.generateUpperAndLowerMatrix(aMatrix, upperAndLower);
        MatrixOperations.generateMultipliedULandVectorB(upperAndLower, diagonalVector, newVectorB);

        double maxSub;
        for (int i = 0; i < Consts.MAX_ITERATIONS; i++) {
            maxSub = 0;
            for (int j = 0; j < Consts.N; j++) {
                tempVectorX[j] = 0;
                for (int k = 0; k < Consts.N; k++) {
                    tempVectorX[j] += xVector[k] * upperAndLower[j][k];
                }
                tempVectorX[j] += newVectorB[j];
                if (Math.abs(tempVectorX[j] - xVector[j]) > maxSub){
                    maxSub = Math.abs(tempVectorX[j] - xVector[j]);
                }
            }
            if (maxSub < Consts.residuum){
                System.out.println("Jest to iteracja numer:\t" + i);
                break;
            }
            for (int j = 0; j < Consts.N; j++) {
                xVector[j] = tempVectorX[j];
            }
        }
    }

    public static void methodGaussSeidel(double[][] aMatrix, double[] bVector, double[] xVector) {
        double[] tempVectorX = new double[Consts.N];
        double[] newVectorB = new double[Consts.N];
        double[] diagonalVector = new double[Consts.N];
        double[][] upperAndLower = new double[Consts.N][Consts.N];

        for (int i = 0; i < Consts.N; i++) {
            xVector[i] = 0;
            tempVectorX[i] = 0;
            newVectorB[i] = bVector[i];
        }
        //M = -D^1(L+U) :
        VectorOperations.generateDiagonalVector(aMatrix, diagonalVector);
        VectorOperations.generateReverseVector(diagonalVector);
        MatrixOperations.generateUpperAndLowerMatrix(aMatrix, upperAndLower);
        MatrixOperations.generateMultipliedULandVectorB(upperAndLower, diagonalVector, newVectorB);

        double maxSub;
        for (int i = 0; i < Consts.MAX_ITERATIONS; i++) {
            maxSub = 0;
            for (int j = 0; j < Consts.N; j++) {
                tempVectorX[j] = 0;
                for (int k = 0; k < Consts.N; k++) {
                    tempVectorX[j] += xVector[k] * upperAndLower[j][k];
                }
                tempVectorX[j] += newVectorB[j];
                if (Math.abs(tempVectorX[j] - xVector[j]) > maxSub){
                    maxSub = Math.abs(tempVectorX[j] - xVector[j]);
                }
                xVector[j] = tempVectorX[j];
            }
            if (maxSub < Consts.residuum){
//                System.out.println("Jest to iteracja numer:\t" + i);
                break;
            }
            for (int j = 0; j < Consts.N; j++) {
                xVector[j] = tempVectorX[j];
            }
        }
    }
}
