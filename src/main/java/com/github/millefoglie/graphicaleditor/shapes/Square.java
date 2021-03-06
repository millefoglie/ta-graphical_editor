package com.github.millefoglie.graphicaleditor.shapes;

import java.awt.Polygon;

/**
 * The Square class.
 */
public class Square extends PolygonalShape {

    private static final long serialVersionUID = 1396154981482160892L;
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
	
	setShape(poly);
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
