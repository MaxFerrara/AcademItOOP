package name.max_ferrara.hash_table;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

public class MyHashTable<T> implements Collection<T> {
    private T[] items;
    private static final int DEFAULT_CAPACITY = 50;

    private int modCount;

    public MyHashTable(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("capacity can not be < 0");
        }

        items = (T[]) new Object[initialCapacity];
    }

    public MyHashTable() {
        items = (T[]) new Object[DEFAULT_CAPACITY];
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("[ ");

        for (int i = 0; i < this.size(); ++i) {
            stringBuilder.append(items[i]).append(", ");
        }

        stringBuilder.setLength(stringBuilder.length() - 2);
        stringBuilder.append(" ]");

        return stringBuilder.toString();
    }

    private int getHashCode(T element) {
        return element.hashCode() % items.length;
    }

    @Override
    public int size() {
        return items.length;
    }

    @Override
    public boolean isEmpty() {
        return items.length == 0;
    }

    @Override
    public boolean contains(Object o) {
        return false;
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
            items[key] = (T) list;
            list.add(item);
        }

        return true;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
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

    }
}
