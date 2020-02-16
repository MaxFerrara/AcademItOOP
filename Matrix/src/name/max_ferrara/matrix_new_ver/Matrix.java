package name.max_ferrara.matrix_new_ver;

import name.max_ferrara.vector.Vector;

import java.util.Arrays;

public class Matrix {
    private Vector[] coordinates;

    public Matrix(int stringsQuantity, int columnsQuantity) {
        Vector[] tmp = new Vector[stringsQuantity];

        for (int i = 0; i < tmp.length; ++i) {
            tmp[i] = new Vector(columnsQuantity);
        }

       /* for (Vector vector : tmp) {

        } */

        coordinates = tmp;
    }

    public Matrix(double[][] matrixCoordinates) {

    }

    @Override
    public String toString() {
        return Arrays.deepToString(coordinates);
    }
}
