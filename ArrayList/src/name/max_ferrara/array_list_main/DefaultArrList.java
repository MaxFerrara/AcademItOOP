package name.max_ferrara.array_list_main;

import java.util.ArrayList;
import java.util.List;

public class DefaultArrList {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>(15);
        list1.add(1);
        //list1.containsAll();
        Integer x = list1.get(0);
        System.out.println(x);
    }
}
