package com.github.millefoglie.graphicaleditor.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import com.github.millefoglie.graphicaleditor.listeners.DrawingPaneMouseListener;

public class DrawingPane extends JPanel {

    private static final long serialVersionUID = 7003768625421565753L;
    
    private final List<ShapeComponent> shapeComponents = new LinkedList<>();
    
    private ShapeContextMenu shapeContextMenu;
    private DrawingPaneContextMenu drawingPaneContextMenu;

    public void init() {
	Dimension dim = new Dimension(790, 565);

	setMinimumSize(dim);
	setMaximumSize(dim);
	setPreferredSize(dim);
	setBackground(Color.WHITE);
	setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
	addMouseListener(new DrawingPaneMouseListener());
	
	shapeContextMenu = new ShapeContextMenu();
	shapeContextMenu.init();
	
	drawingPaneContextMenu = new DrawingPaneContextMenu();
	drawingPaneContextMenu.init();
	
	setComponentPopupMenu(drawingPaneContextMenu);
    }

    public List<ShapeComponent> getShapeComponents() {
	return shapeComponents;
    }

    public void addShapeComponent(ShapeComponent sc) {
	shapeComponents.add(sc);
	add(sc);
    }
    
    public void removeShapeComponent(ShapeComponent sc) {
	shapeComponents.remove(sc);
	remove(sc);
    }

    /**
     * Clear the pane.
     */
    public void clear() {
	ShapeComponent sc;
	
	for (ListIterator<ShapeComponent> it = shapeComponents.listIterator();
		it.hasNext(); ) {
	    sc = it.next();
	    
	    remove(sc);
	    it.remove();
	}
    }
    
    public ShapeContextMenu getShapeContextMenu() {
        return shapeContextMenu;
    }
    
    public DrawingPaneContextMenu getDrawingPaneContextMenu() {
        return drawingPaneContextMenu;
    }
    
}
