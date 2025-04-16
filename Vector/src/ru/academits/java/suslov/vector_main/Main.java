package ru.academits.java.suslov.vector_main;

import ru.academits.java.suslov.vector.Vector;

public class Main {
    public static void main(String[] args) {
        System.out.printf("Конструкторы%n");

        Vector vector1 = new Vector(1);
        Vector vector2 = new Vector(5);
        //    Vector vector3 = new Vector(-1);

        System.out.printf("Вектор 1: %s%n", vector1);
        System.out.printf("Вектор 2: %s%n%n", vector2);

        vector1 = new Vector(new double[]{1, 2, 3});
        vector2 = new Vector(5, new double[]{9, 8, 7});

        System.out.printf("Вектор 1: %s%n", vector1);
        System.out.printf("Вектор 2: %s%n%n", vector2);

        vector1 = new Vector(vector2);

        System.out.printf("Вектор 1: %s%n", vector1);
        System.out.printf("Вектор 2: %s%n%n", vector2);

        System.out.printf("Метод getSize() для получения размерности вектора%n%n");
        System.out.printf("Размер вектора 1 = %d%n%n", vector1.getSize());

        vector2 = new Vector(new double[]{0, 1, 2, 3, 4, 5});
        System.out.printf("""
                Сложение векторов %s
                                и %s%n""", vector1, vector2);

        vector1.add(vector2);

        System.out.printf("Результат =       %s%n%n", vector1);

        System.out.printf("""
                Вычитание из вектора %s
                             вектора %s%n""", vector1, vector2);

        vector1.subtract(vector2);

        System.out.printf("Результат =          %s%n%n", vector1);

        System.out.printf("Умножение вектора %s на %.1f%n", vector1, 5.5);

        vector1.multiply(5.5);

        System.out.printf("Результат = %s%n%n", vector1);

        System.out.printf("Разворот вектора %s%n", vector1);

        vector1.revert();

        System.out.printf("Результат = %s%n%n", vector1);

        System.out.printf("Получение длины вектора %s%n", vector1);
        System.out.printf("Результат = %s%n%n", vector1.getLength());

        System.out.printf("Установка компоненты вектора %s по индексу %d. Поставим %f%n", vector1, 0, 4.2);

        vector1.setComponent(0, 4.2);

        System.out.printf("Получение компоненты вектора %s по индексу %d%n", vector1, 0);
        System.out.printf("Результат = %s%n%n", vector1.getComponent(0));

        vector1 = new Vector(new double[]{1.0, 2.0, 3.0});
        vector2 = new Vector(new double[]{1.0, 2.0, 3.2});

        if (vector1.equals(vector2)) {
            System.out.printf("Вектора %s и %s равны%n%n", vector1, vector2);
        } else {
            System.out.printf("Вектора %s и %s не равны%n%n", vector1, vector2);
        }

        System.out.printf("Вектор сумма двух векторов %s и %s%n", vector1, vector2);

        Vector vector3 = Vector.getSum(vector1, vector2);

        System.out.printf("Результат = %s%n%n", vector3);

        vector1 = new Vector(new double[]{5.0, 5.0, 5.0});
        vector2 = new Vector(new double[]{3.0, 2.0, 1.0});

        System.out.printf("Вектор разность двух векторов %s и %s%n", vector1, vector2);

        vector3 = Vector.getDifference(vector1, vector2);

        System.out.printf("Результат = %s%n%n", vector3);

        vector1 = new Vector(new double[]{5.0, 5.0, 5.0});
        vector2 = new Vector(new double[]{0.0, 2.0, 1.0});

        System.out.printf("Скалярное произведение произведение двух векторов %s и %s%n", vector1, vector2);

        System.out.printf("Результат = %.2f%n%n", Vector.getScalarProduct(vector1, vector2));
    }
}
