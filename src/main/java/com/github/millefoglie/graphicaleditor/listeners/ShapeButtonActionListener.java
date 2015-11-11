package com.github.millefoglie.graphicaleditor.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.github.millefoglie.graphicaleditor.Editor;
import com.github.millefoglie.graphicaleditor.shapes.ShapeNames;

/**
 * Listener for shape selection buttons.
 */
public class ShapeButtonActionListener implements ActionListener {

    /** The brush shape name. */
    private ShapeNames shapeName;
    
    public ShapeButtonActionListener(ShapeNames shapeName) {
	this.shapeName = shapeName;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
	Editor.getInstance().setShapeBrush(shapeName);
    }
}
