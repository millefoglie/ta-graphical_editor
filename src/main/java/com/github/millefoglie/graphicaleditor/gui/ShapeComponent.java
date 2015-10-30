package com.github.millefoglie.graphicaleditor.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Rectangle;

import javax.swing.JComponent;

import com.github.millefoglie.graphicaleditor.shapes.AbstractShape;

/**
 * The Shape Component class.
 */
@SuppressWarnings("serial")
public class ShapeComponent extends JComponent {
    
    /** The shape element. */
    private AbstractShape shapeElement;
    
    /**
     * Instantiates a new shape component.
     */
    public ShapeComponent() {
	setOpaque(false);
	setInheritsPopupMenu(false);
    }
    
    /**
     * Instantiates a new shape component.
     *
     * @param shapeElement the shape element
     */
    public ShapeComponent(AbstractShape shapeElement) {
	this();
	this.shapeElement = shapeElement;
	
	setBounds(shapeElement.getShape().getBounds());
        repaint();
    }
    
    public AbstractShape getShapeElement() {
        return shapeElement;
    }

    public void setShapeElement(AbstractShape shapeElement) {
	this.shapeElement = shapeElement;
	
	setOpaque(false);
	setBounds(shapeElement.getShape().getBounds());
        revalidate();
        repaint();
    }

    @Override
    public Dimension getPreferredSize() {
        //  Include Border insets and Shape bounds
        Insets insets = getInsets();
        Rectangle bounds = shapeElement.getShape().getBounds();

        //  Determine the preferred size
        int width = insets.left + insets.right + bounds.width;
        int height = insets.top + insets.bottom + bounds.height;

        return new Dimension(width, height);
    }

    @Override
    public Dimension getMinimumSize() {
        return getPreferredSize();
    }

    @Override
    public Dimension getMaximumSize() {
        return getPreferredSize();
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        //  Shape translation (ie. non-zero X/Y position in bounding rectangle)
        //  and Border insets.
        Rectangle bounds = shapeElement.getShape().getBounds();
        Insets insets = getInsets();
        
        // TODO: fix shape outline clipping
        bounds.grow(1, 1);

        //  Do all translations at once
        g2d.translate(insets.left - bounds.x, insets.top - bounds.y);
        this.setBounds(bounds);
        
        g2d.setColor(Color.BLACK);
        g2d.draw(shapeElement.getShape());

        g2d.dispose();
    }
    
    @Override
    public boolean contains(int x, int y)
    {
        Rectangle bounds = shapeElement.getShape().getBounds();
        Insets insets = getInsets();

        //  Check to see if the Shape contains the point. Take into account
        //  the Shape X/Y coordinates, Border insets and Shape translation.
        int translateX = x + bounds.x - insets.left;
        int translateY = y + bounds.y - insets.top;
        
        return shapeElement.getShape().contains(translateX, translateY);
    }
}
