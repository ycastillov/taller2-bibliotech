import edu.princeton.cs.stdlib.StdDraw;
import java.awt.Color;

/**
 * Protector de Pantalla
 *
 * @author Yamir Castillo Villegas
 */
public class taller {

    /**
     *
     *  The Main
     */
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
        double incremento = 0.05;
        double linea1_x0 = min + (max - min) * Math.random();
        double linea1_y0 = min + (max - min) * Math.random();
        // Linea 2
        double linea2_x0 = linea1_x0 + incremento;
        double linea2_y0 = linea1_y0 + incremento;
        // Linea 3
        double linea3_x0 = linea1_x0 + 2*incremento;
        double linea3_y0 = linea1_y0 + 2*incremento;
        // Linea 4
        double linea4_x0 = linea1_x0 + 3*incremento;
        double linea4_y0 = linea1_y0 + 3*incremento;
        // Linea 5
        double linea5_x0 = linea1_x0 + 4*incremento;
        double linea5_y0 = linea1_y0 + 4*incremento;
        // Linea 6
        double linea6_x0 = linea1_x0 + 5*incremento;
        double linea6_y0 = linea1_y0 + 5*incremento;

        // Definicion posiciones finales
        double linea1_x1 = min + (max - min) * Math.random();
        double linea1_y1 = min + (max - min) * Math.random();
        // Linea 2
        double linea2_x1 = linea1_x1 + incremento;
        double linea2_y1 = linea1_y1 + incremento;
        // Linea 3
        double linea3_x1 = linea1_x1 + 2*incremento;
        double linea3_y1 = linea1_y1 + 2*incremento;
        // Linea 4
        double linea4_x1 = linea1_x1 + 3*incremento;
        double linea4_y1 = linea1_y1 + 3*incremento;
        // Linea 5
        double linea5_x1 = linea1_x1 + 4*incremento;
        double linea5_y1 = linea1_y1 + 4*incremento;
        // Linea 6
        double linea6_x1 = linea1_x1 + 5*incremento;
        double linea6_y1 = linea1_y1 + 5*incremento;

        // Definicion velocidad primera linea
        double linea1_vx0 = -0.01 + (0.01  - (-0.01)) * Math.random();
        double linea1_vy0 = -0.01 + (0.01  - (-0.01)) * Math.random();
        double linea1_vx1 = -0.01 + (0.01  - (-0.01)) * Math.random();
        double linea1_vy1 = -0.01 + (0.01  - (-0.01)) * Math.random();
        // Linea 2
        double linea2_vx0 = linea1_vx0;
        double linea2_vy0 = linea1_vy0;
        double linea2_vx1 = linea1_vx1;
        double linea2_vy1 = linea1_vy1;
        // Linea 3
        double linea3_vx0 = linea1_vx0;
        double linea3_vy0 = linea1_vy0;
        double linea3_vx1 = linea1_vx1;
        double linea3_vy1 = linea1_vy1;
        // Linea 4
        double linea4_vx0 = linea1_vx0;
        double linea4_vy0 = linea1_vy0;
        double linea4_vx1 = linea1_vx1;
        double linea4_vy1 = linea1_vy1;
        // Linea 5
        double linea5_vx0 = linea1_vx0;
        double linea5_vy0 = linea1_vy0;
        double linea5_vx1 = linea1_vx1;
        double linea5_vy1 = linea1_vy1;
        // Linea 6
        double linea6_vx0 = linea1_vx0;
        double linea6_vy0 = linea1_vy0;
        double linea6_vx1 = linea1_vx1;
        double linea6_vy1 = linea1_vy1;

        // Definimos un arreglo que contiene los colores
        Color[] colores = {Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.BLUE, Color.PINK};

