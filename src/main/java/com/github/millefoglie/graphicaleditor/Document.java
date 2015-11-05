package com.github.millefoglie.graphicaleditor;

import java.io.Serializable;
import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import com.github.millefoglie.graphicaleditor.commands.Command;
import com.github.millefoglie.graphicaleditor.shapes.AbstractShape;
import com.github.millefoglie.graphicaleditor.transformations.Transformation;

/**
 * The class representing edited documents.
 */
public class Document implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -3619382018337028666L;

    /** The shape elements. */
    private final BlockingQueue<AbstractShape> shapeElements =
	    new LinkedBlockingQueue<>();
    
    /** The queue of transformations to be applied to animated objects. */
    private BlockingQueue<Transformation> transformationsQueue =
	    new LinkedBlockingQueue<>();
    
    private final Deque<Command> undoList = new LinkedList<>();
    private final Deque<Command> redoList = new LinkedList<>();
    
    /**
     * Instantiates a new document.
     */
    public Document() {}

    /**
     * Gets the shape elements.
     *
     * @return the shape elements
     */
    public BlockingQueue<AbstractShape> getShapeElements() {
	return shapeElements;
    }

    /**
     * Adds the shape element.
     *
     * @param shapeElement the shape element
     */
    public void addShapeElement(AbstractShape shapeElement) {
	shapeElements.offer(shapeElement);
    }
    
    /**
     * Removes the shape element.
     *
     * @param shapeElement the shape element
     */
    public void removeShapeElement(AbstractShape shapeElement) {
	shapeElements.remove(shapeElement);
    }

    /**
     * Add a transformation to the queue.
     * @param t the transformation
     */
    public void addTransformation(Transformation t) {
	transformationsQueue.offer(t);
    }

    /**
     * Remove a transformation from the queue.
     * @param t the transformation
     */
    public void removeTransformation(Transformation t) {
	transformationsQueue.remove(t);
    }

    /**
     * Clear the transformations queue.
     */
    public void clearTransformations() {
	transformationsQueue.clear();
    }
    
    public BlockingQueue<Transformation> getTransformationsQueue() {
        return transformationsQueue;
    }

    public void addHistory(Command command) {
	undoList.addLast(command);
	redoList.clear();
    }
    
    public void undo() {
	Command c = undoList.removeLast();

	redoList.addLast(c);
	c.undo();
    }
    
    public void redo() {
	Command c = redoList.removeLast();

	undoList.addLast(c);
	c.exec();
    }
    
    public void clearHistory() {
	undoList.clear();
	redoList.clear();
    }
}