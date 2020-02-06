package name.max_ferrara.shapes_main;

import name.max_ferrara.shapes.Shape;

import java.util.Comparator;

public final class ShapeAreaComparator implements Comparator<Shape> {
    @Override
    public int compare(Shape shape1, Shape shape2) {
        return Double.compare(shape1.getArea(), shape2.getArea());
    }
}
