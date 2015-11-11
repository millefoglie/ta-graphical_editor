package com.github.millefoglie.graphicaleditor.document;

import java.io.Serializable;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import com.github.millefoglie.graphicaleditor.shapes.AbstractShape;
import com.github.millefoglie.graphicaleditor.transformations.Transformation;

public class DocumentContent implements Serializable {
    
    private static final long serialVersionUID = 5493186993727860609L;

    final BlockingQueue<AbstractShape> shapes =
	    new LinkedBlockingQueue<>();
    
    final BlockingQueue<Transformation> transformationsQueue =
	    new LinkedBlockingQueue<>();

    public DocumentContent() {}

    public BlockingQueue<AbstractShape> getShapes() {
        return shapes;
    }

    public BlockingQueue<Transformation> getTransformationsQueue() {
        return transformationsQueue;
    }

}
