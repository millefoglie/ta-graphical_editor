package com.github.millefoglie.graphicaleditor.model;

import java.io.Serializable;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import com.github.millefoglie.graphicaleditor.animation.Animation;
import com.github.millefoglie.graphicaleditor.shapes.AbstractShape;

/**
 * The class representing edited documents.
 */
public class Document implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -3619382018337028666L;

    /** The shape elements. */
    private final BlockingQueue<AbstractShape> shapeElements =
	    new LinkedBlockingQueue<>();
    
    private final Animation animation = new Animation();
    
    /**
     * Instantiates a new document.
     */
    public Document() {
	animation.start();
    }

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

    public Animation getAnimation() {
        return animation;
    }
}