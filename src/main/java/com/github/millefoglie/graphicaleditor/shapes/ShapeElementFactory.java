package com.github.millefoglie.graphicaleditor.shapes;

/**
 * A factory for creating AbstractShape objects.
 */
public class ShapeElementFactory {

    /**
     * New shape element.
     *
     * @param name the shape name
     * @param cx the center X
     * @param cy the center Y
     * @return the abstract shape
     */
    public static AbstractShape newShape(ShapeNames name, int cx, int cy) {
	switch (name) {
	case TRIANGLE:
	    return new Triangle(cx, cy);
	case SQUARE:
	    return new Square(cx, cy);
	case TRAPEZIUM:
	    return new Trapezium(cx, cy);
	case CIRCLE:
	    return new Circle(cx, cy);
	case ELLIPSE:
	    return new Ellipse(cx, cy);
	default:
	    return null;
	}
    }
}
