package name.max_ferrara.matrix;

import name.max_ferrara.vector.Vector;

import java.util.Arrays;

public class Matrix {
    private double[][] coordinates;

    public Matrix(int stringsQuantity, int columnsQuantity) {
        coordinates = new double[stringsQuantity][columnsQuantity];
    }

    public Matrix(double[][] matrixCoordinates) {
        coordinates = Arrays.copyOf(matrixCoordinates, matrixCoordinates.length);
    }

    public Matrix(Vector... vector) {
        double[][] tmp = new double[vector.length][vector.length];

        for (int i = 0; i < tmp.length; ++i) {
            for (int j = 0; j < tmp[i].length; ++i) {
                // tmp[i][j] = vector[j].getVectorCoordinates();
            }
        }

        coordinates = tmp;
    }

    public Matrix(Matrix matrix) {
        coordinates = Arrays.copyOf(matrix.coordinates, matrix.coordinates.length);
    }

    @Override
    public String toString() {
        return Arrays.deepToString(coordinates);
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }

        if (object == null || object.getClass() != getClass()) {
            return false;
        }

        Matrix matrix = (Matrix) object;

        return Arrays.equals(coordinates, matrix.coordinates);
    }

    @Override
    public int hashCode() {
        final int prime = 21;
        int hash = 1;
        hash = prime * hash + Arrays.hashCode(coordinates);
        return hash;
    }
}
