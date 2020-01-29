package shapes;

import java.util.Comparator;

public final class ShapeAreaComparator implements Comparator<Shape> {
    @Override
    public int compare(Shape area1, Shape area2) {
        return Double.compare(area1.getArea(), area2.getArea());
    }
}
