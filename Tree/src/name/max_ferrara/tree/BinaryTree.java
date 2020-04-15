package name.max_ferrara.tree;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree<T extends Comparable<T>> {
    private TreeItem<T> root;
    private Comparator<T> comparator;

    public BinaryTree() {
    }

    public BinaryTree(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    public boolean isEmpty() {
        return root == null;
    }

    private int compare(T data1, T data2) {
        if (comparator == null) {
            return data1.compareTo(data2);
        } else {
            return comparator.compare(data1, data2);
        }
    }

    public void add(T data) {
        root = add(root, data);
    }

    private TreeItem<T> add(TreeItem<T> item, T data) {
        if (item == null) {
            return new TreeItem<>(data);
        }

        if (compare(data, item.data) == 0) {
            item.data = data;
        } else {
            if (compare(data, item.data) < 0) {
                item.left = add(item.left, data);
            } else {
                item.right = add(item.right, data);
            }
        }

        return item;
    }

    public boolean contains(T data) {
        return contains(root, data);
    }

    private boolean contains(TreeItem<T> item, T data) {
        if (item == null) {
            return false;
        } else if (compare(data, item.data) == 0) {
            return true;
        } else if (compare(data, item.data) < 0) {
            return contains(item.left, data);
        } else {
            return contains(item.right, data);
        }
    }

    public void delete(T data) {
        root = delete(root, data);
    }


    private TreeItem<T> delete(TreeItem<T> item, T data) {
        if (item == null) {
            return null;
        } else if (compare(data, item.data) < 0) {
            item.left = delete(item.left, data);
        } else if (compare(data, item.data) > 0) {
            item.right = delete(item.right, data);
        } else {
            if (item.left == null) {
                return item.right;
            } else if (item.right == null) {
                return item.left;
            } else {
                item.data = getMinData(item.left);
                item.left = delete(item.left, item.data);
            }
        }

        return item;
    }

    private T getMinData(TreeItem<T> item) {
        while (item.right != null) {
            item = item.right;
        }

        return item.data;
    }

    //обход в глубину и получение размера
    public int size() {
        Stack<TreeItem<T>> stack = new Stack<>();
        TreeItem<T> currentItem = root;
        int size = 0;

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

    //обход в глубину рекурсия
    public void depthVisit() {
        visit(root);
    }

    private void visit(TreeItem<T> item) {
        if (item != null) {
            System.out.println(item);

            visit(item.left);
            visit(item.right);
        }
    }

    //обход в ширину
    public void widthVisit() {
        Queue<TreeItem<T>> queue = new LinkedList<>();
        TreeItem<T> currentItem = root;

        queue.add(currentItem);

        while (!queue.isEmpty()) {
            TreeItem<T> tmp = queue.poll();

            System.out.println(tmp.data);
            if (tmp.left != null) {
                queue.add(tmp.left);
            }

            if (tmp.right != null) {
                queue.add(tmp.right);
            }
        }
    }
}
