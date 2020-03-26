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

    public Matrix(double[][] array) {
        if (array.length < 1) {
            throw new IllegalArgumentException("Illegal matrix dimensions");
        }

        int maxLength = 0;

        for (double[] doubles : array) {
            if (doubles.length > maxLength) {
                maxLength = doubles.length;
            }
        }

        if (maxLength < 1) {
            throw new IllegalArgumentException("Illegal matrix dimensions");
        }

        vectors = new Vector[array.length];

        for (int i = 0; i < vectors.length; ++i) {
            vectors[i] = new Vector(maxLength, array[i]);
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

        Vector vector = new Vector(maxLength);

        for (int i = 0; i < vectors.length; ++i) {
            vectors[i] = Vector.getSum(vectors[i], vector);
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
        StringBuilder stringBuilder = new StringBuilder("{ ");

        for (Vector vector : vectors) {
            stringBuilder.append(vector);
            stringBuilder.append(", ");
        }

        stringBuilder.setLength(stringBuilder.length() - 2);
        stringBuilder.append(" }");

        return stringBuilder.toString();
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

    public void setRow(int rowIndex, double[] array) {
        if (array.length != getColumnsQuantity()) {
            throw new IllegalArgumentException("Illegal row length");
        }

        if (rowIndex >= getRowsQuantity() || rowIndex < 0) {
            throw new IndexOutOfBoundsException("invalid argument value");
        }

        vectors[rowIndex] = new Vector(array);
    }

    public int getRowsQuantity() {
        return vectors.length;
    }

    public int getColumnsQuantity() {
        return vectors[0].getSize();
    }

    public Vector getRow(int rowIndex) {
        if (rowIndex < 0 || rowIndex >= getRowsQuantity()) {
            throw new IndexOutOfBoundsException("invalid index value");
        }

        return new Vector(vectors[rowIndex]);
    }

    public Vector getColumn(int columnIndex) {
        if (columnIndex < 0 || columnIndex >= getColumnsQuantity()) {
            throw new IndexOutOfBoundsException("invalid index value");
        }

        double[] tmp = new double[getRowsQuantity()];

        for (int i = 0; i < vectors.length; ++i) {
            tmp[i] = vectors[i].getElementByIndex(columnIndex);
        }

        return new Vector(tmp);
    }

    public void transpose() {
        Vector[] tmp = new Vector[getColumnsQuantity()];

        for (int i = 0; i < getColumnsQuantity(); ++i) {
            tmp[i] = getColumn(i);
        }

        vectors = tmp;
    }

    public void multiplyOnScalar(double number) {
        for (Vector vector : vectors) {
            vector.scale(number);
        }
    }

    public double calculateDeterminant() {
        if (getRowsQuantity() != getColumnsQuantity()) {
            throw new IllegalArgumentException("Illegal matrix dimensions");
        }

        if (getRowsQuantity() == 1) {
            return vectors[0].getElementByIndex(0);
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
        if (vector.getSize() != this.getColumnsQuantity()) {
            throw new IllegalArgumentException("Illegal matrix dimensions");
        }

        Vector resultVector = new Vector(vectors.length);

        for (int i = 0; i < vectors.length; ++i) {
            for (int j = 0; j < vectors[i].getSize(); ++j) {
                resultVector.setElementByIndex(i, Vector.getScalarComposition(vectors[i], vector));
            }
        }

        return resultVector;
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
        if (matrix1.getRowsQuantity() != matrix2.getRowsQuantity() || matrix1.getColumnsQuantity() != matrix2.getColumnsQuantity()) {
            throw new IllegalArgumentException("Illegal matrix dimensions");
        }

        Matrix cloneMatrix = new Matrix(matrix1);
        cloneMatrix.add(matrix2);

        return cloneMatrix;
    }

    public static Matrix getDiff(Matrix matrix1, Matrix matrix2) {
        if (matrix1.getRowsQuantity() != matrix2.getRowsQuantity() || matrix1.getColumnsQuantity() != matrix2.getColumnsQuantity()) {
            throw new IllegalArgumentException("Illegal matrix dimensions");
        }

        Matrix cloneMatrix = new Matrix(matrix1);
        cloneMatrix.subtract(matrix2);

        return cloneMatrix;
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
