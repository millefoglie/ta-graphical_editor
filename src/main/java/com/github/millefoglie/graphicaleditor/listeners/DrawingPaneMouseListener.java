package com.github.millefoglie.graphicaleditor.listeners;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;

import com.github.millefoglie.graphicaleditor.Editor;
import com.github.millefoglie.graphicaleditor.gui.DrawingPane;
import com.github.millefoglie.graphicaleditor.gui.Gui;
import com.github.millefoglie.graphicaleditor.gui.ShapeComponent;
import com.github.millefoglie.graphicaleditor.shapes.AbstractShape;
import com.github.millefoglie.graphicaleditor.shapes.ShapeElementFactory;
import com.github.millefoglie.graphicaleditor.shapes.ShapeNames;
import com.github.millefoglie.graphicaleditor.util.IntersectionDetector;

/**
 * The listener interface for receiving drawingPaneMouse events.
 * The class that is interested in processing a drawingPaneMouse
 * event implements this interface, and the object created
 * with that class is registered with a component using the
 * component's <code>addDrawingPaneMouseListener<code> method. When
 * the drawingPaneMouse event occurs, that object's appropriate
 * method is invoked.
 *
 * @see DrawingPaneMouseEvent
 */
public class DrawingPaneMouseListener extends MouseAdapter {
    
    private static final String SHAPE_CREATION_FAILED =
	    "Could not create shape: new shape intersects with another shape.";

    @Override
    public void mouseClicked(MouseEvent e) {
	
	// left mouse button click
	if (e.getButton() == MouseEvent.BUTTON1) {
	    Editor editor = Editor.getInstance();
	    ShapeNames shapeBrush = editor.getShapeBrush();
	    
	    // no brush selected
	    if (shapeBrush == null) {
		return;
	    }
	    
	    DrawingPane drawPane = Gui.getInstance().getDrawingPane();
	    AbstractShape shapeElement = ShapeElementFactory.newShape(
		    shapeBrush, e.getX(), e.getY());
	    ShapeComponent sc = new ShapeComponent(shapeElement);

	    if (IntersectionDetector.intersect(shapeElement,
		    editor.getDocument().getShapeElements())) {
		JOptionPane.showMessageDialog(null, SHAPE_CREATION_FAILED);
		return;
	    }
	    
	    JPopupMenu menu = Gui.getInstance()
		    .getDrawingPane().getShapeContextMenu();
	    
	    sc.setComponentPopupMenu(menu);
	    editor.getDocument().addShapeElement(shapeElement);
	    drawPane.addShapeComponent(sc);
	    drawPane.repaint();
	}
    }
}
