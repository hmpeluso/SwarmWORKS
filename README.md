# SwarmWORKS
Assigment working for fictitious game company developing an insect-themed game for distribution on multiple platforms.


All of the graphics for this application will be handled by the StdDraw library developed by Robert Sedgewick and Kevin Wayne at Princeton University. 
This library is not particularly powerful or full-featured, but it makes it easier to develop simple graphical applications in Java.

SwarmDriver.java has been developed to load the simulation data, initialize the drawing window, and handle the main simulation loop.

It is your responsibility to develop a Simulation class that is able to read the configuration file passed to the Simulation constructor. 
This class must also provide an "update" method that will be responsible for updating the state of all simulation elements at each time step, 
and a "draw" method that will be responsible for re-drawing simulation elements after they have been updated. 
Your code will be tested using the driver above.

SwarmConstants.java contains a set of constant values such as the window size, the simulation update rate, etc.

The following classes will be helpful for maintaining and updating insect locations:

Point.java - The Point class is an encapsulation of a two-dimensional location.
Pose.java - The Pose class is a subclass of Point that includes heading information.
PoseUtils.java - This class contains utility methods for updating Poses so that the edges of the window are handled correctly.


A list of simulation elements will be provided to the application in a text file. 
The first line of the file will contain a single integer describing the total number of elements encoded in the file. 
The second line will be blank. The remainder of the file will consist of entries describing the simulation elements.

The first line of each entry will contain an element type identifier. 
Subsequent lines will contain information appropriate to that element type. 
Where there are multiple values on a single line, each value will be separated by a single space. 
There will be a single blank line after each entry, including the last. 
You may assume that the file will be free of defects.
