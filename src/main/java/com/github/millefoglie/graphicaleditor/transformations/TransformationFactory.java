package com.github.millefoglie.graphicaleditor.transformations;

import com.github.millefoglie.graphicaleditor.Settings;
import com.github.millefoglie.graphicaleditor.shapes.AbstractShape;

public class TransformationFactory {

    private TransformationFactory() {}
    
    public static Rotation newRotation(AbstractShape shape, double phi,
	    boolean compensateAnimation) {
	if (compensateAnimation) {
	    phi /= (Settings.getFps() * Settings.getIterationsPerFrame());
	}
	
	return new Rotation(shape, phi);
    }
}
