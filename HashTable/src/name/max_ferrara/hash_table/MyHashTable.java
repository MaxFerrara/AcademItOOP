package name.max_ferrara.hash_table;

import java.util.*;

public class MyHashTable<T> implements Collection<T> {
    private ArrayList<T>[] items;
    private static final int DEFAULT_ARRAY_LENGTH = 16;
    private int size;

    private int modCount;

    public MyHashTable(int arrayLength) {
        if (arrayLength < 0) {
            throw new IllegalArgumentException("capacity can not be < 0");
        }
        //noinspection unchecked
        items = new ArrayList[arrayLength];
    }

    public MyHashTable() {
        //noinspection unchecked
        items = new ArrayList[DEFAULT_ARRAY_LENGTH];
    }

    private class MyHashTableIterator implements Iterator<T> {
        private int currentIndex = -1;
        private int currentArrayIndex = 0;
        private int currentListIndex = -1;
        private final int expectedModCount = modCount;

        @Override
        public boolean hasNext() {
            return currentIndex + 1 < size;
        }

        @Override
        public T next() {
            if (expectedModCount != modCount) {
                throw new ConcurrentModificationException("collection has been modified");
            }

            if (!hasNext()) {
                throw new NoSuchElementException("collection is ending");
            }

            while (currentIndex != size) {
                ArrayList<T> currentList = items[currentArrayIndex];

                if (currentList != null && currentListIndex + 1 != currentList.size()) {
                    currentIndex++;
                    currentListIndex++;

                    return currentList.get(currentListIndex);
                }

                currentListIndex = -1;
                currentArrayIndex++;
            }

            return null;
        }
    }

    @Override
    public String toString() {
        if (size == 0) {
            return "[]";
        }

        StringBuilder stringBuilder = new StringBuilder("[");

        for (ArrayList<T> item : items) {
            stringBuilder.append(item).append(", ");
        }

        stringBuilder.setLength(stringBuilder.length() - 2);
        stringBuilder.append("]");

        return stringBuilder.toString();
    }

    private int getKey(Object element) {
        if (element == null) {
            return 0;
        }

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
        int key = getKey(object);

        if (items[key] == null) {
            return false;
        }

        return items[key].contains(object);
    }

    @Override
    public Iterator<T> iterator() {
        return new MyHashTableIterator();
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        int index = 0;

        for (T item : this) {
            array[index] = item;
            ++index;
        }

        return array;
    }

    @Override
    public <E> E[] toArray(E[] elements) {
        if (elements.length < size) {
            //noinspection unchecked
            return (E[]) Arrays.copyOf(toArray(), size, elements.getClass());
        }

        //noinspection SuspiciousSystemArraycopy
        System.arraycopy(toArray(), 0, elements, 0, size);

        if (elements.length > size) {
            elements[size] = null;
        }

        return elements;
    }

    @Override
    public boolean add(T item) {
        int key = getKey(item);

        if (items[key] == null) {
            items[key] = new ArrayList<>();
        }

        items[key].add(item);

        ++modCount;
        ++size;

        return true;
    }

    @Override
    public boolean remove(Object object) {
        int key = getKey(object);

        if (items[key].remove(object)) {
            --size;
            ++modCount;

            return true;
        }

        return false;
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
        for (T element : collection) {
            add(element);
        }

        return collection.size() != 0;
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        boolean isCollectionModified = false;
        int sizeAfterModification = 0;

        for (ArrayList<T> item : items) {
            if (item != null && item.size() > 0) {
                item.removeAll(collection);

                sizeAfterModification += item.size();
            }
        }

        if (size != sizeAfterModification) {
            size = sizeAfterModification;
            isCollectionModified = true;

            ++modCount;
        }

        return isCollectionModified;
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        boolean isCollectionModified = false;
        int sizeAfterModification = 0;

        for (ArrayList<T> item : items) {
            if (item != null && item.size() > 0) {
                item.retainAll(collection);

                sizeAfterModification += item.size();
            }
        }

        if (size != sizeAfterModification) {
            size = sizeAfterModification;
            isCollectionModified = true;

            ++modCount;
        }

        return isCollectionModified;
    }

    @Override
    public void clear() {
        ++modCount;
        Arrays.fill(items, null);
        size = 0;
    }
}
