package name.max_ferrara.matrix;

import name.max_ferrara.vector.Vector;

import java.util.Arrays;

public class Matrix {
    private Vector[] vectors;

    public Matrix(int rowsQuantity, int columnsQuantity) {
        if (rowsQuantity < 1 || columnsQuantity < 1) {
            throw new IllegalArgumentException("Illegal matrix dimensions");
        }

        vectors = new Vector[rowsQuantity];

        for (int i = 0; i < vectors.length; ++i) {
            vectors[i] = new Vector(columnsQuantity);
        }
    }

    public Matrix(double[][] matrixCoordinates) {
        int maxLength = 0;

        for (int i = 0; i < matrixCoordinates.length; ++i) {
            if (matrixCoordinates[i].length > maxLength) {
                maxLength = matrixCoordinates[i].length;
            }
        }

        vectors = new Vector[matrixCoordinates.length];

        for (int i = 0; i < vectors.length; ++i) {
            vectors[i] = new Vector(maxLength, matrixCoordinates[i]);
        }
    }

    public Matrix(Vector... vectors) {
        int maxLength = 0;

        for (int i = 0; i < vectors.length; ++i) {
            if (maxLength < vectors[i].getSize()) {
                maxLength = vectors[i].getSize();
            }
        }

        for (int i = 0; i < vectors.length; ++i) {
            vectors[i] = new Vector(maxLength, vectors[i].toArray());
        }

        this.vectors = vectors;
    }

    public Matrix(Matrix matrix) {
        vectors = new Vector[matrix.vectors.length];

        for (int i = 0; i < vectors.length; ++i) {
            vectors[i] = new Vector(matrix.vectors[i]);
        }
    }

   /* @Override
    public String toString() {
        return Arrays.deepToString(vectors);
    } */

    @Override
    public String toString() {
        StringBuilder formatVectors = new StringBuilder("{  }");

        for (Vector vector : vectors) {
            formatVectors.insert(formatVectors.length() - 2, vector.toString() + ", ");
        }

        formatVectors.delete(formatVectors.length() - 4, formatVectors.length() - 2);

        return formatVectors.toString();
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

        return Arrays.equals(vectors, matrix.vectors);
    }

    @Override
    public int hashCode() {
        final int prime = 21;
        int hash = 1;
        hash = prime * hash + Arrays.hashCode(vectors);
        return hash;
    }

    public String getSize() {
        return String.format("Matrix size: rows - %s, columns -  %s", vectors.length, vectors[0].getSize());
    }

    public Vector getRow(int rowIndex) {
        return new Vector(vectors[rowIndex]);
    }

    public Vector getColumn(int columnIndex) {
        double[] tmp = new double[vectors[0].getSize()];

        for (int i = 0; i < vectors.length; ++i) {
            tmp[i] = vectors[i].getElementByIndex(columnIndex);
        }

        return new Vector(tmp);
    }

    public void transpose() {

        for (int i = 0; i < vectors.length; ++i) {
            double[] tmp = new double[vectors[0].getSize()];

            for (int j = 0; j < vectors[i].getSize(); ++j) {
                tmp[j] = vectors[j].getElementByIndex(i);
            }
            Vector vector = new Vector(tmp);
            vectors[i] = vector;
        }
    }

    public void scale(double number) {
        for (int i = 0; i < vectors.length; ++i) {
            vectors[i].scale(number);
        }
    }

    public double getDeterminant(Matrix matrix) {
        if (matrix.vectors.length != matrix.vectors[0].getSize()) {
            throw new IllegalArgumentException("Illegal matrix dimensions");
        }

        double[][] matrixTmp = matrix.getArrayFromMatrix();

        if (matrixTmp.length == 1) {
            return matrixTmp[0][0];
        }

        if (matrixTmp.length == 2) {
            return (matrixTmp[0][0] * matrixTmp[1][1]) - (matrixTmp[0][1] * matrixTmp[1][0]);
        }

        double determinant = 0;

        for (int i = 0; i < matrixTmp[0].length; ++i) {
            double[][] tmp = new double[matrixTmp.length - 1][matrixTmp[0].length - 1];

            for (int j = 1; j < matrixTmp.length; ++j) {
                for (int k = 0; k < matrixTmp[0].length; ++k) {
                    if (k < i) {
                        tmp[j - 1][k] = matrixTmp[j][k];
                    } else if (k > i) {
                        tmp[j - 1][k - 1] = matrixTmp[j][k];
                    }
                }
            }

            determinant += matrixTmp[0][i] * Math.pow(-1, i) * getDeterminant(new Matrix(tmp));
        }

        return determinant;
    }

    public Vector getVectorMultiply(Vector vector) {
        if (vector.getSize() != vectors[0].getSize()) {
            throw new IllegalArgumentException("Illegal matrix dimensions");
        }

        double[][] tmp = getArrayFromMatrix();
        double[] result = new double[vectors.length];

        for (int i = 0; i < tmp.length; ++i) {
            for (int j = 0; j < tmp[i].length; ++j) {
                result[i] += tmp[i][j] * vector.getElementByIndex(j);
            }
        }

        return new Vector(result);
    }

    public void add(Matrix matrix) {
        if ((vectors.length != matrix.vectors.length) && (vectors[0].getSize() != matrix.vectors[0].getSize())) {
            throw new IllegalArgumentException("Illegal matrix dimensions");
        }

        for (int i = 0; i < vectors.length; ++i) {
            vectors[i].add(matrix.vectors[i]);
        }
    }

    public void subtract(Matrix matrix) {
        if ((vectors.length != matrix.vectors.length) && (vectors[0].getSize() != matrix.vectors[0].getSize())) {
            throw new IllegalArgumentException("Illegal matrix dimensions");
        }

        for (int i = 0; i < vectors.length; ++i) {
            vectors[i].subtract(matrix.vectors[i]);
        }
    }

    public static Matrix getSum(Matrix matrix1, Matrix matrix2) {
        Matrix cloneMatrix = new Matrix(matrix1);
        cloneMatrix.add(matrix2);

        return new Matrix(cloneMatrix);
    }

    public static Matrix getDiff(Matrix matrix1, Matrix matrix2) {
        Matrix cloneMatrix = new Matrix(matrix1);
        cloneMatrix.subtract(matrix2);

        return new Matrix(cloneMatrix);
    }

    public static Matrix getComposition(Matrix matrix1, Matrix matrix2) {
        if (matrix1.vectors[0].getSize() != matrix2.vectors.length) {
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
        double[][] tmp = new double[vectors.length][vectors[0].getSize()];

        for (int i = 0; i < tmp.length; ++i) {
            tmp[i] = vectors[i].toArray();
        }

        return tmp;
    }
}
