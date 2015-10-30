package com.github.millefoglie.graphicaleditor.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.github.millefoglie.graphicaleditor.Editor;
import com.github.millefoglie.graphicaleditor.shapes.ShapeNames;

/**
 * The listener interface for receiving shapeButtonAction events.
 * The class that is interested in processing a shapeButtonAction
 * event implements this interface, and the object created
 * with that class is registered with a component using the
 * component's <code>addShapeButtonActionListener<code> method. When
 * the shapeButtonAction event occurs, that object's appropriate
 * method is invoked.
 *
 * @see ShapeButtonActionEvent
 */
public class ShapeButtonActionListener implements ActionListener {

    /** The brush shape name. */
    private ShapeNames shapeName;
    
    
    /**
     * Instantiates a new shape button action listener.
     *
     * @param shapeName the shape name
     */
    public ShapeButtonActionListener(ShapeNames shapeName) {
	super();
	this.shapeName = shapeName;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
	Editor editor = Editor.getInstance();
	
	editor.setShapeBrush(shapeName);
    }
}
