package name.max_ferrara.vector_new_ver;

import java.util.Arrays;

public class Vector {
    private double[] coordinates;

    public Vector(int length) {
        if (length < 1) {
            throw new IllegalArgumentException("vectorSize can not < 1");
        }

        coordinates = new double[length];
    }

    public Vector(double[] vectorCoordinates) {
        if (vectorCoordinates.length < 1) {
            throw new IllegalArgumentException("vectorSize can not < 1");
        }

        coordinates = Arrays.copyOf(vectorCoordinates, vectorCoordinates.length);
    }

    public Vector(int vectorSize, double[] vectorCoordinates) {
        if (vectorCoordinates.length < 1) {
            throw new IllegalArgumentException("vectorSize can not < 1");
        }

        double[] tmp = new double[vectorSize];

        coordinates = Arrays.copyOf(vectorCoordinates, tmp.length);
    }

    public Vector(Vector vector) {
        coordinates = Arrays.copyOf(vector.coordinates, vector.coordinates.length);
    }

    @Override
    public String toString() {
        return Arrays.toString(coordinates);
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }

        if (object == null || object.getClass() != getClass()) {
            return false;
        }

        Vector vector = (Vector) object;

        return Arrays.equals(coordinates, vector.coordinates);
    }

    @Override
    public int hashCode() {
        final int prime = 21;
        int hash = 1;

        hash = prime * hash + Arrays.hashCode(coordinates);
        return hash;
    }

    public double getElementIndex(int index) {
        return coordinates[index];
    }

    public void scaling(double number) {
        for (int i = 0; i < coordinates.length; ++i) {
            coordinates[i] *= number;
        }
    }

    public void reverse() {
        scaling(-1);
    }

    public double getLength() {
        double vectorLength = 0;

        for (int i = 0; i < coordinates.length; ++i) {
            vectorLength = vectorLength + Math.pow(coordinates[i], 2);
        }

        return Math.sqrt(vectorLength);
    }

    public void getSum(Vector vector) {
        if (coordinates.length > vector.coordinates.length) {
            double[] tmp = new double[Math.max(coordinates.length, vector.coordinates.length)];
            vector.coordinates = Arrays.copyOf(vector.coordinates, tmp.length);

            for (int i = 0; i < coordinates.length; ++i) {
                coordinates[i] = coordinates[i] + vector.coordinates[i];
            }
        }

        if (coordinates.length < vector.coordinates.length) {
            double[] tmp = new double[Math.max(coordinates.length, vector.coordinates.length)];
            coordinates = Arrays.copyOf(coordinates, tmp.length);

            for (int i = 0; i < coordinates.length; ++i) {
                coordinates[i] = coordinates[i] + vector.coordinates[i];
            }
        }

        for (int i = 0; i < coordinates.length; ++i) {
            coordinates[i] = coordinates[i] + vector.coordinates[i];
        }
    }

    private static double[] getMaxLengthVector(double[] vectorDirection1, double[] vectorDirection2) {
        return (vectorDirection1.length > vectorDirection2.length) ? vectorDirection1 : vectorDirection2;
    }
}
