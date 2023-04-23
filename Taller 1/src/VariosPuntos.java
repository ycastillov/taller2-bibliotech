import edu.princeton.cs.stdlib.StdDraw;

import java.awt.*;

/**
 *  Varios Puntos rebotando
 *
 * @author Yamir
 */

public class VariosPuntos {
    /**
     *
     * The Main.
     */
    public static void main(String[] args) {

        double min = -1.0;
        double max = 1.0;

        StdDraw.setXscale(min, max);
        StdDraw.setYscale(min, max);

        StdDraw.enableDoubleBuffering();

        double x0 = min + (max - min) * Math.random();
        double y0 = min + (max - min) * Math.random();

        double x1 = min + (max - min) * Math.random();
        double y1 = min + (max - min) * Math.random();

        double vx0 = 0.1 - 0.2 * Math.random();
        double vy0 = 0.1 - 0.2 * Math.random();

        double vx1 = 0.1 - 0.2 * Math.random();
        double vy1 = 0.1 - 0.2 * Math.random();

        calcularColision(x0,y0,x1,y1,vx0,vy0,vx1,vy1);

        System.out.println(x1);

    }

    private static void calcularColision(double x0, double vx0, double y0, double vy0, double x1, double vx1, double y1, double vy1) {

        Color[] colores = {Color.BLUE, Color.GREEN, Color.RED, Color.ORANGE, Color.CYAN};

        int counter = 0;

        while (true) {

            if (Math.abs(x0 + vx0) > 1.0) {
                vx0 = -vx0;
            }
            if (Math.abs(y0 + vy0) > 1.0) {
                vy0 = -vy0;
            }
            if (Math.abs(x1 + vx1) > 1.0) {
                vx1 = -vx1;
            }
            if (Math.abs(y1 + vy1) > 1.0) {
                vy1 = -vy1;
            }

            x0 += vx0;
            y0 += vy0;
            x1 += vx1;
            y1 += vy1;

            if (counter < 6) {
                StdDraw.setPenColor(colores[(int) (Math.random() * colores.length)]);
                StdDraw.line(x0,y0,x1,y1);
                counter += 1;
            }
            else {
                StdDraw.setPenColor(Color.BLACK);
                StdDraw.line(x0,y0,x1,y1);
                counter = 0;
            }



            StdDraw.show();

            StdDraw.pause(50);
        }
    }
}
