package com.github.millefoglie.graphicaleditor.shapes;

import java.awt.Polygon;

public class Triangle extends PolygonalShape {

    private static final long serialVersionUID = -433298419230605019L;
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
	
	// construct equilateral triangle
	poly.addPoint(cx, cy - UNIT);
	poly.addPoint((int) (cx + 0.86 * UNIT), (int) (cy + 0.5 * UNIT));
	poly.addPoint((int) (cx - 0.86 * UNIT), (int) (cy + 0.5 * UNIT));
	
	setShape(poly);
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
