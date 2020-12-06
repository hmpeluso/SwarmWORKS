import java.io.FileNotFoundException;

/**
 * Driver for the Swarm application.
 * 
 * @author Nathan Sprague
 * @version V1.0, 3/15
 */
public class SwarmDriver {
    /**
     * Create a Simulation object from a configuration file and execute the main
     * simulation loop.
     * 
     * args[0] Should contain the location of a properly formatted configuration
     * file.
     * 
     * All other command line arguments will be ignored.
     * 
     * @param args - command line arguments
     */
    public static void main(String[] args) {
        
        try {
            Simulation sim = new Simulation(args[0]);

            StdDraw.setCanvasSize(SwarmConstants.SCREEN_WIDTH,
                    SwarmConstants.SCREEN_HEIGHT);
            StdDraw.setXscale(0, SwarmConstants.SCREEN_WIDTH);
            StdDraw.setYscale(0, SwarmConstants.SCREEN_HEIGHT);
            StdDraw.enableDoubleBuffering();

            while (true) {
                StdDraw.clear(SwarmConstants.SCREEN_COLOR);
                sim.update();
                sim.draw();
                StdDraw.show();
                StdDraw.pause(SwarmConstants.DRAW_DELAY);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Unable to open configuration file: " + args[0]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Usage: java SwarmDriver CONFIG_FILE");
        }
    }

}
