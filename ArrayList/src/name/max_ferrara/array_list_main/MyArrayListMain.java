package name.max_ferrara.array_list_main;

import name.max_ferrara.array_list.MyArrayList;

import java.util.ArrayList;
import java.util.Arrays;

public class MyArrayListMain {
    public static void main(String[] args) {
        try {
            MyArrayList<Integer> list1 = new MyArrayList<>();
            MyArrayList<String> list2 = new MyArrayList<>();

            list2.add("Max");
            list2.add("Maks");
            list2.add("Maksim");
            list2.add("Makson");

            list1.add(1);
            list1.add(2);
            list1.add(25);
            list1.add(14);
            list1.add(4, 15);

            System.out.println(list2.size());
            System.out.println(list2);
            System.out.println(list2.remove("Max"));
            System.out.println(list2);

            String[] namesArray = list2.toArray(new String[0]);

            System.out.println(Arrays.toString(namesArray));

        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }
}
