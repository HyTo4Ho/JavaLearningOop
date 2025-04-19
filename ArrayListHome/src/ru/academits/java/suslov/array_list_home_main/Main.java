package ru.academits.java.suslov.array_list_home_main;

import java.io.*;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> rowsList;
        String path = String.valueOf(Paths.get("ArrayListHome", "src"));
        String fileName = "input.txt";

        System.out.printf("Прочитаем файл %s%n", path + File.separator + fileName);

        try {
            rowsList = readListFromFile(path, fileName);
            System.out.printf("Получили список: %s%n%n", rowsList);
        } catch (IOException e) {
            System.out.printf("Произошла ошибка: \"%s\"%n%n", e.getMessage());
        }

        ArrayList<Integer> numbersList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 1, 5, 5, 11, 12));
        System.out.printf("Теперь заводим новый список с числами: %s%n", numbersList);

        removeEvenNumbers(numbersList);
        System.out.printf("Тот же список, но без чётных чисел: %s%n", numbersList);

        ArrayList<Integer> distinctNumbersList = new ArrayList<>(getDistinctList(numbersList));
        System.out.printf("А это новый! Нуу.. на самом деле он как старый, но без дублей: %s%n", distinctNumbersList);
    }

    private static ArrayList<String> readListFromFile(String path, String fileName) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(path + File.separator + fileName))) {
            ArrayList<String> rowsList = new ArrayList<>();

            while (true) {
                String line = reader.readLine();

                if (line == null) {
                    break;
                }

                rowsList.add(line);
            }

            return rowsList;
        }
    }

    private static void removeEvenNumbers(ArrayList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) % 2 == 0) {
                list.remove(i);
                i--;
            }
        }
    }

    private static <T> ArrayList<T> getDistinctList(ArrayList<T> list) {
        ArrayList<T> resultList = new ArrayList<>(list.size());

        for (T currentElement : list) {
            if (!resultList.contains(currentElement)) {
                resultList.add(currentElement);
            }
        }

        return resultList;
    }
}
