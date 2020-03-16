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

    //получение значения первого элемента
    public T getFirstElement() {
        if (isEmpty()) {
            throw new NullPointerException("list is empty");
        }

        return head.getElement();
    }

    //получение значения по индексу
    public T getListItemByIndex(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("go beyond the list");
        }

        int indexCount = -1;

        ListItem<T> tmp = head;

        while (tmp != null) {
            indexCount++;

            if (index == indexCount) {
                return tmp.getElement();
            }

            tmp = tmp.getNextElement();
        }

        return null;
    }

    //изменение элемента по индексу, вернуть старое значение
    public T setListItemByIndex(int index, T listItem) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("go beyond the list");
        }

        if (listItem == null) {
            throw new NullPointerException("listItem can't be null");
        }

        int indexCount = -1;

        for (ListItem<T> tmp = head; tmp != null; tmp = tmp.getNextElement()) {
            indexCount++;

            if (indexCount == index) {
                ListItem<T> oldListItem = new ListItem<T>(tmp.getElement());
                tmp.setElement(listItem);

                return oldListItem.getElement();
            }
        }

        return null;
    }

    public void deleteListItemByIndex(int index) {
        int indexCount = -1;

        for (ListItem<T> tmp = head, prev = null; tmp != null; prev = tmp, tmp = tmp.getNextElement()) {
            indexCount++;

            if (indexCount == index) {
                ListItem<T> delListItem = new ListItem<T>(tmp.getElement());
                tmp = new ListItem<T>(delListItem.getElement(), delListItem.getNextElement());
            }
        }
        //size--;
    }

    //вставка в начало
    public void addFirst(T listItem) {
        if (listItem == null) {
            throw new NullPointerException("element can't be null");
        }

        head = new ListItem<>(listItem, head);
        size++;
    }

    //удаление первого элемента списка
    public T deleteFirstListItem() {
        ListItem<T> tmp = head;
        head = head.getNextElement();
        --size;

        return tmp.getElement();
    }

    public void reverse() {
        ListItem<T> curr = head;
        ListItem<T> pre = null;
        ListItem<T> incoming = null;

        while (curr != null) {
            incoming = curr.getNextElement();
            //curr.getNextElement() = pre;
            pre = curr;
            curr = incoming;
        }

        head = pre;

    }
}


