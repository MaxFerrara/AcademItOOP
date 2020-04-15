package name.max_ferrara.tree_integer_test;

public class Node {
    int data;
    Node right;
    Node left;

    public Node(int data) {
        this.data = data;
        right = null;
        left = null;
    }

    @Override
    public String toString() {
        return data + "";
    }

    public int getData() {
        return data;
    }

    public Node getRight() {
        return right;
    }

    public Node getLeft() {
        return left;
    }
}
