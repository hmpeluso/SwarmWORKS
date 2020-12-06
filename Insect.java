import java.awt.Color;
import java.util.Random;

/**
 * PA5 - Simulation: Insect Abstract Class.
 * 
 * @author Hannah Peluso
 * @version 11-10-20
 *
 */
public abstract class Insect implements Agent {

    protected Color color;
    protected double speed;
    protected Pose direction;

    /**
     * super constructor for bee and beetle.
     * 
     * @param red color red
     * @param green color green
     * @param blue color blue
     * @param speed of insect.
     */
    public Insect(int red, int green, int blue, double speed) {
        this.color = new Color(red, green, blue);
        this.speed = speed;
        Random rand = new Random();
        this.direction = new Pose(rand.nextInt(SwarmConstants.SCREEN_WIDTH),
                rand.nextInt(SwarmConstants.SCREEN_HEIGHT),
                rand.nextDouble() * (2 * Math.PI));

    }

    /**
     * method to draw each agent.
     */
    @Override
    public abstract void draw();

    /**
     * method to update position of each agent.
     */
    @Override
    public abstract void update();

}
