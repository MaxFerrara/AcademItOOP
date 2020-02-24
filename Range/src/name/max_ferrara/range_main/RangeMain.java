package name.max_ferrara.range_main;

import name.max_ferrara.range.Range;

import java.util.Arrays;

public final class RangeMain {
    public static void main(String[] args) {
        try {
            Range range1 = new Range(-5, 20);
            Range range2 = new Range(16, 25);

            System.out.println(range1);
            System.out.println(range1.getLength());
            System.out.println(range1.getIntersection(range2));

            System.out.println((Arrays.toString(range1.getUnion(range2))));
            System.out.println(Arrays.toString(range1.getDifference(range2)));
            System.out.println(Arrays.toString(range2.getDifference(range1)));
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}
