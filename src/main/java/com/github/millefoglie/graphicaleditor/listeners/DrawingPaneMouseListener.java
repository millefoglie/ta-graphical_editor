package com.github.millefoglie.graphicaleditor.listeners;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.github.millefoglie.graphicaleditor.Document;
import com.github.millefoglie.graphicaleditor.Editor;
import com.github.millefoglie.graphicaleditor.commands.Command;
import com.github.millefoglie.graphicaleditor.commands.CommandFactory;
import com.github.millefoglie.graphicaleditor.shapes.ShapeNames;

/**
 * The listener interface for receiving drawingPaneMouse events.
 * The class that is interested in processing a drawingPaneMouse
 * event implements this interface, and the object created
 * with that class is registered with a component using the
 * component's @code{addDrawingPaneMouseListener} method. When
 * the drawingPaneMouse event occurs, that object's appropriate
 * method is invoked.
 *
 * @see DrawingPaneMouseEvent
 */
public class DrawingPaneMouseListener extends MouseAdapter {
    
    @Override
    public void mouseClicked(MouseEvent e) {
	
	// left mouse button click
	if (e.getButton() == MouseEvent.BUTTON1) {
	    Editor editor = Editor.getInstance();
	    ShapeNames shapeBrush = editor.getShapeBrush();
	    
	    // brush is selected
	    if (shapeBrush != null) {
		Command cmd = CommandFactory.newCreateShapeCommand(
			shapeBrush, e.getX(), e.getY());
		
		Document doc = editor.getDocument();
		
		doc.addHistory(cmd);
		cmd.exec();
	    }
	}
    }
}
