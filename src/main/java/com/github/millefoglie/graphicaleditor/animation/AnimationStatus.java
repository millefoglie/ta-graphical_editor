package com.github.millefoglie.graphicaleditor.animation;

import java.io.Serializable;

public class AnimationStatus implements Serializable {
    
    private static final long serialVersionUID = -475800876971222718L;
    
    private boolean rotating;

    public AnimationStatus() {}
    
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
