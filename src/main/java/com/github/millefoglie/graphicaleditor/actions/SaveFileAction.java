package com.github.millefoglie.graphicaleditor.actions;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.AbstractAction;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import com.github.millefoglie.graphicaleditor.Document;
import com.github.millefoglie.graphicaleditor.Editor;

/**
 * The Save File Action.
 */
public class SaveFileAction extends AbstractAction {

    private static final long serialVersionUID = -4590203484358650839L;
    private static final String FILE_SAVE_FAILED =
	    "Could not save this file";
    public static final String SAVE = "save";

    public SaveFileAction() {
	putValue(NAME, SAVE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
	JFileChooser jfc = new JFileChooser();

	if (jfc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
	    File f = jfc.getSelectedFile();

	    try (ObjectOutputStream out =
		    new ObjectOutputStream(new FileOutputStream(f))) {
		Document doc = Editor.getInstance().getDocument();
		
		out.writeObject(doc);
	    } catch (IOException e1) {
		JOptionPane.showMessageDialog(null, FILE_SAVE_FAILED);
		e1.printStackTrace();
	    }
	}
    }

}
