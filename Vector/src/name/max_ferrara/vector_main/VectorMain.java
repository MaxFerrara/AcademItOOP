package name.max_ferrara.vector_main;

import name.max_ferrara.vector.Vector;

public class VectorMain {
    public static void main(String[] args) {
        try {
            Vector vector1 = new Vector(6);
            Vector vector2 = new Vector(new double[]{10, 4, 13, 9.65, 3, 14});
            Vector vector3 = new Vector(new double[]{-4, 25, 2.5, 0, 135, 27, 5, 9, 15, 56});
            Vector vector4 = new Vector(10, new double[]{10, 4, 13, 9.65, 3, 14});
            Vector cloneVector = new Vector(vector2);

            System.out.println(vector1);
            System.out.println(vector2);
            System.out.println(vector3);
            System.out.println(vector4);
            System.out.println(cloneVector);
            System.out.println();

            System.out.println(vector1.equals(vector2));
            System.out.println(vector2.hashCode());
            System.out.println();

            System.out.println(vector2.getElementByIndex(3));
            System.out.println(vector3.getLength());
            vector2.reverse();
            System.out.println(vector2);
            vector2.scale(1.25);
            System.out.println(vector2);
            System.out.println();

            System.out.println(Vector.getSum(vector1, vector3));
            System.out.println(Vector.getDifference(vector1, vector3));
            System.out.println(Vector.getScalarComposition(vector2, vector3));
            System.out.println();

            vector1.subtract(vector3);
            vector2.add(vector3);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}
