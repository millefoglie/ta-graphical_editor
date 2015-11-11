package com.github.millefoglie.graphicaleditor.listeners;

import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;

import com.github.millefoglie.graphicaleditor.gui.ShapeComponent;
import com.github.millefoglie.graphicaleditor.gui.ShapeContextMenu;

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
