package name.max_ferrara.matrix_main;

import name.max_ferrara.matrix.Matrix;
import name.max_ferrara.vector.Vector;

public class MatrixMain {
    public static void main(String[] args) {
        Matrix matrix1 = new Matrix(2, 3);
        Matrix matrix2 = new Matrix(new double[][]{{1, 2, 3}, {1, 2, 3, 4}, {1, 2, 3}});

        Vector vector1 = new Vector(new double[]{1, 2, 3, 4, 5});
        Vector vector2 = new Vector(new double[]{1, 2, 3, 4});
        Vector vector3 = new Vector(new double[]{1, 2, 3});
        Matrix matrix3 = new Matrix(vector1, vector2, vector3);
        Matrix cloneMatrix = new Matrix(matrix3);

        System.out.println(matrix1);
        System.out.println(matrix2);
        System.out.println(matrix3);
        System.out.println(cloneMatrix);
        System.out.println(matrix1.getMatrixSize());
        System.out.println(matrix3.getRowVector(1));
    }
}
