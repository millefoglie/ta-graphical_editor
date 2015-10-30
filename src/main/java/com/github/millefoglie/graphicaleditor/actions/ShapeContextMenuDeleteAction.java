package com.github.millefoglie.graphicaleditor.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JPopupMenu;

import com.github.millefoglie.graphicaleditor.Editor;
import com.github.millefoglie.graphicaleditor.gui.DrawingPane;
import com.github.millefoglie.graphicaleditor.gui.Gui;
import com.github.millefoglie.graphicaleditor.gui.ShapeComponent;
import com.github.millefoglie.graphicaleditor.shapes.AbstractShape;

/**
 * The Shape Context Menu Delete Action.
 */
public class ShapeContextMenuDeleteAction extends AbstractAction {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 5430115521614347917L;
    
    /** The Constant DELETE. */
    public static final String DELETE = "delete";

    /**
     * Instantiates a new shape context menu delete action.
     */
    public ShapeContextMenuDeleteAction() {
	putValue(NAME, DELETE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
	DrawingPane drawPane = Gui.getInstance().getDrawingPane();
	JPopupMenu menu = drawPane.getShapeContextMenu();
	
	ShapeComponent sc = (ShapeComponent) menu.getInvoker();
	AbstractShape s = sc.getShapeElement();
	
	Editor editor = Editor.getInstance();
	
	drawPane.removeShapeComponent(sc);
	editor.getDocument().removeShapeElement(s);
	s.getAnimationStatus().setRotating(false);

//	menu.setVisible(false);
    }

}
