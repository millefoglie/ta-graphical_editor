package com.github.millefoglie.graphicaleditor.listeners;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.github.millefoglie.graphicaleditor.Editor;
import com.github.millefoglie.graphicaleditor.commands.Command;
import com.github.millefoglie.graphicaleditor.commands.CommandFactory;
import com.github.millefoglie.graphicaleditor.document.Document;
import com.github.millefoglie.graphicaleditor.shapes.ShapeNames;

public class DrawingPaneMouseListener extends MouseAdapter {
    
    @Override
    public void mouseClicked(MouseEvent e) {
	
	// left mouse button click
	if (e.getButton() == MouseEvent.BUTTON1) {
	    Editor editor = Editor.getInstance();
	    ShapeNames shapeBrush = editor.getShapeBrush();
	    
	    // brush must be selected
	    if (shapeBrush != null) {
		Command cmd = CommandFactory.newCreateShapeCommand(
			shapeBrush, e.getX(), e.getY());
		
		Document doc = editor.getDocument();
		
		doc.commit();
		cmd.exec();
	    }
	}
    }
}
