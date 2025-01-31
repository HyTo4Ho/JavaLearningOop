package Code;

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
}
