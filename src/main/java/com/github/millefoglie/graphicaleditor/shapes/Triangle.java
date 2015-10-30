package com.github.millefoglie.graphicaleditor.shapes;

import java.awt.Polygon;

/**
 * The Triangle class.
 */
public class Triangle extends AbstractPolygon {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -433298419230605019L;

    /** The Constant UNIT. */
    private static final int UNIT = 40;
    
    /**
     * Instantiates a new triangle.
     */
    public Triangle() {}
    
    /**
     * Instantiates a new triangle.
     *
     * @param cx the center X
     * @param cy the center Y
     */
    public Triangle(int cx, int cy) {
	super(cx, cy);
	Polygon poly = new Polygon();
	
	poly.addPoint(cx, cy - UNIT);
	poly.addPoint(cx + UNIT, cy + UNIT);
	poly.addPoint(cx - UNIT, cy + UNIT);
	
	setBaseShape(poly);
    }
    
    @Override
    public Triangle clone() throws CloneNotSupportedException {
	Triangle clone = new Triangle();
	clone.cx = cx;
	clone.cy = cy;
	clone.theta = theta;
	clone.affineTransform = affineTransform;
	clone.baseShape = baseShape;
	clone.shape = shape;
	
	return clone;
    }

    @Override
    public int hashCode() {
	return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
	if (obj == null) {
	    return false;
	}
	
	if (obj == this) {
	    return true;
	}
	
	if (obj.getClass() != this.getClass()) {
	    return false;
	}
	
	return super.equals(obj);
    }
}
