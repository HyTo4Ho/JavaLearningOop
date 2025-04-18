package ru.academits.java.suslov.range;

public class Range {
    private static final double EPSILON = 1e-10;

    private double from;
    private double to;

    public Range(double from, double to) {
        if (from - to > EPSILON) {
            throw new IllegalArgumentException("Начало отрезка (from: " + from + ") должно быть меньше или равно его конца (to: " + to + ")");
        }

        this.from = from;
        this.to = to;
    }

    public double getFrom() {
        return from;
    }

    public void setFrom(double from) {
        if (from - to > EPSILON) {
            throw new IllegalArgumentException("Начало отрезка (from: " + from + ") должно быть меньше или равно его конца (to: " + to + ")");
        }

        this.from = from;
    }

    public double getTo() {
        return to;
    }

    public void setTo(double to) {
        if (from - to > EPSILON) {
            throw new IllegalArgumentException("Начало отрезка (from: " + from + ") должно быть меньше или равно его конца (to: " + to + ")");
        }

        this.to = to;
    }

    public double getLength() {
        return to - from;
    }

    public boolean isInside(double x) {
        return from - x <= EPSILON && x - to <= EPSILON;
    }

    /**
     * Получение интервала-пересечения двух интервалов
     * Если не пересекаются вернется null
     */
    public Range getIntersection(Range range) {
        // Пересечений нет - вернем нул
        if (from >= range.to || to <= range.from) {
            return null;
        }

        return new Range(Math.max(from, range.from), Math.min(to, range.to));
    }

    /**
     * Получение объединения двух интервалов
     * Если не пересекаются вернется два исходных интервала
     */
    public Range[] getUnion(Range range) {
        // Пересечений нет - вернем оба
        if (from > range.to || to < range.from) {
            return new Range[]{new Range(from, to), new Range(range.from, range.to)};
        }

        return new Range[]{new Range(Math.min(from, range.from), Math.max(to, range.to))};
    }

    /**
     * Получение разности двух интервалов (из первого интервала вычитаем второй)
     * Если не пересекаются вернется исходный интервал
     */
    public Range[] getDifference(Range range) {
        // Пересечений нет - вернем исходный интервал
        if (from >= range.to || to <= range.from) {
            return new Range[]{new Range(from, to)};
        }

        // Первый интервал полностью лежит во втором - вернем пустой массив
        if (from >= range.from && to <= range.to) {
            return new Range[0];
        }

        // Второй интервал полностью лежит в первом - тогда будет два куска
        if (from < range.from && to > range.to) {
            return new Range[]{new Range(from, range.from), new Range(range.to, to)};
        }

        if (from < range.from) {
            return new Range[]{new Range(from, range.from)};
        }

        return new Range[]{new Range(range.to, to)};
    }
}