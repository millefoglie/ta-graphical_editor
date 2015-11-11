package com.github.millefoglie.graphicaleditor;

/**
 * A temporary class for storing settings. It should be moved to a properties
 * file instead.
 */
public class Settings {

    private static int fps = 60;
    private static int iterationsPerFrame = 5;
    
    private Settings() {}

    public static int getFps() {
        return fps;
    }

    public static int getIterationsPerFrame() {
        return iterationsPerFrame;
    }

}