        // Ciclo infinito
        while (true) {

            // Definicion de la colision de las lineas
            // Linea 1
            if (Math.abs(linea1_x0 + linea1_vx0) > 1.0) {
                linea1_vx0 = -linea1_vx0;
            }
            if (Math.abs(linea1_y0 + linea1_vy0) > 1.0) {
                linea1_vy0 = -linea1_vy0;
            }
            if (Math.abs(linea1_x1 + linea1_vx1) > 1.0) {
                linea1_vx1= -linea1_vx1;
            }
            if (Math.abs(linea1_y1 + linea1_vy1) > 1.0) {
                linea1_vy1 = -linea1_vy1;
            }

            // Linea 2
            if (Math.abs(linea2_x0 + linea2_vx0) > 1.0) {
                linea2_vx0 = -linea2_vx0;
            }
            if (Math.abs(linea2_y0 + linea2_vy0) > 1.0) {
                linea2_vy0 = -linea2_vy0;
            }
            if (Math.abs(linea2_x1 + linea2_vx1) > 1.0) {
                linea2_vx1= -linea2_vx1;
            }
            if (Math.abs(linea2_y1 + linea2_vy1) > 1.0) {
                linea2_vy1 = -linea2_vy1;
            }

            // Linea 3
            if (Math.abs(linea3_x0 + linea3_vx0) > 1.0) {
                linea3_vx0 = -linea3_vx0;
            }
            if (Math.abs(linea3_y0 + linea3_vy0) > 1.0) {
                linea3_vy0 = -linea3_vy0;
            }
            if (Math.abs(linea3_x1 + linea3_vx1) > 1.0) {
                linea3_vx1= -linea3_vx1;
            }
            if (Math.abs(linea3_y1 + linea3_vy1) > 1.0) {
                linea3_vy1 = -linea3_vy1;
            }

            // Linea 4
            if (Math.abs(linea4_x0 + linea4_vx0) > 1.0) {
                linea4_vx0 = -linea4_vx0;
            }
            if (Math.abs(linea4_y0 + linea4_vy0) > 1.0) {
                linea4_vy0 = -linea4_vy0;
            }
            if (Math.abs(linea4_x1 + linea4_vx1) > 1.0) {
                linea4_vx1= -linea4_vx1;
            }
            if (Math.abs(linea4_y1 + linea4_vy1) > 1.0) {
                linea4_vy1 = -linea4_vy1;
            }

            // Linea 5
            if (Math.abs(linea5_x0 + linea5_vx0) > 1.0) {
                linea5_vx0 = -linea5_vx0;
            }
            if (Math.abs(linea5_y0 + linea5_vy0) > 1.0) {
                linea5_vy0 = -linea5_vy0;
            }
            if (Math.abs(linea5_x1 + linea5_vx1) > 1.0) {
                linea5_vx1= -linea5_vx1;
            }
            if (Math.abs(linea5_y1 + linea5_vy1) > 1.0) {
                linea5_vy1 = -linea5_vy1;
            }

            // Linea 6
            if (Math.abs(linea6_x0 + linea6_vx0) > 1.0) {
                linea6_vx0 = -linea6_vx0;
            }
            if (Math.abs(linea6_y0 + linea6_vy0) > 1.0) {
                linea6_vy0 = -linea6_vy0;
            }
            if (Math.abs(linea6_x1 + linea6_vx1) > 1.0) {
                linea6_vx1= -linea6_vx1;
            }
            if (Math.abs(linea6_y1 + linea6_vy1) > 1.0) {
                linea6_vy1 = -linea6_vy1;
            }

            // Actualizacion de la posicion
            linea1_x0 += linea1_vx0;
            linea1_y0 += linea1_vy0;
            linea1_x1 += linea1_vx1;
            linea1_y1 += linea1_vy1;

            linea2_x0 += linea2_vx0;
            linea2_y0 += linea2_vy0;
            linea2_x1 += linea2_vx1;
            linea2_y1 += linea2_vy1;

            linea3_x0 += linea3_vx0;
            linea3_y0 += linea3_vy0;
            linea3_x1 += linea3_vx1;
            linea3_y1 += linea3_vy1;

            linea4_x0 += linea4_vx0;
            linea4_y0 += linea4_vy0;
            linea4_x1 += linea4_vx1;
            linea4_y1 += linea4_vy1;

            linea5_x0 += linea5_vx0;
            linea5_y0 += linea5_vy0;
            linea5_x1 += linea5_vx1;
            linea5_y1 += linea5_vy1;

            linea6_x0 += linea6_vx0;
            linea6_y0 += linea6_vy0;
            linea6_x1 += linea6_vx1;
            linea6_y1 += linea6_vy1;

            // Limpia la pantalla
            StdDraw.clear();

            // Dibujo de lineas
            for (int i=0;i<6;i++) {
                StdDraw.setPenColor(colores[i]);
                if (i == 0) {
                    StdDraw.line(linea1_x0,linea1_y0,linea1_x1,linea1_y1);
                }
                if (i == 1) {
                    StdDraw.line(linea2_x0,linea2_y0,linea2_x1,linea2_y1);
                }
                if (i == 2) {
                    StdDraw.line(linea3_x0,linea3_y0,linea3_x1,linea3_y1);
                }
                if (i == 3) {
                    StdDraw.line(linea4_x0,linea4_y0,linea4_x1,linea4_y1);
                }
                if (i == 4) {
                    StdDraw.line(linea5_x0,linea5_y0,linea5_x1,linea5_y1);
                }
                if (i == 5) {
                    StdDraw.line(linea6_x0,linea6_y0,linea6_x1,linea6_y1);
                }
            }

            // Muestra la actualizacion en la pantalla
            StdDraw.show();

            // Controla la velocidad de las lineas
            StdDraw.pause(20);
        }

    }

}