import java.util.Random;

/**
 * PA5 - Simulation: Bee Class.
 * 
 * @author Hannah Peluso
 * @version 11-10-20
 *
 */
public class Bee extends Insect {

    private double angleStd;

    /**
     * bee class constructor.
     * 
     * @param red color red
     * @param green color green
     * @param blue color blue
     * @param speed of bee
     * @param angleStd direction of bee.
     */
    public Bee(int red, int green, int blue, double speed, double angleStd) {
        super(red, green, blue, speed);
        this.angleStd = angleStd;

    }

    /**
     * draws a bee.
     */
    @Override
    public void draw() {
        StdDraw.setPenRadius();
        StdDraw.setPenColor(this.color);
        PoseUtils.drawPoseAsTriangle(this.direction, 5.0, 10.0);
    }

    /**
     * updates a bee position in simulation.
     */
    @Override
    public void update() {
        Random rand = new Random();
        double x = rand.nextGaussian() * this.angleStd;
        this.direction = new Pose(this.direction.xPosition,
                this.direction.yPosition, this.direction.getHeading() + x);
        this.direction = PoseUtils.move(this.direction, this.speed);

    }

}
