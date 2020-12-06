import java.awt.Color;

/**
 * PA5 - Simulation: Flower Class.
 * 
 * @author Hannah Peluso
 * @version 11-10-20
 *
 */
public class Flower implements Agent {

    protected Color color;
    protected double[] xCoordinates;
    protected double[] yCoordinates;

    /**
     * flower class constructor- basically a polygon.
     * 
     * @param red color red
     * @param green color green
     * @param blue color blue
     * @param x array of x points of polygon
     * @param y array of y points of polygon
     * @param points worth in simulation
     */
    public Flower(int red, int green, int blue, int points, double[] x,
            double[] y) {
        this.color = new Color(red, green, blue);
        this.xCoordinates = new double[points];
        this.yCoordinates = new double[points];
        
        // each point has to be initialized in the new array. 
        for (int i = 0; i < x.length; i++) {
            this.xCoordinates[i] = x[i];
        }
        for (int i = 0; i < y.length; i++) {
            this.yCoordinates[i] = y[i];
        }
    }

    /**
     * draws a flower.
     */
    @Override
    public void draw() {
        StdDraw.setPenRadius();
        StdDraw.setPenColor(this.color);
        StdDraw.filledPolygon(this.xCoordinates, this.yCoordinates);
    }

    /**
     * this method does nothing because flowers don't move.
     */
    @Override
    public void update() {
    }

}
