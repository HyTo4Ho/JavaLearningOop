package ru.academits.java.suslov.shapes;

import java.util.Objects;

public class Triangle implements Shape {
    private double aPointX;
    private double aPointY;
    private double bPointX;
    private double bPointY;
    private double cPointX;
    private double cPointY;

    public Triangle(double aPointX, double aPointY, double bPointX, double bPointY, double cPointX, double cPointY) {
        this.aPointX = aPointX;
        this.aPointY = aPointY;
        this.bPointX = bPointX;
        this.bPointY = bPointY;
        this.cPointX = cPointX;
        this.cPointY = cPointY;
    }

    public double getAPointX() {
        return aPointX;
    }

    public void setAPointX(double aPointX) {
        this.aPointX = aPointX;
    }

    public double getAPointY() {
        return aPointY;
    }

    public void setAPointY(double aPointY) {
        this.aPointY = aPointY;
    }

    public double getBPointX() {
        return bPointX;
    }

    public void setBPointX(double bPointX) {
        this.bPointX = bPointX;
    }

    public double getBPointY() {
        return bPointY;
    }

    public void setBPointY(double bPointY) {
        this.bPointY = bPointY;
    }

    public double getCPointX() {
        return cPointX;
    }

    public void setCPointX(double cPointX) {
        this.cPointX = cPointX;
    }

    public double getCPointY() {
        return cPointY;
    }

    public void setCPointY(double cPointY) {
        this.cPointY = cPointY;
    }

    private double getLength(double firstCoordinateX, double firstCoordinateY, double secondCoordinateX, double secondCoordinateY) {
        return Math.sqrt(Math.pow(secondCoordinateX - firstCoordinateX, 2) + Math.pow(secondCoordinateY - firstCoordinateY, 2));
    }

    public double getABLength() {
        return getLength(aPointX, aPointY, bPointX, bPointY);
    }

    public double getBCLength() {
        return getLength(bPointX, bPointY, cPointX, cPointY);
    }

    public double getCALength() {
        return getLength(cPointX, cPointY, aPointX, aPointY);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return Double.compare(triangle.aPointX, aPointX) == 0 && Double.compare(triangle.aPointY, aPointY) == 0 && Double.compare(triangle.bPointX, bPointX) == 0 && Double.compare(triangle.bPointY, bPointY) == 0 && Double.compare(triangle.cPointX, cPointX) == 0 && Double.compare(triangle.cPointY, cPointY) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(aPointX, aPointY, bPointX, bPointY, cPointX, cPointY);
    }

    @Override
    public String toString() {
        return String.format("Треугольник по точкам (%.2f ; %.2f) , (%.2f ; %.2f) , (%.2f ; %.2f)", aPointX, aPointY, bPointX, bPointY, cPointX, cPointY);
    }

    @Override
    public double getWidth() {
        return Math.max(Math.max(aPointX, bPointX), cPointX) - Math.min(Math.min(aPointX, bPointX), cPointX);
    }

    @Override
    public double getHeight() {
        return Math.max(Math.max(aPointY, bPointY), cPointY) - Math.min(Math.min(aPointY, bPointY), cPointY);
    }

    @Override
    public double getArea() {
        double semiPerimeter = getPerimeter() / 2;

        return Math.sqrt(semiPerimeter * (semiPerimeter - getABLength()) * (semiPerimeter - getBCLength()) * (semiPerimeter - getCALength()));
    }

    @Override
    public double getPerimeter() {
        return getABLength() + getBCLength() + getCALength();
    }
}
