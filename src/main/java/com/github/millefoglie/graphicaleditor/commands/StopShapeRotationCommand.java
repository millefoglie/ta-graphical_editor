package com.github.millefoglie.graphicaleditor.commands;

import com.github.millefoglie.graphicaleditor.gui.ShapeComponent;
import com.github.millefoglie.graphicaleditor.shapes.AbstractShape;

public class StopShapeRotationCommand implements Command {

    private static final long serialVersionUID = 2185075083005246197L;

    private final ShapeComponent shapeComponent;

    StopShapeRotationCommand(ShapeComponent shapeComponent) {
	super();
	this.shapeComponent = shapeComponent;
    }

    @Override
    public void exec() {
	AbstractShape shape = shapeComponent.getShape();

	shape.getAnimationStatus().setRotating(false);
    }
    
}
