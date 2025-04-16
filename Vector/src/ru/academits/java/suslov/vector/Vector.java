package ru.academits.java.suslov.vector;

import java.util.Arrays;

public class Vector {
    /**
     * Компоненты вектора
     */
    private double[] components;

    /**
     * Размерность size, все компоненты равны 0
     */
    public Vector(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException(String.format("Размерность вектора должна быть больше 0. Передано значение %d", size));
        }

        components = new double[size];
    }

    /**
     * Конструктор копирования
     */
    public Vector(Vector vector) {
        if (vector == null) {
            throw new NullPointerException("Объекта не существует :(");
        }

        components = Arrays.copyOf(vector.components, vector.components.length);
    }

    /**
     * Заполнение вектора значениями из массива
     */
    public Vector(double[] components) {
        if (components.length == 0) {
            throw new IllegalArgumentException(String.format("Размерность вектора должна быть больше 0. Передано значение %d", components.length));
        }

        this.components = Arrays.copyOf(components, components.length);
    }

    /**
     * Заполнение вектора значениями из массива. Если длина массива меньше size, то считать что в остальных компонентах 0
     */
    public Vector(int size, double[] components) {
        if (size <= 0) {
            throw new IllegalArgumentException(String.format("Размерность вектора должна быть больше 0. Передано значение %d", size));
        }

        this.components = Arrays.copyOf(components, size);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("{");

        for (double component : components) {
            stringBuilder.append(component)
                    .append(", ");
        }

        return stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length()).append('}').toString();
    }

    /**
     * Переопределить метод equals, чтобы был true  векторы имеют одинаковую размерность и соответствующие компоненты равны. Соответственно, переопределить hashCode
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Vector vector = (Vector) o;
        return Arrays.equals(components, vector.components);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(components);
    }

    public int getSize() {
        return components.length;
    }

    /**
     * Прибавление к вектору другого вектора
     */
    public void add(Vector vector) {
        if (vector.components.length > components.length) {
            components = Arrays.copyOf(components, vector.components.length);
        }

        for (int i = 0; i < vector.components.length; i++) {
            components[i] += vector.components[i];
        }
    }

    /**
     * Вычитание из вектора другого вектора
     */
    public void subtract(Vector vector) {
        if (vector.components.length > components.length) {
            components = Arrays.copyOf(components, vector.components.length);
        }

        for (int i = 0; i < vector.components.length; i++) {
            components[i] -= vector.components[i];
        }
    }

    /**
     * Умножение вектора на скаляр
     */
    public void multiply(double multiplier) {
        for (int i = 0; i < components.length; i++) {
            components[i] *= multiplier;
        }
    }

    /**
     * Разворот вектора (умножение всех компонент на -1)
     */
    public void revert() {
        multiply(-1);
    }

    /**
     * Получение длины вектора
     */
    public double getLength() {
        double squaresSum = 0;

        for (double component : components) {
            squaresSum += component * component;
        }

        return Math.sqrt(squaresSum);
    }

    /**
     * Получение компоненты вектора по индексу
     */
    public double getComponent(int index) {
        return components[index];
    }

    /**
     * Установка компоненты вектора по индексу
     */
    public void setComponent(int index, double component) {
        components[index] = component;
    }

    /**
     * Сложение двух векторов – должен создаваться новый вектор
     */
    public static Vector getSum(Vector vector1, Vector vector2) {
        Vector result = new Vector(vector1);
        result.add(vector2);

        return result;
    }

    /**
     * Вычитание векторов – должен создаваться новый вектор
     */
    public static Vector getDifference(Vector vector1, Vector vector2) {
        Vector result = new Vector(vector1);
        result.subtract(vector2);

        return result;
    }

    /**
     * Скалярное произведение векторов
     */
    public static double getScalarProduct(Vector vector1, Vector vector2) {
        int minSize = Math.min(vector1.components.length, vector2.components.length);

        double scalarProduct = 0;

        for (int i = 0; i < minSize; i++) {
            scalarProduct += vector1.components[i] * vector2.components[i];
        }

        return scalarProduct;
    }
}
