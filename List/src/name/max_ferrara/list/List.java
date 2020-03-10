package name.max_ferrara.list;

import name.max_ferrara.list_item.ListItem;

public class List<T> {
    private ListItem<T> head;
    private int size;

    public List() {
        head = null;
        size = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int getSize() {
        return size;
    }

    public void add(ListItem<T> data) {
        head = data;
    }

}
