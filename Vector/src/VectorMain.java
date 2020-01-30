import vector.Vector;

public class VectorMain {
    public static void main(String[] args) {
        Vector vector = new Vector(7);
        Vector vector1 = new Vector(new double[]{10, 4, 13, 9.65, 3, 14});
        Vector vector2 = new Vector(new double[]{10, 4, 13, 9.65, 3, 14}, 10);
        Vector clone = new Vector(vector2);

        System.out.println(vector);
        System.out.println(vector1);
        System.out.println(vector2);
        System.out.println(clone);
    }
}
