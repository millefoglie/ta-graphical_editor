package com.github.millefoglie.graphicaleditor.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import com.github.millefoglie.graphicaleditor.Editor;
import com.github.millefoglie.graphicaleditor.Util;
import com.github.millefoglie.graphicaleditor.document.Document;
import com.github.millefoglie.graphicaleditor.gui.DrawingPane;
import com.github.millefoglie.graphicaleditor.gui.Gui;

public class UndoAction extends AbstractAction {

    private static final long serialVersionUID = 328451384433087682L;
    public static final String UNDO = "undo";

    public UndoAction() {
	putValue(NAME, UNDO);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
	Document doc = Editor.getInstance().getDocument();
	DrawingPane drawPane = Gui.getInstance().getDrawingPane();
	
	doc.undo();
	drawPane.clear();
	Util.generateShapeComponents(doc.getShapes());
	drawPane.repaint();
    }

}
