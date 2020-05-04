package name.max_ferrara.array_list_main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DefaultArrList {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        /*list2.add(-1);
        list2.add(-2);
        list2.add(-3);
        list2.add(-4); */

        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(5);

        System.out.println(list1);
        System.out.println(list2);
        System.out.println(list1.addAll(2, list2));
        System.out.println(list1);
    }
}
