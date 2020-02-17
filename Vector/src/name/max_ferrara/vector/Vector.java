package name.max_ferrara.vector;

import java.util.Arrays;

public class Vector {
    private double[] coordinates;

    public Vector(int length) {
        if (length < 1) {
            throw new IllegalArgumentException("vectorLength can not < 1");
        }

        coordinates = new double[length];
    }

    public Vector(double[] vectorCoordinates) {
        if (vectorCoordinates.length < 1) {
            throw new IllegalArgumentException("vectorLength can not < 1");
        }

        coordinates = Arrays.copyOf(vectorCoordinates, vectorCoordinates.length);
    }

    public Vector(int vectorLength, double[] vectorCoordinates) {
        if (vectorCoordinates.length < 1) {
            throw new IllegalArgumentException("vectorLength can not < 1");
        }

        double[] tmp = new double[vectorLength];

        coordinates = Arrays.copyOf(vectorCoordinates, tmp.length);
    }

    public Vector(Vector vector) {
        coordinates = Arrays.copyOf(vector.coordinates, vector.coordinates.length);
    }

    @Override
    public String toString() {
        StringBuilder formatCoordinates = new StringBuilder();

        for (double coordinate : coordinates) {
            formatCoordinates.append(coordinate).append(", ");
        }

        formatCoordinates.setLength(formatCoordinates.length() - 2);

        return "{ " + formatCoordinates.toString() + " }";
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

    public int getVectorLength() {
        return coordinates.length;
    }

    public double getElementIndex(int index) {
        return coordinates[index];
    }

    public void scale(double number) {
        for (int i = 0; i < coordinates.length; ++i) {
            coordinates[i] *= number;
        }
    }

    public void reverse() {
        scale(-1);
    }

    public double getLength() {
        double vectorLength = 0;

        for (double coordinate : coordinates) {
            vectorLength = vectorLength + Math.pow(coordinate, 2);
        }

        return Math.sqrt(vectorLength);
    }

    public void subtraction(Vector vector) {
        if (coordinates.length > vector.coordinates.length) {
            double[] tmp = new double[Math.max(coordinates.length, vector.coordinates.length)];
            vector.coordinates = Arrays.copyOf(vector.coordinates, tmp.length);

            for (int i = 0; i < coordinates.length; ++i) {
                coordinates[i] = coordinates[i] - vector.coordinates[i];
            }
        } else if (coordinates.length < vector.coordinates.length) {
            double[] tmp = new double[Math.max(coordinates.length, vector.coordinates.length)];
            coordinates = Arrays.copyOf(coordinates, tmp.length);

            for (int i = 0; i < coordinates.length; ++i) {
                coordinates[i] = coordinates[i] - vector.coordinates[i];
            }
        } else {
            for (int i = 0; i < coordinates.length; ++i) {
                coordinates[i] = coordinates[i] - vector.coordinates[i];
            }
        }
    }

    public void summarize(Vector vector) {
        if (coordinates.length > vector.coordinates.length) {
            double[] tmp = new double[Math.max(coordinates.length, vector.coordinates.length)];
            vector.coordinates = Arrays.copyOf(vector.coordinates, tmp.length);

            for (int i = 0; i < coordinates.length; ++i) {
                coordinates[i] = coordinates[i] + vector.coordinates[i];
            }
        } else if (coordinates.length < vector.coordinates.length) {
            double[] tmp = new double[Math.max(coordinates.length, vector.coordinates.length)];
            coordinates = Arrays.copyOf(coordinates, tmp.length);

            for (int i = 0; i < coordinates.length; ++i) {
                coordinates[i] = coordinates[i] + vector.coordinates[i];
            }
        } else {
            for (int i = 0; i < coordinates.length; ++i) {
                coordinates[i] = coordinates[i] + vector.coordinates[i];
            }
        }
    }

    public static double getScalarComposition(Vector vector1, Vector vector2) {
        if (vector1.coordinates.length > vector2.coordinates.length) {
            double[] tmp = new double[Math.max(vector1.coordinates.length, vector2.coordinates.length)];
            vector2.coordinates = Arrays.copyOf(vector2.coordinates, tmp.length);

            for (int i = 0; i < tmp.length; ++i) {
                tmp[i] = vector1.coordinates[i] * vector2.coordinates[i];
            }

            return Arrays.stream(tmp).sum();
        }

        if (vector1.coordinates.length < vector2.coordinates.length) {
            double[] tmp = new double[Math.max(vector1.coordinates.length, vector2.coordinates.length)];
            vector1.coordinates = Arrays.copyOf(vector1.coordinates, tmp.length);

            for (int i = 0; i < tmp.length; ++i) {
                tmp[i] = vector1.coordinates[i] * vector2.coordinates[i];
            }

            return Arrays.stream(tmp).sum();
        }

        double[] tmp = new double[vector1.coordinates.length];

        for (int i = 0; i < tmp.length; ++i) {
            tmp[i] = vector1.coordinates[i] * vector2.coordinates[i];

        }

        return Arrays.stream(tmp).sum();
    }

    public static Vector getSum(Vector vector1, Vector vector2) {
        vector1.summarize(vector2);

        return new Vector(vector1);
    }

    public static Vector getDifference(Vector vector1, Vector vector2) {
        vector1.subtraction(vector2);

        return new Vector(vector1);
    }
}
