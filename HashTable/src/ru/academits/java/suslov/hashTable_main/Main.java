package ru.academits.java.suslov.hashTable_main;
import ru.academits.java.suslov.hashTable.HashTable;

public class Main {
    public static void main(String[] args) {
        HashTable<String> hashTable = new HashTable<>(10);

        System.out.printf("Размер таблицы: %d%n", hashTable.size());

        hashTable.add("one");
        hashTable.add("two");
        hashTable.add("three");
        hashTable.add("four");
        hashTable.add("five");

        System.out.printf("Размер таблицы: %d%n", hashTable.size());

        hashTable.remove("three");
        hashTable.remove("four");

        System.out.printf("Размер таблицы: %d%n", hashTable.size());

        if (hashTable.contains("one")) {
            System.out.printf("Таблица содержет \"one\"%n");
        } else {
            System.out.printf("Таблица не содержет \"one\"%n");

        }

        hashTable.clear();

        System.out.printf("Размер таблицы: %d%n", hashTable.size());
    }
}
