package name.max_ferrara.matrix;

import name.max_ferrara.vector.Vector;

import java.util.Arrays;

public class Matrix {
    private int stringsQuantity;
    private int columnsQuantity;
    private double[][] matrixCoordinates;

    public Matrix(int stringsQuantity, int columnsQuantity) {
        double[][] tmp = new double[stringsQuantity][columnsQuantity];

        for (int i = 0; i < tmp.length; ++i) {
            for (int j = 0; j < tmp[i].length; ++j) {
                tmp[i][j] = 0;
            }
        }

        this.stringsQuantity = stringsQuantity;
        this.columnsQuantity = columnsQuantity;
        this.matrixCoordinates = tmp;
    }

    public Matrix(double[][] matrixCoordinates) {
        this.matrixCoordinates = matrixCoordinates;
    }

    public Matrix(Vector[] vector) {
        double[][] tmp = new double[][ vector.length];
    }

    public Matrix(Matrix matrix) {
        stringsQuantity = matrix.stringsQuantity;
        columnsQuantity = matrix.columnsQuantity;
        matrixCoordinates = matrix.matrixCoordinates;
    }

    @Override
    public String toString() {
        return Arrays.deepToString(matrixCoordinates);
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

        return stringsQuantity == matrix.stringsQuantity && columnsQuantity == matrix.columnsQuantity && Arrays.equals(matrixCoordinates, matrix.matrixCoordinates);
    }

    @Override
    public int hashCode() {
        final int prime = 21;
        int hash = 1;

        hash = prime * hash + columnsQuantity;
        hash = prime * hash + stringsQuantity;
        hash = prime * hash + Arrays.hashCode(matrixCoordinates);
        return hash;
    }
}
