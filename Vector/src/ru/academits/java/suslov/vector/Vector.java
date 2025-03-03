package ru.academits.java.suslov.vector;

import java.util.Arrays;

public class Vector {
    /**
     * Компоненты вектора
     */
    private double[] components;

    /**
     * Размерность n, все компоненты равны 0
     */
    public Vector(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException(String.format("Размерность вектора должна быть больше 0. Передано %d", n));
        }

        components = new double[n];
    }

    /**
     * конструктор копирования
     */
    public Vector(Vector vector) {
        if (vector == null || vector.components.length == 0) {
            throw new IllegalArgumentException(String.format("Размерность вектора должна быть больше 0. Передано %d", vector != null ? vector.components.length : 0));
        }

        components = Arrays.copyOf(vector.components, vector.components.length);
    }

    /**
     * заполнение вектора значениями из массива
     */
    public Vector(double[] components) {
        if (components.length == 0) {
            throw new IllegalArgumentException(String.format("Размерность вектора должна быть больше 0. Передано %d", components.length));
        }

        this.components = Arrays.copyOf(components, components.length);
    }

    /**
     * заполнение вектора значениями из массива. Если длина массива меньше n, то считать что в остальных компонентах 0
     */
    public Vector(int n, double[] components) {
        if (n <= 0) {
            throw new IllegalArgumentException(String.format("Размерность вектора должна быть больше 0. Передано %d", n));
        }

        this.components = Arrays.copyOf(components, n);
    }

    public double[] getComponents() {
        return components;
    }

    public void setComponents(double[] components) {
        this.components = components;
    }

    @Override
    public String toString() {
        return Arrays.toString(components).replace('[', '{').replace(']', '}');
    }

    /**
     * Переопределить метод equals, чтобы был true  векторы имеют одинаковую размерность и соответствующие компоненты равны. Соответственно, переопределить hashCode
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
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
    public void addVector(Vector vector) {
        if (vector.components.length > components.length) {
            components = Arrays.copyOf(components, vector.components.length);
        }

        for (int i = 0; i < components.length; i++) {
            components[i] += vector.components[i];
        }
    }

    /**
     * Вычитание из вектора другого вектора
     */
    public void subtractVector(Vector vector) {
        for (int i = 0; i < components.length; i++) {
            components[i] -= vector.components[i];
        }
    }

    /**
     * Умножение вектора на скаляр
     */
    public void multiply(int n) {
        for (int i = 0; i < components.length; i++) {
            components[i] *= n;
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

        for (int i = 0; i < components.length; i++) {
            squaresSum += components[i] * components[i];
        }

        return Math.abs(Math.sqrt(squaresSum));
    }

    /**
     * Получение компоненты вектора по индексу
     */
    public double getComponentWithIndex(int n) {
        return components[n];
    }

    /**
     * Установка компоненты вектора по индексу
     */
    public void setComponentWithIndex(int n, double value) {
        components[n] = value;
    }

    /**
     * Сложение двух векторов – должен создаваться новый вектор
     */
    public static Vector createSumVector(Vector vector1, Vector vector2) {
        Vector result = new Vector(vector1);
        result.addVector(vector2);

        return result;
    }

    /**
     * Вычитание векторов – должен создаваться новый вектор
     */
    public static Vector createDifferenceVector(Vector vector1, Vector vector2) {
        Vector result = new Vector(vector1);
        result.addVector(vector2);

        return result;
    }

    /**
     * Скалярное произведение векторов
     */
    public static Vector createMultipleVector(Vector vector1, Vector vector2) {
        Vector result = new Vector(vector1);

        for (int i = 0; i < vector1.components.length; i++) {
            result.components[i] = vector1.components[i] * vector2.components[i];
        }

        return result;
    }
}
