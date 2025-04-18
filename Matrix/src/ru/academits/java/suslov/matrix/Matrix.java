package ru.academits.java.suslov.matrix;
import ru.academits.java.suslov.vector.Vector;
import java.util.Arrays;

public class Matrix {
    private Vector[] rows;

    /**
     * Матрица нулей размера nxm
     */
    public Matrix(int rowsCount, int columnsCount) {
        if (rowsCount <= 0 || columnsCount <= 0) {
            throw new IllegalArgumentException(String.format("Количество строк(%d) и столбцов(%d) должно быть положительным", rowsCount, columnsCount));
        }

        rows = new Vector[rowsCount];

        for (int i = 0; i < rowsCount; i++) {
            rows[i] = new Vector(columnsCount);
        }
    }

    /**
     * Конструктор копирования
     */
    public Matrix(Matrix matrix) {
        rows = new Vector[matrix.rows.length];

        for (int i = 0; i < matrix.getRowsCount(); i++) {
            rows[i] = new Vector(matrix.rows[i]);
        }
    }

    /**
     * Из двумерного массива
     */
    public Matrix(double[][] doublesArray) {
        if (doublesArray.length == 0) {
            throw new IllegalArgumentException(String.format("Количество строк(%d) должно быть положительным", doublesArray.length));
        }

        int maximumLength = doublesArray[0].length;

        for (int i = 1; i < doublesArray.length; i++) {
            if (doublesArray[i].length > maximumLength) {
                maximumLength = doublesArray[i].length;
            }
        }

        if (maximumLength == 0) {
            throw new IllegalArgumentException(String.format("Количество столбцов(%d) должно быть положительным", doublesArray.length));
        }

        rows = new Vector[doublesArray.length];

        for (int i = 0; i < doublesArray.length; i++) {
            rows[i] = new Vector(Arrays.copyOf(doublesArray[i], maximumLength));
        }
    }

    /**
     * Из массива векторов-строк
     */
    public Matrix(Vector[] vectorsArray) {
        if (vectorsArray.length == 0) {
            throw new IllegalArgumentException(String.format("Количество строк(%d) должно быть положительным", vectorsArray.length));
        }

        int maximumLength = vectorsArray[0].getSize();

        for (int i = 1; i < vectorsArray.length; i++) {
            if (vectorsArray[i].getSize() > maximumLength) {
                maximumLength = vectorsArray[i].getSize();
            }
        }

        rows = new Vector[vectorsArray.length];

        for (int i = 0; i < vectorsArray.length; i++) {
            rows[i] = new Vector(maximumLength, vectorsArray[i]);
        }
    }

    public int getRowsCount() {
        return rows.length;
    }

    public int getColumnsCount() {
        return rows[0].getSize();
    }

    /**
     * Получение вектора-строки по индексу
     */
    public Vector getRow(int index) {
        if (index < 0 || index > rows.length - 1) {
            throw new IllegalArgumentException(String.format("Индекс должен быть между 0 и %d. Передано = %d", rows.length - 1, index));
        }

        return new Vector(rows[index]);
    }

