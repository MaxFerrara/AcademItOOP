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

    public class MyHashTableIterator implements Iterator<T> {
        private int expectedModCount = modCount;
        private int currentIndex = -1;
        private int currentArrayIndex = 0;
        private LinkedList<T> currentList;

        @Override
        public boolean hasNext() {
            return currentIndex + 1 < size;
        }

        @Override
        public T next() {
            if (expectedModCount != modCount) {
                throw new ConcurrentModificationException("collection has been modified");
            }

            while (currentIndex != size) {
                // int count = 0;
                if (items[currentArrayIndex] != null) {
                    currentList = items[currentArrayIndex];

                    for (T element : currentList) {
                        currentIndex++;

                        return element;
                    }
                } else {
                    currentArrayIndex++;
                }
            }

            return null;
        }

        public T nex1t() {
            if (expectedModCount != modCount) {
                throw new ConcurrentModificationException("collection has been modified");
            }

            while (currentIndex != size) {
                if (items[currentArrayIndex] != null) {
                    currentList = items[currentArrayIndex];
                    int count = 0;

                    while (count <= currentList.size()) {
                        for (T element : currentList) {
                            currentIndex++;
                            count++;
                            return element;
                        }
                    }
                } else {
                    currentArrayIndex++;
                }
            }

            return null;
        }
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
        return new MyHashTableIterator();
    }

    @Override
    public Object[] toArray() {
        ArrayList<T> list = new ArrayList<>(size);

        for (LinkedList<T> item : items) {
            if (item != null) {
                list.addAll(item);
            }
        }

        return list.toArray();
    }

    @Override
    public <E> E[] toArray(E[] elements) {
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
        for (Object element : collection) {
            if (!contains(element)) {
                return false;
            }
        }

        return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> collection) {
        if (collection.isEmpty()) {
            return false;
        }

        for (Object element : collection) {
            add((T) element);
        }

        return true;
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        for (Object element : collection) {
            remove(element);
        }

        return true;
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        for (LinkedList<T> item : items) {
            for (T element : item) {
                if (!contains(collection)) {
                    remove(element);
                }
            }
        }

        return true;
    }

    @Override
    public void clear() {
        Arrays.fill(items, null);
        size = 0;
    }
}
