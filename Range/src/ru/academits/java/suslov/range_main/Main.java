package ru.academits.java.suslov.range_main;

import ru.academits.java.suslov.range.Range;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите два числа по маске \"x y\":");
        String input = scanner.nextLine();

        String[] dots = input.split(" ");

        Range range = new Range(Double.parseDouble(dots[0]), Double.parseDouble(dots[1]));

        if (range.isInside(0)) {
            System.out.printf("Длина диапазона: %.2f", range.getLength());
        } else {
            System.out.println("Прямая не проходит через 0");
        }
    }
}
