import vector.Vector;

import java.util.Arrays;

public class VectorMain {
    public static void main(String[] args) {
        Vector vector = new Vector(7);
        Vector vector1 = new Vector(new double[]{10, 4, 13, 9.65, 3, 14});
        Vector vector2 = new Vector(new double[]{10, 4, 13, 9.65, 3, 14}, 10);
        Vector cloneVector = new Vector(vector);

        /*System.out.println(vector);
        System.out.println(vector1);
        System.out.println(vector2);
        System.out.println(cloneVector);

        System.out.println(vector.equals(vector2));
        System.out.print(vector1.hashCode()); */

        System.out.println(vector1.getElementIndex(3));
        System.out.println(vector1.getLength());
        System.out.println(Arrays.toString(vector1.reverse()));
        System.out.println(Arrays.toString(vector1.getScalar(2)));
    }
}
