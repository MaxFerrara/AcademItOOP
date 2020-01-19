import java.util.Arrays;

public class VectorTest {
    public static void main(String[] args) {
        Vector vector = new Vector(7);
        Vector vector1 = new Vector(new double[]{10, 4, 13, 9.65, 3, 14});

        System.out.println(vector);
        System.out.println(vector.toString());
        System.out.println(vector1.toString());
    }
}
