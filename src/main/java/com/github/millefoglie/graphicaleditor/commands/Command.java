package com.github.millefoglie.graphicaleditor.commands;

import java.io.Serializable;

public interface Command extends Serializable {

    public void exec();
}
