package ru.academits.java.suslov.matrix_main;

import ru.academits.java.suslov.matrix.Matrix;
import ru.academits.java.suslov.vector.Vector;

public class Main {
    public static void main(String[] args) {
        System.out.println("Конструкторы");
        System.out.println();

        Matrix matrix1 = new Matrix(2, 2);
        Matrix matrix2 = new Matrix(3, 2);

        System.out.printf("Матрица 1: %s", matrix1);
        System.out.println();
        System.out.printf("Матрица 2: %s", matrix2);
        System.out.println();
        System.out.println();

        matrix2 = new Matrix(matrix1);

        System.out.printf("Матрица 1: %s", matrix1);
        System.out.println();
        System.out.printf("Матрица 2: %s", matrix2);
        System.out.println();
        System.out.println();

        matrix1 = new Matrix(new double[][]{{1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}});
        matrix2 = new Matrix(new Vector[]{new Vector(3), new Vector(5)});

        System.out.printf("Матрица 1: %s", matrix1);
        System.out.println();
        System.out.printf("Матрица 2: %s", matrix2);
        System.out.println();
        System.out.println();

        System.out.println("Метод getSize() для получения размерности матрицы");
        System.out.println();
        System.out.printf("Размер матрицы 1 = %d", matrix1.getSize());
        System.out.println();
        System.out.println();
    }
}
