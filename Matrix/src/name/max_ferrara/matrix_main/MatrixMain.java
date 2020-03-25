package name.max_ferrara.matrix_main;

import name.max_ferrara.matrix.Matrix;
import name.max_ferrara.vector.Vector;

public class MatrixMain {
    public static void main(String[] args) {
        try {
            Matrix matrix1 = new Matrix(new double[][]{{1, -1}, {2, 0}, {3, 0}});
            Matrix matrix2 = new Matrix(new double[][]{{1, 1}, {2, 0}});
            Matrix matrix3 = new Matrix(new double[][]{{0, 0, 0}, {1, 1, 1}});
            Matrix matrix4 = new Matrix(new double[][]{{1, 1, 1}, {0, 0, 0}});

            Vector vector1 = new Vector(new double[]{1, 2, 3, 4, 5});
            Vector vector2 = new Vector(new double[]{1, 2, 3, 4});
            Vector vector3 = new Vector(new double[]{1, 2, 3});
            Vector vector4 = new Vector(new double[]{1, 2});
            Vector vector5 = new Vector(new double[]{1});

            Matrix matrix5 = new Matrix(vector1, vector2, vector3, vector4, vector5);
            System.out.println(matrix5);

            Matrix cloneMatrix = new Matrix(matrix5);

            Matrix matrix6 = new Matrix(new double[][]{{1, -1, 2, 3}, {2, 0, 6, 5}, {3, 0, 0, 0}, {1, 2, 3, 4}});
            Matrix matrix7 = new Matrix(3, 3);

            System.out.println(matrix7);

            matrix7.setRow(0, new double[]{1, 2, 3});

            System.out.println(cloneMatrix.getColumn(1));
            System.out.println(cloneMatrix.getRow(2));
            cloneMatrix.multiplyOnScalar(2);
            System.out.println(cloneMatrix);
            cloneMatrix.transpose();

            System.out.println(cloneMatrix);
            System.out.println(Matrix.getComposition(matrix1, matrix2));

            System.out.println(matrix1);
            System.out.println(vector4);
            System.out.println(matrix1.getVectorMultiply(vector4));
            System.out.println(matrix6.calculateDeterminant());
            System.out.println(Matrix.getSum(matrix3, matrix4));
            System.out.println(Matrix.getDiff((new Matrix(new double[][]{{1, 1, 1}, {1, 1, 1}})), (new Matrix(new double[][]{{2, 2, 2}, {2, 2, 2}}))));

            matrix3.add(matrix4);
            System.out.println(matrix3);
            matrix3.subtract(matrix4);
            System.out.println(matrix3);
        } catch (IllegalArgumentException | IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }
}
