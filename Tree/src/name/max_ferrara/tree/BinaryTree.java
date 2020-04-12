package name.max_ferrara.tree;

import java.util.Comparator;
import java.util.Stack;

public class BinaryTree<T extends Comparable<T>> {
    TreeItem<T> root;
    private Comparator<T> comparator;

    public BinaryTree() {
    }

    public BinaryTree(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    @Override
    public String toString() {
        return "0";
    }

    private int compare(T data1, T data2) {
        if (comparator == null) {
            return data1.compareTo(data2);
        } else {
            return comparator.compare(data1, data2);
        }
    }

    public void add(T data) {
        add(root, data);
    }

    private TreeItem<T> add(TreeItem<T> root, T data) {
        if (this.root == null) {
            return new TreeItem<T>(data);
        }

        if (compare(data, root.data) == 0) {
            return root;
        }

        if (compare(data, root.data) < 0) {
            root.left = add(root.left, data);
        } else {
            root.right = add(root.right, data);
        }

        return root;
    }

    public boolean contains(T data) {
        return contains(root, data);
    }

    private boolean contains(TreeItem<T> root, T data) {
        if (root == null) {
            return false;
        } else if (compare(data, root.data) == 0) {
            return true;
        } else if (compare(data, root.data) < 0) {
            return contains(root.left, data);
        } else {
            return contains(root.right, data);
        }
    }

   /* public void delete(T data) {
        delete(root, data);
    }


    private TreeItem<T> delete(TreeItem<T> root, T data) {
        if (root == null) {
            return null;
        } else if (compare(data, root.data) < 0) {
            root.left = delete(root.left, data);
        } else if (compare(data, root.data) > 0) {
            root.right = delete(root.right, data);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                root.data = getMax(root.left);
                root.left = delete(root.left, root.data);
            }

        }

        return root;
    }

    private T getMax(TreeItem<T> root) {
        while (root.right != null) {
            root = root.right;
        }

        return root.data;
    } */

    public int size() {
        TreeItem<T> currentItem = root;
        int size = 0;
        Stack<TreeItem<T>> stack = new Stack<>();

        while (!stack.empty() || currentItem != null) {
            if (currentItem != null) {
                stack.push(currentItem);
                currentItem = currentItem.left;
            } else {
                size++;
                currentItem = stack.pop();
                currentItem = currentItem.right;
            }
        }

        return size;
    }

}
