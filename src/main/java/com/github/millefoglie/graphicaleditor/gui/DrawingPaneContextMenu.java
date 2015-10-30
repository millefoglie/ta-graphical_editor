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
    
    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 577492804369940901L;

    /** The open file action. */
    private Action openFile;
    
    /** The save file action. */
    private Action saveFile;
    
    /** The open file menu item. */
    private JMenuItem jmiOpen;
    
    /** The save file menu item. */
    private JMenuItem jmiSave;
    
    /**
     * Instantiates a new drawing pane context menu.
     */
    public DrawingPaneContextMenu() {}
    
    /**
     * Initialize the context menu.
     */
    public void init() {
	openFile = new OpenFileAction();
	saveFile = new SaveFileAction();
	
	jmiOpen = new JMenuItem(openFile);
	jmiSave = new JMenuItem(saveFile);

	add(jmiOpen);
	add(jmiSave);
    }
}
