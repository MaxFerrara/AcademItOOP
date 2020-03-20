package name.max_ferrara.list_main;

import name.max_ferrara.list.SinglyLinkedList;

public class ListMain {
    public static void main(String[] args) {
        try {
            SinglyLinkedList<Integer> list1 = new SinglyLinkedList<>();

            list1.addFirst(25);
            list1.addFirst(15);
            list1.addFirst(-5);
            list1.addFirst(35);
            list1.addFirst(13);

            System.out.println(list1);
            System.out.println(list1.getSize());
            System.out.println();
            System.out.println(list1.getFirstListItem());
            System.out.println();
            System.out.println(list1.getListItemByIndex(4));
            System.out.println(list1);
            System.out.println(list1.setListItemByIndex(4, 100));
            System.out.println(list1);
            System.out.println(list1.deleteListItemByIndex(2));
            System.out.println(list1);
            System.out.println(list1.getSize());
            list1.addListItemByIndex(2,-11);
            System.out.println(list1);
            System.out.println(list1.getSize());
        } catch (IndexOutOfBoundsException | NullPointerException e) {
            e.printStackTrace();
        }
    }
}
