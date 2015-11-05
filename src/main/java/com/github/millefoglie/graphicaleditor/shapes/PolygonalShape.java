package com.github.millefoglie.graphicaleditor.shapes;

import java.awt.Polygon;
import java.awt.Shape;

/**
 * A Polygonal Shape class, which is a bridge to the Java 2D API Polygon.
 */
public class PolygonalShape extends AbstractShape {

    private static final long serialVersionUID = 345026425159683900L;

    /**
     * Instantiates a new abstract polygon.
     */
    public PolygonalShape() {
	baseShape = new Polygon();
	shape = baseShape;
    }
    
    /**
     * Instantiates a new abstract polygon.
     *
     * @param cx the center X
     * @param cy the center Y
     */
    public PolygonalShape(int cx, int cy) {
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

    @Override
    public PolygonalShape getProxy() {
	return this;
    }
    
}
