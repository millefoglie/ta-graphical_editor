package com.github.millefoglie.graphicaleditor.commands;

import com.github.millefoglie.graphicaleditor.gui.ShapeComponent;
import com.github.millefoglie.graphicaleditor.shapes.AbstractShape;

public class StopShapeRotationCommand implements Command {

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

    @Override
    public void undo() {
	// TODO Auto-generated method stub

    }

}
