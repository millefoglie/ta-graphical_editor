package com.github.millefoglie.graphicaleditor;

import javax.swing.SwingUtilities;

import com.github.millefoglie.graphicaleditor.animation.AnimationThread;
import com.github.millefoglie.graphicaleditor.gui.Gui;

/**
 * The main class.
 */
public class App {

    public static void main(String[] args) {
	SwingUtilities.invokeLater(new Runnable() {
	    public void run() {
		Gui.getInstance().go();
		
		Editor editor = Editor.getInstance();
		Document document = new Document();
		AnimationThread animation = new AnimationThread();
		
		editor.setDocument(document);
		animation.start();
	    }
	});
    }
}
