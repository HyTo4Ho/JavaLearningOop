package ru.academits.java.suslov.array_list;

import java.util.*;

public class ArrayList<E> implements List<E> {
    private E[] items;
    private int count;
    private int modCount;

    @SuppressWarnings("unchecked")
    public ArrayList(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException(String.format("Размер должен быть положительным числом. Передано = %d", capacity));
        }

        items = (E[]) new Object[capacity];
    }

    @SuppressWarnings("unchecked")
    public ArrayList() {
        items = (E[]) new Object[8];
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
            items = Arrays.copyOf(items, items.length * 2);
        }
    }

    @Override
    public boolean add(E element) {
        ensureCapacity(count + 1);

        items[count] = element;
        count++;
        modCount++;

        return true;
    }

    @Override
    public void add(int index, E element) {
        if (index < 0 || index > count) {
            throw new IllegalArgumentException(String.format("Индекс должен быть между 0 и %d. Передано = %d", count, index));
        }

        ensureCapacity(count + 1);

        System.arraycopy(items, index, items, index + 1, count - index);
        items[index] = element;

        count++;
        modCount++;
    }

    @Override
    public boolean remove(Object o) {
        int index = indexOf(o);

        if (index < 0) {
            return false;
        }

        remove(index);

        return true;
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index > count - 1) {
            throw new IllegalArgumentException(String.format("Индекс должен быть между 0 и %d. Передано = %d", count - 1, index));
        }

        E oldItem = items[index];

        System.arraycopy(items, index + 1, items, index, count - index - 1);

        count--;
        modCount++;

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
            if (items[i].equals(o)) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {

        for (int i = count - 1; i >= 0; i--) {
            if (items[i].equals(o)) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            private int currentIndex = -1;
            private final int freezeModCount = modCount;

            @Override
            public boolean hasNext() {
                return currentIndex + 1 < count;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("Коллекция кончилась");
                }

                if (freezeModCount != modCount) {
                    throw new ConcurrentModificationException("Коллекция не актуальна");
                }

                ++currentIndex;
                return items[currentIndex];
            }
        };
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(items, count);
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T[] toArray(T[] a) {
        if (a.length < count) {
            a = (T[]) Arrays.copyOf(items, count);
            return a;
        }

        return (T[]) Arrays.copyOf(items, count);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return addAll(count, c);
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        if (index < 0 || index > count) {
            throw new IllegalArgumentException(String.format("Индекс должен быть между 0 и %d. Передано = %d", count, index));
        }

        if (c.isEmpty()) {
            return false;
        }

        ensureCapacity(count + c.size());

        System.arraycopy(items, index, items, index + c.size(), count - index);

        int i = index;

        for (E object : c) {
            items[i] = object;
            i++;
        }

        count += c.size();
        modCount++;

        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean hasSuccess = false;

        for (Object o : c) {
            while (indexOf(o) >= 0) {
                remove(indexOf(o));
                hasSuccess = true;
            }
        }

        return hasSuccess;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        if (c.isEmpty()) {
            this.clear();
            return true;
        }

        boolean hasSuccess = false;

        for (int i = 0; i < count - 1; ) {
            if (!c.contains(items[i])) {
                remove(items[i]);
                hasSuccess = true;
                continue;
            }

            i++;
        }

        return hasSuccess;
    }

    @Override
    public void clear() {
        if (count == 0) {
            return;
        }

        Arrays.fill(items, 0, count, null);
        count = 0;
        modCount++;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index > count - 1) {
            throw new IllegalArgumentException(String.format("Индекс должен быть между 0 и %d. Передано = %d", count - 1, index));
        }

        return items[index];
    }

    @Override
    public E set(int index, E element) {
        if (index < 0 || index > count - 1) {
            throw new IllegalArgumentException(String.format("Индекс должен быть между 0 и %d. Передано = %d", count - 1, index));
        }

        E oldValue = items[index];

        items[index] = element;
        modCount++;

        return oldValue;
    }


    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public String toString() {
        if (count == 0) {
            return "{}";
        }

        int maxIndex = count - 1;
        StringBuilder stringBuilder = new StringBuilder("{");

        for (int i = 0; i < maxIndex; i++) {
            stringBuilder.append(items[i]).append(", ");
        }

        stringBuilder.append(items[maxIndex]).append('}');

        return stringBuilder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ArrayList<?> arrayList = (ArrayList<?>) o;

        return count == arrayList.count && Arrays.equals(items, arrayList.items);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(count);
        result = 31 * result + Arrays.hashCode(items);
        return result;
    }

    public void trimToSize() {
        if (items.length > count) {
            items = Arrays.copyOf(items, count);
        }
    }
}
