package shapes;

import java.util.Comparator;

public class CompareShapeArea implements Comparator<Shape> {
    @Override
    public int compare(Shape area1, Shape area2) {
        return Double.compare(area1.getArea(), area2.getArea());
    }
}
