package UkladyRownanLiniowych;

/**
 * Created by Szczepan on 30.03.2017.
 */
public class Main {

    public static void main(String[] args) {
        double diff = 0;

        for (int i = 0; i < 1; i++){
            double[][] aMatrix = new double[Consts.N][Consts.N];
            double[] xVector = new double[Consts.N];
            double[] bVector = new double[Consts.N];

            VectorOperations.generateVectorB(bVector);
            MatrixOperations.generateMatrixA(aMatrix, Consts.a12, Consts.a2, Consts.a3);

            long start;
            start = System.nanoTime();

            ResolvingMethods.methodGauss(aMatrix, bVector, xVector);
//            ResolvingMethods.methodJacobi(aMatrix, bVector, xVector);
//            ResolvingMethods.methodJacobi(aMatrix, bVector, xVector);

            double[] axVector = new double[Consts.N];
            MatrixOperations.multipleMatrixVector(aMatrix, xVector, axVector);
            VectorOperations.subVectors(axVector, bVector);
            System.out.println("NORMA:\t" + VectorOperations.generateNormEuc(axVector));

            //Time in ms
            diff += (double)(System.nanoTime() - start)/1000000;

//            VectorOperations.printVector(xVector);
        }

//        System.out.println(Double.toString(diff/20).replace(".", ","));
    }
}