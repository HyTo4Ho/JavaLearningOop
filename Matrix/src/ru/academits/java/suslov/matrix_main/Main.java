package ru.academits.java.suslov.matrix_main;

import ru.academits.java.suslov.matrix.Matrix;
import ru.academits.java.suslov.vector.Vector;

public class Main {
    public static void main(String[] args) {
        System.out.printf("Конструкторы%n");

        Matrix matrix1 = new Matrix(2, 2);
        Matrix matrix2 = new Matrix(3, 2);

        System.out.printf("Матрица 1: %s%n", matrix1);
        System.out.printf("Матрица 2: %s%n%n", matrix2);

        matrix2 = new Matrix(matrix1);

        System.out.printf("Матрица 1: %s%n", matrix1);
        System.out.printf("Матрица 2: %s%n%n", matrix2);

        matrix1 = new Matrix(new double[][]{{1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}});
        matrix2 = new Matrix(new Vector[]{new Vector(3), new Vector(5)});

        System.out.printf("Матрица 1: %s%n", matrix1);
        System.out.printf("Матрица 2: %s%n%n", matrix2);

        System.out.println("Метод getSize() для получения размерности матрицы%n");
        System.out.printf("Размер матрицы 1 = %d%n%n", matrix1.getRowsCount());

        System.out.println("Зададим элемент матрицы под номером 1%n");

        matrix1.setRow(1, new Vector(new double[]{7, 7, 7}));

        System.out.printf("Результат = %s%n%n", matrix1);

        System.out.println("Получим элемент матрицы под номером 1%n");
        System.out.printf("Результат = %s%n%n", matrix1.getRow(1).toString());

        System.out.println("Получим вектор-столбец под номером 2%n");
        System.out.printf("Результат = %s%n%n", matrix1.getColumnByIndex(2));

        matrix1 = new Matrix(new double[][]{{1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}, {7.0, 8.0, 9.0}, {7.0, 8.0, 9.0}});

        System.out.printf("Транспонирование матрицы %s%n", matrix1);

        matrix1.transpose();

        System.out.printf("Результат = %s%n%n", matrix1);

        System.out.printf("Умножим матрицу на 0! А ХА ХА ХА ХА%n");

        matrix1.multiply(0);

        System.out.printf("Результат = %s%n%n", matrix1);

        System.out.printf("Ладно, заведём новую квадратную матрицу%n");

        matrix1 = new Matrix(new double[][]{{5, 6}, {11, 2}});

        System.out.printf("Результат = %s%n%n", matrix1);

        System.out.printf("Определитель такой матрицы = %s%n%n", matrix1.getDeterminant());

        matrix1 = new Matrix(new double[][]{{5, 1, 20}, {7, 2, 18}, {4, 3, 70}});

        System.out.printf("А для матрицы %s%n", matrix1);
        System.out.printf("Определитель = %s%n%n", matrix1.getDeterminant());

        Vector vector = new Vector(new double[]{1, 6, 3});

        System.out.printf("Умножение матрицы %s на вектор %s%n", matrix1, vector);
        System.out.printf("Результат = %s%n%n", matrix1.multiplyOnVector(vector));

        matrix1 = new Matrix(new double[][]{{1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}});
        matrix2 = new Matrix(new double[][]{{7.0, 9.0, 5.0}, {7.0, 3.0, 4.0}});

        System.out.printf("Прибавить к матрице %s матрицу %s%n", matrix1, matrix2);

        matrix1.add(matrix2);

        System.out.printf("Результат = %s%n%n", matrix1);

        System.out.printf("Вычитание из матрицы %s матрицы %s%n", matrix1, matrix2);

        matrix1.subtract(matrix2);

        System.out.printf("Результат = %s%n%n", matrix1);

        Matrix matrix3 = Matrix.getSum(matrix1, matrix2);

        System.out.printf("Сложение матрицы %s и %s%n", matrix1, matrix2);
        System.out.printf("Результат = %s%n%n", matrix3);

        matrix3 = Matrix.getDifference(matrix1, matrix2);

        System.out.printf("Вычитание из матрицы %s матрицы %s%n", matrix1, matrix2);
        System.out.printf("Результат = %s%n%n", matrix3);

        matrix1 = new Matrix(new double[][]{{1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}});
        matrix2 = new Matrix(new double[][]{{7.0, 9.0, 4, 2}, {11.0, 2.0, 2, 6}, {0.0, 4.0, 4, 5}});

        System.out.printf("Умножение матриц %s и %s%n", matrix1, matrix2);
        System.out.printf("Результат = %s%n", Matrix.getMultiply(matrix1, matrix2));
        System.out.printf("Результат = %s%n%n", Matrix.getMultiply(matrix2, matrix1));
    }
}
