import java.util.Arrays;

public class ShapeMaster {
    public static void main(String[] args) {
        CompareShape compareShape = new CompareShape();
        Square square1 = new Square(5);
        Square square2 = new Square(6);

        Rectangle rectangle1 = new Rectangle(5, 2);
        Rectangle rectangle2 = new Rectangle(4, 3);

        Triangle triangle1 = new Triangle(1, 1, 2, 2, 3, 3);
        Triangle triangle2 = new Triangle(-1, 2, -2, 3, -3, 4);
        Triangle triangle3 = new Triangle(1, 1, 2, 2, 3, 3);

        Circle circle1 = new Circle(5);
        Circle circle2 = new Circle(10);
        
    }
}
