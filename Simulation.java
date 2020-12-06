import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * PA5 - Simulation: Main method Class.
 * 
 * @author Hannah Peluso
 * @version 11-10-20
 *
 */
public class Simulation {

    private Agent[] elements;

    /**
     * constructor for simulation. this method takes a given file and
     * initializes the array with all the elements.
     * 
     * @param path to be read.
     * @throws FileNotFoundException exception error.
     */
    public Simulation(String path) throws FileNotFoundException {
        // called from swarmDriver to create Sim objects.
        File file = new File(path);
        if (!file.exists()) {
            throw new FileNotFoundException();
        }
        this.elements = readMe(file);

    }

    /**
     * this reads the file and finds the elements in it, then creates the
     * objects. this method calls other methods to create the objects, not the
     * constructors for the objects. a new class and new method would need to be
     * created to make new objects for the simulations.
     * 
     * @param file to be read given from simulation class.
     * @return elements array of agents in the simulation.
     * 
     * @throws FileNotFoundException exception error.
     * 
     */
    public Agent[] readMe(File file) throws FileNotFoundException {
        // create a new file to be read.
        Scanner str = new Scanner(file);
        String newFile = "";
        while (str.hasNextLine()) {
            newFile = newFile + str.nextLine() + "\n";
        }

        // split the file by elements and their parameters.
        String[] fileSplit = newFile.split("\n\n");

        int size = Integer.parseInt(fileSplit[0]);
        Agent[] agents = new Agent[size];

        // split the individual elements by parameters and create objects out of
        // the file.
        int h = 1;
        for (int i = 0; i < agents.length; i++) {
            String current = fileSplit[h];

            if (current.startsWith("bee\n")) {
                String[] b = fileSplit[h].split("\\s+");
                agents[i] = readBee(b);

            } else if (current.startsWith("swarm")) {
                String[] s = fileSplit[h].split("\\s+");
                agents[i] = readSwarm(s);

            } else if (current.startsWith("beetle")) {
                String[] bt = fileSplit[h].split("\\s+");
                agents[i] = readBeetle(bt);

            } else if (current.startsWith("flower")) {
                String[] f = fileSplit[h].split("\\s+");
                agents[i] = readFlower(f);

            }
            h++;
        }
        // return array of total elements in the file.
        return agents;
    }

    /**
     * this method is updating every object in elements when called by main
     * method.
     */
    public void update() {
        for (Agent item : elements) {
            item.update();
        }
    }

    /**
     * this method is drawing everything in elements, either in the beginning or
     * after its been updated.
     */
    public void draw() {
        for (Agent item : elements) {
            item.draw();
        }
    }

    /**
     * read bee section of file and return bee object.
     * 
     * @param text to be read.
     * @return bee object.
     */
    private Bee readBee(String[] text) {
        int r = Integer.parseInt(text[1]);
        int g = Integer.parseInt(text[2]);
        int bl = Integer.parseInt(text[3]);
        double s = Double.parseDouble(text[4]);
        double a = Double.parseDouble(text[5]);

        return new Bee(r, g, bl, s, a);
    }

    /**
     * read beetle section of file and return bee object.
     * 
     * @param text to be read.
     * @return beetle object.
     */
    private Beetle readBeetle(String[] text) {
        int r = Integer.parseInt(text[1]);
        int g = Integer.parseInt(text[2]);
        int bl = Integer.parseInt(text[3]);
        double s = Double.parseDouble(text[4]);
        double t = Double.parseDouble(text[5]);

        return new Beetle(r, g, bl, s, t);
    }

    /**
     * read swarm section of file and return bee object.
     * 
     * @param text to be read.
     * @return swarm object.
     */
    private Swarm readSwarm(String[] text) {
        int n = Integer.parseInt(text[1]);
        int qr = Integer.parseInt(text[2]);
        int qg = Integer.parseInt(text[3]);
        int qbl = Integer.parseInt(text[4]);
        double qs = Double.parseDouble(text[5]);
        double qa = Double.parseDouble(text[6]);
        int r = Integer.parseInt(text[7]);
        int g = Integer.parseInt(text[8]);
        int bl = Integer.parseInt(text[9]);
        double ds = Double.parseDouble(text[10]);
        double a = Double.parseDouble(text[11]);
        double m = Double.parseDouble(text[12]);

        return new Swarm(n, qr, qg, qbl, qs, qa, r, g, bl, ds, a, m);

    }

    /**
     * read flower section of file and return bee object.
     * 
     * @param text to be read
     * @return flower object.
     */
    private Flower readFlower(String[] text) {
        int r = Integer.parseInt(text[1]);
        int g = Integer.parseInt(text[2]);
        int bl = Integer.parseInt(text[3]);
        int num = Integer.parseInt(text[4]);
        double[] x = new double[num];
        double[] y = new double[num];
        int k = 0;
        
        // next part is reading each set of x and y values and placing them into
        // their respective arrays of values.
        for (int j = 5; j < text.length - num; j++) {
            x[k] = Double.parseDouble(text[j]);
            k++;
        }
        k = 0;
        for (int l = text.length - num; l < text.length; l++) {
            y[k] = Double.parseDouble(text[l]);
            k++;
        }

        return new Flower(r, g, bl, num, x, y);

    }

}
