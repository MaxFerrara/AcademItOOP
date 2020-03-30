package name.max_ferrara.array_list_main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DefaultArrList {
    public static void main(String[] args) {
        int[] arr = new int[0];
        System.out.println(arr.length);
        arr[0] = 1;

        System.out.println(Arrays.toString(arr));
    }
}
