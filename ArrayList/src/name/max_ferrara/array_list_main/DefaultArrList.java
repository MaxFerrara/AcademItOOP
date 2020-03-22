package name.max_ferrara.array_list_main;

import java.util.ArrayList;
import java.util.List;

public class DefaultArrList {
    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<>(15);
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(5);
        list1.add(6);
        list1.add(7);
        System.out.println(list1.size());
        System.out.println(list1);
    }
}
