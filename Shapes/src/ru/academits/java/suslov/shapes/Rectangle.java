package ru.academits.java.suslov.shapes;

public class Rectangle implements Shape {
    private static final double EPSILON = 1e-10;

    private double aPointX;

    private double aPointY;

    private double bPointX;

    private double bPointY;

    private double cPointX;

    private double cPointY;

    private double aBLength;

    private double bCLength;

    private double cALength;

    public Rectangle(double aPointX, double aPointY, double bPointX, double bPointY, double cPointX, double cPointY) {
        this.aPointX = aPointX;
        this.aPointY = aPointY;
        this.bPointX = bPointX;
        this.bPointY = bPointY;
        this.cPointX = cPointX;
        this.cPointY = cPointY;

        this.aBLength = Math.sqrt(Math.pow(bPointX - aPointX, 2) + Math.pow(bPointY - aPointY, 2));
        this.bCLength = Math.sqrt(Math.pow(cPointX - bPointX, 2) + Math.pow(cPointY - bPointY, 2));
        this.cALength = Math.sqrt(Math.pow(aPointX - cPointX, 2) + Math.pow(aPointY - cPointY, 2));
    }

    public double getAPointX() {
        return aPointX;
    }

    public void setAPointX(double aPointX) {
        this.aPointX = aPointX;

        this.aBLength = Math.sqrt(Math.pow(bPointX - aPointX, 2) + Math.pow(bPointY - aPointY, 2));
        this.cALength = Math.sqrt(Math.pow(aPointX - cPointX, 2) + Math.pow(aPointY - cPointY, 2));
    }

    public double getAPointY() {
        return aPointY;
    }

    public void setAPointY(double aPointY) {
        this.aPointY = aPointY;

        this.aBLength = Math.sqrt(Math.pow(bPointX - aPointX, 2) + Math.pow(bPointY - aPointY, 2));
        this.cALength = Math.sqrt(Math.pow(aPointX - cPointX, 2) + Math.pow(aPointY - cPointY, 2));
    }

    public double getBPointX() {
        return bPointX;
    }

    public void setBPointX(double bPointX) {
        this.bPointX = bPointX;

        this.aBLength = Math.sqrt(Math.pow(bPointX - aPointX, 2) + Math.pow(bPointY - aPointY, 2));
        this.bCLength = Math.sqrt(Math.pow(cPointX - bPointX, 2) + Math.pow(cPointY - bPointY, 2));
    }

    public double getBPointY() {
        return bPointY;
    }

    public void setBPointY(double bPointY) {
        this.bPointY = bPointY;

        this.aBLength = Math.sqrt(Math.pow(bPointX - aPointX, 2) + Math.pow(bPointY - aPointY, 2));
        this.bCLength = Math.sqrt(Math.pow(cPointX - bPointX, 2) + Math.pow(cPointY - bPointY, 2));
    }

    public double getCPointX() {
        return cPointX;
    }

    public void setCPointX(double cPointX) {
        this.cPointX = cPointX;

        this.bCLength = Math.sqrt(Math.pow(cPointX - bPointX, 2) + Math.pow(cPointY - bPointY, 2));
        this.cALength = Math.sqrt(Math.pow(aPointX - cPointX, 2) + Math.pow(aPointY - cPointY, 2));
    }

    public double getCPointY() {
        return cPointY;
    }

    public void setCPointY(double cPointY) {
        this.cPointY = cPointY;

        this.bCLength = Math.sqrt(Math.pow(cPointX - bPointX, 2) + Math.pow(cPointY - bPointY, 2));
        this.cALength = Math.sqrt(Math.pow(aPointX - cPointX, 2) + Math.pow(aPointY - cPointY, 2));
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
        return Math.max(Math.max(this.getAPointX(), this.getBPointX()), this.getCPointX()) - Math.min(Math.min(this.getAPointX(), this.getBPointX()), this.getCPointX());
    }

    @Override
    public double getHeight() {
        return Math.max(Math.max(this.getAPointY(), this.getBPointY()), this.getCPointY()) - Math.min(Math.min(this.getAPointY(), this.getBPointY()), this.getCPointY());
    }

    @Override
    public double getArea() {
        double semiPerimeter = this.getPerimeter() / 2;

        return Math.sqrt(semiPerimeter * (semiPerimeter - this.aBLength) * (semiPerimeter - this.bCLength) * (semiPerimeter - this.cALength));
    }

    @Override
    public double getPerimeter() {
        return this.aBLength + this.bCLength + this.cALength;
    }
}