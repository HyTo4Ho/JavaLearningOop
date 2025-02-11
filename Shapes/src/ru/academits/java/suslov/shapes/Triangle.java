package ru.academits.java.suslov.shapes;

public class Triangle implements Shape {
    private double side12;
    private double side23;
    private double side31;

    public Triangle(double x1, double y1, double x2, double y2, double x3, double y3) {

    }

    public double getSide12() {
        return side12;
    }

    public void setSide12(double side12) {
        this.side12 = side12;
    }

    public double getSide23() {
        return side23;
    }

    public void setSide23(double side23) {
        this.side23 = side23;
    }

    public double getSide31() {
        return side31;
    }

    public void setSide31(double side31) {
        this.side31 = side31;
    }

    @Override
    public double getWidth() {
        return 0;
        //      В качестве ширины возвращать max(x1, x2, x3) – min(x1, x2, x3)
    }

    @Override
    public double getHeight() {
        return 0;
        //      В качестве высоты возвращать max(y1, y2, y3) – min(y1, y2, y3)
    }

    @Override
    public double getArea() {
        return 0;
    }

    @Override
    public double getPerimeter() {
        return 0;
    }
}
