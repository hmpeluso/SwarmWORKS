/**
 * Encapsulation of an immutable two-dimensional point.
 * 
 * @author Nathan Sprague
 * @version V1.0 3/15
 */
public class Point {
    protected final double xPosition;
    protected final double yPosition;

    /**
     * Construct a point object.
     * 
     * @param xPosition - position on the X-axis
     * @param yPosition - position on the Y-axis
     */
    public Point(double xPosition, double yPosition) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
    }

    /**
     * @return the X coordinate
     */
    public double getX() {
        return xPosition;
    }

    /**
     * @return the Y coordinate
     */
    public double getY() {
        return yPosition;
    }

    /**
     * @return String representation of this point as "(x, y)"
     */
    public String toString() {
        return "(" + xPosition + ", " + yPosition + ")";
    }

}
