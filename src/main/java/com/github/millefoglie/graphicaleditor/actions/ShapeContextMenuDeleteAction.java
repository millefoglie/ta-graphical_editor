package com.github.millefoglie.graphicaleditor.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JPopupMenu;

import com.github.millefoglie.graphicaleditor.Editor;
import com.github.millefoglie.graphicaleditor.commands.Command;
import com.github.millefoglie.graphicaleditor.commands.CommandFactory;
import com.github.millefoglie.graphicaleditor.document.Document;
import com.github.millefoglie.graphicaleditor.gui.DrawingPane;
import com.github.millefoglie.graphicaleditor.gui.Gui;
import com.github.millefoglie.graphicaleditor.gui.ShapeComponent;

public class ShapeContextMenuDeleteAction extends AbstractAction {

    private static final long serialVersionUID = 5430115521614347917L;
    public static final String DELETE = "delete";

    public ShapeContextMenuDeleteAction() {
	putValue(NAME, DELETE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
	Editor editor = Editor.getInstance();
	DrawingPane drawPane = Gui.getInstance().getDrawingPane();
	JPopupMenu menu = drawPane.getShapeContextMenu();
	
	ShapeComponent sc = (ShapeComponent) menu.getInvoker();
	
	Command cmd = CommandFactory.newDeleteShapeCommand(sc);
	Document doc = editor.getDocument();
	
	doc.commit();
	cmd.exec();
    }

}
