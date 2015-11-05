package com.github.millefoglie.graphicaleditor.shapes;

/**
 * The Circle class.
 */
public class Circle extends Ellipse {
    
    private static final long serialVersionUID = 4546183360446647593L;
    private static final int DEFALUT_RADIUS = 40;
    
    /**
     * Instantiates a new circle.
     *
     * @param cx the center X
     * @param cy the center Y
     */
    Circle(int cx, int cy) {
	super(cx, cy, DEFALUT_RADIUS, DEFALUT_RADIUS);
    }

    public double getRadius() {
	return a;	// ellipses' half-axis
    }
    
    @Override
    public Circle clone() throws CloneNotSupportedException {
	return (Circle) super.clone();
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
