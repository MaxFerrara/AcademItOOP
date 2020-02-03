package vector;

import java.util.Arrays;

public class Vector {
    private int vectorSize;
    private double[] vectorDirection;

    public Vector(int vectorSize) {
        if (vectorSize < 0) {
            throw new IllegalArgumentException("vectorSize can not < zero");
        }

        double[] tmp = new double[vectorSize];

        Arrays.fill(tmp, 0);

        this.vectorSize = vectorSize;
        this.vectorDirection = tmp;
    }

    public Vector(double[] vectorDirection) {
        this.vectorDirection = vectorDirection;
    }

    public Vector(double[] vectorDirection, int vectorSize) {
        if (vectorSize < 0) {
            throw new IllegalArgumentException("vectorSize can not < zero");
        }

        double[] tmp = new double[vectorSize];
        int lengthValue = tmp.length - vectorDirection.length;

        for (int i = 0; i < tmp.length - lengthValue; i++) {
            if (tmp[i] > vectorDirection.length) {
                tmp[i] = 0;
            }

            tmp[i] = vectorDirection[i];
        }

        this.vectorSize = vectorSize;
        this.vectorDirection = tmp;
    }

    public Vector(Vector vector) {
        this.vectorSize = vector.vectorSize;
        this.vectorDirection = vector.vectorDirection;
    }

    public double[] getVectorDirection() {
        return vectorDirection;
    }

    public void setVectorDirection(double[] vectorDirection) {
        this.vectorDirection = vectorDirection;
    }

    public int getVectorSize() {
        return vectorSize;
    }

    public void setVectorSize(int vectorSize) {
        if (vectorSize < 0) {
            throw new IllegalArgumentException("vectorSize can not < zero");
        }

        this.vectorSize = vectorSize;
    }

    @Override
    public String toString() {
        return Arrays.toString(vectorDirection);
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }

        if (object == null || object.getClass() != this.getClass()) {
            return false;
        }

        Vector vector = (Vector) object;

        return vectorSize == vector.vectorSize && Arrays.equals(vectorDirection, vector.vectorDirection);
    }

    @Override
    public int hashCode() {
        final int prime = 21;
        int hash = 1;

        hash *= prime + vectorSize;
        hash *= prime + Arrays.stream(vectorDirection).sum();
        return hash;
    }

    public double getElementIndex(int index) {
        return vectorDirection[index];
    }

    public int getLength() {
        return vectorDirection.length;
    }

    public double[] reverse() {
        for (int i = 0; i < vectorDirection.length; ++i) {
            vectorDirection[i] *= -1;
        }

        return vectorDirection;
    }

    public double[] getScalar(int number) {
        for (int i = 0; i < vectorDirection.length; ++i) {
            vectorDirection[i] *= number;
        }

        return vectorDirection;
    }

    public static Vector getSum(Vector vector1, Vector vector2) {
        //int arrLength = Math.max(vector1.vectorSize, vector2.vectorSize);
        double[] tmp = new double[vector1.vectorDirection.length];

        for (int i = 0; i < tmp.length; ++i) {
            tmp[i] = vector1.vectorDirection[i] + vector2.vectorDirection[i];
        }

        return new Vector(tmp);
    }

    public static Vector getDifference(Vector vector1, Vector vector2) {
        //int arrLength = Math.max(vector1.vectorSize, vector2.vectorSize);
        double[] tmp = new double[vector1.vectorDirection.length];

        for (int i = 0; i < tmp.length; ++i) {
            tmp[i] = vector1.vectorDirection[i] - vector2.vectorDirection[i];
        }

        return new Vector(tmp);
    }

    public static Vector getScalarComposition(Vector vector1, Vector vector2) {
        //int arrLength = Math.max(vector1.vectorSize, vector2.vectorSize);
        double[] tmp = new double[vector1.vectorDirection.length];

        for (int i = 0; i < tmp.length; ++i) {
            tmp[i] = vector1.vectorDirection[i] * vector2.vectorDirection[i];
        }

        return new Vector(tmp);
    }

    public Vector getSumVec(Vector vector) {
        double[] tmp = new double[Math.max(vectorDirection.length, vector.vectorDirection.length)];
        int lengthDiff = Math.max(vectorDirection.length, vector.vectorDirection.length) - Math.min(vectorDirection.length, vector.vectorDirection.length);

        for (int i = 0; i < tmp.length - lengthDiff; ++i) {
            if (tmp[i] > Math.min(vectorDirection.length, vector.vectorDirection.length)) {
                if (vectorDirection.length > vector.vectorDirection.length) {
                    tmp[i] = vectorDirection[i];
                } else {
                    tmp[i] = vector.vectorDirection[i];
                }
            }

            tmp[i] = vectorDirection[i] + vector.vectorDirection[i];
        }

        return new Vector(tmp);
    }

    public Vector getDiffVec(Vector vector) {
        double[] tmp = new double[Math.max(vectorDirection.length, vector.vectorDirection.length)];

        for (int i = 0; i < tmp.length; ++i) {
            if (tmp[i] > Math.min(vectorDirection.length, vector.vectorDirection.length)) {
                tmp[i] = 0;
            }

            tmp[i] = vectorDirection[i] - vector.vectorDirection[i];
        }

        return new Vector(tmp);
    }
}