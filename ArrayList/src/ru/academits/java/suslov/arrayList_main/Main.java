package ru.academits.java.suslov.arrayList_main;

import ru.academits.java.suslov.arrayList.ArrayList;

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

        arrayList.add(2, 30);

        System.out.printf("Размер списка: %d%n", arrayList.size());
        System.out.println(arrayList);

        arrayList.remove(1);

        System.out.printf("Размер списка: %d%n", arrayList.size());
        System.out.println(arrayList);

        Object o = 10;
        arrayList.remove(o);

        System.out.printf("Размер списка: %d%n", arrayList.size());
        System.out.println(arrayList);
    }
}
