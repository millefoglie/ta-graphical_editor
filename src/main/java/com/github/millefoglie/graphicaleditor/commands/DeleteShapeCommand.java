package com.github.millefoglie.graphicaleditor.commands;

import com.github.millefoglie.graphicaleditor.Document;
import com.github.millefoglie.graphicaleditor.Editor;
import com.github.millefoglie.graphicaleditor.gui.DrawingPane;
import com.github.millefoglie.graphicaleditor.gui.Gui;
import com.github.millefoglie.graphicaleditor.gui.ShapeComponent;
import com.github.millefoglie.graphicaleditor.shapes.AbstractShape;

public class DeleteShapeCommand implements Command {
    
    private final ShapeComponent shapeComponent;

    public DeleteShapeCommand(ShapeComponent shapeComponent) {
	super();
	this.shapeComponent = shapeComponent;
    }

    @Override
    public void exec() {
	DrawingPane drawPane = Gui.getInstance().getDrawingPane();
	Document doc = Editor.getInstance().getDocument();
	AbstractShape shape = shapeComponent.getShape();
	
	drawPane.removeShapeComponent(shapeComponent);
	doc.removeShapeElement(shape);
	shape.getAnimationStatus().setRotating(false);
    }

    @Override
    public void undo() {
	// TODO Auto-generated method stub

    }

}
