package TROPA;

import MAPA.Map;
import MAPA.tipoCasilla;

import java.awt.*;

public class Tropa {


    public Point posicion;
    public int movimientos;

    public void setPosicion(Point posicion) {
        this.posicion = posicion;
    }

    public void MoveUP(Map map, int movimientos){
        for (int i = 0; i < movimientos ; i++) {
            if (this.posicion.x < map.mapa.length-1)
                if (map.mapa[this.posicion.x + 1][this.posicion.y].tipo == tipoCasilla.LLANURA1
                        && map.mapa[this.posicion.x + 1][this.posicion.y].tipo == tipoCasilla.LLANURA2
                        && map.mapa[this.posicion.x + 1][this.posicion.y].tipo == tipoCasilla.LLANURA3)
                    this.posicion.x++;
        }


    }
    public void MoveDOWN(Map map, int movimientos){
        for (int i = 0; i < movimientos ; i++) {
            if (this.posicion.x < map.mapa.length-1)
                if (map.mapa[this.posicion.x + 1][this.posicion.y].tipo == tipoCasilla.LLANURA1
                        && map.mapa[this.posicion.x + 1][this.posicion.y].tipo == tipoCasilla.LLANURA2
                        && map.mapa[this.posicion.x + 1][this.posicion.y].tipo == tipoCasilla.LLANURA3)
                    this.posicion.x++;
        }


    }
    public void MoveLEFT(Map map, int movimientos){
        for (int i = 0; i < movimientos ; i++) {
            if (this.posicion.y > 0)
                if (map.mapa[this.posicion.x][this.posicion.y-1].tipo == tipoCasilla.LLANURA1
                        && map.mapa[this.posicion.x][this.posicion.y-1].tipo == tipoCasilla.LLANURA2
                        && map.mapa[this.posicion.x][this.posicion.y-1].tipo == tipoCasilla.LLANURA3)
                    this.posicion.y--;
        }

    }
    public void MoveRIGHT(Map map, int movimientos){
        for (int i = 0; i < movimientos ; i++) {
            if (this.posicion.y < map.mapa.length-1)
                if (map.mapa[this.posicion.x][this.posicion.y+1].tipo == tipoCasilla.LLANURA1
                        && map.mapa[this.posicion.x][this.posicion.y+1].tipo == tipoCasilla.LLANURA2
                        && map.mapa[this.posicion.x][this.posicion.y+1].tipo == tipoCasilla.LLANURA3)
                    this.posicion.y++;
        }

    }
}
