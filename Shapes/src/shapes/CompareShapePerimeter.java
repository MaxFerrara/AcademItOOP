package shapes;

import java.util.Comparator;

public class CompareShapePerimeter implements Comparator<Shape> {
    @Override
    public int compare(Shape perimeter1, Shape perimeter2) {
        return Double.compare(perimeter1.getPerimeter(), perimeter2.getPerimeter());
    }
}
