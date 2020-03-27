package name.max_ferrara.array_list;

import java.util.*;

public class MyArrayList<T> implements List<T> {
    private int size;
    private T[] items;
    private static final int DEFAULT_CAPACITY = 10;

    private int modCount;

    public MyArrayList(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("capacity can not be < 0");
        }

        if (initialCapacity <= 10) {
            items = (T[]) new Object[DEFAULT_CAPACITY];
        } else {
            items = (T[]) new Object[initialCapacity];
        }
    }

    public MyArrayList() {
        items = (T[]) new Object[DEFAULT_CAPACITY];
    }

    public class MyArrayListIterator implements Iterator<T> {
        int expectedModCount = MyArrayList.this.modCount;
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

            if (currentIndex >= size) {
                throw new NoSuchElementException("collection is ending");
            }

            ++currentIndex;
            return items[currentIndex];
        }
    }

    private void ensureCapacity(int newCapacity) {
        if(items.length < newCapacity) {
            items = Arrays.copyOf(items, newCapacity);

            ++modCount;
        }
    }

    public void trimToSize() {
        items = Arrays.copyOf(items, size());

        ++modCount;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("[ ");

        for (int i = 0; i < this.size; ++i) {
            stringBuilder.append(items[i]).append(", ");
        }

        stringBuilder.setLength(stringBuilder.length() - 2);
        stringBuilder.append(" ]");

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
    public <E> E[] toArray(E[] element) {
        if (element.length < size) {
            return (E[]) Arrays.copyOf(items, size, element.getClass());
        }

        System.arraycopy(items, 0, element, 0, size);

        if (element.length > size) {
            element[size] = null;
        }

        return element;
    }

    @Override
    public boolean add(T item) {
        add(size(), item);
        return true;
    }

    @Override
    public boolean remove(Object item) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(items[i], item)) {
                remove(i);

                return true;
            }
        }

        return false;
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> collection) {
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> collection) {
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        return false;
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
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("array index of bound");
        }

        return items[index];
    }

    @Override
    public T set(int index, T item) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("array index of bound");
        }

        T oldItem = items[index];
        items[index] = item;

        return oldItem;
    }

    @Override
    public void add(int index, T item) {
        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException("array index of bound");
        }

        ++modCount;

        if (items.length == size()) {
            ensureCapacity(size() * 2 + 1);
        }

        for (int i = size; i > index; --i) {
            items[i] = items[i - 1];
        }
        items[index] = item;

        ++size;
    }

    @Override
    public T remove(int index) {
        if (index < 0 || index >= size()) {
            throw new ArrayIndexOutOfBoundsException("array index of bound");
        }

        ++modCount;

        T removeItem = items[index];
        for (int i = index; i < size() - 1; i++) {
            items[i] = items[i + 1];
        }
        --size;

        return removeItem;
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
