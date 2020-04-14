package name.max_ferrara.tree;

class TreeItem<T> {
    T data;
    TreeItem<T> right;
    TreeItem<T> left;

    public TreeItem(T data) {
        this.data = data;
        right = null;
        left = null;
    }

    public TreeItem(T data, TreeItem<T> right, TreeItem<T> left) {
        this.data = data;
        this.right = right;
        this.left = left;
    }

    @Override
    public String toString() {
        return data.toString();
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public TreeItem<T> getRight() {
        return right;
    }

    public void setRight(TreeItem<T> right) {
        this.right = right;
    }

    public TreeItem<T> getLeft() {
        return left;
    }

    public void setLeft(TreeItem<T> left) {
        this.left = left;
    }
}
