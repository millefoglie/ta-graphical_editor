package com.github.millefoglie.graphicaleditor.animation;

import java.io.Serializable;

/**
 * The animation statuses of animated shapes.
 */
public class AnimationStatus implements Serializable {
    
    private static final long serialVersionUID = -475800876971222718L;
    
    private boolean rotating;

    public AnimationStatus() {}
    
    /**
     * Restore all statuses to their primary values (disable all animations on
     * the corresponding object)
     */
    public void clear() {
	rotating = false;
    }

    public boolean isRotating() {
        return rotating;
    }

    public void setRotating(boolean rotating) {
        this.rotating = rotating;
    }

}
