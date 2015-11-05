package com.github.millefoglie.graphicaleditor.commands;

import com.github.millefoglie.graphicaleditor.gui.ShapeComponent;
import com.github.millefoglie.graphicaleditor.shapes.ShapeNames;

public class CommandFactory {

    private CommandFactory() {}
    
    public static Command newCreateShapeCommand(ShapeNames shapeBrush,
	    int x, int y) {
	return new CreateShapeCommand(shapeBrush, x, y);
    }
    
    public static Command newDeleteShapeCommand(ShapeComponent shapeComponent) {
	return new DeleteShapeCommand(shapeComponent);
    }
 
    public static Command newStartShapeRotationCommand(
	    ShapeComponent shapeComponent) {
	return new StartShapeRotationCommand(shapeComponent);
    }
    
    public static Command newStopShapeRotationCommand(
	    ShapeComponent shapeComponent) {
	return new StopShapeRotationCommand(shapeComponent);
    }
    
}
