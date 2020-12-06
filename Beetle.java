import java.util.Random;

/**
 * PA5 - Simulation: Beetle Class.
 * 
 * @author Hannah Peluso
 * @version 11-10-20
 *
 */
public class Beetle extends Insect {

    private double turnProbability;

    /**
     * beetle class constructor.
     * 
     * @param red color red.
     * @param green color green
     * @param blue color blue
     * @param speed of beetle
     * @param turnProb turn probability of beetle
     */
    public Beetle(int red, int green, int blue, double speed, double turnProb) {
        super(red, green, blue, speed);
        turnProbability = turnProb;
        
    }

    /**
     * draws a beetle.
     */
    @Override
    public void draw() {
        StdDraw.setPenRadius();
        StdDraw.setPenColor(this.color);
        StdDraw.filledCircle(this.direction.xPosition, this.direction.yPosition,
                6.0);
    }

    /**
     * updates a beetle in simulation.
     */
    @Override
    public void update() {
        Random rand = new Random();
        if (rand.nextDouble() < this.turnProbability) {
            double x = rand.nextDouble() * (2 * Math.PI);
            this.direction = new Pose(this.direction.xPosition,
                    this.direction.yPosition, x);
        }
        this.direction = PoseUtils.move(this.direction, this.speed);
    }

}
