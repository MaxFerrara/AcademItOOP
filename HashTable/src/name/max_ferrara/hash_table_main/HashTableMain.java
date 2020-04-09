package name.max_ferrara.hash_table_main;

import name.max_ferrara.hash_table.MyHashTable;

import java.util.Iterator;

public class HashTableMain {
    public static void main(String[] args) {
        MyHashTable<Integer> myTable = new MyHashTable<>(8);
        Iterator<Integer> iterator = myTable.iterator();

        myTable.add(1);
        myTable.add(11);
        myTable.add(131);
        myTable.add(1311);

        myTable.add(10000);
        myTable.add(8982);
        myTable.add(322);
        myTable.add(-5735);

        System.out.println(myTable);

        for (Integer element : myTable) {
            System.out.println(element);
        }
    }
}
