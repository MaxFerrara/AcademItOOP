package name.max_ferrara.tree_main;

import name.max_ferrara.tree.BinaryTree;

public class TreeMain {
    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<>(new IntegerComp());

        System.out.println(tree.isEmpty());

        tree.add(25);
        tree.add(0);
        tree.add(19);
        tree.add(29);
        tree.add(45);
        tree.add(-100);

        tree.delete(25);
        System.out.println(tree.contains(0));
        System.out.println(tree.size());
        System.out.println(tree.isEmpty());
        System.out.println(tree.size());
        tree.widthVisit();
        tree.depthVisit();
        System.out.println(tree.isEmpty());
    }
}
