import shapes.*;

import java.util.Arrays;
import java.util.Comparator;

public class ShapeMain {
    private static void printElementInformation(Shape[] shapes, Comparator<Shape> comparator, int elementPosition) {
        Arrays.sort(shapes, comparator);
        System.out.println(shapes[shapes.length - elementPosition]);
    }

    public static void main(String[] args) {
        ShapeAreaComparator shapeAreaComparator = new ShapeAreaComparator();
        ShapePerimeterComparator shapePerimeterComparator = new ShapePerimeterComparator();

        Square square1 = new Square(5);
        Square square2 = new Square(6);

        Rectangle rectangle1 = new Rectangle(5, 2);
        Rectangle rectangle2 = new Rectangle(4, 3);

        Triangle triangle1 = new Triangle(1, 1, 5, 5, 8, 3);
        Triangle triangle2 = new Triangle(2, 2, 5, -5, 10, 0);

        Circle circle1 = new Circle(5);
        Circle circle2 = new Circle(10);

        Shape[] shapes = {square1, square2, rectangle1, rectangle2, triangle1, triangle2, circle1, circle2};

        printElementInformation(shapes, shapeAreaComparator, 1);
        printElementInformation(shapes, shapePerimeterComparator, 2);
    }
}
