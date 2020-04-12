package name.max_ferrara.tree_main;

import name.max_ferrara.tree.BinaryTree;

import java.util.Set;
import java.util.TreeSet;

public class TreeMain {
    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<>(new IntegerComp());

        tree.add(25);
        tree.add(0);
        tree.add(19);
        tree.add(29);
        tree.add(45);

        System.out.println(tree.size());
        //System.out.println(tree);
    }
}
