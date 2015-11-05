package com.github.millefoglie.graphicaleditor.gui;

import javax.swing.Action;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import com.github.millefoglie.graphicaleditor.actions.OpenFileAction;
import com.github.millefoglie.graphicaleditor.actions.SaveFileAction;

/**
 * The Drawing Pane Context Menu.
 */
public class DrawingPaneContextMenu extends JPopupMenu {
    
    private static final long serialVersionUID = 577492804369940901L;
    private Action openFile;
    private Action saveFile;
    private JMenuItem jmiOpen;
    private JMenuItem jmiSave;
    
    public DrawingPaneContextMenu() {}
    
    public void init() {
	openFile = new OpenFileAction();
	saveFile = new SaveFileAction();
	
	jmiOpen = new JMenuItem(openFile);
	jmiSave = new JMenuItem(saveFile);

	add(jmiOpen);
	add(jmiSave);
    }
}
