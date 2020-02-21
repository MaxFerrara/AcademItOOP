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

    public double getDeterminant() {
        if (coordinates.length != coordinates[0].getSize()) {
            throw new IllegalArgumentException("Illegal matrix dimensions");
        }

        double[][] matrix = getArrayFromMatrix();

        if (matrix.length == 1) {
            return matrix[0][0];
        }

        if (matrix.length == 2) {
            return (matrix[0][0] * matrix[1][1]) - (matrix[0][1] * matrix[1][0]);
        }
        double determinant = 0;

        for (int i = 0; i < matrix[0].length; ++i) {
            double[][] tmp = new double[matrix.length - 1][matrix[0].length - 1];

            for(int j = 1; j < matrix.length; ++j) {
                for(int k = 0; k < matrix[0].length; ++k) {

                }

            }
        }


        return determinant;
    }

    public Vector getVectorMultiply(Vector vector) {
        if (vector.getSize() != coordinates[0].getSize()) {
            throw new IllegalArgumentException("Illegal matrix dimensions");
        }

        double[][] tmp = getArrayFromMatrix();
        double[] result = new double[coordinates.length];

        for (int i = 0; i < tmp.length; ++i) {
            for (int j = 0; j < tmp[i].length; ++j) {
                result[i] += tmp[i][j] * vector.getElementByIndex(j);
            }
        }

        return new Vector(result);
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
        if (matrix1.coordinates[0].getSize() != matrix2.coordinates.length) {
            throw new IllegalArgumentException("Illegal matrix dimensions");
        }

        double[][] matrixOne = matrix1.getArrayFromMatrix();
        double[][] matrixTwo = matrix2.getArrayFromMatrix();
        double[][] tmp = new double[matrixOne.length][matrixTwo[0].length];

        for (int i = 0; i < tmp.length; ++i) {
            for (int j = 0; j < tmp[i].length; ++j) {
                for (int k = 0; k < matrixOne[0].length; ++k) {
                    tmp[i][j] += matrixOne[i][k] * matrixTwo[k][j];
                }
            }
        }

        return new Matrix(tmp);
    }

    private double[][] getArrayFromMatrix() {
        double[][] tmp = new double[coordinates.length][coordinates[0].getSize()];

        for (int i = 0; i < tmp.length; ++i) {
            tmp[i] = coordinates[i].getArrayFromVector();
        }

        return tmp;
    }
}
