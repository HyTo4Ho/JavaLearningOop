package ru.academits.java.suslov.arrayListHome_main;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> listFromFile = readListFromFile();

        System.out.println(listFromFile);

        ArrayList<Integer> numbersList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 1, 5, 5));
        removeEvenNumbers(numbersList);

        System.out.println(numbersList);

        ArrayList<Integer> newNumbersList = new ArrayList<>(removeDuplicateNumbers(numbersList));

        System.out.println(newNumbersList);
    }

    private static ArrayList<String> readListFromFile() {
        ArrayList<String> resultList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("ArrayListHome\\src\\input.txt"))) {
            while (true) {
                String line = reader.readLine();

                if (line == null) {
                    break;
                }

                resultList.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return resultList;
    }

    private static void removeEvenNumbers(ArrayList<Integer> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) % 2 == 0) {
                list.remove(i);
                i--;
            }
        }
    }

    private static ArrayList<Integer> removeDuplicateNumbers(ArrayList<Integer> list) {
        ArrayList<Integer> resultList = new ArrayList<>();

        for (int i = 0; i < list.size() - 1; i++) {
            if (list.indexOf(list.get(i)) >= i) {
                resultList.add(list.get(i));
            }
        }

        return resultList;
    }
}
