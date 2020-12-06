/**
 * Utility methods for working with Pose objects within Swarm Simulation
 * project.
 * 
 * (Note that the behavior of some methods in this class depend upon constants
 * defined in SwarmConstants.java. This makes this code less portable, but more
 * convenient to work with in the context of this project.)
 * 
 * @author Nathan Sprague
 * @version V1.0, 3/15
 *
 */
public class PoseUtils {
    /**
     * Draw an isosceles triangle at the location and heading of the provided
     * Pose. The triangle will be centered at the x,y position of the Pose
     * object.
     *
     * @param pose - location and heading for the triangle
     * @param width - the width of the base of the triangle
     * @param height - the height of the triangle
     */
    public static void drawPoseAsTriangle(Pose pose, double width,
            double height) {

        Point llPoint = transformPoseToScreen(pose,
                new Point(-.5 * height, -.5 * width));
        Point lrPoint = transformPoseToScreen(pose,
                new Point(-.5 * height, .5 * width));
        Point endPoint = transformPoseToScreen(pose, new Point(.5 * height, 0));

        double[] xs = new double[3];
        double[] ys = new double[3];

        xs[0] = llPoint.getX();
        xs[1] = endPoint.getX();
        xs[2] = lrPoint.getX();
        ys[0] = llPoint.getY();
        ys[1] = endPoint.getY();
        ys[2] = lrPoint.getY();

        StdDraw.filledPolygon(xs, ys);

    }

    /**
     * Move the provided pose forward at the indicated speed. This method will
     * "wrap" the position of the pose object. I.e. Objects that pass off the
     * edge of the screen will reappear on the opposite edge.
     * 
     * @param pose - the pose to update
     * @param speed - the speed to use in moving the pose (in pixels/second)
     * @return a new pose with the same heading and an updated position
     */
    public static Pose move(Pose pose, double speed) {
        Point p = transformPoseToScreen(pose, new Point(speed, 0));
        double newX = p.getX();
        double newY = p.getY();

        if (newX > SwarmConstants.SCREEN_WIDTH) {
            newX = 0.0;
        } else if (newX < 0) {
            newX = SwarmConstants.SCREEN_WIDTH;
        }
        if (newY > SwarmConstants.SCREEN_HEIGHT) {
            newY = 0.0;
        } else if (newY < 0) {
            newY = SwarmConstants.SCREEN_HEIGHT;
        }
        return new Pose(newX, newY, pose.getHeading());

    }

    /**
     * Steer the provided pose toward the indicated point. This method correctly
     * handles the "wrapped" simulation environment.
     * 
     * @param pose - initial pose
     * @param target - target point to steer toward
     * @param maxTurnAngle - the maximum amount to steer (in radians)
     * @return a pose object that has been steered by the appropriate amount
     */
    public static Pose steer(Pose pose, Point target, double maxTurnAngle) {
        Point observedPoint = observedPosition(pose, target);

        Point inPose = transformScreenToPose(pose, observedPoint);

        double angleDiff = Math.atan2(inPose.getY(), inPose.getX());

        if (angleDiff > maxTurnAngle) {
            angleDiff = maxTurnAngle;
        }
        if (angleDiff < -maxTurnAngle) {
            angleDiff = -maxTurnAngle;
        }

        return new Pose(pose.getX(), pose.getY(),
                pose.getHeading() + angleDiff);
    }

    // -------------------------------------------------
    // HELPER METHOD BELOW THIS POINT
    // -------------------------------------------------

    /**
     * Perform a transform from screen coordinates to the coordinate frame
     * defined by a Pose object.
     * 
     * @param pose - the coordinate frame to transform into
     * @param point - the screen position to transform
     * @return - the transformed point (in pose coordinates)
     */
    private static Point transformScreenToPose(Pose pose, Point point) {
        double newX;
        double newY;

        newX = point.getX() * Math.cos(-pose.getHeading())
                - point.getY() * Math.sin(-pose.getHeading())
                - pose.getX() * Math.cos(-pose.getHeading())
                + pose.getY() * Math.sin(-pose.getHeading());

        newY = point.getX() * Math.sin(-pose.getHeading())
                + point.getY() * Math.cos(-pose.getHeading())
                - pose.getX() * Math.sin(-pose.getHeading())
                - pose.getY() * Math.cos(-pose.getHeading());

        return new Point(newX, newY);
    }

    /**
     * Perform a transform from the coordinate frame defined by a Pose object to
     * screen coordinates.
     * 
     * @param pose - the coordinate frame to transform from
     * @param point - the point to transform (in pose coordinates)
     * @return - the transformed point (in screen coordinates)
     */
    private static Point transformPoseToScreen(Pose pose, Point point) {
        double newX;
        double newY;
        newX = point.getX() * Math.cos(pose.getHeading())
                - point.getY() * Math.sin(pose.getHeading()) + pose.getX();
        newY = point.getX() * Math.sin(pose.getHeading())
                + point.getY() * Math.cos(pose.getHeading()) + pose.getY();
        return new Point(newX, newY);
    }

    /**
     * Calculate the observed position of one point relative to another, taking
     * into account the "wrapped" nature of the simulation. For example, if
     * pointA is near the top of the display screen and pointB is near the
     * bottom, then pointB should be considered -above- pointA, because the
     * shortest route from A to B involves moving upward.
     * 
     * @param thisPoint - the source point
     * @param otherPoint - the destination point
     * @return the observed position of otherPoint from the perspective of
     *     thisPoint
     */
    private static Point observedPosition(Point thisPoint, Point otherPoint) {
        double newX = otherPoint.getX();
        double newY = otherPoint.getY();
        if (Math.abs(thisPoint.getX() - otherPoint.getX()) > (.5
                * SwarmConstants.SCREEN_WIDTH)) {
            if (otherPoint.getX() > (.5 * SwarmConstants.SCREEN_WIDTH)) {
                newX = otherPoint.getX() - SwarmConstants.SCREEN_WIDTH;
            } else {
                newX = otherPoint.getX() + SwarmConstants.SCREEN_WIDTH;
            }
        }

        if (Math.abs(thisPoint.getY() - otherPoint.getY()) > (.5
                * SwarmConstants.SCREEN_HEIGHT)) {
            if (otherPoint.getY() > (.5 * SwarmConstants.SCREEN_HEIGHT)) {
                newY = otherPoint.getY() - SwarmConstants.SCREEN_HEIGHT;
            } else {
                newY = otherPoint.getY() + SwarmConstants.SCREEN_HEIGHT;
            }
        }

        return new Point(newX, newY);
    }

}
