package com.github.millefoglie.graphicaleditor;

/**
 * @author "millefoglie"
 *
 * A class for storing App settings.
 */
public class Settings {

    private static int fps = 60;
    private static int iterationsPerFrame = 5;
    
    private Settings() {}

    public static int getFps() {
        return fps;
    }

    public static void setFps(int fps) {
        Settings.fps = fps;
    }

    public static int getIterationsPerFrame() {
        return iterationsPerFrame;
    }

    public static void setIterationsPerFrame(int iterationsPerFrame) {
        Settings.iterationsPerFrame = iterationsPerFrame;
    }
}
