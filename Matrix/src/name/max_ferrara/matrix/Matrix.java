package name.max_ferrara.matrix;

import name.max_ferrara.vector.Vector;

import java.util.Arrays;

public class Matrix {
    private Vector[] vectors;

    public Matrix(int rowsQuantity, int columnsQuantity) {
        if (rowsQuantity < 1 || columnsQuantity < 1) {
            throw new IllegalArgumentException("matrix can't has size < zero");
        }

        vectors = new Vector[rowsQuantity];

        for (int i = 0; i < vectors.length; ++i) {
            vectors[i] = new Vector(columnsQuantity);
        }
    }

    public Matrix(double[][] array) {
        if (array.length < 1) {
            throw new IllegalArgumentException("rows quantity can't be < zero");
        }

        int maxLength = 0;

        for (double[] doubles : array) {
            if (doubles.length > maxLength) {
                maxLength = doubles.length;
            }
        }

        if (maxLength < 1) {
            throw new IllegalArgumentException("columns quantity can't be < zero");
        }

        vectors = new Vector[array.length];

        for (int i = 0; i < vectors.length; ++i) {
            vectors[i] = new Vector(maxLength, array[i]);
        }
    }

    public Matrix(Vector... vectors) {
        if (vectors.length < 1) {
            throw new IllegalArgumentException("matrix can't has size < zero");
        }

        int maxLength = 0;

        for (Vector vector : vectors) {
            if (maxLength < vector.getSize()) {
                maxLength = vector.getSize();
            }
        }

        this.vectors = new Vector[vectors.length];

        for (int i = 0; i < vectors.length; ++i) {
            this.vectors[i] = new Vector(maxLength);
            this.vectors[i].add(vectors[i]);
        }
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

    public int getRowsQuantity() {
        return vectors.length;
    }

    public int getColumnsQuantity() {
        return vectors[0].getSize();
    }

    public void setRow(int rowIndex, Vector vector) {
        if (vector.getSize() != getColumnsQuantity()) {
            throw new IllegalArgumentException("vector's length is invalid");
        }

        if (rowIndex >= getRowsQuantity() || rowIndex < 0) {
            throw new IndexOutOfBoundsException("out of bounds");
        }

        Vector newRow = new Vector(vector);

        vectors[rowIndex] = newRow;
    }

    public Vector getRow(int rowIndex) {
        if (rowIndex < 0 || rowIndex >= getRowsQuantity()) {
            throw new IndexOutOfBoundsException("out of bound");
        }

        return new Vector(vectors[rowIndex]);
    }

    public Vector getColumn(int columnIndex) {
        if (columnIndex < 0 || columnIndex >= getColumnsQuantity()) {
            throw new IndexOutOfBoundsException("out of bound");
        }

        Vector column = new Vector(getRowsQuantity());

        for (int i = 0; i < vectors.length; ++i) {
            column.setElementByIndex(i, vectors[i].getElementByIndex(columnIndex));
        }

        return column;
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
            throw new IllegalArgumentException("quantity of rows and columns should be equal");
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

    public Vector getMultiply(Vector vector) {
        if (vector.getSize() != getColumnsQuantity()) {
            throw new IllegalArgumentException("vector length and quantity of columns should be equal");
        }

        Vector resultVector = new Vector(vectors.length);

        for (int i = 0; i < vectors.length; ++i) {
            resultVector.setElementByIndex(i, Vector.getScalarComposition(vectors[i], vector));
        }

        return resultVector;
    }

    private static void checkMatrixSizes(int firstMatrixRowsQuantity, int secondMatrixRowsQuantity, int firstMatrixColumnsQuantity, int secondMatrixColumnsQuantity) {
        if (firstMatrixRowsQuantity != secondMatrixRowsQuantity) {
            throw new IllegalArgumentException("first matrix's rows: " + firstMatrixRowsQuantity + " should be equals second matrix's rows: " + secondMatrixRowsQuantity);
        }

        if (firstMatrixColumnsQuantity != secondMatrixColumnsQuantity) {
            throw new IllegalArgumentException("first matrix's columns: " + firstMatrixColumnsQuantity + " should be equals second matrix's columns: " + secondMatrixColumnsQuantity);
        }
    }

    public void add(Matrix matrix) {
        checkMatrixSizes(getRowsQuantity(), matrix.getRowsQuantity(), getColumnsQuantity(), matrix.getColumnsQuantity());

        for (int i = 0; i < vectors.length; ++i) {
            vectors[i].add(matrix.vectors[i]);
        }
    }

    public void subtract(Matrix matrix) {
        checkMatrixSizes(getRowsQuantity(), matrix.getRowsQuantity(), getColumnsQuantity(), matrix.getColumnsQuantity());

        for (int i = 0; i < vectors.length; ++i) {
            vectors[i].subtract(matrix.vectors[i]);
        }
    }

    public static Matrix getSum(Matrix matrix1, Matrix matrix2) {
        checkMatrixSizes(matrix1.getRowsQuantity(), matrix2.getRowsQuantity(), matrix1.getColumnsQuantity(), matrix2.getColumnsQuantity());

        Matrix cloneMatrix = new Matrix(matrix1);
        cloneMatrix.add(matrix2);

        return cloneMatrix;
    }

    public static Matrix getDiff(Matrix matrix1, Matrix matrix2) {
        checkMatrixSizes(matrix1.getRowsQuantity(), matrix2.getRowsQuantity(), matrix1.getColumnsQuantity(), matrix2.getColumnsQuantity());

        Matrix cloneMatrix = new Matrix(matrix1);
        cloneMatrix.subtract(matrix2);

        return cloneMatrix;
    }

    public static Matrix getComposition(Matrix matrix1, Matrix matrix2) {
        if (matrix1.getColumnsQuantity() != matrix2.getRowsQuantity()) {
            throw new IllegalArgumentException("first matrix's columns should be equals second matrix's rows");
        }

        double[][] multiplyResult = new double[matrix1.getRowsQuantity()][matrix2.getColumnsQuantity()];

        for (int i = 0; i < multiplyResult.length; ++i) {
            for (int j = 0; j < multiplyResult[i].length; ++j) {
                for (int k = 0; k < matrix1.getColumnsQuantity(); ++k) {
                    multiplyResult[i][j] += matrix1.vectors[i].getElementByIndex(k) * matrix2.vectors[k].getElementByIndex(j);
                }
            }
        }

        return new Matrix(multiplyResult);
    }
}
