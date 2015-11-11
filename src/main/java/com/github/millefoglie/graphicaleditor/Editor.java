package com.github.millefoglie.graphicaleditor;

import com.github.millefoglie.graphicaleditor.document.Document;
import com.github.millefoglie.graphicaleditor.shapes.ShapeNames;

public class Editor {
    
    private static final Editor EDITOR = new Editor();
    
    private Document document;
    private ShapeNames shapeBrush;
    
    private Editor() {}
	
    public static Editor getInstance() {
	return EDITOR;
    }
    
    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public ShapeNames getShapeBrush() {
        return shapeBrush;
    }

    public void setShapeBrush(ShapeNames shapeBrush) {
        this.shapeBrush = shapeBrush;
    }
    
}
