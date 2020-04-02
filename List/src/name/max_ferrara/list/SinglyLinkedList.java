package name.max_ferrara.list;

import java.util.NoSuchElementException;
import java.util.Objects;

public class SinglyLinkedList<T> {
    private ListItem<T> head;
    private int size;

    public SinglyLinkedList() {
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "[ ]";
        }

        StringBuilder stringBuilder = new StringBuilder("[ ");
        ListItem<T> tmp = head;

        while (tmp != null) {
            stringBuilder.append(tmp.getData()).append(", ");
            tmp = tmp.getNext();
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
    public T getFirstData() {
        if (isEmpty()) {
            throw new NoSuchElementException("list is empty");
        }

        return head.getData();
    }

    public ListItem<T> getListItemByIndex(int index) {
        int i = 0;

        for (ListItem<T> current = head; current != null; current = current.getNext()) {
            if (index == i) {
                return current;
            }

            i++;
        }

        return null;
    }

    //получение значения по индексу
    public T getDataByIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("list index out of bounds");
        }

        return getListItemByIndex(index).getData();
    }

    //изменение элемента по индексу, вернуть старое значение
    public T setDataByIndex(int index, T data) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("list index out of bounds");
        }

        ListItem<T> oldListItem = new ListItem<>(getListItemByIndex(index).getData());
        getListItemByIndex(index).setData(data);

        return oldListItem.getData();
    }

    //удаление элемента по индексу, вернуть старое значение
    public T deleteDataByIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("list index out of bounds");
        }

        if (index == 0) {
            return deleteFirstListItem();
        }

        index--;
        ListItem<T> deletedListItem = getListItemByIndex(index).getNext();
        getListItemByIndex(index).setNext(getListItemByIndex(index).getNext().getNext());
        --size;

        return deletedListItem.getData();
    }

    //вставка в начало
    public void addFirst(T data) {
        head = new ListItem<>(data, head);
        ++size;
    }

    //вставка элемента по индексу
    public void addDataByIndex(int index, T data) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("list index out of bounds");
        }

        if (index == 0) {
            addFirst(data);
        }

        index--;
        getListItemByIndex(index).setNext(new ListItem<>(data, getListItemByIndex(index).getNext()));
        ++size;
    }

    //удаление узла по значению
    public boolean deleteByValue(T data) {
        for (ListItem<T> current = head, prev = null; current != null; prev = current, current = current.getNext()) {
            if (Objects.equals(current.getData(), data)) {
                if (prev == null) {
                    head = current.getNext();
                } else {
                    prev.setNext(current.getNext());
                }
                --size;

                return true;
            }
        }

        return false;
    }

    //удаление первого элемента списка
    public T deleteFirstListItem() {
        if (isEmpty()) {
            throw new NoSuchElementException("list is empty");
        }

        ListItem<T> deletedListItem = head;
        head = head.getNext();
        --size;

        return deletedListItem.getData();
    }

    //разворот списка
    public void reverse() {
        ListItem<T> current = head;
        ListItem<T> prev = null;
        ListItem<T> tmp;

        while (current != null) {
            tmp = current.getNext();
            current.setNext(prev);
            prev = current;
            current = tmp;
        }
        head = prev;
    }

    //копирование списка
    public SinglyLinkedList<T> copy() {
        SinglyLinkedList<T> listCopy = new SinglyLinkedList<>();

        if (head == null) {
            return listCopy;
        }

        ListItem<T> newListItemHead = new ListItem<>(head.getData(), null);
        listCopy.head = newListItemHead;

        for (ListItem<T> current = head.getNext(); current != null; current = current.getNext()) {
            ListItem<T> copyListItem = new ListItem<>(current.getData(), null);
            newListItemHead.setNext(copyListItem);
            newListItemHead = copyListItem;
        }
        listCopy.size = size;

        return listCopy;
    }
}


