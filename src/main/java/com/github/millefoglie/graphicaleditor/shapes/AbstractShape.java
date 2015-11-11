package com.github.millefoglie.graphicaleditor.shapes;

import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.io.Serializable;

import com.github.millefoglie.graphicaleditor.animation.AnimationStatus;

/**
 * An abstract shape that provides a bridge to Java 2D API shapes and adds
 * additional functionality for geometric manipulations and transformations.
 */
public abstract class AbstractShape implements Cloneable, Serializable {
    
    private static final long serialVersionUID = 1905126146086563967L;

    /** The centre X. */
    protected int cx;
    
    /** The centre Y. */
    protected int cy;
    
    /** The angle of the shape current rotation. */
    protected double theta;
    
    /** The animation status flags. */
    protected AnimationStatus animationStatus  = new AnimationStatus();
    
    /** The base shape (without any transformations). */
    protected Shape baseShape;
    
    /** The Java 2D API shape. */
    protected Shape shape;
    
    /** The affine transformation. */
    protected AffineTransform affineTransform;
    
    /**
     * Instantiates a new abstract shape.
     */
    public AbstractShape(){}
    
    /**
     * Instantiates a new abstract shape.
     *
     * @param cx the center X
     * @param cy the center Y
     */
    public AbstractShape(int cx, int cy) {
	this.cx = cx;
	this.cy = cy;
    }

    public int getCx() {
        return cx;
    }

    public int getCy() {
        return cy;
    }

    public double getTheta() {
        return theta;
    }

    public Shape getShape() {
        return shape;
    }
    
    public Shape getBaseShape() {
        return baseShape;
    }

    public AnimationStatus getAnimationStatus() {
        return animationStatus;
    }

    public void setCx(int cx) {
        this.cx = cx;
    }

    public void setCy(int cy) {
        this.cy = cy;
    }

    public void setTheta(double theta) {
        this.theta = theta;
    }

    /**
     * Set the base shape and update the current shape to match the new base
     * and reset theta value.
     * @param shape the new base shape
     */
    public void setShape(Shape shape) {
	this.baseShape = shape;
	this.shape = shape;
	this.theta = 0;
    }
    
    public abstract PolygonalShape getProxy();

    public void rotate(double phi) {
	if (affineTransform == null) {
	    affineTransform = new AffineTransform();
	}
	
	theta += phi;
	affineTransform.rotate(phi, cx, cy);
	shape = affineTransform.createTransformedShape(baseShape);
    }

    @Override
    public AbstractShape clone() throws CloneNotSupportedException {
	return (AbstractShape) super.clone();
    }

    @Override
    public int hashCode() {
	return (int) cx;
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
	
	AbstractShape other = (AbstractShape) obj;
	
	return (this.cx == other.cx) && (this.cy == other.cy)
		&& (this.affineTransform == other.affineTransform)
		&& (this.theta == other.theta)
		&& (this.baseShape == other.baseShape)
		&& (this.shape == other.shape);
    }

}
