package com.github.millefoglie.graphicaleditor.transformations;

import com.github.millefoglie.graphicaleditor.shapes.AbstractShape;
import com.github.millefoglie.graphicaleditor.util.Settings;

public class TransformationFactory {

    private TransformationFactory() {}
    
    public static Rotation getRotation(AbstractShape shape, double phi,
	    boolean compensateAnimation) {
	if (compensateAnimation) {
	    phi /= (Settings.getFps() * Settings.getIterationsPerFrame());
	}
	
	return new Rotation(shape, phi);
    }
}
