package com.github.millefoglie.graphicaleditor;

import javax.swing.SwingUtilities;

import com.github.millefoglie.graphicaleditor.gui.Gui;
import com.github.millefoglie.graphicaleditor.model.Document;

public class App {

    public static void main(String[] args) {
	SwingUtilities.invokeLater(new Runnable() {
	    public void run() {
		Gui.getInstance().go();
		
		Editor editor = Editor.getInstance();
		Document document = new Document();
		
		editor.setDocument(document);
		document.getAnimation().start();
	    }
	});
    }
}
