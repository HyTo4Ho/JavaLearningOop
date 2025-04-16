package ru.academits.java.suslov.matrix;

import java.util.Arrays;

import ru.academits.java.suslov.vector.Vector;

public class Matrix {
    private final Vector[] rows;

    /**
     * Матрица нулей размера nxm
     */
    public Matrix(int rowsCount, int componentsCount) {
        rows = new Vector[rowsCount];

        for (int i = 0; i < rowsCount; i++) {
            rows[i] = new Vector(componentsCount);
        }
    }

    /**
     * Конструктор копирования
     */
    public Matrix(Matrix matrix) {
        rows = new Vector[matrix.rows.length];

        for (int i = 0; i < matrix.getSize(); i++) {
            rows[i] = new Vector(matrix.rows[i]);
        }
    }

    /**
     * Из двумерного массива
     */
    public Matrix(double[][] matrix) {
        rows = new Vector[matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            rows[i] = new Vector(matrix[i]);
        }
    }

    /**
     * Из массива векторов-строк
     */
    public Matrix(Vector[] vectorsArray) {
        rows = new Vector[vectorsArray.length];

        for (int i = 0; i < vectorsArray.length; i++) {
            rows[i] = new Vector(vectorsArray[i]);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Matrix matrix = (Matrix) o;
        return Arrays.equals(rows, matrix.rows);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(rows);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("{");

        for (int i = 0; i < rows.length; i++) {
            result.append(rows[i].toString());

            if (i != rows.length - 1) {
                result.append(", ");
            }
        }

        return result.append("}").toString();
    }

    /**
     * Получение размеров матрицы
     */
    public int getSize() {
        return rows.length;
    }

    /**
     * Получение вектора-строки по индексу
     */
    public Vector getRow(int index) {
        if (index < 0 || index > rows.length - 1) {
            throw new IllegalArgumentException(String.format("Индекс должен быть между 0 и %d. Передано = %d", rows.length, index));
        }

        return rows[index];
    }

    /**
     * Задание вектора-строки по индексу
     */
    public void setRow(int index, Vector row) {
        if (index < 0 || index > rows.length - 1) {
            throw new IllegalArgumentException(String.format("Индекс должен быть между 0 и %d. Передано = %d", rows.length, index));
        }

        if (row.getSize() != rows[0].getSize() && rows.length > 1) {
            throw new IllegalArgumentException(String.format("Размер вектора должен быть %d. Передано = %d", rows[0].getSize(), row.getSize()));
        }

        rows[index] = new Vector(row);
    }

    /**
     * Получение вектора-столбца по индексу
     */
    public Vector getColumnByIndex(int index) {
        if (index < 0 || index > rows[0].getSize() - 1) {
            throw new IllegalArgumentException(String.format("Индекс должен быть между 0 и %d. Передано = %d", rows[0].getSize(), index));
        }

        Vector result = new Vector(rows.length);

        for (int i = 0; i < rows.length; i++) {
            result.setComponent(i, rows[i].getComponent(index));
        }

        return result;
    }

    /**
     * Транспонирование матрицы
     */
    public void transpose() {
        if (rows.length != rows[0].getSize()) {
            throw new IllegalArgumentException("Матрица должна быть квадратной");
        }

        Matrix tmp = new Matrix(this);

        for (int i = 0; i < tmp.rows[0].getSize(); i++) {
            rows[i] = tmp.getColumnByIndex(i);
        }
    }

    /**
     * Умножение на скаляр
     */
    public void multiply(double n) {
        for (Vector row : rows) {
            row.multiply(n);
        }
    }

    /**
     * Вычисление определителя матрицы
     */
    public double getDeterminant() {
        double result = 0;
        double temp = 1;

        for (int i = 0; i < rows[0].getSize(); i++) {
            for (int j = 0; j < rows.length; j++) {
                int index = j + i;
                if (index >= rows.length) {
                    index -= rows.length;
                }

                temp *= rows[index].getComponent(j);
            }

            result += temp;
            temp = 1;
        }

        for (int i = 0; i < rows[0].getSize(); i++) {
            for (int j = 0; j < rows.length; j++) {
                int index = i - j;
                if (index < 0) {
                    index += rows.length;
                }

                temp *= rows[j].getComponent(index);
            }

            result -= temp;
            temp = 1;
        }

        return result;
    }

    /**
     * Умножение матрицы на вектор
     */
    public double[] multiplyOnVector(Vector vector) {
        if (vector.getSize() != rows[0].getSize()) {
            throw new IllegalArgumentException("Размер вектора должен совпадать с количеством столбцов");
        }

        double[] result = new double[rows.length];

        for (int i = 0; i < rows.length; i++) {
            result[i] = Vector.getScalarProduct(rows[i], vector);
        }

        return result;
    }

    /**
     * Сложение матриц
     */
    public void add(Matrix matrix) {
        if (rows.length != matrix.getSize() || rows[0].getSize() != matrix.rows[0].getSize()) {
            throw new IllegalArgumentException("Матрицы должна быть равны");
        }

        for (int i = 0; i < rows.length; i++) {
            rows[i].add(matrix.rows[i]);
        }
    }

    /**
     * Вычитание матриц
     */
    public void subtract(Matrix matrix) {
        if (rows.length != matrix.getSize() || rows[0].getSize() != matrix.rows[0].getSize()) {
            throw new IllegalArgumentException("Матрицы должна быть равны");
        }

        for (int i = 0; i < rows.length; i++) {
            rows[i].subtract(matrix.rows[i]);
        }
    }

    /**
     * Сложение матриц
     */
    public static Matrix getSum(Matrix matrix1, Matrix matrix2) {
        if (matrix1.getSize() != matrix2.getSize() || matrix1.rows[0].getSize() != matrix2.rows[0].getSize()) {
            throw new IllegalArgumentException("Матрицы должна быть равны");
        }

        Matrix result = new Matrix(matrix1);

        for (int i = 0; i < matrix1.getSize(); i++) {
            System.out.println(i);

            result.rows[i].add(matrix2.rows[i]);
        }

        return result;
    }

    /**
     * Вычитание матриц
     */
    public static Matrix getDifference(Matrix matrix1, Matrix matrix2) {
        if (matrix1.getSize() != matrix2.getSize() || matrix1.rows[0].getSize() != matrix2.rows[0].getSize()) {
            throw new IllegalArgumentException("Матрицы должна быть равны");
        }

        Matrix result = new Matrix(matrix1);

        for (int i = 0; i < matrix1.getSize(); i++) {
            result.rows[i].subtract(matrix2.rows[i]);
        }

        return result;
    }

    /**
     * Умножение матриц
     */
    public static Matrix getMultiple(Matrix matrix1, Matrix matrix2) {
        if (matrix1.getSize() != matrix2.getSize() || matrix1.rows[0].getSize() != matrix2.rows[0].getSize()) {
            throw new IllegalArgumentException("Матрицы должна быть равны");
        }

        Matrix result = new Matrix(matrix1.rows.length, 1);

        for (int i = 0; i < matrix1.rows.length; i++) {
            result.rows[i].setComponent(0, Vector.getScalarProduct(matrix1.rows[i], matrix2.rows[i]));
        }

        return result;
    }
}
