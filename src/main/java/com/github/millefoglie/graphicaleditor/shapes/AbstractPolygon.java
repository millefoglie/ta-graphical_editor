package com.github.millefoglie.graphicaleditor.shapes;

import java.awt.Polygon;
import java.awt.Shape;

/**
 * An abstract polygon class which is a bridge to Java 2D Polygon.
 */
public class AbstractPolygon extends AbstractShape {

    private static final long serialVersionUID = 345026425159683900L;

    /**
     * Instantiates a new abstract polygon.
     */
    public AbstractPolygon() {
	baseShape = new Polygon();
	shape = baseShape;
    }
    
    /**
     * Instantiates a new abstract polygon.
     *
     * @param cx the center X
     * @param cy the center Y
     */
    public AbstractPolygon(int cx, int cy) {
	super(cx, cy);
	baseShape = new Polygon();
	shape = baseShape;
    }
    
    @Override
    public Polygon getBaseShape() {
	return (Polygon) super.getBaseShape();
    }

    @Override
    public void setShape(Shape shape) {
	if (!(shape instanceof Polygon)) {
	    throw new IllegalArgumentException("Shape is not a Polygon");
	}
	
	super.setShape(shape);
    }
    
    @Override
    public void setBaseShape(Shape shape) {
	if (!(shape instanceof Polygon)) {
	    throw new IllegalArgumentException("Shape is not a Polygon");
	}
	
	super.setBaseShape(shape);
    }
}
