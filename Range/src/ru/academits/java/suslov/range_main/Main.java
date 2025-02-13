package ru.academits.java.suslov.range_main;

import ru.academits.java.suslov.range.Range;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Здравствуйте!");
        System.out.println("Пожалуйста, задайте два интервала, а мы поделаем с ними всякого разного.");
        System.out.println("Задайте первый интервал. Введите два числа по маске \"x y\":");
        String pointsInputString = scanner.nextLine();

        System.out.println("Задайте второй интервал. Введите два числа по маске \"x y\":");
        pointsInputString = pointsInputString + " " + scanner.nextLine();

        String[] points = pointsInputString.split(" ");

        Range range1 = new Range(Double.parseDouble(points[0]), Double.parseDouble(points[1]));
        Range range2 = new Range(Double.parseDouble(points[2]), Double.parseDouble(points[3]));

        System.out.printf("Длина первого диапазона: %.2f, а второго: %.2f", range1.getLength(), range2.getLength());
        System.out.println();

        if (range1.isInside(0) && range2.isInside(0)) {
            System.out.println("Оба отрезка проходят через 0");
        } else if (!range1.isInside(0) && !range2.isInside(0)) {
            System.out.println("Ни один из отрезков не проходит через 0");
        } else if (range1.isInside(0)) {
            System.out.println("Первый отрезок проходит через 0");
        } else {
            System.out.println("Второй отрезок проходит через 0");
        }

        Range joinRange = range1.getIntersection(range2);

        if (joinRange != null) {
            System.out.printf("Отрезки пересекаются на интервале от: %.2f до: %.2f", joinRange.getFrom(), joinRange.getTo());
            System.out.println();
        } else {
            System.out.println("Отрезки не пересекаются");
        }

        Range[] mergeRange = range1.getMerge(range2);

        if (mergeRange.length == 2) {
            System.out.printf("При объединении получаются отрезки от: %.2f до: %.2f и от: %.2f до: %.2f", mergeRange[0].getFrom(), mergeRange[0].getTo(), mergeRange[1].getFrom(), mergeRange[1].getTo());
            System.out.println();
        } else {
            System.out.printf("При объединении получается отрезок от: %.2f до: %.2f", mergeRange[0].getFrom(), mergeRange[0].getTo());
            System.out.println();
        }

        Range[] subtractionRange = range1.getDifference(range2);

        if (subtractionRange.length == 2) {
            System.out.printf("При вычитании получаются отрезки от: %.2f до: %.2f и от: %.2f до: %.2f", subtractionRange[0].getFrom(), subtractionRange[0].getTo(), subtractionRange[1].getFrom(), subtractionRange[1].getTo());
            System.out.println();
        } else if (subtractionRange.length == 1) {
            System.out.printf("При вычитании получается отрезок от: %.2f до: %.2f", subtractionRange[0].getFrom(), subtractionRange[0].getTo());
            System.out.println();
        } else {
            System.out.println("При вычитании ничего не остается");
        }
    }
}