    /**
     * Задание вектора-строки по индексу
     */
    public void setRow(int index, Vector row) {
        if (index < 0 || index > rows.length) {
            throw new IllegalArgumentException(String.format("Индекс должен быть между 0 и %d. Передано = %d", rows.length - 1, index));
        }

        if (row.getSize() != getColumnsCount()) {
            throw new IllegalArgumentException(String.format("Размер вектора должен быть %d. Передано = %d", getColumnsCount(), row.getSize()));
        }

        rows[index] = new Vector(row);
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
        StringBuilder stringBuilder = new StringBuilder("{");

        for (Vector row : rows) {
            stringBuilder.append(row).append(", ");
        }

        return stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length()).append('}').toString();
    }

    /**
     * Получение вектора-столбца по индексу
     */
    public Vector getColumnByIndex(int index) {
        if (index < 0 || index > getColumnsCount() - 1) {
            throw new IllegalArgumentException(String.format("Индекс должен быть между 0 и %d. Передано = %d", getColumnsCount(), index));
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
        Vector[] newRows = new Vector[getColumnsCount()];

        for (int i = 0; i < getColumnsCount(); i++) {
            newRows[i] = getColumnByIndex(i);
        }

        rows = newRows;
    }

    /**
     * Умножение на скаляр
     */
    public void multiply(double scalar) {
        for (Vector row : rows) {
            row.multiply(scalar);
        }
    }

    /**
     * Вычисление определителя матрицы
     */
    public double getDeterminant() {
        if (getRowsCount() != getColumnsCount()) {
            throw new IllegalStateException("Матрица должна быть квадратной");
        }

        if (getRowsCount() == 1) {
            return rows[0].getComponent(0);
        }

        if (getRowsCount() == 2) {
            return rows[0].getComponent(0) * rows[1].getComponent(1) - rows[1].getComponent(0) * rows[0].getComponent(1);
        }

        double result = 0;
        double temp = 1;

        for (int i = 0; i < getColumnsCount(); i++) {
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

        for (int i = 0; i < getColumnsCount(); i++) {
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
    public Vector multiplyOnVector(Vector vector) {
        if (vector.getSize() != getColumnsCount()) {
            throw new IllegalArgumentException(String.format("Размер вектора (%d) должен совпадать с количеством столбцов (%d)", vector.getSize(), getColumnsCount()));
        }

        Vector resultVector = new Vector(rows.length);
        double component = 0;

        for (int i = 0; i < rows.length; i++) {
            for (int j = 0; j < rows.length; j++) {
                component += vector.getComponent(j) * rows[i].getComponent(j);
            }

            resultVector.setComponent(i, component);
            component = 0;
        }

        return resultVector;
    }

    private static void checkSizes(Matrix matrix1, Matrix matrix2) {
        if (matrix1.getRowsCount() != matrix2.getRowsCount()) {
            throw new IllegalArgumentException(String.format("Количество строк матриц должно совпадать. Сейчас %d и %d", matrix1.getRowsCount(), matrix2.getRowsCount()));
        }

        if (matrix1.getColumnsCount() != matrix2.getColumnsCount()) {
            throw new IllegalArgumentException(String.format("Количество столбцов матриц должно совпадать. Сейчас %d и %d", matrix1.getColumnsCount(), matrix2.getColumnsCount()));
        }
    }

    /**
     * Сложение матриц
     */
    public void add(Matrix matrix) {
        checkSizes(this, matrix);

        for (int i = 0; i < rows.length; i++) {
            rows[i].add(matrix.rows[i]);
        }
    }

    /**
     * Вычитание матриц
     */
    public void subtract(Matrix matrix) {
        checkSizes(this, matrix);

        for (int i = 0; i < rows.length; i++) {
            rows[i].subtract(matrix.rows[i]);
        }
    }

    /**
     * Сложение матриц
     */
    public static Matrix getSum(Matrix matrix1, Matrix matrix2) {
        checkSizes(matrix1, matrix2);

        Matrix result = new Matrix(matrix1);

        for (int i = 0; i < matrix1.getRowsCount(); i++) {
            result.rows[i].add(matrix2.rows[i]);
        }

        return result;
    }

    /**
     * Вычитание матриц
     */
    public static Matrix getDifference(Matrix matrix1, Matrix matrix2) {
        checkSizes(matrix1, matrix2);

        Matrix result = new Matrix(matrix1);

        for (int i = 0; i < matrix1.getRowsCount(); i++) {
            result.rows[i].subtract(matrix2.rows[i]);
        }

        return result;
    }

    /**
     * Умножение матриц
     */
    public static Matrix getMultiply(Matrix matrix1, Matrix matrix2) {
        int matrix1RowCount = matrix1.getRowsCount();
        int matrix1ColumnCount = matrix1.getColumnsCount();
        int matrix2RowCount = matrix2.getRowsCount();
        int matrix2ColumnCount = matrix2.getColumnsCount();

        if (matrix1RowCount != matrix2ColumnCount && matrix1ColumnCount != matrix2RowCount) {
            throw new IllegalArgumentException(String.format("Количество строк первой матрицы (%d) должно совпадать с количеством столбцов второй матрицыы (%d).", matrix1RowCount, matrix2ColumnCount));
        }

        Matrix result;

        if (matrix1RowCount != matrix2ColumnCount) {
            result = new Matrix(matrix1RowCount, matrix2ColumnCount);
        } else {
            result = new Matrix(matrix2RowCount, matrix1ColumnCount);
        }

        int i = 0;
        int j = 0;

        while (i < result.getRowsCount()) {
            Vector matrix1Row = matrix1RowCount == matrix2ColumnCount ? matrix2.getRow(i) : matrix1.getRow(i);
            Vector matrix2Column = matrix1RowCount == matrix2ColumnCount ? matrix1.getColumnByIndex(j) : matrix2.getColumnByIndex(j);

            double newElement = 0;

            for (int k = 0; k < matrix1Row.getSize(); k++) {
                newElement += matrix1Row.getComponent(k) * matrix2Column.getComponent(k);
            }

            result.rows[i].setComponent(j, newElement);

            if (j == result.getColumnsCount() - 1) {
                i++;
                j = 0;
            } else {
                j++;
            }
        }

        return result;
    }
}
