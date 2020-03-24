package name.max_ferrara.array_list;

import java.util.*;

public class MyArrayList<T> implements List<T> {
    private int size;
    private T[] items;
    private static final int DEFAULT_CAPACITY = 10;

    private int modCount = 0;

    public MyArrayList(int initialCapacity) {
        if (initialCapacity > 0) {
            items = (T[]) new Object[initialCapacity];
        } else {
            items = (T[]) new Object[DEFAULT_CAPACITY];
        }
        size = 0;
    }

    public MyArrayList() {
        items = (T[]) new Object[DEFAULT_CAPACITY];
        size = 0;
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

    public void ensureCapacity(int newCapacity) {
        if (newCapacity < size) {
            return;
        }

        ++modCount;

        items = Arrays.copyOf(items, newCapacity);
    }

    public void trimToSize() {
        ++modCount;

        ensureCapacity(size());
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
        if (item == null) {
            for (int index = 0; index < size; index++)
                if (items[index] == null) {
                    fastRemove(index);

                    return true;
                }
        } else {
            for (int index = 0; index < size; index++)
                if (item.equals(items[index])) {
                    fastRemove(index);

                    return true;
                }
        }

        return false;
    }

    private void fastRemove(int index) {
        if (index < 0 || index >= size()) {
            throw new ArrayIndexOutOfBoundsException("array index of bound");
        }

        ++modCount;

        int numMoved = size - index - 1;

        if (numMoved > 0) {
            System.arraycopy(items, index + 1, items, index, numMoved);
        }

        items[--size] = null;
    }

    private boolean batchRemove(Collection<?> c, boolean complement) {
        final Object[] items = this.items;
        int count = 0;
        int containsCount = 0;
        boolean isModified = false;

        try {
            for (; count < size; count++)
                if (c.contains(items[count]) == complement) {
                    items[containsCount++] = items[count];
                }
        } finally {
            if (count != size) {
                System.arraycopy(items, count, items, containsCount, size - count);
                containsCount += size - count;
            }
            if (containsCount != size) {
                for (int i = containsCount; i < size; i++) {
                    items[i] = null;
                }
                modCount += size - containsCount;
                size = containsCount;

                isModified = true;
            }
        }

        return isModified;
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        Set<?> set = new HashSet<>(collection);

        for (T element : items) {
            if (set.contains(element)) {
                set.remove(element);

                if (set.isEmpty()) {
                    return true;
                }
            }
        }

        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> collection) {
        Object[] incomingCollection = collection.toArray();

        int numNew = incomingCollection.length;
        ensureCapacity(size + numNew);
        System.arraycopy(incomingCollection, 0, items, size, numNew);
        size += numNew;

        return numNew != 0;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> collection) {
        Object[] incomingCollection = collection.toArray();

        int numNew = incomingCollection.length;
        ensureCapacity(size + numNew);
        int numMoved = size - index;

        if (numMoved > 0) {
            System.arraycopy(items, index, items, index + numNew, numMoved);
        }

        System.arraycopy(incomingCollection, 0, items, index, numNew);
        size += numNew;

        return numNew != 0;
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        if (collection == null) {
            throw new NullPointerException("collection is null");
        }

        return batchRemove(collection, false);
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        if (collection == null) {
            throw new NullPointerException("collection is null");
        }

        return batchRemove(collection, true);
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
        if (item == null) {
            for (int i = 0; i < size; i++) {
                if (items[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (item.equals(items[i])) {
                    return i;
                }
            }
        }

        return -1;
    }

    @Override
    public int lastIndexOf(Object item) {
        if (item == null) {
            for (int i = size - 1; i >= 0; i--) {
                if (items[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = size - 1; i >= 0; i--) {
                if (item.equals(items[i])) {
                    return i;
                }
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
