package name.max_ferrara.list;

import name.max_ferrara.list_item.ListItem;

public class SinglyLinkedList<T> {
    private ListItem<T> head;
    private int size;

    public SinglyLinkedList() {
        head = null;
        size = 0;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("[ ");
        ListItem<T> tmp = head;

        while (tmp != null) {
            stringBuilder.append(tmp.getElement()).append(", ");
            tmp = tmp.getNextElement();
        }

        stringBuilder.setLength(stringBuilder.length() - 2);
        stringBuilder.append(" ]");

        return stringBuilder.toString();
    }

    //проверка на пустоту
    public boolean isEmpty() {
        return head == null;
    }

    //размер списка
    public int getSize() {
        return size;
    }

    //первый элемент
    public T getFirstElement() {
        if (isEmpty()) {
            return null;
        }

        return head.getElement();
    }

    //вставка в начало
    public void addFirst(T listItem) {
        if (listItem == null) {
            throw new NullPointerException("element can't be null");
        }

        head = new ListItem<>(listItem, head);
        size++;
    }

    public T getListItemByIndex(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("go beyond the list");
        }

        int indexCount = -1;

        while (head != null) {
            indexCount++;

            if (index == indexCount) {
                return head.getElement();
            }

            head = head.getNextElement();
        }

        return null;
    }

    public void setListItemByIndex(int index, T listItem) {
        int indexCount = -1;
        ListItem<T> tmp = new ListItem<T>(listItem);

        for (tmp = head; tmp!= null; tmp = tmp.getNextElement()) {

        }
    }
}


