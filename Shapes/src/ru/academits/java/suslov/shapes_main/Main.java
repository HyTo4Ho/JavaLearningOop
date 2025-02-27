package ru.academits.java.suslov.shapes_main;

import ru.academits.java.suslov.shapes.*;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Shape[] shapes = {
                new Square(10),
                new Square(5),
                new Triangle(0, 0, 0, 20, 20, 0),
                new Rectangle(5, 30),
                new Circle(7)
        };

        System.out.println("Имеем такие фигуры:");
        for (Shape e : shapes) {
            System.out.println(e.toString());
        }

        System.out.println();

        System.out.printf("Максимальная площадь фигуры = %.2f", getShapeWithMaxArea(shapes));
        System.out.println();
        System.out.printf("Почти самый большой периметр фигуры = %.2f", getShapeWithPreMaxPerimeter(shapes));
    }

    private static double getShapeWithMaxArea(Shape[] shapes) {
        Arrays.sort(shapes, new ShapesAreaComparator());

        return shapes[shapes.length - 1].getArea();
    }

    private static double getShapeWithPreMaxPerimeter(Shape[] shapes) {
        Arrays.sort(shapes, new ShapesPerimeterComparator());

        return shapes[shapes.length - 2].getPerimeter();
    }
}
