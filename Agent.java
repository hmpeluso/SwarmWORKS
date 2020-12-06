/**
 * PA5 - Simulation: Agent Interface Class.
 * 
 * @author Hannah Peluso
 * @version 11-10-20
 *
 */
public interface Agent {

    /**
     * method to be overriden to draw each agent.
     */
    void draw();

    /**
     * method to be overriden to update position of each agent.
     */
    void update();

}
