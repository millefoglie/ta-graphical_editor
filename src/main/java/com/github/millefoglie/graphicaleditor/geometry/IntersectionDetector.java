package com.github.millefoglie.graphicaleditor.geometry;

import java.awt.Point;
import java.awt.Polygon;
import java.util.Collection;
import java.util.Iterator;

import com.github.millefoglie.graphicaleditor.shapes.PolygonalShape;
import com.github.millefoglie.graphicaleditor.shapes.AbstractShape;
import com.github.millefoglie.graphicaleditor.shapes.Circle;

/**
 * The class for detecting intersections between various shapes.
 */
public class IntersectionDetector {

    /**
     * Instantiates a new intersection detector.
     */
    private IntersectionDetector() {}

    /**
     * Check if a shape intersects any of listed shapes.
     *
     * @param shape the shape to be checked for intersection
     * @param shapes the collection of shapes
     * @return true, if the shape intersects any other shape
     */
    public static synchronized boolean intersect(
	    AbstractShape shape, Collection<AbstractShape> shapes) {
	AbstractShape s;
	
	for (Iterator<AbstractShape> it = shapes.iterator();
		it.hasNext(); ) {
	    s = it.next();
	    
	    if (intersect(shape, s)) {
		return true;
	    }
	}
	
	return false;
    }

    /**
     * Check if two shapes intersect.
     *
     * @param s1 the first shape
     * @param s2 the second shape
     * @return true, if shapes intersect
     */
    public static boolean intersect(AbstractShape s1, AbstractShape s2) {
	if (s1.equals(s2)) {
	    return false;
	}

	if ((s1 instanceof Circle) && (s2 instanceof Circle)) {
	    return intersectCircle((Circle) s1, (Circle) s2);
	}

	return intersect(s1.getProxy(), s2.getProxy());
    }

    /**
     * Check if two polygons intersect.
     *
     * @param p1 the first polygon
     * @param p2 the second polygon
     * @return true, if polygons intersect
     */
    private static boolean intersect(PolygonalShape p1, PolygonalShape p2) {
	if ((p1 == null) || (p2 == null)) {
	    return false;
	}
	
	return separationLineTest(p1, p2) && separationLineTest(p2, p1);
    }

    
    /**
     * Intersection test based on the hyperplane separation axis theorem. We
     * use edges normals as projection axis. If a gap between polygons 
     * projections is found, then there is not intersection. Otherwise,
     * the operation should be performed on swapped pair of polygons.
     *
     * @param p1 the first polygon
     * @param p2 the second polygon
     * @return true, if no gap is found
     */
    private static boolean separationLineTest(
	    PolygonalShape p1, PolygonalShape p2) {
	
	// get shape without transformations
	Polygon poly1 = p1.getBaseShape();

	// polygons projections on respective axes
	Interval<Double> interval1;
	Interval<Double> interval2;

	// centre and rotation angle of the first polygon
	int cx = p1.getCx();
	int cy = p1.getCy();
	double theta = p1.getTheta();

	int lx1;
	int ly1;
	int lx2;
	int ly2;

	Point start = new Point();
	Point end = new Point();

	for (int i = 0; i < poly1.npoints; i++) {

	    // get adjacent vertices at base polygons edge ends
	    lx1 = poly1.xpoints[i];
	    ly1 = poly1.ypoints[i];
	    lx2 = poly1.xpoints[(i + 1) % poly1.npoints];
	    ly2 = poly1.ypoints[(i + 1) % poly1.npoints];

	    // get start/end points of normal vector of rotated polygon edge
	    start = GeomUtil.rotate(ly2, lx1, cx, cy, theta);
	    end = GeomUtil.rotate(ly1, lx2, cx, cy, theta);

	    // find projections of polygons on respective axis
	    interval1 = GeomUtil.project(start, end, p1);
	    interval2 = GeomUtil.project(start, end, p2);

	    if (!(Interval.overlap(interval1, interval2))) {
		return false;
	    }
	}

	return true;
    }

    /**
     * Check if two circles intersect.
     *
     * @param c1 the first circle
     * @param c2 the second circle
     * @return true, if circles intersect
     */
    private static boolean intersectCircle(Circle c1, Circle c2) {
	int cx1 = c1.getCx();
	int cy1 = c1.getCy();
	int cx2 = c2.getCx();
	int cy2 = c2.getCy();
	double r1 = c1.getRadius();
	double r2 = c2.getRadius();

	return GeomUtil.dist(cx1, cy1, cx2, cy2) < r1 + r2;
    }
    
}
