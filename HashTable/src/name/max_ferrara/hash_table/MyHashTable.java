package name.max_ferrara.hash_table;

import java.util.*;

public class MyHashTable<T> implements Collection<T> {
    private LinkedList<T>[] items;
    private static final int DEFAULT_CAPACITY = 16;
    private int size;

    private int modCount;

    public MyHashTable(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("capacity can not be < 0");
        }

        items = new LinkedList[initialCapacity];
        Arrays.fill(items, null);
    }

    public MyHashTable() {
        items = new LinkedList[DEFAULT_CAPACITY];
        Arrays.fill(items, null);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("[ ");

        for (int i = 0; i < items.length; ++i) {
            stringBuilder.append(items[i]).append(", ");
        }

        stringBuilder.setLength(stringBuilder.length() - 2);
        stringBuilder.append(" ]");

        return stringBuilder.toString();
    }

    private int getHashCode(Object element) {
        return Math.abs(element.hashCode() % items.length);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object object) {
        int key = getHashCode(object);

        if (items[key] == null) {
            return false;
        } else {
            return items[key].contains(object);
        }
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {

        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean add(T item) {
        int key = getHashCode(item);

        if (items[key] == null) {
            LinkedList<T> list = new LinkedList<>();
            items[key] = list;
            list.add(item);
        } else {
            items[key].add(item);
        }

        ++size;
        return true;
    }

    @Override
    public boolean remove(Object object) {
        if (!contains(object)) {
            return false;
        } else {
            int key = getHashCode(object);
            items[key].remove(object);
            --size;

            if (items[key].size() == 0) {
                items[key] = null;
            }

            return true;
        }
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        Arrays.fill(items, null);
        size = 0;
    }
}
