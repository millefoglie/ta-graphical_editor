package com.github.millefoglie.graphicaleditor.animation;

import java.io.Serializable;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import com.github.millefoglie.graphicaleditor.gui.DrawingPane;
import com.github.millefoglie.graphicaleditor.gui.Gui;
import com.github.millefoglie.graphicaleditor.transformations.Transformation;
import com.github.millefoglie.graphicaleditor.util.Settings;

public class Animation implements Serializable {

    private static final long serialVersionUID = -3735419385535297361L;

    private BlockingQueue<Transformation> transformationsQueue =
	    new LinkedBlockingQueue<>();
    private transient AnimationThread animationThread;

    public Animation() {}

    public void addTransformation(Transformation t) {
	transformationsQueue.offer(t);
    }

    public void removeTransformation(Transformation t) {
	transformationsQueue.remove(t);
    }

    public void clear() {
	transformationsQueue.clear();
    }

    public void start() {
	if ((animationThread == null) || (animationThread.isInterrupted())) {
	    animationThread = new AnimationThread();
	    
	    animationThread.start();
	}
    }

    
    private class AnimationThread extends Thread { 
	
	@Override
	public void run() {
	    DrawingPane drawPane = Gui.getInstance().getDrawingPane();
	    
	    Transformation t;
	    Transformation first;
	    
	    long startTS;
	    long sleepTime;
	    
	    int iteration;
	    int fps = Settings.getFps();
	    int iterationsPerFrame = Settings.getIterationsPerFrame();

	    while (true) {
		startTS = System.currentTimeMillis();
		
		

		for (iteration = 0;
			iteration < iterationsPerFrame; iteration++) {
		    first = transformationsQueue.poll();
		    t = first;
		    
		    // queue traversing loop start
		    do {

			// ignore static shapes, which are not removed from the queue
			if ((t == null)) {
			    continue;
			}

			t.transform();
			transformationsQueue.offer(t);

			t = transformationsQueue.poll();

			// stop the loop when we reach the starting element
		    } while (t != first);
		    // return the last polled element to the queue
		    if (t != null) {
			transformationsQueue.offer(t);
		    } 
		}
		
		// limit frame-rate
		sleepTime = 1000 / fps - System.currentTimeMillis() + startTS;
		sleepTime = Math.max(sleepTime, 0);
		
		try {
		    sleep(sleepTime);
		    drawPane.repaint();
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}
	    }
	}
    }

}
