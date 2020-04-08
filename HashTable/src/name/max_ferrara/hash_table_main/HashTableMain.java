package name.max_ferrara.hash_table_main;

import name.max_ferrara.hash_table.MyHashTable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HashTableMain {
    public static void main(String[] args) {
        MyHashTable<Integer> myTable = new MyHashTable<>(5);
        Iterator<Integer> iterator = myTable.iterator();

        /*List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(11);
        list.add(131);
        list.add(1311); */

        myTable.add(1);
        myTable.add(11);
        myTable.add(131);
        myTable.add(1311);

        myTable.add(10000);
        myTable.add(8982);
        myTable.add(322);
        myTable.add(-5735);

        System.out.println(myTable.size());
        System.out.println(myTable);

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
