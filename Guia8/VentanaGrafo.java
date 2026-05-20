import javax.swing.*;
import java.awt.*;

public class VentanaGrafo extends JPanel {

    int[][] posiciones = {

            {300,50},
            {150,120},
            {450,120},
            {80,250},
            {220,250},
            {380,250},
            {520,250},
            {150,400},
            {350,400},
            {500,400}
    };

    String[] nombres = {

            "UMB",
            "Portal Norte",
            "Portal Sur",
            "Portal Suba",
            "Portal 80",
            "Portal Tunal",
            "Portal Usme",
            "Portal Americas",
            "Portal Dorado",
            "Portal 20 Julio"
    };

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        // LINEAS

        dibujarLinea(g,0,1);
        dibujarLinea(g,0,2);
        dibujarLinea(g,1,3);
        dibujarLinea(g,1,4);
        dibujarLinea(g,2,5);
        dibujarLinea(g,2,6);
        dibujarLinea(g,3,7);
        dibujarLinea(g,4,7);
        dibujarLinea(g,5,8);
        dibujarLinea(g,6,9);
        dibujarLinea(g,7,8);
        dibujarLinea(g,8,9);

        // NODOS

        for (int i = 0;
             i < posiciones.length;
             i++) {

            int x = posiciones[i][0];

            int y = posiciones[i][1];

            g.fillOval(x,y,40,40);

            g.drawString(
                    nombres[i],
                    x - 10,
                    y - 10);
        }
    }

    private void dibujarLinea(Graphics g,
                              int origen,
                              int destino) {

        int x1 =
                posiciones[origen][0] + 20;

        int y1 =
                posiciones[origen][1] + 20;

        int x2 =
                posiciones[destino][0] + 20;

        int y2 =
                posiciones[destino][1] + 20;

        g.drawLine(x1,y1,x2,y2);
    }

    public static void mostrar() {

        JFrame ventana =
                new JFrame("Grafo Bogotá");

        VentanaGrafo panel =
                new VentanaGrafo();

        ventana.add(panel);

        ventana.setSize(700,600);

        ventana.setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE);

        ventana.setVisible(true);
    }
}