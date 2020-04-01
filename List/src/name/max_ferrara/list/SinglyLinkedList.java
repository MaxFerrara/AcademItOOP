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
            throw new IndexOutOfBoundsException("go beyond the list");
        }

        ListItem<T> oldListItem = new ListItem<>(getListItemByIndex(index).getData());
        getListItemByIndex(index).setData(data);

        return oldListItem.getData();
    }

    //удаление элемента по индексу, вернуть старое значение
    public T deleteDataByIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("List index out of bounds");
        }

        if (index == 0) {
            return deleteFirstListItem();
        }

        index = index - 1;

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
            throw new IndexOutOfBoundsException("List index out of bounds");
        }

        if (index == 0) {
            addFirst(data);
        }

        index = index - 1;
        getListItemByIndex(index).setNext(new ListItem<>(data, getListItemByIndex(index).getNext()));
        ++size;
    }

    //удаление узла по значению
    public boolean deleteByValue(T listItem) {
        for (ListItem<T> tmp = head, prev = null; tmp != null; prev = tmp, tmp = tmp.getNext()) {
            if (Objects.equals(tmp.getData(), listItem)) {
                if (prev == null) {
                    head = tmp.getNext();
                } else {
                    prev.setNext(tmp.getNext());
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

        for (ListItem<T> tmp = head; tmp != null; tmp = tmp.getNext()) {
            if (tmp == head) {
                listCopy.head = newListItemHead;
            } else {
                ListItem<T> copyListItem = new ListItem<>(tmp.getData(), null);
                newListItemHead.setNext(copyListItem);
                newListItemHead = copyListItem;
            }
        }
        listCopy.size = size;

        return listCopy;
    }
}


