package com.github.millefoglie.graphicaleditor.geometry;

import static java.lang.Math.cos;
import static java.lang.Math.pow;
import static java.lang.Math.sin;

import java.awt.Point;
import java.awt.Polygon;

import com.github.millefoglie.graphicaleditor.shapes.PolygonalShape;

/**
 * The class for geometric operations with points on a plane.
 */
public class GeomUtil {
    
    private GeomUtil() {}
    
    /**
     * Get distance between two points
     *
     * @param x1 the x1
     * @param y1 the y1
     * @param x2 the x2
     * @param y2 the y2
     * @return the double
     */
    public static double dist(double x1, double y1, double x2, double y2) {
	return Math.sqrt(pow(x1 - x2, 2) + pow(y1 - y2, 2));
    }
    
    /**
     * Get distance between two points
     *
     * @param x1 the x1
     * @param y1 the y1
     * @param x2 the x2
     * @param y2 the y2
     * @return the double
     */
    public static double dist(int x1, int y1, int x2, int y2) {
	return dist((double) x1, (double) y1, (double) x2, (double) y2);
    }
    
    /**
     * Rotate a point relative to a pivot.
     *
     * @param x the x value of rotated point
     * @param y the y value of rotated point
     * @param cx the x value of pivot point
     * @param cy the y value of pivot point
     * @param phi the angle of rotation
     * @return the rotation result point
     */
    public static Point rotate(int x, int y,
	    int cx, int cy, double phi) {
	double cosPhi = cos(phi);
	double sinPhi = sin(phi);
	
	double rx = cx + (cosPhi * (x - cx) - sinPhi * (y - cy));
	double ry = cy + (sinPhi * (x - cx) + cosPhi * (y - cy));
	
	Point result = new Point();
	result.setLocation(rx, ry);
	
	return result;
    }
    
    /**
     * Project a point to an axis.
     *
     * @param x1 the x value of axis vector start
     * @param y1 the y value of axis vector start
     * @param x2 the x value of axis vector end
     * @param y2 the y value of axis vector end
     * @param x the x value of projected point
     * @param y the y value of projected point
     * @return the double value of respective point on the axis (so that the
     * axis is considered as a real numbers axis).
     */
    public static double project(int x1, int y1,
	    int x2, int y2, int x, int y) {
	return (x - x1) * (x2 - x1) + (y - y1) * (y2 - y1);
    }
    
    /**
     * Project a polygon to a line.
     *
     * @param x1 the x value of axis vector start
     * @param y1 the y value of axis vector start
     * @param x2 the x value of axis vector end
     * @param y2 the y value of axis vector end
     * @param abPoly the polygon
     * @return the pair of min and max values of polygon's points projections.
     * Can be considered as an interval on a real axis.
     */
    public static Interval<Double> project(int x1, int y1,
	    int x2, int y2, PolygonalShape abPoly) {
	
	Polygon poly = abPoly.getBaseShape();
	
	if (poly.npoints < 1) {
	    throw new IllegalArgumentException("Polygon is empty");
	}
	
	int cx = abPoly.getCx();
	int cy = abPoly.getCy();
	double theta = abPoly.getTheta();
	
	Interval<Double> interval = new Interval<>();

	Point p = rotate(poly.xpoints[0], poly.ypoints[0], cx, cy, theta);
	
	double proj = project(x1, y1, x2, y2, (int) p.getX(), (int) p.getY());
	double left = proj;
	double right = proj;
	
	for (int i = 1; i < poly.npoints; i++) {
	    p = rotate(poly.xpoints[i], poly.ypoints[i], cx, cy, theta);
	    proj = project(x1, y1, x2, y2, (int) p.getX(), (int) p.getY());
	    
	    if (proj < left) {
		left = proj;
	    } else if (proj > right) {
		right = proj;
	    }
	}
	
	interval.left = left;
	interval.right = right;
	
	return interval;
    }
    
    /**
     * Project a polygon to a line.
     *
     * @param start the start of the axis vector
     * @param end the end of the axis vector
     * @param abPoly the polygon
     * @return the pair of min and max values of polygon's points projections.
     * Can be considered as an interval on a real axis.
     */
    public static Interval<Double> project(Point start, Point end,
	    PolygonalShape abPoly) {
	return project((int) start.getX(), (int) start.getY(),
		(int) end.getX(), (int) end.getY(), abPoly);
    }
}
