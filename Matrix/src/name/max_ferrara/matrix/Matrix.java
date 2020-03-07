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

    public Matrix(double[][] twoDimensionalArray) {
        if (twoDimensionalArray.length < 1 || twoDimensionalArray[0].length < 1) {
            throw new IllegalArgumentException("Illegal matrix dimensions");
        }

        int maxLength = 0;

        for (double[] doubles : twoDimensionalArray) {
            if (doubles.length > maxLength) {
                maxLength = doubles.length;
            }
        }

        vectors = new Vector[twoDimensionalArray.length];

        for (int i = 0; i < vectors.length; ++i) {
            vectors[i] = new Vector(maxLength, twoDimensionalArray[i]);
        }
    }

    public Matrix(Vector... vectors) {
        if (vectors.length < 1) {
            throw new IllegalArgumentException("Illegal matrix dimensions");
        }

        int maxLength = 0;

        for (Vector vector : vectors) {
            if (maxLength < vector.getSize()) {
                maxLength = vector.getSize();
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
        final int prime = 19;
        int hash = 1;
        hash = prime * hash + Arrays.hashCode(vectors);
        return hash;
    }

    private int getRowsQuantity() {
        return vectors.length;
    }

    private int getColumnsQuantity() {
        return vectors[0].getSize();
    }

    public String getSize() {
        return String.format("Matrix size: rows - %s, columns -  %s", getRowsQuantity(), getColumnsQuantity());
    }

    public Vector getRow(int rowIndex) {
        return new Vector(vectors[rowIndex]);
    }

    public Vector getColumn(int columnIndex) {
        double[] tmp = new double[getColumnsQuantity()];

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

    public void scalarMultiply(double number) {
        for (Vector vector : vectors) {
            vector.scale(number);
        }
    }

    public double calculateDeterminant() {
        if (getRowsQuantity() != getColumnsQuantity()) {
            throw new IllegalArgumentException("Illegal matrix dimensions");
        }

        if (getRowsQuantity() == 1) {
            return this.vectors[0].getElementByIndex(0);
        }

        if (getRowsQuantity() == 2) {
            return vectors[0].getElementByIndex(0) * vectors[1].getElementByIndex(1) - vectors[1].getElementByIndex(0) * vectors[0].getElementByIndex(1);
        }

        double result = 0;

        for (int i = 0; i < getColumnsQuantity(); i++) {
            double[][] tmp = new double[getRowsQuantity() - 1][getColumnsQuantity() - 1];

            for (int j = 1; j < getRowsQuantity(); j++) {
                int columnIndex = 0;

                for (int n = 0; n < getRowsQuantity(); n++) {
                    if (n == i) {
                        continue;
                    }
                    tmp[j - 1][columnIndex] = vectors[j].getElementByIndex(n);
                    columnIndex++;
                }
            }
            result += Math.pow(-1, i) * vectors[0].getElementByIndex(i) * new Matrix(tmp).calculateDeterminant();
        }

        return result;
    }

    public Vector getVectorMultiply(Vector vector) {
        if (vector.getSize() != getColumnsQuantity()) {
            throw new IllegalArgumentException("Illegal matrix dimensions");
        }

        double[] result = new double[vectors.length];

        for (int i = 0; i < vectors.length; ++i) {
            for (int j = 0; j < vectors[i].getSize(); ++j) {
                result[i] += vectors[i].getElementByIndex(j) * vector.getElementByIndex(j);
            }
        }

        return new Vector(result);
    }

    public void add(Matrix matrix) {
        if (getRowsQuantity() != matrix.getRowsQuantity() || getColumnsQuantity() != matrix.getColumnsQuantity()) {
            throw new IllegalArgumentException("Illegal matrix dimensions");
        }

        for (int i = 0; i < vectors.length; ++i) {
            vectors[i].add(matrix.vectors[i]);
        }
    }

    public void subtract(Matrix matrix) {
        if (getRowsQuantity() != matrix.getRowsQuantity() || getColumnsQuantity() != matrix.getColumnsQuantity()) {
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
        if (matrix1.getColumnsQuantity() != matrix2.getRowsQuantity()) {
            throw new IllegalArgumentException("Illegal matrix dimensions");
        }

        double[][] multiplyResult = new double[matrix1.getRowsQuantity()][matrix2.getColumnsQuantity()];

        for (int i = 0; i < multiplyResult.length; ++i) {
            for (int j = 0; j < multiplyResult[i].length; ++j) {
                for (int k = 0; k < matrix1.vectors[0].getSize(); ++k) {
                    multiplyResult[i][j] += matrix1.vectors[i].getElementByIndex(k) * matrix2.vectors[k].getElementByIndex(j);
                }
            }
        }

        return new Matrix(multiplyResult);
    }
}
