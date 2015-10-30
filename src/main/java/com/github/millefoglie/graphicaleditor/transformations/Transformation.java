package com.github.millefoglie.graphicaleditor.transformations;

import java.io.Serializable;

public interface Transformation extends Serializable{
    
    public void transform();
    
    public boolean isExpired();
}
