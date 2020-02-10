package name.max_ferrara.matrix_main;

import name.max_ferrara.matrix.Matrix;

public class MatrixMain {
    public static void main(String[] args) {
        Matrix matrix1 = new Matrix(3, 2);
        Matrix matrix2 = new Matrix(new double[][]{{1, 2, 3}, {1, 2, 3}});
        Matrix cloneMatrix = new Matrix(matrix1);

        System.out.println(matrix1);
        System.out.println(matrix2);
    }
}
