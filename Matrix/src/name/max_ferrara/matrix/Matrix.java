package name.max_ferrara.matrix;

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
            if (tmp[i].getSize() >= vectorMax.getSize()) {
                vectorMax = tmp[i];
            }
        }

        for (int i = 0; i < tmp.length; ++i) {
            if (tmp[i].getSize() < vectorMax.getSize()) {
                tmp[i] = new Vector(vectorMax.getSize(), matrixCoordinates[i]);
            }
        }

        coordinates = tmp;
    }

    public Matrix(Vector... vectors) {
        Vector vectorMax = new Vector(1);

        for (int i = 0; i < vectors.length; ++i) {
            if (vectors[i].getSize() >= vectorMax.getSize()) {
                vectorMax = vectors[i];
            }
        }

        for (int i = 0; i < vectors.length; ++i) {
            if (vectors[i].getSize() < vectorMax.getSize()) {
                vectors[i] = new Vector(vectorMax.getSize(), vectors[i].getArrayFromVector());
            }
        }

/*        for (int i = 0; i < vectors.length; ++i) {
            // create newVec
            for(int j = 0; j < vectors[i].getSize(); ++j) {
                // fill Vec
            }
            // get full Vec
            // Vec[i] = newVec
        } */

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
        return String.format("Matrix size: rows - %s, cols -  %s", coordinates.length, coordinates[0].getSize());
    }

    public Vector getRowVector(int row) {
        return new Vector(coordinates[row - 1]);
    }

    public Vector getColVector(int col) {
        return new Vector(getTranspose().coordinates[col - 1]);
    }

    public Matrix getTranspose() {
        double[][] matrixT = getArrayFromMatrix();

        double[][] tmp = new double[matrixT[0].length][matrixT.length];

        for (int i = 0; i < tmp.length; i++) {
            for (int j = 0; j < tmp[i].length; j++) {
                tmp[j][i] = matrixT[i][j];
            }
        }

        return new Matrix(tmp);
    }

    public void scale(double number) {
        for (int i = 0; i < coordinates.length; ++i) {
            coordinates[i].scale(number);
        }
    }

    public void sum(Matrix matrix) {
        for (int i = 0; i < coordinates.length; ++i) {
            coordinates[i].summarize(matrix.coordinates[i]);
        }
    }

    public void diff(Matrix matrix) {
        for (int i = 0; i < coordinates.length; ++i) {
            coordinates[i].subtraction(matrix.coordinates[i]);
        }
    }

    public static Matrix getSum(Matrix matrix1, Matrix matrix2) {
        Matrix cloneMatrix = new Matrix(matrix1);
        cloneMatrix.sum(matrix2);

        return new Matrix(cloneMatrix);
    }

    public static Matrix getDiff(Matrix matrix1, Matrix matrix2) {
        Matrix cloneMatrix = new Matrix(matrix1);
        cloneMatrix.diff(matrix2);

        return new Matrix(cloneMatrix);
    }

    public static Matrix getMulti(Matrix matrix1, Matrix matrix2) {
        Vector[] tmp = new Vector[matrix1.coordinates.length];

        return new Matrix(tmp);
    }

    public double[][] getArrayFromMatrix() {
        double[][] tmp = new double[coordinates.length][coordinates[0].getSize()];

        for (int i = 0; i < tmp.length; ++i) {
            tmp[i] = coordinates[i].getArrayFromVector();
        }

        return tmp;
    }
}
