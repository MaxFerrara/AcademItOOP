package name.max_ferrara.tree_integer_test;

public class TestMain {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        tree.add(25);
        tree.add(0);
        tree.add(16);
        tree.add(100);
        tree.add(-5);
        tree.add(79);
        tree.add(-500);
        tree.add(98);

        System.out.println(tree.isEmpty());
        System.out.println(tree);
    }
}
