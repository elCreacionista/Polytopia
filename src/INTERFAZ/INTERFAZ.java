package INTERFAZ;

import JUGADOR.Jugador;
import MAPA.Map;


import javax.swing.*;
import java.awt.*;

public class INTERFAZ extends JFrame {


    static String seleccionado = "nothing";
    Container Panel_mapa;
    Container contenedor;
    JLabel[][] label;
    JLabel Jugad;




    Map mapa;
    Jugador jugador;
    Point initialpos;
    Point local = new Point(300,300);

    int timer = 1000;
    int time = 0;
    static int tics = 0;




    public INTERFAZ(Map c, Jugador j) {





        this.mapa = c;
        this.jugador = j;
        new JFrame("mapa");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,600);
        Panel_mapa = new Container();
        Panel_mapa.setSize(2000, 2000);
        initialpos = new Point((-j.posicion.x * 20) + 300,(-j.posicion.y * 20) + 300);
        Panel_mapa.setLocation(initialpos);
        label = new JLabel[c.mapa.length][c.mapa[0].length];
        //Panel_mapa.setLayout(new GridLayout(c.mapa.length, c.mapa[0].length));
        setLocationRelativeTo(null);
        contenedor = new Container();
        add(contenedor, BorderLayout.CENTER);
        contenedor.setSize(200,200);
        contenedor.setLocation(new Point(50,0));
        contenedor.setBackground(Color.white);

        contenedor.add(Panel_mapa);
        losJL(c, j);
        addKeyListener(new Keyboard());
        Panel_mapa.addMouseListener(new MouseJugador(this,j,c));
        setVisible(true);
        Panel_mapa.addMouseMotionListener(new Mouse(this));


    }

    public void ponerJL(Map c, Jugador ju) {

        for (int i = 0; i < c.mapa.length; i++) {
            for (int j = 0; j < c.mapa[0].length; j++) {

                if (losJug(i, j, ju)) {
                    System.out.println(i + "  " + j);
                } else UnJL(i, j, c);

            }
        }
    }

    public boolean losJug(int i, int j, Jugador c) {

        if (c.posicion.x == i && c.posicion.y == j) {

            label[i][j].setBackground(new Color(200, 200, 200));
            return true;
        }
        return false;
    }

    public void CuadJL(Map m, Jugador j) {

        int x = j.posicion.x - 1;
        int y = j.posicion.y - 1;

        if (x < 0) x = 0;
        if (y < 0) y = 0;

        int max_x = j.posicion.x + 1;
        int max_y = j.posicion.y + 1;

        if (max_x >= m.mapa.length) max_x = m.mapa.length - 1;
        if (max_y >= m.mapa[0].length) max_y = m.mapa[0].length - 1;

        for (int i = x; i <= max_x; i++) {
            for (int k = y; k <= max_y; k++) {
                if (losJug(i, k, j)) {
                } else UnJL(i, k, m);

            }
        }
    }


    public void ResetMap(Map c, Jugador ju){
        for (int i = 0; i < c.mapa.length - 1; i++) {
            for (int j = 0; j < c.mapa[0].length - 1; j++) {
                this.label[i][j].setText("");
                if (losJug(i, j, ju)) {

                } else UnJL(i, j, c);
            }
        }
    }


    public void CambiarColor(Point p, Color color){
        this.label[p.x][p.y].setBackground(color);
    }

    public void PonerNumero(int numero, Point posicion){
        this.label[posicion.x][posicion.y].setText(("" + numero));
    }

    public void losJL(Map c, Jugador ju) {


        for (int i = 0; i < c.mapa.length - 1; i++) {
            for (int j = 0; j < c.mapa[0].length - 1; j++) {

                label[i][j] = new JLabel("");
                label[i][j].setBounds(i*20,j*20,20,20);
                label[i][j].setOpaque(true);

                if (losJug(i, j, ju)) {

                } else UnJL(i, j, c);

                Panel_mapa.add(label[i][j]);
            }
        }
    }

    public void UnJL(int i, int j, Map c) {

        switch (c.mapa[i][j].tipo) {
            case MAR:
                label[i][j].setBackground(new Color(0, 0, 100));
                break;
            case LLANURA1:
                label[i][j].setBackground(new Color(154, 180, 70));
                break;
            case LLANURA2:
                label[i][j].setBackground(new Color(128, 180, 64));
                break;
            case LLANURA3:
                label[i][j].setBackground(new Color(101, 180, 32));
                break;
            case BOSQUE:
                label[i][j].setBackground(new Color(27, 126, 29));
                break;
            case MONTE:
                label[i][j].setBackground(new Color(100, 100, 100));
                break;
            case RIO:
                label[i][j].setBackground(new Color(0, 100, 250));
                break;
            case CIUDAD:
                label[i][j].setBackground(new Color(0, 0, 0));
                break;
            default:
                System.out.println("Keapasao");
                break;

        }
    }


}
