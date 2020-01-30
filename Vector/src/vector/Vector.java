package vector;

import java.util.Arrays;

public class Vector {
    private int vectorSize;
    private double[] vectorDirection;

    public Vector(int vectorSize) {
        double[] tmp = new double[vectorSize];

        Arrays.fill(tmp, 0);

        this.vectorSize = vectorSize;
        this.vectorDirection = tmp;
    }

    public Vector(double[] vectorDirection) {
        this.vectorDirection = vectorDirection;
    }

    public Vector(double[] vectorDirection, int vectorSize) {
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

    public Vector(Vector v) {
        this(v.getVectorDirection(), v.getVectorSize());
    }

    @Override
    public String toString() {
        return Arrays.toString(vectorDirection);
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
        this.vectorSize = vectorSize;
    }
}
