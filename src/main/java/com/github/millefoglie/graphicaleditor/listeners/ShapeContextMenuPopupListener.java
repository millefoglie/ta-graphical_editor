package com.github.millefoglie.graphicaleditor.listeners;

import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;

import com.github.millefoglie.graphicaleditor.gui.ShapeComponent;
import com.github.millefoglie.graphicaleditor.gui.ShapeContextMenu;

/**
 * The listener interface for receiving shapeContextMenuPopup events.
 * The class that is interested in processing a shapeContextMenuPopup
 * event implements this interface, and the object created
 * with that class is registered with a component using the
 * component's @code{addShapeContextMenuPopupListener} method. When
 * the shapeContextMenuPopup event occurs, that object's appropriate
 * method is invoked.
 *
 * @see ShapeContextMenuPopupEvent
 */
public class ShapeContextMenuPopupListener implements PopupMenuListener {

    @Override
    public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
	ShapeContextMenu menu = (ShapeContextMenu) e.getSource();
	ShapeComponent sc = (ShapeComponent) menu.getInvoker();
	
	// toggle rotate / stop actions depending on rotation status
	if (sc.getShape().getAnimationStatus().isRotating()) {
	    menu.useRotateStopAction();
	} else {
	    menu.useRotateStartAction();
	}
    }

    @Override
    public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {}

    @Override
    public void popupMenuCanceled(PopupMenuEvent e) {}

}
