package com.github.millefoglie.graphicaleditor.transformations;

import com.github.millefoglie.graphicaleditor.Settings;
import com.github.millefoglie.graphicaleditor.shapes.AbstractShape;

/**
 * @author "millefoglie"
 *
 * The factory for transformations.
 */
public class TransformationFactory {

    private TransformationFactory() {}
    
    /**
     * Create a new Rotation
     * 
     * @param shape the shape to be rotated
     * @param phi the angle or angular speed
     * @param compensateAnimation if true, the angle is divided by an 
     * appropriate number for each iteration, thus making phi an angular speed
     * @return
     */
    public static Rotation newRotation(AbstractShape shape, double phi,
	    boolean compensateAnimation) {
	if (compensateAnimation) {
	    phi /= (Settings.getFps() * Settings.getIterationsPerFrame());
	}
	
	return new Rotation(shape, phi);
    }
}
