package com.github.millefoglie.graphicaleditor;

import java.util.Collection;

import javax.swing.JPopupMenu;

import com.github.millefoglie.graphicaleditor.gui.DrawingPane;
import com.github.millefoglie.graphicaleditor.gui.Gui;
import com.github.millefoglie.graphicaleditor.gui.ShapeComponent;
import com.github.millefoglie.graphicaleditor.shapes.AbstractShape;

/**
 * A utility class for managing the application. It should be turned into a
 * mediator between the Editor, Gui and Document.
 */
public class Util {
    
    private Util() {}
    
    public static void generateShapeComponents(
	    Collection<? extends AbstractShape> shapes) {
	DrawingPane drawPane = Gui.getInstance().getDrawingPane();
	JPopupMenu menu = drawPane.getShapeContextMenu();
	ShapeComponent sc;
	
	for (AbstractShape s : shapes) {
	    sc = new ShapeComponent(s);
	    
	    sc.setComponentPopupMenu(menu);
	    drawPane.addShapeComponent(sc);
	}
    }
    
}
