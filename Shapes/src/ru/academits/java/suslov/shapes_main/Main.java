package ru.academits.java.suslov.shapes_main;

import ru.academits.java.suslov.shapes.*;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Shape[] shapes = {new Square(10),
                new Square(5),
                new Triangle(0, 0, 0, 20, 20, 0),
                new Rectangle(5, 30),
                new Circle(7)};

        printShapeWithMaxArea(shapes);
    }

    private static void printShapeWithMaxArea(Shape[] shapes) {
        Arrays.sort(shapes, Comparator.comparingDouble(Shape::getArea));

        System.out.printf("Максимальная площадь фигуры %.2f", shapes[0].getArea());
    }
}
