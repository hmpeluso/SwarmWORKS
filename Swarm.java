/**
 * PA5 - Simulation: Swarm Class- very similar to bee class and uses bee
 * methods.
 * 
 * @author Hannah Peluso
 * @version 11-10-20
 *
 */
public class Swarm implements Agent {

    private double maxTurnRate;
    private Bee queen;
    private Bee[] drones;

    /**
     * constructor for a Swarm.
     * 
     * @param numDrones number of bees in swarm
     * @param qred queen color red
     * @param qgreen queen color green
     * @param qblue queen color blue
     * @param qspeed queen speed
     * @param qangleStd queen angle
     * @param red drones color red
     * @param green drones color green
     * @param blue drones color blue
     * @param speed drones speed
     * @param angleStd drones angle
     * @param turnRate drones turn rate
     */
    public Swarm(int numDrones, int qred, int qgreen, int qblue, double qspeed,
            double qangleStd, int red, int green, int blue, double speed,
            double angleStd, double turnRate) {
        this.queen = new Bee(qred, qgreen, qblue, qspeed, qangleStd);
        drones = new Bee[numDrones];
        for (int i = 0; i < drones.length; i++) {
            drones[i] = new Bee(red, green, blue, speed, angleStd);
        }
        this.maxTurnRate = turnRate;

    }

    /**
     * draws a swarm and it's queen.
     */
    @Override
    public void draw() {
        this.queen.draw();
        for (Bee item : this.drones) {
            item.draw();
        }
    }

    /**
     * updates a swarm in simulation- updates the queen and swarm follows
     * accordingly, but not exactly.
     */
    @Override
    public void update() {
        this.queen.update();
        
        // steers drones toward queen and then adjusts direction and moves after
        // queen.
        for (Bee item : this.drones) {
            item.direction = PoseUtils.steer(item.direction,
                    this.queen.direction, this.maxTurnRate);
            item.update();
        }
    }

}
