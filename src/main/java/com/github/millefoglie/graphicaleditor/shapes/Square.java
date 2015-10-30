package com.github.millefoglie.graphicaleditor.shapes;

import java.awt.Polygon;

/**
 * The Square class.
 */
public class Square extends AbstractPolygon {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1396154981482160892L;

    /** The Constant UNIT. */
    private static final int UNIT = 30;
    
    /**
     * Instantiates a new square.
     */
    public Square() {}
    
    /**
     * Instantiates a new square.
     *
     * @param cx the center X
     * @param cy the center Y
     */
    public Square(int cx, int cy) {
	super(cx, cy);
	Polygon poly = new Polygon();
	
	poly.addPoint(cx - UNIT, cy - UNIT);
	poly.addPoint(cx + UNIT, cy - UNIT);
	poly.addPoint(cx + UNIT, cy + UNIT);
	poly.addPoint(cx - UNIT, cy + UNIT);
	
	setBaseShape(poly);
    }
    
    @Override
    public Square clone() throws CloneNotSupportedException {
	Square clone = new Square();
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
