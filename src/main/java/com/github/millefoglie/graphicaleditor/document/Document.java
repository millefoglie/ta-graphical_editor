package com.github.millefoglie.graphicaleditor.document;

import java.io.Serializable;
import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.BlockingQueue;

import org.apache.commons.lang3.SerializationUtils;

import com.github.millefoglie.graphicaleditor.shapes.AbstractShape;
import com.github.millefoglie.graphicaleditor.transformations.Transformation;

public class Document implements Serializable, Cloneable {

    private static final long serialVersionUID = -3619382018337028666L;

    private DocumentContent content = new DocumentContent();
    
    private final Deque<DocumentContent> undoCache = new LinkedList<>();
    private final Deque<DocumentContent> redoCache = new LinkedList<>();
    
    public Document() {}

    public BlockingQueue<AbstractShape> getShapes() {
	return content.shapes;
    }

    public void addShape(AbstractShape shape) {
	content.shapes.offer(shape);
    }
    
    public void removeShape(AbstractShape shape) {
	content.shapes.remove(shape);
    }

    public void addTransformation(Transformation t) {
	content.transformationsQueue.offer(t);
    }

    public void removeTransformation(Transformation t) {
	content.transformationsQueue.remove(t);
    }

    public void clearTransformations() {
	content.transformationsQueue.clear();
    }
    
    public BlockingQueue<Transformation> getTransformationsQueue() {
        return content.transformationsQueue;
    }

    /**
     * Add a new save-point to the undo cache and clear available redo's.
     */
    public void commit() {
	DocumentContent cachedContent = SerializationUtils.clone(content);
	
	undoCache.offerLast(cachedContent);
	redoCache.clear();
    }
    
    public void clearHistory() {
	undoCache.clear();
	redoCache.clear();
    }
    
    public void undo() {
	DocumentContent cachedContent = undoCache.pollLast();
	
	if (cachedContent != null) {
	    redoCache.offerLast(content);

	    content = cachedContent;
	}
    }
    
    public void redo() {
	DocumentContent cachedContent = redoCache.pollLast();
	
	if (cachedContent != null) {
	    undoCache.offerLast(content);
	    
	    content = cachedContent;
	}
    }

}