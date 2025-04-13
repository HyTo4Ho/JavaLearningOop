package ru.academits.java.suslov.list;

public class SinglyLinkedList<T> {
    private ListItem<T> head;
    private int count;

    public SinglyLinkedList() {
    }

    /**
     * Получение размера списка
     */
    public int getCount() {
        return count;
    }

    /**
     * Получение значения первого элемента
     */
    public T getHead() {
        return head.getData();
    }

    /**
     * Вставка элемента в начало
     */
    public void setHead(T value) {
        this.head = new ListItem<>(value, this.head);

        count++;
    }

    /**
     * Удаление первого элемента
     */
    public T deleteHead() {
        T oldValue = head.getData();
        head = head.getNext();

        count--;

        return oldValue;
    }

    /**
     * Получение значения по указанному индексу
     */
    public T getElementByIndex(int index) {
        checkIndex(index);

        ListItem<T> item = head;

        for (int i = 2; i <= index; i++) {
            item = item.getNext();
        }

        return item.getData();
    }

    private void checkIndex(int index) {
        if (index <= 0 || index > count + 1) {
            throw new IndexOutOfBoundsException(String.format("Неверный индекс %d. Возможно значение от 1 до %d", index, count + 1));
        }
    }

    /**
     * Изменение значения по указанному индексу
     */
    public T modifyElementByIndex(int index, T value) {
        checkIndex(index);

        ListItem<T> item = head;

        for (int i = 2; i <= index; i++) {
            item = item.getNext();
        }

        T oldValue = item.getData();
        item.setData(value);

        return oldValue;
    }

    /**
     * Удаление элемента по индексу
     */
    public T deleteElementByIndex(int index) {
        checkIndex(index);

        ListItem<T> item = head;

        for (int i = 2; i < index; i++) {
            item = item.getNext();
        }

        T oldValue = item.getData();

        item.setNext(item.getNext().getNext());

        count--;

        return oldValue;
    }

    /**
     * Вставка элемента по индексу
     */
    public void setElementByIndex(int index, T value) {
        checkIndex(index);

        ListItem<T> item = head;

        for (int i = 2; i < index; i++) {
            item = item.getNext();
        }

        ListItem<T> newItem = new ListItem<>(value, item.getNext());
        item.setNext(newItem);

        count++;
    }

    /**
     * Удаление элемента по значению
     */
    public boolean deleteElementByValue(T value) {
        ListItem<T> item = head;

        if (head.getData() == value) {
            deleteHead();
            return true;
        }

        for (int i = 2; i <= count; i++) {
            item = item.getNext();

            if (item.getData() == value) {
                deleteElementByIndex(i);
                return true;
            }
        }

        return false;
    }

    /**
     * Разворот списка за линейное время
     */
    public void revertList() {
        ListItem<T> previousItem = null;

        for (ListItem<T> currentItem = head; currentItem != null; ) {
            ListItem<T> nextItem = currentItem.getNext();
            currentItem.setNext(previousItem);
            previousItem = currentItem;
            currentItem = nextItem;
        }

        head = previousItem;
    }

    /**
     * Копирование списка
     */
    public SinglyLinkedList<T> copyList() {
        SinglyLinkedList<T> newList = new SinglyLinkedList<>();

        ListItem<T> item = head;
        newList.setHead(item.getData());

        for (int i = 2; i <= count; i++) {
            item = item.getNext();
            newList.setElementByIndex(i, item.getData());
        }

        return newList;
    }

    @Override
    public String toString() {
        if (head == null) {
            return "{}";
        }

        StringBuilder stringBuilder = new StringBuilder("{");

        ListItem<T> item = head;

        while (item != null) {
            stringBuilder.append(item.getData()).append(", ");

            item = item.getNext();
        }

        if (stringBuilder.length() > 1) {
            stringBuilder.setLength(stringBuilder.length() - 2);
        }

        return stringBuilder.append('}').toString();
    }
}
