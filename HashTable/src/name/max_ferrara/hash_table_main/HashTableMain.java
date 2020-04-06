package name.max_ferrara.hash_table_main;

import name.max_ferrara.hash_table.MyHashTable;

public class HashTableMain {
    public static void main(String[] args) {
        MyHashTable<Integer> myTable = new MyHashTable<>(10);

        myTable.add(1);
        myTable.add(11);
        myTable.add(131);
        myTable.add(1311);

        myTable.add(1000000);
        myTable.add(89482582);
        myTable.add(322);
        myTable.add(-579335);

        System.out.println(myTable);
        System.out.println(myTable.contains(322));
        System.out.println(myTable.remove(322));
        System.out.println(myTable);
    }
}
