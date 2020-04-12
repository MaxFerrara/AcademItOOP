package name.max_ferrara.tree_main;

import java.util.Comparator;

public class IntegerComp implements Comparator<Integer> {
    @Override
    public int compare(Integer num1, Integer num2) {
        return num1 - num2;
    }
}
