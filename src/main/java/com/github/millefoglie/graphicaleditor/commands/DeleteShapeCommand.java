package com.github.millefoglie.graphicaleditor.commands;

import com.github.millefoglie.graphicaleditor.Editor;
import com.github.millefoglie.graphicaleditor.document.Document;
import com.github.millefoglie.graphicaleditor.gui.DrawingPane;
import com.github.millefoglie.graphicaleditor.gui.Gui;
import com.github.millefoglie.graphicaleditor.gui.ShapeComponent;
import com.github.millefoglie.graphicaleditor.shapes.AbstractShape;

public class DeleteShapeCommand implements Command {
    
    private static final long serialVersionUID = 7786982549696632356L;
   
    private final ShapeComponent shapeComponent;

    DeleteShapeCommand(ShapeComponent shapeComponent) {
	super();
	this.shapeComponent = shapeComponent;
    }

    @Override
    public void exec() {
	DrawingPane drawPane = Gui.getInstance().getDrawingPane();
	Document doc = Editor.getInstance().getDocument();
	AbstractShape shape = shapeComponent.getShape();
	
	drawPane.removeShapeComponent(shapeComponent);
	doc.removeShape(shape);
	shape.getAnimationStatus().setRotating(false);
    }

}
