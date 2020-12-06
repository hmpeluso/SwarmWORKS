/**
 * A Pose is a Point with an associated heading.
 * 
 * @author Nathan Sprague
 * @version V1.0 3/15
 */
public class Pose extends Point {
    private final double heading;

    /**
     * Construct a Pose.
     * 
     * @param xPosition - position on the X-axis
     * @param yPosition - position on the Y-axis
     * @param heading - the heading (in radians)
     */
    public Pose(double xPosition, double yPosition, double heading) {
        super(xPosition, yPosition);
        this.heading = heading;
    }

    /**
     * @return the heading in radians
     */
    public double getHeading() {
        return heading;
    }

    /**
     * @return String representation of this pose as "(x, y, heading)"
     */
    public String toString() {
        return "(" + xPosition + ", " + yPosition + ", " + heading + ")";
    }

}
