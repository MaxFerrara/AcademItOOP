package name.max_ferrara.hash_table_main;

import name.max_ferrara.hash_table.MyHashTable;

public class HashTableMain {
    public static void main(String[] args) {
        MyHashTable<Integer> table = new MyHashTable<>(40);

        table.add(1);
        table.add(11);
        table.add(131);
        table.add(1311);

        System.out.println(table);
    }
}
