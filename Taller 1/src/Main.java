import edu.princeton.cs.stdlib.StdDraw;

/**
 * Dibujar puntos al azar en la pantalla.
 *
 * @author Yamir
 *
 */
public class Main {

    /**
     *  The Main
     */
    public static void main(String[] args) {

        // Rango de dibujo

        double min = -1.0;
        double max = 1.0;

        // Definicion de la escala del tiempo

        StdDraw.setXscale(min,max);
        StdDraw.setYscale(min,max);

        // Evitar el parpadeo de la pantalla

        StdDraw.enableDoubleBuffering();

        // Dibujar un 1.00.000 de puntos
        for (int i = 0; i < 1000000; i++) {
            // Generacion de un par ordenado x,y
            double x = min + (max - min) * Math.random();
            double y = min + (max - min) * Math.random();

            StdDraw.point(x, y);
            StdDraw.show();


        }
    }
}
