package com.github.millefoglie.graphicaleditor.transformations;

import java.util.Collection;

import com.github.millefoglie.graphicaleditor.Editor;
import com.github.millefoglie.graphicaleditor.geometry.IntersectionDetector;
import com.github.millefoglie.graphicaleditor.shapes.AbstractShape;

/**
 * @author "millefoglie"
 *
 * The rotation transformation.
 */
public class Rotation implements Transformation {

    private static final long serialVersionUID = -5358285454631896699L;

    private final AbstractShape shape;
    private final double phi;

    private boolean expired;

    public Rotation(AbstractShape shape, double phi) {
	super();
	this.shape = shape;
	this.phi = phi;
    }

    @Override
    public void transform() {
	if (!expired && shape.getAnimationStatus().isRotating()) {
	    Collection<AbstractShape> shapes = 
		    Editor.getInstance().getDocument().getShapeElements();

	    shape.rotate(phi);

	    if (IntersectionDetector.intersect(shape, shapes)) {
		shape.rotate(-phi);
	    }
	} else {
	    expired = true;
	}
    }

    @Override
    public boolean isExpired() {
	return expired;
    }
}
