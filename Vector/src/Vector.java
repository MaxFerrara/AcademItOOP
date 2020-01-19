import java.util.Arrays;

public class Vector {
    private int vectorSize;
    private double[] vector;

    public Vector(int vectorSize) {
        double[] tmp = new double[vectorSize];

        Arrays.fill(tmp, 0);

        this.vectorSize = vectorSize;
        this.vector = tmp;
    }

    public Vector(double[] vector) {
        this.vector = vector;
    }

    public Vector(double[] vector, int vectorSize) {

    }

    @Override
    public String toString() {
        return Arrays.toString(vector);
    }
}
