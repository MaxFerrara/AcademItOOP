import vector.Vector;

import java.util.Arrays;

public class VectorMain {
    public static void main(String[] args) {
        try {
            Vector vector = new Vector(6);
            Vector vector1 = new Vector(new double[]{10, 4, 13, 9.65, 3, 14});
            Vector vector3 = new Vector(new double[]{-4, 25, 2.5, 0, 135, 27, 5, 9, 15, 56});
            Vector vector2 = new Vector(new double[]{10, 4, 13, 9.65, 3, 14}, 10);
            Vector cloneVector = new Vector(vector);

        /*System.out.println(vector);
        System.out.println(vector1);
        System.out.println(vector2);
        System.out.println(cloneVector);

        System.out.println(vector.equals(vector2));
        System.out.println(vector1.hashCode());

        System.out.println(vector1.getElementIndex(3));
        System.out.println(vector1.getLength());
        System.out.println(Arrays.toString(vector1.reverse()));
        System.out.println(Arrays.toString(vector1.getScalar(2))); */


            /*System.out.println(Vector.getSum(vector1, vector3));
            System.out.println(Vector.getDifference(vector1, vector3));
            System.out.println(Vector.getScalarComposition(vector1, vector3));
            System.out.println();
            System.out.println(vector1.getDiffVec(vector3));

             */
            System.out.println(vector1.getSumVec(vector3));
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}
