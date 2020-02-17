package name.max_ferrara.matrix_new_ver;

import name.max_ferrara.vector.Vector;

import java.util.Arrays;

public class Matrix {
    private Vector[] coordinates;

    public Matrix(int rows, int cols) {
        Vector[] tmp = new Vector[rows];

        for (int i = 0; i < tmp.length; ++i) {
            tmp[i] = new Vector(cols);
        }

        coordinates = tmp;
    }

    public Matrix(double[][] matrixCoordinates) {
        Vector[] tmp = new Vector[matrixCoordinates.length];

        for (int i = 0; i < tmp.length; ++i) {
            tmp[i] = new Vector(matrixCoordinates[i]);
        }

        Vector vectorMax = new Vector(1);

        for (int i = 0; i < tmp.length; ++i) {
            if (tmp[i].getVectorLength() >= vectorMax.getVectorLength()) {
                vectorMax = tmp[i];
            }
        }

        for (int i = 0; i < tmp.length; ++i) {
            if (tmp[i].getVectorLength() < vectorMax.getVectorLength()) {
                tmp[i] = new Vector(vectorMax.getVectorLength(), matrixCoordinates[i]);
            }
        }

        coordinates = tmp;
    }

    public Matrix(Vector... vectors) {
        coordinates = vectors;
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

        return Arrays.deepEquals(coordinates, matrix.coordinates);
    }

    @Override
    public int hashCode() {
        final int prime = 21;
        int hash = 1;
        hash = prime * hash + Arrays.deepHashCode(coordinates);
        return hash;
    }

    public String getMatrixSize() {
        return String.format("Matrix size: rows - %s, cols -  %s", coordinates.length, coordinates[0].getVectorLength());
    }

    public Vector getRowVector(int row) {
        return new Vector(coordinates[row - 1]);
    }

    public Vector getColVector(int col) {
        return new Vector(5);
    }

    public void transpose() {
        for (int i = 0; i < coordinates.length; ++i) {
            for (int j = 0; j < coordinates[j].getVectorLength(); ++j) {
                //coordinates[i][new Vector(coordinates[j])] = ;
            }
        }
    }

   /* public double getDeterminant(Matrix matrix) {
        double deter = Matrix
    } */
}
