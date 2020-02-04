import vector.Vector;

import java.util.Arrays;

public class TestVector {
    public static double[] getMaxMinArray(double[] arr, double[] arr1) {
        if (arr.length >= arr1.length) {
            return arr;
        }

        return arr1;
    }

    public static void main(String[] args) {
        int[] a = {10, 20, 30, 40};
        int[] b = {25, 50, 75, 100, 125, 90, 35};
        int[] sum = new int[Math.max(a.length, b.length)];

        for (int i = 0; i < sum.length; ++i) {
            sum[i] = 0;

            if (i >= Math.min(a.length, b.length)) {
                sum[i] = b[i];
            } else {
                sum[i] = a[i] + b[i];
            }
        }

        System.out.println(Arrays.toString(sum));
    }
}
