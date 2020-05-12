package name.max_ferrara.array_list;

import java.util.*;

public class MyArrayList<T> implements List<T> {
    private int size;
    private T[] items;
    private static final int DEFAULT_CAPACITY = 10;

    private int modCount;

    public MyArrayList(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("capacity can not be < 0, current capacity:" + initialCapacity);
        }

        //noinspection unchecked
        items = (T[]) new Object[initialCapacity];
    }

    public MyArrayList() {
        //noinspection unchecked
        items = (T[]) new Object[DEFAULT_CAPACITY];
    }

    public class MyArrayListIterator implements Iterator<T> {
        private int expectedModCount = modCount;
        private int currentIndex = -1;

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

            ++currentIndex;
            return items[currentIndex];
        }
    }

    public void ensureCapacity(int newCapacity) {
        if (items.length < newCapacity) {
            items = Arrays.copyOf(items, newCapacity);

            ++modCount;
        }
    }

    public void trimToSize() {
        if (items.length > size) {
            items = Arrays.copyOf(items, size);

            ++modCount;
        }
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("index must be >=0 and < " + size + ", current indexValue: " + index);
        }
    }

    private void checkIndexForAdd(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("index must be >=0 and <= " + size + ", current indexValue: " + index);
        }
    }

    @Override
    public String toString() {
        if (size == 0) {
            return "[]";
        }

        StringBuilder stringBuilder = new StringBuilder("[");

        for (int i = 0; i < size; ++i) {
            stringBuilder.append(items[i]).append(", ");
        }

        stringBuilder.setLength(stringBuilder.length() - 2);
        stringBuilder.append("]");

        return stringBuilder.toString();
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
    public boolean contains(Object item) {
        return indexOf(item) >= 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyArrayListIterator();
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(items, size);
    }

    @Override
    public <E> E[] toArray(E[] elements) {
        if (elements.length < size) {
            //noinspection unchecked
            return (E[]) Arrays.copyOf(items, size, elements.getClass());
        }

        //noinspection SuspiciousSystemArraycopy
        System.arraycopy(items, 0, elements, 0, size);

        if (elements.length > size) {
            elements[size] = null;
        }

        return elements;
    }

    @Override
    public boolean add(T item) {
        add(size, item);
        return true;
    }

    @Override
    public boolean remove(Object item) {
        int index = indexOf(item);

        if (index >= 0) {
            remove(index);

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
        return addAll(size, collection);
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> collection) {
        checkIndexForAdd(index);

        if (collection.isEmpty()) {
            return false;
        }

        int requiredCapacity = size + collection.size();

        if (items.length < requiredCapacity) {
            ensureCapacity(requiredCapacity + 1);
        }

        System.arraycopy(items, index, items, index + collection.size(), size - index);

        for (T element : collection) {
            items[index++] = element;
        }

        size += collection.size();
        ++modCount;

        return true;
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        boolean isCollectionModified = false;

        for (int i = 0; i < size; ++i) {
            if (collection.contains(items[i])) {
                remove(i);
                --i;

                isCollectionModified = true;
            }
        }

        return isCollectionModified;
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        boolean isCollectionModified = false;

        for (int i = 0; i < size; ++i) {
            if (!collection.contains(items[i])) {
                remove(i);
                --i;

                isCollectionModified = true;
            }
        }

        return isCollectionModified;
    }

    @Override
    public void clear() {
        ++modCount;

        for (int i = 0; i < size; i++) {
            items[i] = null;
        }

        size = 0;
    }

    @Override
    public T get(int index) {
        checkIndex(index);

        return items[index];
    }

    @Override
    public T set(int index, T item) {
        checkIndex(index);

        T oldItem = items[index];
        items[index] = item;

        return oldItem;
    }

    @Override
    public void add(int index, T item) {
        checkIndexForAdd(index);

        if (items.length == size) {
            ensureCapacity(items.length * 2 + 1);
        }

        if (index < size) {
            System.arraycopy(items, index, items, index + 1, size - index);
        }

        items[index] = item;
        ++modCount;

        ++size;
    }

    @Override
    public T remove(int index) {
        checkIndex(index);

        T removedItem = items[index];

        if (index == size - 1) {
            items[index] = null;
        } else {
            System.arraycopy(items, index + 1, items, index, size - 1 - index);
        }

        ++modCount;
        items[size - 1] = null;
        --size;

        return removedItem;
    }

    @Override
    public int indexOf(Object item) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(items[i], item)) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public int lastIndexOf(Object item) {
        for (int i = size - 1; i >= 0; i--) {
            if (Objects.equals(items[i], item)) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }
}
