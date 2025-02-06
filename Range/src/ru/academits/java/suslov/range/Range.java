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
    public Range getJoinRange(Range second) {
        // Пересечений нет - вернем нул
        if (!this.isInside(second.getFrom()) && !this.isInside(second.getTo())) {
            return null;
        }

        return new Range(Math.max(this.getFrom(), second.getFrom()), Math.min(this.getTo(), second.getTo()));
    }

    /**
     * Получение объединения двух интервалов
     * Если не пересекаются вернется два исходных интервала
     */
    public Range[] getMergeRange(Range second) {
        // Пересечений нет - вернем оба
        if (!this.isInside(second.getFrom()) && !this.isInside(second.getTo())) {
            return new Range[]{this, second};
        }

        return new Range[]{new Range(Math.min(this.getFrom(), second.getFrom()), Math.max(this.getTo(), second.getTo()))};
    }

    /**
     * Получение разности двух интервалов (из первого интервала вычитаем второй)
     * Если не пересекаются вернется пустой массив
     */
    public Range[] getSubtractionRange(Range second) {
        // Пересечений нет - вернем исходный интервал
        if (!this.isInside(second.getFrom()) && !this.isInside(second.getTo())) {
            return new Range[]{this};
        }
        // Второй интервал полностью лежит в первом - тогда будет два куска
        if (this.isInside(second.getFrom()) && this.isInside(second.getTo())) {
            return new Range[]{new Range(this.getFrom(), second.getFrom()), new Range(second.getTo(), this.getTo())};
        }

        return new Range[]{new Range(Math.min(this.getFrom(), second.getFrom()), Math.max(this.getFrom(), second.getFrom()))};
    }
}
