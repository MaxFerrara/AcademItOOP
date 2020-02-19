package name.max_ferrara.matrix_main;

import name.max_ferrara.matrix.Matrix;
import name.max_ferrara.vector.Vector;

import java.util.Arrays;

public class MatrixMain {
    public static void main(String[] args) {
        Matrix matrix2 = new Matrix(new double[][]{{1, 2, 3}, {1, 2, 3, 4}, {1, 2, 3}});
        Vector vector1 = new Vector(new double[]{1, 2, 3, 4, 5});
        Vector vector2 = new Vector(new double[]{1, 2, 3, 4});
        Vector vector3 = new Vector(new double[]{1, 2, 3});
        Vector vector4 = new Vector(new double[]{1, 2});
        Vector vector5 = new Vector(new double[]{1});
        Matrix matrix3 = new Matrix(vector1, vector2, vector3, vector4, vector5);

        System.out.println(matrix2);
        System.out.println(matrix3);
        matrix3.transpose();
        System.out.println(matrix3);

    }
}
