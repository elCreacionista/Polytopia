import INTERFAZ.INTERFAZ;
import TROPA.Tropa;
import MAPA.Llanura;
import MAPA.Map;
import MAPA.MapGenerator;
import MAPA.MapTransformer;

import java.awt.*;

public class Main {


    public static void main(String[] args) {
        Map mapa = new Map(new MapTransformer(new MapGenerator(100,100)));
        Tropa tropa = new Tropa();
        tropa.setPosicion(new Point(50, 50));
        for (int i = 0; i < 10 ; i++) {
            if (mapa.mapa[tropa.posicion.x][tropa.posicion.y] instanceof Llanura)
                break;
            else
                tropa.setPosicion(new Point((int)(Math.random()*99), (int)(Math.random()*99)));

        }
        INTERFAZ in = new INTERFAZ(mapa, tropa);
    }

}
