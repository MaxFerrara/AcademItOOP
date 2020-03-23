package name.max_ferrara.array_list_main;

import java.util.ArrayList;
import java.util.List;

public class DefaultArrList {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>(15);
        list1.add(1);
        List untypedList = list1;
        untypedList.add("123");
        Integer x = list1.get(0);
        System.out.println(x);
    }
}
