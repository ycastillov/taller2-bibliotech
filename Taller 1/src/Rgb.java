import edu.princeton.cs.stdlib.StdDraw;
import java.awt.Color;

/**
 * Protector de Pantalla
 *
 * @author Yamir Castillo Villegas
 */
public class Rgb {

    public static void main(String[] args) {

        // Definicion el rango de dibujo
        double min = -1.0;
        double max = 1.0;

        // Definicion de la escala del lienzo del dibujo
        StdDraw.setXscale(min, max);
        StdDraw.setYscale(min, max);

        // Evita parpadeo de la pantalla
        StdDraw.enableDoubleBuffering();

        // Definicion posiciones iniciales
        double x0 = min + (max - min) * Math.random();
        double y0 = min + (max - min) * Math.random();

        // Definicion posicion final primera linea
        double x1 = min + (max - min) * Math.random();
        double y1 = min + (max - min) * Math.random();

        // Definicion velocidad primera linea
        double vx0 = -0.01 + (0.01  - (-0.01)) * Math.random();
        double vy0 = -0.01 + (0.01  - (-0.01)) * Math.random();
        double vx1 = -0.01 + (0.01  - (-0.01)) * Math.random();
        double vy1 = -0.01 + (0.01  - (-0.01)) * Math.random();

        double[] linea1;
        linea1 = new double[]{x0,y0,x1,y1,vx0,vy0,vx1,vy1};

        // Creamos un arreglo para almacenar cada linea




        Color[] colores = {Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.BLUE, Color.PINK};


        // Ciclo infinito
        while (true) {


            // Definicion de la colision de las lineas
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

            linea1 = new double[]{x0,y0,x1,y1,vx0,vy0,vx1,vy1};

            // Actualiza la posicion de la linea
            x0 += vx0;
            y0 += vy0;
            x1 += vx1;
            y1 += vy1;

            // Limpiar la pantalla
            StdDraw.clear();

            // Dibujo de linea
            double incremento = 0.02;
            for (int i=0;i<6;i++) {
                StdDraw.setPenColor(colores[i]);
                StdDraw.line(x0+(i*incremento),y0+(i*incremento),x1+(i*incremento),y1+(i*incremento));
            }

            // Mostrar la pantalla

            StdDraw.show();

            // Controlar velocidad de las lineas
            StdDraw.pause(20);
        }

    }

}