package com.github.millefoglie.graphicaleditor.gui;

import javax.swing.Action;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import com.github.millefoglie.graphicaleditor.actions.OpenFileAction;
import com.github.millefoglie.graphicaleditor.actions.RedoAction;
import com.github.millefoglie.graphicaleditor.actions.SaveFileAction;
import com.github.millefoglie.graphicaleditor.actions.UndoAction;

public class DrawingPaneContextMenu extends JPopupMenu {
    
    private static final long serialVersionUID = 577492804369940901L;
    private Action openFile;
    private Action saveFile;
    private Action undo;
    private Action redo;
    private JMenuItem jmiOpen;
    private JMenuItem jmiSave;
    private JMenuItem jmiUndo;
    private JMenuItem jmiRedo;
    
    public DrawingPaneContextMenu() {}
    
    public void init() {
	openFile = new OpenFileAction();
	saveFile = new SaveFileAction();
	undo = new UndoAction();
	redo = new RedoAction();
	
	jmiOpen = new JMenuItem(openFile);
	jmiSave = new JMenuItem(saveFile);
	jmiUndo = new JMenuItem(undo);
	jmiRedo = new JMenuItem(redo);

	add(jmiOpen);
	add(jmiSave);
	add(jmiUndo);
	add(jmiRedo);
    }
    
}
