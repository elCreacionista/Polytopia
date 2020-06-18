package INTERFAZ;

import TROPA.Tropa;
import TROPA.PathFinding;
import MAPA.Map;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseJugador  implements MouseListener {
    Movimiento movimiento;
    INTERFAZ interfaz;
    Tropa tropa;
    Map map;
    MouseJugador(INTERFAZ interfaz, Tropa tropa, Map map){

        this.interfaz = interfaz;
        this.tropa = tropa;
        this.map = map;
    }

    Point click;
    Point mapclick;
    @Override
    public void mouseClicked(MouseEvent e) {
        double x = ((double) e.getX() / 2000) * map.mapa.length;
        double y = ((double) e.getY() / 2000) * map.mapa[0].length;
        click = new Point((int)x,(int)y);
        System.out.println(x);
        System.out.println(y);
        PathFinding path = new PathFinding(tropa,map, interfaz);
        //interfaz.PonerNumero(path.BuscarDistancia(click),click);
        switch (INTERFAZ.seleccionado) {
            case "nothing":
                movimiento = new Movimiento(interfaz, map, tropa);

                if (click.equals(tropa.posicion)) {
                    movimiento.MovimientoTropaTest01(interfaz, map, path, click);
                    INTERFAZ.seleccionado = "tropa";
                }
                else{
                    System.out.println(path.BuscarCaminoTest(tropa.posicion,click));
                    PathFinding.found = false;
                }

                break;
            case "tropa":
                if (tropa.numMov > 0 && interfaz.label[click.x][click.y].getBackground().equals(new Color(50,50,255))){
                    tropa.posicion = click;
                    tropa.numMov -= 1;
                }
                interfaz.ResetMap(map, tropa);
                INTERFAZ.seleccionado = "nothing";
                break;

        }

    }

    @Override
    public void mousePressed(MouseEvent e) {
      /*  click = new Point(e.getX(),e.getY());
        mapclick = new Point((e.getX() * 20) / map.mapa.length ,(e.getY() * 20) / map.mapa[0].length );
        interfaz.label[mapclick.x][mapclick.y].setBackground(Color.RED);
        System.out.println("x: " + mapclick.x + " y: " + mapclick.y);
    */}

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
