package name.max_ferrara.tree_main;

import java.util.Comparator;

public class IntegerComp implements Comparator<Integer> {
    @Override
    public int compare(Integer number1, Integer number2) {
        return number1 - number2;
    }
}
