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
     * матрица нулей размера nxm
     */
    public Matrix(int rowsCount, int componentsCount) {
        rows = new Vector[rowsCount];

        for (int i = 0; i < rowsCount; i++) {
            rows[i] = new Vector(componentsCount);
        }
    }

    /**
     * конструктор копирования
     */
    public Matrix(Matrix matrix) {
        rows = matrix.rows;
    }

    /**
     * из двумерного массива
     */
    Matrix(double[][] matrix) {
        rows = new Vector[matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            rows[i] = new Vector(matrix[i]);
        }
    }

    /**
     * из массива векторов-строк
     */
    Matrix(Vector[] vectorsArray) {
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

        for (Vector e : rows) {
            result.append(e.toString()).append(", ");
        }

        return result.substring(0, result.length() - 2) + "}";
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
    public void multiply(int n) {
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
     * умножение матрицы на вектор
     */
    public void multiplyOnVector(Vector vector) {
        for (int i = 0; i < rows.length; i++) {
            rows[i] = Vector.createMultipleVector(rows[i], vector);
        }
    }

    /**
     * Сложение матриц
     */
    public void addMatrix(Matrix matrix) {
        for (int i = 0; i < rows.length; i++) {
            rows[i].addVector(matrix.rows[i]);
        }
    }

    /**
     * Вычитание матриц
     */
    public void subtractMatrix(Matrix matrix) {
        for (int i = 0; i < rows.length; i++) {
            rows[i].subtractVector(matrix.rows[i]);
        }
    }

    /**
     * Сложение матриц
     */
    public static Matrix createSumVector(Matrix matrix1, Matrix matrix2) {
        Matrix result = new Matrix(matrix1);

        for (int i = 0; i < matrix1.rows.length; i++) {
            result.rows[i].addVector(matrix2.rows[i]);
        }

        return result;
    }

    /**
     * Вычитание матриц
     */
    public static Matrix createDifferenceVector(Matrix matrix1, Matrix matrix2) {
        Matrix result = new Matrix(matrix1);

        for (int i = 0; i < matrix1.rows.length; i++) {
            result.rows[i].subtractVector(matrix2.rows[i]);
        }

        return result;
    }

    /**
     * Умножение матриц
     */
    public static Matrix createMultipleVector(Matrix matrix1, Matrix matrix2) {
        Matrix result = new Matrix(matrix1.rows.length, matrix1.rows.length);

        for (int i = 0; i < matrix1.rows.length; i++) {
            result.rows[i] = Vector.createMultipleVector(matrix1.rows[i], matrix2.rows[i]);
        }

        return result;
    }
}
