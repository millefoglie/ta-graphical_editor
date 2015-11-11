package com.github.millefoglie.graphicaleditor.actions;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.AbstractAction;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import com.github.millefoglie.graphicaleditor.Editor;
import com.github.millefoglie.graphicaleditor.Util;
import com.github.millefoglie.graphicaleditor.document.Document;
import com.github.millefoglie.graphicaleditor.gui.DrawingPane;
import com.github.millefoglie.graphicaleditor.gui.Gui;

public class OpenFileAction extends AbstractAction {
    
    private static final long serialVersionUID = 3821461942203864759L;
    private static final String FILE_OPEN_FAILED =
	    "Could not open this file";
    public static final String OPEN = "open";

    public OpenFileAction() {
	putValue(NAME, OPEN);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
	JFileChooser jfc = new JFileChooser();
	
	if (jfc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
	    File f = jfc.getSelectedFile();
	    
	    try (ObjectInputStream in =
		    new ObjectInputStream(new FileInputStream(f))) {
		Document doc = (Document) in.readObject();
		DrawingPane drawPane = Gui.getInstance().getDrawingPane();
		
		drawPane.clear();
		doc.clearHistory();
		Editor.getInstance().setDocument(doc);
		Util.generateShapeComponents(doc.getShapes());
		drawPane.repaint();
		
	    } catch (IOException | ClassNotFoundException e1) {
		JOptionPane.showMessageDialog(null, FILE_OPEN_FAILED);
		e1.printStackTrace();
	    }
	}
    }
    
}
