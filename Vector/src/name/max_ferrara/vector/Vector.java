package name.max_ferrara.vector;

import java.util.Arrays;

public class Vector {
    private double[] coordinates;

    public Vector(int length) {
        if (length < 1) {
            throw new IllegalArgumentException("vectorLength can not be < 1");
        }

        coordinates = new double[length];
    }

    public Vector(double[] coordinates) {
        if (coordinates.length < 1) {
            throw new IllegalArgumentException("vectorLength can not be < 1");
        }

        this.coordinates = Arrays.copyOf(coordinates, coordinates.length);
    }

    public Vector(int length, double[] coordinates) {
        if (length < 1) {
            throw new IllegalArgumentException("vectorLength can not be < 1");
        }

        this.coordinates = Arrays.copyOf(coordinates, length);
    }

    public Vector(Vector vector) {
        coordinates = Arrays.copyOf(vector.coordinates, vector.coordinates.length);
    }

    @Override
    public String toString() {
        StringBuilder formatCoordinates = new StringBuilder("{  }");

        for (double coordinate : coordinates) {
            formatCoordinates.insert(formatCoordinates.length() - 2, coordinate + ", ");
        }

        formatCoordinates.delete(formatCoordinates.length() - 4, formatCoordinates.length() - 2);

        return formatCoordinates.toString();
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

    public int getSize() {
        return coordinates.length;
    }

    public double getElementByIndex(int index) {
        if (index >= coordinates.length && index <= coordinates.length) {
            throw new ArrayIndexOutOfBoundsException("index can't be > or < vector size");
        }

        return coordinates[index];
    }

    public void setElementByIndex(int index, double coordinate) {
        if (index >= coordinates.length && index <= coordinates[0]) {
            throw new ArrayIndexOutOfBoundsException("index can't be > or < vector size");
        }

        coordinates[index] = coordinate;
    }

    public void scale(double number) {
        for (int i = 0; i < coordinates.length; ++i) {
            coordinates[i] *= number;
        }
    }

    public void reverse() {
        scale(-1);
    }

    public double getModule() {
        double length = 0;

        for (double coordinate : coordinates) {
            length += Math.pow(coordinate, 2);
        }

        return Math.sqrt(length);
    }

    public void subtract(Vector vector) {
        int maxLength = Math.max(coordinates.length, vector.coordinates.length);

        for (int i = 0; i < maxLength; ++i) {
            if (maxLength >= coordinates.length) {
                coordinates = Arrays.copyOf(coordinates, maxLength);
            }

            if (maxLength >= vector.coordinates.length) {
                vector.coordinates = Arrays.copyOf(vector.coordinates, maxLength);
            }

            coordinates[i] = coordinates[i] - vector.coordinates[i];
        }
    }

    public void add(Vector vector) {
        int maxLength = Math.max(coordinates.length, vector.coordinates.length);

        for (int i = 0; i < maxLength; ++i) {
            if (maxLength >= coordinates.length) {
                coordinates = Arrays.copyOf(coordinates, maxLength);
            }

            if (maxLength >= vector.coordinates.length) {
                vector.coordinates = Arrays.copyOf(vector.coordinates, maxLength);
            }

            coordinates[i] = coordinates[i] + vector.coordinates[i];
        }
    }

    public static double getScalarComposition(Vector vector1, Vector vector2) {
        double scalarComposition = 0;
        int length = Math.min(vector1.coordinates.length, vector2.coordinates.length);

        for (int i = 0; i < length; ++i) {
            scalarComposition += vector1.coordinates[i] * vector2.coordinates[i];
        }

        return scalarComposition;
    }

    public static Vector getSum(Vector vector1, Vector vector2) {
        Vector cloneVector = new Vector(vector1);
        cloneVector.add(vector2);

        return cloneVector;
    }

    public static Vector getDifference(Vector vector1, Vector vector2) {
        Vector cloneVector = new Vector(vector1);
        cloneVector.subtract(vector2);

        return cloneVector;
    }

    public double[] toArray() {
        return Arrays.copyOf(coordinates, coordinates.length);
    }
}
