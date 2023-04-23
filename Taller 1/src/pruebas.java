import edu.princeton.cs.stdlib.*;
import java.awt.Color;

public class pruebas {
    public static void main(String[] args) {
        // Set up the canvas
        double min = -1.0;
        double max = 1.0;

        StdDraw.setXscale(min,max);
        StdDraw.setYscale(min,max);

        // Define the starting point and speed of the first line randomly
        double x1 = min + (max - min) * Math.random();
        double y1 = min + (max - min) * Math.random();
        double dx1 = -0.01 + (0.01  - (-0.01)) * Math.random();;
        double dy1 = -0.01 + (0.01  - (-0.01)) * Math.random();;

        // Draw the first line
        StdDraw.line(x1, y1, x1 + 0.1, y1 + 0.1);

        // Draw the other five lines following the first line
        for (int i = 0; i < 5; i++) {
            // Get the endpoints of the previous line
            double[] prevStart = {x1, y1};
            double[] prevEnd = {x1 + 0.1, y1 + 0.1};

            // Calculate the direction and speed of the next line based on the previous line
            double dirX = prevEnd[0] - prevStart[0];
            double dirY = prevEnd[1] - prevStart[1];
            double dx = dirX * dx1;
            double dy = dirY * dy1;

            // Check if the first endpoint of the line is off the screen and adjust it accordingly
            double[] nextStart = {prevEnd[0] + dx, prevEnd[1] + dy};
            if (nextStart[0] < -1.0 || nextStart[0] > 1.0) {
                dx = -dx;
                nextStart[0] = prevEnd[0] + dx;
            }
            if (nextStart[1] < -1.0 || nextStart[1] > 1.0) {
                dy = -dy;
                nextStart[1] = prevEnd[1] + dy;
            }

            // Draw the line
            StdDraw.setPenColor(Color.BLACK);
            StdDraw.line(prevEnd[0], prevEnd[1], nextStart[0], nextStart[1]);
            StdDraw.show(); // Update the canvas

            // Update the variables for the next iteration
            x1 = nextStart[0];
            y1 = nextStart[1];
            dx1 = dx;
            dy1 = dy;
        }
    }
}

