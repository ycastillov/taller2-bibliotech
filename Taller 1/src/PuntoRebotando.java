import edu.princeton.cs.stdlib.StdDraw;

/**
 * Pelota Rebotando
 *
 * @author Yamir
 */

public class PuntoRebotando {

    public static void main(String[] args){

        // Rango de dibujo
        double min = -1.0;
        double max = 1.0;

        // Definicion escala del lienzo de dibujo
        StdDraw.setXscale(min, max);
        StdDraw.setYscale(min, max);

        // Evitar el parpadeo de la pantalla
        StdDraw.enableDoubleBuffering();

        // Posicion inicial
        double x = min + (max - min) * Math.random();
        double y = min + (max - min) * Math.random();

        // Velocidad inicial
        double vx = 0.012;
        double vy = 0.032;

        // Radio de la pelota
        double radio = 0.05;

        // Ciclo infinito
        while (true) {

            // Colision
            if (Math.abs(x + vx) > 1.0 - radio) {
                vx = -vx;
            }

            if (Math.abs(y + vy) > 1.0 -radio) {
                vy = -vy;
            }

            // Actualizacion de posicion
            x += vx;
            y += vy;

            // Limpiar el fondo
            StdDraw.clear();

            // Dibujar la pelota
            StdDraw.setPenColor(StdDraw.RED);
            StdDraw.filledCircle(x,y,radio);

            // Mostrar la pantalla y esperar
            StdDraw.show();



        }




    }
}
