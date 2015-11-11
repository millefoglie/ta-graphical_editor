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
 * The Shape Component class, represents a Swing component for a shape object.
 * It enables using shapes as components with listeners, context menus
 * and so on. 
 * 
 * This class was found somewhere on the Internet.
 */
public class ShapeComponent extends JComponent {
    
    private static final long serialVersionUID = -1912025043404696580L;

    private AbstractShape shape;
    
    public ShapeComponent() {
	setOpaque(false);
	setInheritsPopupMenu(false);
    }
    
    public ShapeComponent(AbstractShape shape) {
	this();
	this.shape = shape;
	
	setBounds(shape.getShape().getBounds());
        repaint();
    }
    
    public AbstractShape getShape() {
        return shape;
    }

    public void setShape(AbstractShape shape) {
	this.shape = shape;
	
	setOpaque(false);
	setBounds(shape.getShape().getBounds());
        revalidate();
        repaint();
    }

    @Override
    public Dimension getPreferredSize() {
	
        //  Include Border insets and Shape bounds
        Insets insets = getInsets();
        Rectangle bounds = shape.getShape().getBounds();

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
        Rectangle bounds = shape.getShape().getBounds();
        Insets insets = getInsets();
        
        // fix shape outline clipping
        bounds.grow(1, 1);

        //  Do all translations at once
        g2d.translate(insets.left - bounds.x, insets.top - bounds.y);
        this.setBounds(bounds);
        
        g2d.setColor(Color.BLACK);
        g2d.draw(shape.getShape());

        g2d.dispose();
    }
    
    @Override
    public boolean contains(int x, int y)
    {
        Rectangle bounds = shape.getShape().getBounds();
        Insets insets = getInsets();

        //  Check to see if the Shape contains the point. Take into account
        //  the Shape X/Y coordinates, Border insets and Shape translation.
        int translateX = x + bounds.x - insets.left;
        int translateY = y + bounds.y - insets.top;
        
        return shape.getShape().contains(translateX, translateY);
    }
    
}
