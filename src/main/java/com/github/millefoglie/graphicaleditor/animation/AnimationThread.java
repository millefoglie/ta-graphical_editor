package com.github.millefoglie.graphicaleditor.animation;

import java.util.Iterator;
import java.util.concurrent.BlockingQueue;

import com.github.millefoglie.graphicaleditor.Editor;
import com.github.millefoglie.graphicaleditor.Settings;
import com.github.millefoglie.graphicaleditor.document.Document;
import com.github.millefoglie.graphicaleditor.gui.DrawingPane;
import com.github.millefoglie.graphicaleditor.gui.Gui;
import com.github.millefoglie.graphicaleditor.transformations.Transformation;

public class AnimationThread extends Thread {
    
    @Override
    public void run() {
	DrawingPane drawPane = Gui.getInstance().getDrawingPane();
	Document doc;
	BlockingQueue<Transformation> transformationsQueue;

	Iterator<Transformation> it;
	Transformation t;

	long startTS;	// cycle start timestamp
	long sleepTime;	// time to sleep for correct FPS
	int iteration;	// current iteration
	int fps = Settings.getFps();
	int iterationsPerFrame = Settings.getIterationsPerFrame();

	while (true) {
	    doc = Editor.getInstance().getDocument();
	    transformationsQueue = doc.getTransformationsQueue();
	    
	    startTS = System.currentTimeMillis();
	    
	    // repeat a given number of times for each frame
	    for (iteration = 0; iteration < iterationsPerFrame; iteration++) {
		for (it = transformationsQueue.iterator(); it.hasNext(); ) {
		    t = it.next();
		    t.transform();
		    
		    if (t.isExpired()) {
			it.remove();
		    }
		}
	    }

	    // limit frame-rate
	    sleepTime = 1000 / fps - System.currentTimeMillis() + startTS;
	    sleepTime = Math.max(sleepTime, 0);

	    try {
		sleep(sleepTime);
	    } catch (InterruptedException e) {
		e.printStackTrace();
	    }

	    drawPane.repaint();
	}
    }
    
}
