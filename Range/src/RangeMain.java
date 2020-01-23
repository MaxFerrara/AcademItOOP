import range.Range;

import java.util.Arrays;

public class RangeMain {
    public static void main(String[] args) {
        Range range1 = new Range(-5, 20);
        Range range2 = new Range(16, 25);

        System.out.println(range1.toString());
        System.out.println(range1.getLength());
        System.out.println(range1.getRangesIntersection(range2));
        System.out.println(Arrays.toString(range1.getRangesUnion(range2)));

        System.out.println(Arrays.toString(range1.getRangesDifference(range2)));
        System.out.println(Arrays.toString(range2.getRangesDifference(range1)));
    }
}
