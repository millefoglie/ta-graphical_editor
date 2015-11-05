package com.github.millefoglie.graphicaleditor.commands;

import com.github.millefoglie.graphicaleditor.Document;
import com.github.millefoglie.graphicaleditor.Editor;
import com.github.millefoglie.graphicaleditor.gui.ShapeComponent;
import com.github.millefoglie.graphicaleditor.shapes.AbstractShape;
import com.github.millefoglie.graphicaleditor.transformations.Transformation;
import com.github.millefoglie.graphicaleditor.transformations.TransformationFactory;

public class StartShapeRotationCommand implements Command {

    private final ShapeComponent shapeComponent;

    StartShapeRotationCommand(ShapeComponent shapeComponent) {
	super();
	this.shapeComponent = shapeComponent;
    }

    @Override
    public void exec() {
	Document doc = Editor.getInstance().getDocument();
	AbstractShape shape = shapeComponent.getShape();

	// full rotation in at least 2 seconds
	double angularSpeed = 6.28 * (Math.random() - 0.5);
	Transformation t =
		TransformationFactory.newRotation(shape, angularSpeed, true);

	shape.getAnimationStatus().setRotating(true);
	doc.addTransformation(t);
    }

    @Override
    public void undo() {
	// TODO Auto-generated method stub

    }

}
