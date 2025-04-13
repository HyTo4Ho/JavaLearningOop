package ru.academits.java.suslov.list_main;

import ru.academits.java.suslov.list.SinglyLinkedList;

public class Main {
    public static void main(String[] args) {
        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();

        singlyLinkedList.setHead(5);
        singlyLinkedList.setHead(4);
        singlyLinkedList.setHead(3);
        singlyLinkedList.setHead(2);
        singlyLinkedList.setHead(1);

        singlyLinkedList.setElementByIndex(6, 10);
        singlyLinkedList.setElementByIndex(6, 11);
        singlyLinkedList.setElementByIndex(6, 12);
        singlyLinkedList.setElementByIndex(6, 13);
        singlyLinkedList.setElementByIndex(6, 14);
        singlyLinkedList.setElementByIndex(6, 15);

        System.out.println(singlyLinkedList);

        System.out.printf("Размер списка: %d%n", singlyLinkedList.getCount());
        System.out.printf("Значение первого элемента списка: %d%n", singlyLinkedList.getHead());

        System.out.printf("Значение первого элемента списка было: %d, стало: %d%n", singlyLinkedList.deleteHead(), singlyLinkedList.getHead());

        System.out.printf("Значение третьего элемента списка было: %d, стало: %d%n", singlyLinkedList.modifyElementByIndex(3, 33), singlyLinkedList.getElementByIndex(3));

        System.out.printf("Значение второго элемента списка было: %d, стало: %d%n", singlyLinkedList.deleteElementByIndex(2), singlyLinkedList.getElementByIndex(2));

        System.out.println(singlyLinkedList);

        if (singlyLinkedList.deleteElementByValue(33)) {
            System.out.printf("Удалили элемент со значением 33, такие дела%n");
        }

        System.out.println(singlyLinkedList);

        System.out.printf("Разворот списка%n");
        singlyLinkedList.revertList();

        System.out.println(singlyLinkedList);

        SinglyLinkedList<Integer> newList = singlyLinkedList.copyList();

        System.out.printf("Копирование списка%n");
        System.out.println(singlyLinkedList);
        System.out.println(newList);

        newList.setElementByIndex(3, 10000);

        System.out.printf("%n");
        System.out.println(singlyLinkedList);
        System.out.println(newList);
    }
}
