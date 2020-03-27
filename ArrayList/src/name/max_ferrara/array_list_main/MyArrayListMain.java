package name.max_ferrara.array_list_main;

import name.max_ferrara.array_list.MyArrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyArrayListMain {
    public static void main(String[] args) {
        try {
            MyArrayList<Integer> list1 = new MyArrayList<>(14);

            list1.add(1);
            list1.add(2);
            list1.add(25);
            list1.add(14);
            list1.add(4, 15);

            System.out.println(list1);
        } catch (IndexOutOfBoundsException | NoSuchElementException | NullPointerException e) {
            e.printStackTrace();
        }
    }
}
