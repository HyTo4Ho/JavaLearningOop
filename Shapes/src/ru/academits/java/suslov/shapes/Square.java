package ru.academits.java.suslov.shapes;

public class Square implements Shape {
    private double side;

    public double getSide() {
        return this.side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    public Square(double side) {
        this.side = side;
    }

    @Override
    public double getWidth() {
        return this.side;
    }

    @Override
    public double getHeight() {
        return this.side;
    }

    @Override
    public double getArea() {
        return Math.pow(this.side, 2);
    }

    @Override
    public double getPerimeter() {
        return this.side * 4;
    }
}
