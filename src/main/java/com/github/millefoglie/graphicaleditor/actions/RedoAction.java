package com.github.millefoglie.graphicaleditor.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import com.github.millefoglie.graphicaleditor.Editor;
import com.github.millefoglie.graphicaleditor.Util;
import com.github.millefoglie.graphicaleditor.document.Document;
import com.github.millefoglie.graphicaleditor.gui.DrawingPane;
import com.github.millefoglie.graphicaleditor.gui.Gui;

public class RedoAction extends AbstractAction {

    private static final long serialVersionUID = 3664992603181237306L;
    public static final String REDO = "redo";

    public RedoAction() {
	putValue(NAME, REDO);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
	Document doc = Editor.getInstance().getDocument();
	DrawingPane drawPane = Gui.getInstance().getDrawingPane();

	doc.redo();
	drawPane.clear();
	Util.generateShapeComponents(doc.getShapes());
	drawPane.repaint();
    }

}
