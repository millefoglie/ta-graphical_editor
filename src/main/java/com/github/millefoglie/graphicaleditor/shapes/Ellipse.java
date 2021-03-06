package com.github.millefoglie.graphicaleditor.shapes;

import java.awt.Point;
import java.awt.Polygon;
import java.awt.geom.Ellipse2D;

import com.github.millefoglie.graphicaleditor.geometry.GeomUtil;

public class Ellipse extends AbstractShape {

    private static final long serialVersionUID = 963445119666821858L;
    private static final int DEFAULT_A = 50;
    private static final int DEFAULT_B = 30;
    private static final int SEGMENTS = 32;

    /** The big half-axis. */
    protected double a;
    
    /** The small half-axis. */
    protected double b;

    /** The polygonal approximation. */
    protected PolygonalShape proxy;

    /**
     * Instantiates a new ellipse.
     */
    Ellipse() {}

    /**
     * Instantiates a new ellipse.
     *
     * @param cx the center X
     * @param cy the center Y
     */
    public Ellipse(int cx, int cy) {
	this(cx, cy, DEFAULT_A, DEFAULT_B);
    }

    /**
     * Instantiates a new ellipse.
     *
     * @param cx the center X
     * @param cy the center Y
     * @param a the big half-axis
     * @param b the small half-axis
     */
    Ellipse(int cx, int cy, double a, double b) {
	super(cx, cy);
	setShape(new Ellipse2D.Double(cx - a, cy - b, 2 * a, 2 * b));

	this.a = a;
	this.b = b;
    }

    /**
     * Gets the big half-axis.
     *
     * @return the big half-axis
     */
    public double getA() {
	return a;
    }

    /**
     * Gets the small half-axis.
     *
     * @return the small half-axis
     */
    public double getB() {
	return b;
    }

    @Override
    public PolygonalShape getProxy() {
	if (proxy == null) {
	    Polygon poly = new Polygon();

	    Point p;
	    double phi;

	    // traverse the ellipse and add new vertices to poly
	    for (int i = 0; i < SEGMENTS; i++) {
		phi = 2 * Math.PI * i / SEGMENTS;
		p = GeomUtil.rotate(
			(int) (cx + a * Math.cos(phi)),
			(int) (cy + b * Math.sin(phi)),
			cx, cy, theta);

		poly.addPoint((int) p.getX(), (int) p.getY());
	    }

	    proxy = new PolygonalShape(cx, cy);
	    proxy.setShape(poly);
	}

	// update rotation angle
	proxy.setTheta(theta);

	return proxy;
    }

    @Override
    public Ellipse clone() throws CloneNotSupportedException {
	Ellipse clone = new Ellipse();
	clone.cx = cx;
	clone.cy = cy;
	clone.theta = theta;
	clone.affineTransform = affineTransform;
	clone.baseShape = baseShape;
	clone.shape = shape;
	clone.a = a;
	clone.b = b;
	clone.proxy = proxy;
	clone.a = a;
	clone.b = b;
	
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
	
	Ellipse other = (Ellipse) obj;
	
	return super.equals(obj) && (this.a == other.a)
		&& (this.b == other.b) && (this.proxy == other.proxy);
    }
}
