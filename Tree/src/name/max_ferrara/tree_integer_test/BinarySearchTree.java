package name.max_ferrara.tree_integer_test;

public class BinarySearchTree {
    Node root;

    public BinarySearchTree() {
        root = null;
    }

    @Override
    public String toString() {
        return toString(root);
    }

    protected String toString(Node node) {
        if (node == null) {
            return "";
        }
        return node.data + ", "+toString(node.left) + ", " +
                toString(node.right) + ", ";
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void add(int number) {
        root = addRec(root, number);
    }

    private Node addRec(Node current, int value) {
        if (current == null) {
            return new Node(value);
        }

        if (value < current.data) {
            current.left = addRec(current.left, value);
        } else if (value > current.data) {
            current.right = addRec(current.right, value);
        } else {
            return current;
        }

        return current;
    }
}
