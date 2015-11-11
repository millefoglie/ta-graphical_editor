package com.github.millefoglie.graphicaleditor.commands;

import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;

import com.github.millefoglie.graphicaleditor.Editor;
import com.github.millefoglie.graphicaleditor.document.Document;
import com.github.millefoglie.graphicaleditor.geometry.IntersectionDetector;
import com.github.millefoglie.graphicaleditor.gui.DrawingPane;
import com.github.millefoglie.graphicaleditor.gui.Gui;
import com.github.millefoglie.graphicaleditor.gui.ShapeComponent;
import com.github.millefoglie.graphicaleditor.shapes.AbstractShape;
import com.github.millefoglie.graphicaleditor.shapes.ShapeFactory;
import com.github.millefoglie.graphicaleditor.shapes.ShapeNames;

public class CreateShapeCommand implements Command {

    private static final long serialVersionUID = 3892128606790015980L;
    private static final String SHAPE_CREATION_FAILED =
	    "Could not create shape: new shape intersects with another shape.";

    private final ShapeNames shapeBrush;
    private final int x;
    private final int y;

    CreateShapeCommand(ShapeNames shapeBrush, int x, int y) {
	super();
	this.shapeBrush = shapeBrush;
	this.x = x;
	this.y = y;
    }

    @Override
    public void exec() {
	Document doc = Editor.getInstance().getDocument();
	DrawingPane drawPane = Gui.getInstance().getDrawingPane();
	AbstractShape shape = ShapeFactory.newShape(
		shapeBrush, x, y);

	// shapes should not intersect
	if (IntersectionDetector.intersect(shape, doc.getShapes())) {
	    JOptionPane.showMessageDialog(null, SHAPE_CREATION_FAILED);
	    return;
	}

	ShapeComponent sc = new ShapeComponent(shape);
	JPopupMenu menu = drawPane.getShapeContextMenu();

	sc.setComponentPopupMenu(menu);
	doc.addShape(shape);
	drawPane.addShapeComponent(sc);
	drawPane.repaint();
    }

}
