package ru.academits.java.suslov.shapes_main;

import ru.academits.java.suslov.shapes.*;
import ru.academits.java.suslov.shapes_comparators.ShapesAreaComparator;
import ru.academits.java.suslov.shapes_comparators.ShapesPerimeterComparator;

import java.util.Arrays;

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

        for (Shape shape : shapes) {
            System.out.println(shape);
        }

        System.out.println();

        System.out.printf("Максимальная площадь фигуры = %.2f%n", getShapeWithMaxArea(shapes).getArea());
        System.out.printf("Почти самый большой периметр фигуры = %.2f", getShapeWithPreMaxPerimeter(shapes).getPerimeter());
    }

    private static Shape getShapeWithMaxArea(Shape[] shapes) {
        Arrays.sort(shapes, new ShapesAreaComparator());

        return shapes[shapes.length - 1];
    }

    private static Shape getShapeWithPreMaxPerimeter(Shape[] shapes) {
        Arrays.sort(shapes, new ShapesPerimeterComparator());

        return shapes[shapes.length - 2];
    }
}
