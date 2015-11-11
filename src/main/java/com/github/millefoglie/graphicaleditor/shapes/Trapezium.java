package com.github.millefoglie.graphicaleditor.shapes;

import java.awt.Polygon;

public class Trapezium extends PolygonalShape {
    
    private static final long serialVersionUID = -2715644182178429534L;
    private static final int UNIT = 30;
    
    /**
     * Instantiates a new trapezium.
     */
    public Trapezium() {}
    
    /**
     * Instantiates a new trapezium.
     *
     * @param cx the center X
     * @param cy the center Y
     */
    public Trapezium(int cx, int cy) {
	super(cx, cy);
	Polygon poly = new Polygon();
	
	poly.addPoint(cx + UNIT, cy - UNIT);
	poly.addPoint(cx + 3 * UNIT / 2, cy + UNIT);
	poly.addPoint(cx - 3 * UNIT / 2, cy + UNIT);
	poly.addPoint(cx - UNIT, cy - UNIT);
	
	setShape(poly);
    }
    
    @Override
    public Trapezium clone() throws CloneNotSupportedException {
	Trapezium clone = new Trapezium();
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
