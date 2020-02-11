package name.max_ferrara.matrix_main;

import name.max_ferrara.matrix.Matrix;
import name.max_ferrara.vector.Vector;

public class MatrixMain {
    public static void main(String[] args) {
        Matrix matrix1 = new Matrix(3, 2);
        Matrix matrix2 = new Matrix(new double[][]{{1, 2, 3}, {1, 2, 3}});
        Vector vector1 = new Vector(new double[]{10, 4, 13, 9.65, 3, 14});
        Vector vector3 = new Vector(new double[]{10, 4, 13, 9.65});
        Matrix matrix3 = new Matrix(vector1, vector3);
        Matrix cloneMatrix = new Matrix(matrix1);

        System.out.println(matrix1);
        System.out.println(matrix2);
        System.out.println(matrix3);
    }
}
