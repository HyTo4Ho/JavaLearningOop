package ru.academits.java.suslov.shapes_comparators;

import ru.academits.java.suslov.shapes.Shape;

import java.util.Comparator;

public class ShapesPerimeterComparator implements Comparator<Shape> {
    @Override
    public int compare(Shape shape1, Shape shape2) {
        return Double.compare(shape1.getPerimeter(), shape2.getPerimeter());
    }
}