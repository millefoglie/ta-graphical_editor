package com.github.millefoglie.graphicaleditor.geometry;


/**
 * An auxiliary class to represent intervals or min/max value pairs. 
 */
public class Interval<T extends Comparable<T>> {
    
    public T left;
    public T right;
    
    public Interval() {}

    
    /**
     * Check if two intervals overlap.
     *
     * @param <T> the generic type
     * @param i1 the first interval
     * @param i2 the second interval
     * @return true, if intervals overlap
     */
    public static <T extends Comparable<T>> boolean overlap(
            Interval<T> i1, Interval<T> i2) {
        return ((i1.right.compareTo(i2.left) > 0) 
        	&& (i1.left.compareTo(i2.right) < 0));
    }
}
