package name.max_ferrara.list_main;

import name.max_ferrara.list.SinglyLinkedList;

import java.util.ArrayList;
import java.util.LinkedList;

public class ListMain {
    public static void main(String[] args) {
        SinglyLinkedList<Integer> list1 = new SinglyLinkedList<>();
        SinglyLinkedList<Double> list2 = new SinglyLinkedList<>();

        list1.addFirst(25);
        list1.addFirst(15);
        list1.addFirst(-5);
        list1.addFirst(35);
        list1.addFirst(13);

        //System.out.println(list1);
        //System.out.println(list1.setListItemByIndex(4,100));
        System.out.println(list1);
        list1.insertListItemByIndex(4, 100);
        //System.out.println(list1.isListItemDeletedByKey(35));
        System.out.println(list1);
    }
}
