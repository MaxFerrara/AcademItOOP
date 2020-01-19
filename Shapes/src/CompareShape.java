import java.util.Comparator;

public class CompareShape implements Comparator<Square> {
    @Override
    public int compare(Square area1, Square area2) {
        return Double.compare(area1.getArea(), area2.getArea());
    }
}
