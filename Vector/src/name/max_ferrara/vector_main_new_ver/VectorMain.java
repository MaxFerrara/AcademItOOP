package name.max_ferrara.vector_main_new_ver;

import name.max_ferrara.vector_new_ver.Vector;

public class VectorMain {
    public static void main(String[] args) {
        Vector vector1 = new Vector(5);
        Vector vector2 = new Vector(new double[]{10, 4, 13, 9.65, 3, 14});
        Vector vector3 = new Vector(8, new double[]{1, 2, 3, 4, 5});
        Vector vector4 = new Vector(new double[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});

        System.out.println(vector1);
        System.out.println(vector2);
        System.out.println(vector3);
        System.out.println(vector2.getLength());
        vector1.scaling(1.5);
        vector4.getSum(vector2);
        System.out.println(vector4);
    }
}
