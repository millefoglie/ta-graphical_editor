package com.github.millefoglie.graphicaleditor.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JPopupMenu;

import com.github.millefoglie.graphicaleditor.Editor;
import com.github.millefoglie.graphicaleditor.commands.Command;
import com.github.millefoglie.graphicaleditor.commands.CommandFactory;
import com.github.millefoglie.graphicaleditor.document.Document;
import com.github.millefoglie.graphicaleditor.gui.Gui;
import com.github.millefoglie.graphicaleditor.gui.ShapeComponent;

public class ShapeContextMenuStartRotationAction extends AbstractAction {

    private static final long serialVersionUID = 2200742362121697306L;
    public static final String ROTATE_START = "rotate";
    
    public ShapeContextMenuStartRotationAction() {
	putValue(NAME, ROTATE_START);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
	JPopupMenu menu =
		Gui.getInstance().getDrawingPane().getShapeContextMenu();
	
	ShapeComponent sc = (ShapeComponent) menu.getInvoker();
	
	Command cmd = CommandFactory.newStartShapeRotationCommand(sc);
	Document doc = Editor.getInstance().getDocument();
	
	doc.commit();
	cmd.exec();
    }

}
