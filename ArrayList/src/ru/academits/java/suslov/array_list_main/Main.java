package ru.academits.java.suslov.array_list_main;

import ru.academits.java.suslov.array_list.ArrayList;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();

        System.out.printf("Размер списка: %d%n", arrayList.size());

        arrayList.add(10);
        arrayList.add(23);
        arrayList.add(7);
        arrayList.add(879);

        System.out.printf("Размер списка: %d%n", arrayList.size());
        System.out.println(arrayList);

        arrayList.add(4, 4);
        arrayList.add(4, 30);
        arrayList.add(4, 10);
        arrayList.add(4, 30);

        System.out.printf("Размер списка: %d%n", arrayList.size());
        System.out.println(arrayList);

        System.out.printf("Первый индекс элемента 10: %d%n", arrayList.indexOf(10));
        System.out.printf("Последний индекс элемента 10: %d%n", arrayList.lastIndexOf(10));

        arrayList.remove(1);

        System.out.printf("Размер списка: %d%n", arrayList.size());
        System.out.println(arrayList);

        Integer[] c = new Integer[]{10};
        arrayList.removeAll(List.of(c));

        System.out.printf("Размер списка: %d%n", arrayList.size());
        System.out.println(arrayList);

        c = new Integer[]{1, 2, 3, 4};
        arrayList.retainAll(List.of(c));

        System.out.printf("Размер списка: %d%n", arrayList.size());
        System.out.println(arrayList);

        arrayList.clear();

        System.out.println(arrayList);

        arrayList.add(10);
        arrayList.trimToSize();

        System.out.printf("Размер списка: %d%n", arrayList.size());
        System.out.println(arrayList);
    }
}
