package name.max_ferrara.array_list_main;

import name.max_ferrara.array_list.MyArrayList;

import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;

public class MyArrayListMain {
    public static void main(String[] args) {
        try {
            MyArrayList<Integer> list1 = new MyArrayList<>();
            MyArrayList<Integer> list2 = new MyArrayList<>();

            list2.add(-1);
            list2.add(2);
            list2.add(-3);
            list2.add(4);

            list1.add(1);
            list1.add(2);
            list1.add(3);
            list1.add(4);
            list1.add(5);
            list1.add(6);

            Integer delItem = 6;

            System.out.println(list1.size());
            System.out.println(list1);
            System.out.println(list1.remove(delItem));
            System.out.println(list1);
            System.out.println(list1.size());

            System.out.println(list1.retainAll(list2));

            System.out.println(list1);
            System.out.println(list2);
            list1.removeAll(list2);
            System.out.println(list1);

            MyArrayList<Integer> list3 = new MyArrayList<>(0);
            System.out.println(list3);
            list3.add(1);
            System.out.println(list3);
            list3.add(2);
            list3.add(3);
            System.out.println(list3.size());
            System.out.println(list3);
            list3.trimToSize();
        } catch (IndexOutOfBoundsException | NoSuchElementException | ConcurrentModificationException e) {
            e.printStackTrace();
        }
    }
}
