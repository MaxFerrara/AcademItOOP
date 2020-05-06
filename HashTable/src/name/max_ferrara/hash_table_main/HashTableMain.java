package name.max_ferrara.hash_table_main;

import name.max_ferrara.hash_table.MyHashTable;

import java.util.ArrayList;
import java.util.List;

public class HashTableMain {
    public static void main(String[] args) {
        MyHashTable<Integer> myTable = new MyHashTable<>(6);
        List<Integer> list = new ArrayList<>();

        list.add(11);
        list.add(322);

        myTable.add(1);
        myTable.add(11);
        myTable.add(131);
        myTable.add(1311);

        myTable.add(10000);
        myTable.add(8982);
        myTable.add(322);
        myTable.add(-5735);

        System.out.println(myTable);
        System.out.println(myTable.size());
        System.out.println(myTable.retainAll(list));
        System.out.println(myTable);
        System.out.println(myTable.size());
    }
}
