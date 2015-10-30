package com.github.millefoglie.graphicaleditor.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JPopupMenu;

import com.github.millefoglie.graphicaleditor.Editor;
import com.github.millefoglie.graphicaleditor.gui.Gui;
import com.github.millefoglie.graphicaleditor.gui.ShapeComponent;
import com.github.millefoglie.graphicaleditor.shapes.AbstractShape;
import com.github.millefoglie.graphicaleditor.transformations.Transformation;
import com.github.millefoglie.graphicaleditor.transformations.TransformationFactory;

/**
 * The Shape Context Menu Rotate Start Action.
 */
public class ShapeContextMenuRotateStartAction extends AbstractAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 2200742362121697306L;
    
    /** The Constant ROTATE_START. */
    public static final String ROTATE_START = "rotate";
    
    /**
     * Instantiates a new shape context menu rotate start action.
     */
    public ShapeContextMenuRotateStartAction() {
	putValue(NAME, ROTATE_START);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
	JPopupMenu menu = Gui.getInstance()
		.getDrawingPane().getShapeContextMenu();
	
	ShapeComponent sc = (ShapeComponent) menu.getInvoker();
	AbstractShape s = sc.getShapeElement();
	
	s.getAnimationStatus().setRotating(true);
	
	double angularSpeed = 6.28 * (Math.random() - 0.5);
	Transformation t =
		TransformationFactory.getRotation(s, angularSpeed, true);
	Editor.getInstance().getDocument().getAnimation().addTransformation(t);
    }

}
