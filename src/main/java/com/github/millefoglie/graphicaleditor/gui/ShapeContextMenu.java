package com.github.millefoglie.graphicaleditor.gui;

import javax.swing.Action;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import com.github.millefoglie.graphicaleditor.actions.ShapeContextMenuDeleteAction;
import com.github.millefoglie.graphicaleditor.actions.ShapeContextMenuStartRotationAction;
import com.github.millefoglie.graphicaleditor.actions.ShapeContextMenuStopRotationAction;
import com.github.millefoglie.graphicaleditor.listeners.ShapeContextMenuPopupListener;

/**
 * The Shape Context Menu.
 */
public class ShapeContextMenu extends JPopupMenu {
    
    private static final long serialVersionUID = 7581801945279968503L;
   
    private Action deleteShapeAction;
    private Action rotateStartAction;
    private Action rotateStopAction;
    
    private JMenuItem jmiDelete;
    private JMenuItem jmiRotate;
    
    public ShapeContextMenu() {}
    
    public void init() {
	deleteShapeAction = new ShapeContextMenuDeleteAction();
	rotateStartAction = new ShapeContextMenuStartRotationAction();
	rotateStopAction = new ShapeContextMenuStopRotationAction();
	
	jmiDelete = new JMenuItem(deleteShapeAction);
	jmiRotate = new JMenuItem(rotateStartAction);

	useRotateStartAction();
	add(jmiDelete);
	add(jmiRotate);
	
	addPopupMenuListener(new ShapeContextMenuPopupListener());
    }
    
    public void useRotateStartAction() {
	jmiRotate.setAction(rotateStartAction);
    }
    
    public void useRotateStopAction() {
	jmiRotate.setAction(rotateStopAction);
    }
}
