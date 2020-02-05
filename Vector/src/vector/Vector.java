package vector;

import java.util.Arrays;

public class Vector {
    private int vectorSize;
    private double[] vectorCoordinates;

    public Vector(int vectorSize) {
        if (vectorSize < 0) {
            throw new IllegalArgumentException("vectorSize can not < zero");
        }

        double[] tmp = new double[vectorSize];

        Arrays.fill(tmp, 0);

        this.vectorSize = vectorSize;
        this.vectorCoordinates = tmp;
    }

    public Vector(double[] vectorCoordinates) {
        this.vectorCoordinates = vectorCoordinates;
    }

    public Vector(double[] vectorCoordinates, int vectorSize) {
        if (vectorSize < 0) {
            throw new IllegalArgumentException("vectorSize can not < zero");
        }

        double[] tmp = new double[vectorSize];
        int lengthValue = tmp.length - vectorCoordinates.length;

        for (int i = 0; i < tmp.length - lengthValue; i++) {
            if (tmp[i] > vectorCoordinates.length) {
                tmp[i] = 0;
            }

            tmp[i] = vectorCoordinates[i];
        }

        this.vectorSize = vectorSize;
        this.vectorCoordinates = tmp;
    }

    public Vector(Vector vector) {
        this.vectorSize = vector.vectorSize;
        this.vectorCoordinates = vector.vectorCoordinates;
    }

    public double[] getVectorCoordinates() {
        return vectorCoordinates;
    }

    public void setVectorCoordinates(double[] vectorCoordinates) {
        this.vectorCoordinates = vectorCoordinates;
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
        return Arrays.toString(vectorCoordinates);
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

        return vectorSize == vector.vectorSize && Arrays.equals(vectorCoordinates, vector.vectorCoordinates);
    }

    @Override
    public int hashCode() {
        final int prime = 21;
        int hash = 1;

        hash *= prime + vectorSize;
        hash *= prime + Arrays.stream(vectorCoordinates).sum();
        return hash;
    }

    public double getElementIndex(int index) {
        return vectorCoordinates[index];
    }

    public int getLength() {
        return vectorCoordinates.length;
    }

    public double[] reverse() {
        for (int i = 0; i < vectorCoordinates.length; ++i) {
            vectorCoordinates[i] *= -1;
        }

        return vectorCoordinates;
    }

    public double[] getScalar(int number) {
        for (int i = 0; i < vectorCoordinates.length; ++i) {
            vectorCoordinates[i] *= number;
        }

        return vectorCoordinates;
    }

    public static Vector getSum(Vector vector1, Vector vector2) {
        double[] vectorsSum = new double[Math.max(vector1.vectorCoordinates.length, vector2.vectorCoordinates.length)];

        for (int i = 0; i < vectorsSum.length; ++i) {
            vectorsSum[i] = 0;

            if (i >= Math.min(vector1.vectorCoordinates.length, vector2.vectorCoordinates.length)) {
                vectorsSum[i] = getMaxLengthVector(vector1.vectorCoordinates, vector2.vectorCoordinates)[i];
            } else {
                vectorsSum[i] = vector1.vectorCoordinates[i] + vector2.vectorCoordinates[i];
            }
        }

        return new Vector(vectorsSum);
    }

    public static Vector getDifference(Vector vector1, Vector vector2) {
        double[] vectorsDifference = new double[Math.max(vector1.vectorCoordinates.length, vector2.vectorCoordinates.length)];

        for (int i = 0; i < vectorsDifference.length; ++i) {
            vectorsDifference[i] = 0;

            if (i >= Math.min(vector1.vectorCoordinates.length, vector2.vectorCoordinates.length)) {
                vectorsDifference[i] = -getMaxLengthVector(vector1.vectorCoordinates, vector2.vectorCoordinates)[i];
            } else {
                vectorsDifference[i] = vector1.vectorCoordinates[i] - vector2.vectorCoordinates[i];
            }
        }

        return new Vector(vectorsDifference);
    }

    public static Vector getScalarComposition(Vector vector1, Vector vector2) {
        double[] vectorsScalarComposition = new double[Math.max(vector1.vectorCoordinates.length, vector2.vectorCoordinates.length)];

        for (int i = 0; i < vectorsScalarComposition.length; ++i) {
            vectorsScalarComposition[i] = 0;

            if (i >= Math.min(vector1.vectorCoordinates.length, vector2.vectorCoordinates.length)) {
                vectorsScalarComposition[i] = 0 * getMaxLengthVector(vector1.vectorCoordinates, vector2.vectorCoordinates)[i];
            } else {
                vectorsScalarComposition[i] = vector1.vectorCoordinates[i] * vector2.vectorCoordinates[i];
            }
        }

        return new Vector(vectorsScalarComposition);
    }

    public Vector getSum(Vector vector) {
        double[] vectorsSum = new double[Math.max(vectorCoordinates.length, vector.vectorCoordinates.length)];

        for (int i = 0; i < vectorsSum.length; ++i) {
            vectorsSum[i] = 0;

            if (i >= Math.min(vectorCoordinates.length, vector.vectorCoordinates.length)) {
                vectorsSum[i] = getMaxLengthVector(vectorCoordinates, vector.vectorCoordinates)[i];
            } else {
                vectorsSum[i] = vectorCoordinates[i] + vector.vectorCoordinates[i];
            }
        }

        return new Vector(vectorsSum);
    }

    public Vector getDifference(Vector vector) {
        double[] vectorsDifference = new double[Math.max(vectorCoordinates.length, vector.vectorCoordinates.length)];


        for (int i = 0; i < vectorsDifference.length; ++i) {
            vectorsDifference[i] = 0;

            if (i >= Math.min(vectorCoordinates.length, vector.vectorCoordinates.length)) {
                vectorsDifference[i] = -getMaxLengthVector(vectorCoordinates, vector.vectorCoordinates)[i];
            } else {
                vectorsDifference[i] = vectorCoordinates[i] - vector.vectorCoordinates[i];
            }
        }

        return new Vector(vectorsDifference);
    }

    private static double[] getMaxLengthVector(double[] vectorDirection1, double[] vectorDirection2) {
        return (vectorDirection1.length > vectorDirection2.length) ? vectorDirection1 : vectorDirection2;
    }
}
