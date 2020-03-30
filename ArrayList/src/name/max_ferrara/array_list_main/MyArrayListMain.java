package name.max_ferrara.array_list_main;

import name.max_ferrara.array_list.MyArrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyArrayListMain {
    public static void main(String[] args) {
        try {
            /*MyArrayList<Integer> list1 = new MyArrayList<>();
            MyArrayList<Integer> list2 = new MyArrayList<>(); */

            MyArrayList<Integer> list3 = new MyArrayList<>(0);
            System.out.println(list3);
            list3.add(1);
            System.out.println(list3);
            list3.add(2);
            list3.add(3);
            System.out.println(list3.size());
            System.out.println(list3);

            /*list2.add(1);
            list2.add(4);
            System.out.println(list2);

            list1.add(1);
            list1.add(2);
            list1.add(3);
            list1.add(4);
            list1.add(5);

            System.out.println(list1.retainAll(list2));

            System.out.println(list1);
            System.out.println(list2); */
        } catch (IndexOutOfBoundsException | NoSuchElementException | NullPointerException e) {
            e.printStackTrace();
        }
    }
}
