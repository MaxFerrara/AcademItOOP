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
            stringBuilder.append(tmp.getListItem()).append(", ");
            tmp = tmp.getNextListItem();
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
    public T getFirstListItem() {
        if (isEmpty()) {
            throw new NullPointerException("list is empty");
        }

        return head.getListItem();
    }

    //получение значения по индексу
    public T getListItemByIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("list index out of bounds");
        }

        int indexCount = -1;

        ListItem<T> tmp = head;

        while (tmp != null) {
            indexCount++;

            if (index == indexCount) {
                return tmp.getListItem();
            }

            tmp = tmp.getNextListItem();
        }

        return null;
    }

    //изменение элемента по индексу, вернуть старое значение
    public T setListItemByIndex(int index, T listItem) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("go beyond the list");
        }

        if (listItem == null) {
            throw new NullPointerException("listItem can't be null");
        }

        int indexCount = -1;

        for (ListItem<T> tmp = head; tmp != null; tmp = tmp.getNextListItem()) {
            indexCount++;

            if (indexCount == index) {
                ListItem<T> oldListItem = new ListItem<>(tmp.getListItem());
                tmp.setListItem(listItem);

                return oldListItem.getListItem();
            }
        }

        return null;
    }

    //удаление элемента по индексу, вернуть старое значение
    public T deleteListItemByIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("List index out of bounds");
        }

        if (index == 0) {
            return deleteFirstListItem();
        }

        int indexCount = 0;

        for (ListItem<T> tmp = head; tmp != null; tmp = tmp.getNextListItem()) {
            indexCount++;

            if (indexCount == index) {
                ListItem<T> deletedListItem = tmp.getNextListItem();
                tmp.setNextListItem(tmp.getNextListItem().getNextListItem());
                --size;

                return deletedListItem.getListItem();
            }
        }

        return null;
    }

    //вставка в начало
    public void addFirst(T listItem) {
        if (listItem == null) {
            throw new NullPointerException("listItem is null");
        }

        head = new ListItem<>(listItem, head);
        size++;
    }

    //вставка элемента по индексу
    public void addListItemByIndex(int index, T listItem) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("List index out of bounds");
        }

        if (listItem == null) {
            throw new NullPointerException("listItem is null");
        }

        if (index == 0) {
            head = new ListItem<>(listItem, head);
            ++size;
        }

        int indexCount = 0;

        for (ListItem<T> tmp = head; tmp != null; tmp = tmp.getNextListItem()) {
            indexCount++;

            if (indexCount == index) {
                tmp.setNextListItem(new ListItem<>(listItem, tmp.getNextListItem()));

                break;
            }
        }

        ++size;
    }

    //удаление узла по значению
    public boolean isListItemDeletedByValue(T listItem) {
        ListItem<T> listItemBeforeDelete = this.head;

        if (listItemBeforeDelete == null) {
            return false;
        } else if (listItemBeforeDelete.getListItem() == listItem) {
            this.head = this.head.getNextListItem();
            --size;

            return true;
        }

        while (true) {
            ListItem<T> next = listItemBeforeDelete.getNextListItem();

            if (next == null) {
                return false;
            } else if (next.getListItem() == listItem) {
                break;
            }
            listItemBeforeDelete = next;
        }
        ListItem<T> nextListItem = listItemBeforeDelete.getNextListItem();

        listItemBeforeDelete.setNextListItem(nextListItem.getNextListItem());
        nextListItem.setNextListItem(null);
        --size;

        return true;
    }

    public boolean isListItemDeletedByValue1(T listItem) {
        for (ListItem<T> tmp = head, prev = null; tmp != null; prev = tmp, tmp = tmp.getNextListItem()) {
            if (tmp.getListItem() == listItem) {
                if (prev == null) {
                    head = tmp.getNextListItem();
                } else {
                    prev.setNextListItem(tmp.getNextListItem());
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
            throw new NullPointerException("list is empty");
        }

        ListItem<T> tmp = head;
        head = head.getNextListItem();
        --size;

        return tmp.getListItem();
    }

    //разворот списка
    public void reverse() {
        ListItem<T> current = head;
        ListItem<T> prev = null;
        ListItem<T> tmp;

        while (current != null) {
            tmp = current.getNextListItem();
            current.setNextListItem(prev);
            prev = current;
            current = tmp;
        }

        head = prev;
    }

    //копирование списка
    public SinglyLinkedList<T> copy() {
        SinglyLinkedList<T> copyList = new SinglyLinkedList<>();

        if (head == null) {
            return copyList;
        }

        ListItem<T> newItem = new ListItem<>(head.getListItem(), null);

        for (ListItem<T> tmp = head; tmp != null; tmp = tmp.getNextListItem()) {
            if (tmp == head) {
                copyList.head = newItem;
            } else {
                ListItem<T> copyItem = new ListItem<>(tmp.getListItem(), null);
                newItem.setNextListItem(copyItem);
                newItem = copyItem;
            }
        }
        copyList.size = this.size;

        return copyList;
    }
}


