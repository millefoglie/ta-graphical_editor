package com.github.millefoglie.graphicaleditor.gui;

import javax.swing.Action;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import com.github.millefoglie.graphicaleditor.actions.ShapeContextMenuDeleteAction;
import com.github.millefoglie.graphicaleditor.actions.ShapeContextMenuRotateStartAction;
import com.github.millefoglie.graphicaleditor.actions.ShapeContextMenuRotateStopAction;
import com.github.millefoglie.graphicaleditor.listeners.ShapeContextMenuPopupListener;

// TODO: Auto-generated Javadoc
/**
 * The context menu for shapes.
 */
public class ShapeContextMenu extends JPopupMenu {
    
    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 7581801945279968503L;

    /** The delete shape action. */
    private Action deleteShapeAction;
    
    /** The rotate start action. */
    private Action rotateStartAction;
    
    /** The rotate stop action. */
    private Action rotateStopAction;
    
    /** The delete menu item. */
    private JMenuItem jmiDelete;
    
    /** The rotate menu item. */
    private JMenuItem jmiRotate;
    
    /**
     * Instantiates a new shape context menu.
     */
    public ShapeContextMenu() {}
    
    /**
     * Initialize the context menu.
     */
    public void init() {
	deleteShapeAction = new ShapeContextMenuDeleteAction();
	rotateStartAction = new ShapeContextMenuRotateStartAction();
	rotateStopAction = new ShapeContextMenuRotateStopAction();
	
	jmiDelete = new JMenuItem(deleteShapeAction);
	jmiRotate = new JMenuItem(rotateStartAction);

	setRotateStartAction();
	add(jmiDelete);
	add(jmiRotate);
	
	addPopupMenuListener(new ShapeContextMenuPopupListener());
    }
    
    /**
     * Sets the rotate start action.
     */
    public void setRotateStartAction() {
	jmiRotate.setAction(rotateStartAction);
    }
    
    /**
     * Sets the rotate stop action.
     */
    public void setRotateStopAction() {
	jmiRotate.setAction(rotateStopAction);
    }
}
