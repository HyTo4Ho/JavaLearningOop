package ru.academits.java.suslov.arrayList;

import java.util.*;

public class ArrayList<T> implements List<T> {
    private T[] items;
    private int count;

    public ArrayList(int capacity) {
        items = (T[]) new Object[capacity];
    }

    public ArrayList() {
        items = (T[]) new Object[1];
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    public void ensureCapacity(int capacity) {
        if (capacity > items.length) {
            items = Arrays.copyOf(items, capacity);
        }
    }

    @Override
    public boolean add(T element) {
        ensureCapacity(count + 1);

        items[count] = element;
        count++;

        return false;
    }

    @Override
    public void add(int index, T element) {
        ensureCapacity(index);

        items[index] = element;

        count = Math.max(count, index);
    }

    @Override
    public boolean remove(Object o) {
        int index = indexOf(o);

        remove(index);

        return false;
    }

    @Override
    public T remove(int index) {
        T oldItem = items[index];

        System.arraycopy(items, index + 1, items, index, count - index - 1);

        count--;

        return oldItem;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object object : c) {
            if (!contains(object)) {
                return false;
            }
        }

        return true;
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < count; i++) {
            if (items[i] == o) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        int index = 0;
        boolean found = false;

        for (int i = 0; i < count; i++) {
            if (items[i] == o) {
                found = true;
                index = i;
            }
        }

        return found ? index : -1;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            private int index = -1;

            @Override
            public boolean hasNext() {
                return index < count;
            }

            @Override
            public T next() {
                if (hasNext()) {
                    index++;
                    return items[index];
                }

                return null;
            }
        };
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(items, count);
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return Arrays.copyOf(a, count);
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return addAll(count, c);
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        if (c.isEmpty()) {
            return false;
        }

        ensureCapacity(count + c.size());

        System.arraycopy(items, index, items, index + c.size(), count - index);

        int i = index;

        for (T object : c) {
            items[i] = object;
            i++;
        }

        count += c.size();

        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean success = false;

        for (Object o : c) {
            if (remove(o)) {
                success = true;
            }
        }

        return success;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        boolean success = false;

        for (Object o : items) {
            if (!c.contains(o)) {
                remove(o);
                success = true;
            }
        }

        return success;
    }

    @Override
    public void clear() {
        Arrays.fill(items, 0, count, null);
        count = 0;
    }

    @Override
    public T get(int index) {
        return items[index];
    }

    @Override
    public T set(int index, T element) {
        items[index] = element;

        return element;
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

    @Override
    public String toString() {
        if (count == 0) {
            return "{}";
        }

        StringBuilder stringBuilder = new StringBuilder("{");

        for (int i = 0; i < count - 1; i++) {
            stringBuilder.append(items[i]).append(", ");
        }

        stringBuilder.append(items[count - 1]).append('}');

        return stringBuilder.toString();
    }
}
