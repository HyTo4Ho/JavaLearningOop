package ru.academits.java.suslov.shapes;

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

    private static double getLength(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
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
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Triangle triangle = (Triangle) o;
        return triangle.aPointX == aPointX && triangle.aPointY == aPointY && triangle.bPointX == bPointX &&
                triangle.bPointY == bPointY && triangle.cPointX == cPointX && triangle.cPointY == cPointY;
    }

    @Override
    public int hashCode() {
        final int PRIME = 37;
        int hash = 1;

        hash = PRIME * hash + Double.hashCode(aPointX);
        hash = PRIME * hash + Double.hashCode(aPointY);
        hash = PRIME * hash + Double.hashCode(bPointX);
        hash = PRIME * hash + Double.hashCode(bPointY);
        hash = PRIME * hash + Double.hashCode(cPointX);
        hash = PRIME * hash + Double.hashCode(cPointY);

        return hash;
    }

    @Override
    public String toString() {
        return String.format("Треугольник по точкам (%.2f; %.2f), (%.2f; %.2f), (%.2f; %.2f)", aPointX, aPointY, bPointX, bPointY, cPointX, cPointY);
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
        double aBLength = getABLength();
        double bCLength = getBCLength();
        double cALength = getCALength();

        double semiPerimeter = (aBLength + bCLength + cALength) / 2;

        return Math.sqrt(semiPerimeter * (semiPerimeter - aBLength) * (semiPerimeter - bCLength) * (semiPerimeter - cALength));
    }

    @Override
    public double getPerimeter() {
        return getABLength() + getBCLength() + getCALength();
    }
}
