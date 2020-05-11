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
            return "[]";
        }

        StringBuilder stringBuilder = new StringBuilder("[");
        ListItem<T> currentItem = head;

        while (currentItem != null) {
            stringBuilder.append(currentItem.getData()).append(", ");
            currentItem = currentItem.getNext();
        }

        stringBuilder.setLength(stringBuilder.length() - 2);
        stringBuilder.append("]");

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

    private ListItem<T> getListItemByIndex(int index) {
        ListItem<T> currentItem = head;

        for (int i = 0; i != index; ++i) {
            currentItem = currentItem.getNext();
        }

        return currentItem;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("index must be >=0 and < " + size + ", current indexValue: " + index);
        }
    }

    //получение значения по индексу
    public T getDataByIndex(int index) {
        checkIndex(index);

        return getListItemByIndex(index).getData();
    }

    //изменение элемента по индексу, вернуть старое значение
    public T setDataByIndex(int index, T data) {
        checkIndex(index);

        ListItem<T> item = getListItemByIndex(index);
        T oldValue = item.getData();
        item.setData(data);

        return oldValue;
    }

    //удаление элемента по индексу, вернуть старое значение
    public T deleteDataByIndex(int index) {
        checkIndex(index);

        if (index == 0) {
            return deleteFirst();
        }

        ListItem<T> item = getListItemByIndex(index - 1);
        T deletedValue = item.getNext().getData();
        item.setNext(item.getNext().getNext());
        --size;

        return deletedValue;
    }

    //вставка в начало
    public void addFirst(T data) {
        head = new ListItem<>(data, head);
        ++size;
    }

    //вставка элемента по индексу
    public void addDataByIndex(int index, T data) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("index must be >=0 and <= " + size + ", current indexValue: " + index);
        }

        if (index == 0) {
            addFirst(data);
        } else {
            ListItem<T> item = getListItemByIndex(index - 1);
            item.setNext(new ListItem<>(data, item.getNext()));

            ++size;
        }
    }

    //удаление узла по значению
    public boolean deleteByValue(T data) {
        for (ListItem<T> current = head, previous = null; current != null; previous = current, current = current.getNext()) {
            if (Objects.equals(current.getData(), data)) {
                if (previous == null) {
                    head = current.getNext();
                } else {
                    previous.setNext(current.getNext());
                }
                --size;

                return true;
            }
        }

        return false;
    }

    //удаление первого элемента списка
    public T deleteFirst() {
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
        ListItem<T> previous = null;

        while (current != null) {
            ListItem<T> tmp = current.getNext();
            current.setNext(previous);
            previous = current;
            current = tmp;
        }

        head = previous;
    }

    //копирование списка
    public SinglyLinkedList<T> copy() {
        SinglyLinkedList<T> listCopy = new SinglyLinkedList<>();

        if (head == null) {
            return listCopy;
        }

        ListItem<T> copiedItem = new ListItem<>(head.getData());
        listCopy.head = copiedItem;

        for (ListItem<T> current = head.getNext(); current != null; current = current.getNext()) {
            ListItem<T> copyListItem = new ListItem<>(current.getData());
            copiedItem.setNext(copyListItem);
            copiedItem = copyListItem;
        }

        listCopy.size = size;

        return listCopy;
    }
}


