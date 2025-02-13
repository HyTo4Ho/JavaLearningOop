package ru.academits.java.suslov.shapes_main;

import ru.academits.java.suslov.shapes.*;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // todo может бахнуть цикл с рандомными фигурами? Написать их в консоль, потом сравнивать
        Shape[] shapes = {new Square(10),
                new Square(5),
                new Triangle(0, 0, 0, 20, 20, 0),
                new Rectangle(5, 30),
                new Circle(7)};

        getShapeWithMaxArea(shapes);
    }

    // todo тут надо через Array.sort с компаратором. Что бы это не значило
    private static void getShapeWithMaxArea(Shape[] shapes) {
        int indexMaxArea = 0;

        if (shapes.length != 1) {
            for (int i = 1; i < shapes.length; i++) {
                if (shapes[i].getArea() > shapes[indexMaxArea].getArea()) {
                    indexMaxArea = i;
                }
            }
        }

        System.out.printf("Максимальная площадь %.2f у фигуры с индексом %s", shapes[indexMaxArea].getArea(), indexMaxArea);
    }
}
