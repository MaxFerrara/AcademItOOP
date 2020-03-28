package name.max_ferrara.array_list_main;

import name.max_ferrara.array_list.MyArrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyArrayListMain {
    public static void main(String[] args) {
        try {
            MyArrayList<Integer> list1 = new MyArrayList<>(5);
            MyArrayList<Integer> list2 = new MyArrayList<>(5);

            list2.add(1);
            list2.add(2);
            System.out.println(list2);

            list1.add(1);
            list1.add(2);
            list1.add(3);
            list1.add(4);

            System.out.println(list1.containsAll(list2));
        } catch (IndexOutOfBoundsException | NoSuchElementException | NullPointerException e) {
            e.printStackTrace();
        }
    }
}
