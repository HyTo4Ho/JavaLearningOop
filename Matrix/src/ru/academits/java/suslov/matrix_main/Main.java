package ru.academits.java.suslov.matrix_main;

import ru.academits.java.suslov.matrix.Matrix;
import ru.academits.java.suslov.vector.Vector;

import java.util.Arrays;

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

        System.out.println("Зададим элемент матрицы под номером 1");
        System.out.println();

        matrix1.setRow(1, new Vector(new double[]{7, 7, 7}));

        System.out.printf("Результат = %s", matrix1);
        System.out.println();
        System.out.println();

        System.out.println("Получим элемент матрицы под номером 1");
        System.out.println();
        System.out.printf("Результат = %s", matrix1.getRow(1).toString());
        System.out.println();
        System.out.println();

        System.out.println("Получим вектор-столбец под номером 2");
        System.out.println();
        System.out.printf("Результат = %s", matrix1.getColumnByIndex(2));
        System.out.println();
        System.out.println();

        matrix1 = new Matrix(new double[][]{{1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}, {7.0, 8.0, 9.0}});

        System.out.printf("Транспонирование матрицы %s", matrix1);
        System.out.println();

        matrix1.transpose();

        System.out.printf("Результат = %s", matrix1);
        System.out.println();
        System.out.println();

        System.out.println("Умножим матрицу на 0! А ХА ХА ХА ХА");
        System.out.println();

        matrix2 = new Matrix(matrix1);
        matrix1.multiply(0);

        System.out.printf("Результат = %s", matrix1);
        System.out.println();
        System.out.println();

        System.out.println("Ладно, вернём как было и умножим на 1.5");
        System.out.println();

        matrix1 = new Matrix(matrix2);
        matrix1.multiply(1.5);

        System.out.printf("Результат = %s", matrix1);
        System.out.println();
        System.out.println();

        System.out.printf("Определитель такой матрицы = %s", matrix1.getDeterminant());
        System.out.println();
        System.out.println();

        matrix1 = new Matrix(new double[][]{{5, 1, 20}, {7, 2, 18}, {4, 3, 70}});

        System.out.printf("А для матрицы %s", matrix1);
        System.out.println();
        System.out.printf("Определитель = %s", matrix1.getDeterminant());
        System.out.println();
        System.out.println();

        Vector vector = new Vector(new double[]{1, 6, 3});

        System.out.printf("Умножение матрицы %s на вектор %s", matrix1, vector);
        System.out.println();
        System.out.printf("Результат = %s", Arrays.toString(matrix1.multiplyOnVector(vector)));
        System.out.println();
        System.out.println();

        matrix1 = new Matrix(new double[][]{{1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}});
        matrix2 = new Matrix(new double[][]{{7.0, 9.0, 5.0}, {7.0, 3.0, 4.0}});

        System.out.printf("Прибавить к матрице %s матрицу %s", matrix1, matrix2);
        System.out.println();

        matrix1.add(matrix2);

        System.out.printf("Результат = %s", matrix1);
        System.out.println();
        System.out.println();

        System.out.printf("Вычитание из матрицы %s матрицы %s", matrix1, matrix2);
        System.out.println();

        matrix1.subtract(matrix2);

        System.out.printf("Результат = %s", matrix1);
        System.out.println();
        System.out.println();

        Matrix matrix3 = Matrix.getSum(matrix1, matrix2);

        System.out.printf("Сложение матрицы %s и %s", matrix1, matrix2);
        System.out.println();
        System.out.printf("Результат = %s", matrix3);
        System.out.println();
        System.out.println();

        matrix3 = Matrix.getDifference(matrix1, matrix2);

        System.out.printf("Вычитание из матрицы %s матрицы %s", matrix1, matrix2);
        System.out.println();
        System.out.printf("Результат = %s", matrix3);
        System.out.println();
        System.out.println();

        System.out.printf("Умножение матриц %s и %s", matrix1, matrix2);
        System.out.println();
        System.out.printf("Результат = %s", Matrix.getMultiple(matrix1, matrix2));
        System.out.println();
        System.out.println();
    }
}
