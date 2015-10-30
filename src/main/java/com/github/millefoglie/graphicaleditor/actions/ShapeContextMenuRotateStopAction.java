package com.github.millefoglie.graphicaleditor.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JPopupMenu;

import com.github.millefoglie.graphicaleditor.gui.Gui;
import com.github.millefoglie.graphicaleditor.gui.ShapeComponent;
import com.github.millefoglie.graphicaleditor.shapes.AbstractShape;

/**
 * The Shape Context Menu Rotate Stop Action.
 */
public class ShapeContextMenuRotateStopAction extends AbstractAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 2200742362121697306L;
    
    /** The Constant ROTATE_STOP. */
    public static final String ROTATE_STOP = "stop";
    
    /**
     * Instantiates a new shape context menu rotate stop action.
     */
    public ShapeContextMenuRotateStopAction() {
	putValue(NAME, ROTATE_STOP);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
	JPopupMenu menu = Gui.getInstance()
		.getDrawingPane().getShapeContextMenu();
	
	ShapeComponent sc = (ShapeComponent) menu.getInvoker();
	AbstractShape s = sc.getShapeElement();
	
	s.getAnimationStatus().setRotating(false);
    }

}
