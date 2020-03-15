package name.max_ferrara.list_main;

import name.max_ferrara.list.SinglyLinkedList;

import java.util.ArrayList;

public class ListMain {
    public static void main(String[] args) {
        SinglyLinkedList<Integer> list1 = new SinglyLinkedList<>();
        SinglyLinkedList<Double> list2 = new SinglyLinkedList<>();

        list1.addFirst(25);
        list1.addFirst(15);
        list1.addFirst(-5);
        list1.addFirst(35);
        list1.addFirst(13);

        //System.out.println(list1.getSize());
        //System.out.println(list1.getFirstElement());
        System.out.println(list1);
        System.out.println(list1.getListItemByIndex(1));
        //list1.deleteListItem(0);
        list1.setListItemByIndex(4,100);
        System.out.println(list1);
    }
}
