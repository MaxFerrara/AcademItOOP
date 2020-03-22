package name.max_ferrara.array_list_main;

import name.max_ferrara.array_list.MyArrayList;

import java.util.ArrayList;

public class MyArrayListMain {
    public static void main(String[] args) {
        MyArrayList<Integer> list1 = new MyArrayList<>();
        System.out.println(list1.size());
        list1.add(1);
        list1.add(2);
        list1.add(0,25);

        for(Integer num: list1) {
            System.out.println(num);
        }

        System.out.println(list1.contains(2));
    }
}
