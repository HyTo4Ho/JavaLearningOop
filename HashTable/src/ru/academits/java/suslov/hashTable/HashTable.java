package ru.academits.java.suslov.hashTable;

import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;

import ru.academits.java.suslov.arrayList.ArrayList;

public class HashTable<T> implements Collection<T> {
    private final ArrayList[] items;
    private int count;

    public HashTable(int count) {
        items = new ArrayList[count];
    }

    public HashTable() {
        this(100);
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public boolean contains(Object o) {
        return items[Math.abs(Objects.hashCode(o) % items.length)].contains(o);
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
    public boolean add(T t) {
        items[Math.abs(Objects.hashCode(t) % items.length)].add(t);

        return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        for (T item : c) {
            add(item);
        }

        return true;
    }

    @Override
    public boolean remove(Object o) {
        items[Math.abs(Objects.hashCode(o) % items.length)].remove(o);

        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        for (Object item : c) {
            remove(item);
        }

        return true;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        for (Object item : c) {
            if (!contains(c)) {
                remove(item);
            }
        }

        return true;
    }

    @Override
    public void clear() {
        for (ArrayList item : items) {
            if (item != null) {
                item.clear();
            }
        }
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[count];

        int i = 0;

        for (T row : this) {
            array[i] = row;
            i++;
        }

        return array;
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return a;
    }
}
