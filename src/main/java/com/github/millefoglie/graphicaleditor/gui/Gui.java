package com.github.millefoglie.graphicaleditor.gui;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.github.millefoglie.graphicaleditor.listeners.ShapeButtonActionListener;
import com.github.millefoglie.graphicaleditor.shapes.ShapeNames;

public class Gui {
    
    private static final Gui GUI = new Gui();
    
    private JFrame jfrm;
    private DrawingPane drawPane;

    private Gui() {}
    
    public static Gui getInstance() {
	return GUI;
    }
    
    public DrawingPane getDrawingPane() {
        return drawPane;
    }

    public void setDrawingPane(DrawingPane drawpane) {
        this.drawPane = drawpane;
    }
    
    /**
     * Set up and start GUI.
     */
    public void go() {
	jfrm = new JFrame("Graphical Editor");
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfrm.setResizable(false);
        jfrm.setLayout(new BoxLayout(jfrm.getContentPane(), BoxLayout.Y_AXIS));

        drawPane = new DrawingPane();
        drawPane.init();
        
        setUpShapeButtons();
        
        jfrm.add(drawPane);
        jfrm.pack();

        jfrm.setVisible(true);
    }
    
    private void setUpShapeButtons() {
	JPanel jpanShapeButtons = new JPanel();
	jpanShapeButtons.setLayout(new FlowLayout());
	
	addNewButton(jpanShapeButtons, "Triangle",
		new ShapeButtonActionListener(ShapeNames.TRIANGLE));
	addNewButton(jpanShapeButtons, "Square",
		new ShapeButtonActionListener(ShapeNames.SQUARE));
	addNewButton(jpanShapeButtons, "Trapezium",
		new ShapeButtonActionListener(ShapeNames.TRAPEZIUM));
	addNewButton(jpanShapeButtons, "Circle",
		new ShapeButtonActionListener(ShapeNames.CIRCLE));
	addNewButton(jpanShapeButtons, "Ellipse",
		new ShapeButtonActionListener(ShapeNames.ELLIPSE));
	
	jfrm.add(jpanShapeButtons);
    }
    
    private void addNewButton(JPanel jpanel,
	    String caption,
	    ActionListener listener) {
	JButton jbtn = new JButton(caption);
	jbtn.addActionListener(listener);
	
	jpanel.add(jbtn);
    }
}
