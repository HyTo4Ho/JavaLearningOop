package ru.academits.java.suslov.matrix;

import java.util.Arrays;

import ru.academits.java.suslov.vector.Vector;

public class Matrix {
    private Vector rows[];

    public Vector[] getRows() {
        return rows;
    }

    public void setRows(Vector[] rows) {
        this.rows = rows;
    }

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
        rows = matrix.rows;
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
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
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
    public Vector getRowByIndex(int index) {
        return rows[index];
    }

    /**
     * Задание вектора-строки по индексу
     */
    public void getRowByIndex(int index, Vector row) {
        rows[index] = new Vector(row);
    }

    /**
     * Получение вектора-столбца по индексу
     */
    public Vector getColumnByIndex(int index) {
        Vector result = new Vector(rows.length);
        for (int i = 0; i < rows.length; i++) {
            result.setComponentWithIndex(index, rows[i].getComponentWithIndex(index));
        }

        return result;
    }

    /**
     * Транспонирование матрицы
     */
    public void transpose() {
        Matrix tmp = new Matrix(this);

        for (int i = 0; i < tmp.rows[0].getLength(); i++) {
            rows[i] = tmp.getColumnByIndex(i);
        }
    }

    /**
     * Умножение на скаляр
     */
    public void multiply(double n) {
        for (int i = 0; i < rows.length; i++) {
            rows[i].multiply(n);
        }
    }

    /**
     * Вычисление определителя матрицы
     */
    public double getDeterminant() {
        double result = 0;
        double element = 0;

        for (int i = 0; i < rows[0].getLength(); i++) {
            for (int j = 0; j < rows.length; i++) {
                int index = j + i;
                if (index > rows.length) {
                    index -= rows.length;
                }

                element += +rows[index].getComponentWithIndex(j);
            }

            result += element;
        }

        for (int i = 0; i < rows[0].getLength(); i++) {
            for (int j = 0; j < rows.length; i++) {
                int index = j - i;
                if (index < 0) {
                    index += rows.length;
                }

                element += +rows[index].getComponentWithIndex(j);
            }

            result -= element;
        }

        return result;
    }

    /**
     * Умножение матрицы на вектор
     */
    public void multiplyOnVector(Vector vector) {
/*
        for (int i = 0; i < rows.length; i++) {
            rows[i] = Vector.getMultiple(rows[i], vector);
        }
*/
    }

    /**
     * Сложение матриц
     */
    public void add(Matrix matrix) {
        for (int i = 0; i < rows.length; i++) {
            rows[i].add(matrix.rows[i]);
        }
    }

    /**
     * Вычитание матриц
     */
    public void subtract(Matrix matrix) {
        for (int i = 0; i < rows.length; i++) {
            rows[i].subtract(matrix.rows[i]);
        }
    }

    /**
     * Сложение матриц
     */
    public static Matrix getSum(Matrix matrix1, Matrix matrix2) {
        Matrix result = new Matrix(matrix1);

        for (int i = 0; i < matrix1.rows.length; i++) {
            result.rows[i].add(matrix2.rows[i]);
        }

        return result;
    }

    /**
     * Вычитание матриц
     */
    public static Matrix getDifference(Matrix matrix1, Matrix matrix2) {
        Matrix result = new Matrix(matrix1);

        for (int i = 0; i < matrix1.rows.length; i++) {
            result.rows[i].subtract(matrix2.rows[i]);
        }

        return result;
    }

    /**
     * Умножение матриц
     */
    public static Matrix getMultiple(Matrix matrix1, Matrix matrix2) {
        Matrix result = new Matrix(matrix1.rows.length, matrix1.rows.length);
        /*
        for (int i = 0; i < matrix1.rows.length; i++) {
            result.rows[i] = Vector.getMultiple(matrix1.rows[i], matrix2.rows[i]);
        }
        */

        return result;
    }
}
