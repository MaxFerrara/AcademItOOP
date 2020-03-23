package name.max_ferrara.array_list_main;

import java.util.ArrayList;
import java.util.List;

public class DefaultArrList {
    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<>(15);
        System.out.println(list1.add(1));
        list1.add(2);
        list1.add(2, 15);
        list1.add(3, 15);
        System.out.println(list1.size());
        System.out.println(list1);
        list1.trimToSize();
    }
}
