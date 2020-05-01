package name.max_ferrara.list_main;

import name.max_ferrara.list.SinglyLinkedList;

import java.util.NoSuchElementException;

public class ListMain {
    public static void main(String[] args) {
        try {
            SinglyLinkedList<Integer> list1 = new SinglyLinkedList<>();

            list1.addFirst(25);
            list1.addFirst(15);
            list1.addFirst(-5);
            list1.addFirst(35);
            list1.addFirst(13);

            System.out.println(list1.getSize());
            System.out.println();
            System.out.println(list1.getFirstData());
            System.out.println();
            System.out.println(list1.getDataByIndex(4));
            System.out.println(list1);
            System.out.println(list1.setDataByIndex(4, 100));
            System.out.println(list1);
            System.out.println(list1.deleteDataByIndex(2));
            System.out.println(list1);
            System.out.println(list1.getSize());
            list1.addDataByIndex(4, -11);
            System.out.println(list1);
            System.out.println(list1.getSize());
            System.out.println(list1.deleteByValue(100));
            System.out.println(list1);
            System.out.println(list1.getSize());
            list1.reverse();
            System.out.println(list1);
            System.out.println(list1.copy());
        } catch (IndexOutOfBoundsException | NoSuchElementException e) {
            e.printStackTrace();
        }
    }
}
