package ru.academits.java.suslov.shapes;

public class Triangle implements Shape {
    private double aPointX;
    private double aPointY;
    private double bPointX;
    private double bPointY;
    private double cPointX;
    private double cPointY;
    private double aBLength;
    private double bCLength;
    private double cALength;

    public Triangle(double aPointX, double aPointY, double bPointX, double bPointY, double cPointX, double cPointY) {
        this.aPointX = aPointX;
        this.aPointY = aPointY;
        this.bPointX = bPointX;
        this.bPointY = bPointY;
        this.cPointX = cPointX;
        this.cPointY = cPointY;

        aBLength = Math.sqrt(Math.pow(bPointX - aPointX, 2) + Math.pow(bPointY - aPointY, 2));
        bCLength = Math.sqrt(Math.pow(cPointX - bPointX, 2) + Math.pow(cPointY - bPointY, 2));
        cALength = Math.sqrt(Math.pow(aPointX - cPointX, 2) + Math.pow(aPointY - cPointY, 2));
    }

    public double getAPointX() {
        return aPointX;
    }

    public void setAPointX(double aPointX) {
        this.aPointX = aPointX;

        aBLength = Math.sqrt(Math.pow(bPointX - aPointX, 2) + Math.pow(bPointY - aPointY, 2));
        cALength = Math.sqrt(Math.pow(aPointX - cPointX, 2) + Math.pow(aPointY - cPointY, 2));
    }

    public double getAPointY() {
        return aPointY;
    }

    public void setAPointY(double aPointY) {
        this.aPointY = aPointY;

        aBLength = Math.sqrt(Math.pow(bPointX - aPointX, 2) + Math.pow(bPointY - aPointY, 2));
        cALength = Math.sqrt(Math.pow(aPointX - cPointX, 2) + Math.pow(aPointY - cPointY, 2));
    }

    public double getBPointX() {
        return bPointX;
    }

    public void setBPointX(double bPointX) {
        this.bPointX = bPointX;

        aBLength = Math.sqrt(Math.pow(bPointX - aPointX, 2) + Math.pow(bPointY - aPointY, 2));
        bCLength = Math.sqrt(Math.pow(cPointX - bPointX, 2) + Math.pow(cPointY - bPointY, 2));
    }

    public double getBPointY() {
        return bPointY;
    }

    public void setBPointY(double bPointY) {
        this.bPointY = bPointY;

        aBLength = Math.sqrt(Math.pow(bPointX - aPointX, 2) + Math.pow(bPointY - aPointY, 2));
        bCLength = Math.sqrt(Math.pow(cPointX - bPointX, 2) + Math.pow(cPointY - bPointY, 2));
    }

    public double getCPointX() {
        return cPointX;
    }

    public void setCPointX(double cPointX) {
        this.cPointX = cPointX;

        bCLength = Math.sqrt(Math.pow(cPointX - bPointX, 2) + Math.pow(cPointY - bPointY, 2));
        cALength = Math.sqrt(Math.pow(aPointX - cPointX, 2) + Math.pow(aPointY - cPointY, 2));
    }

    public double getCPointY() {
        return cPointY;
    }

    public void setCPointY(double cPointY) {
        this.cPointY = cPointY;

        bCLength = Math.sqrt(Math.pow(cPointX - bPointX, 2) + Math.pow(cPointY - bPointY, 2));
        cALength = Math.sqrt(Math.pow(aPointX - cPointX, 2) + Math.pow(aPointY - cPointY, 2));
    }

    public double getABLength() {
        return aBLength;
    }

    public double getBCLength() {
        return bCLength;
    }

    public double getCALength() {
        return cALength;
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

        return Math.sqrt(semiPerimeter * (semiPerimeter - aBLength) * (semiPerimeter - bCLength) * (semiPerimeter - cALength));
    }

    @Override
    public double getPerimeter() {
        return aBLength + bCLength + cALength;
    }
}
