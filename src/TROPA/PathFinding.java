package TROPA;

import INTERFAZ.INTERFAZ;
import MAPA.Llanura;
import MAPA.Map;

import java.awt.*;

public class PathFinding {


    public static boolean found = false;
    Tropa tropa;
    Map mapa;
    INTERFAZ interfaz;


    public PathFinding(Tropa tropa, Map mapa, INTERFAZ interfaz){
        this.tropa = tropa;
        this.mapa = mapa;
        this.interfaz = interfaz;
    }

    public boolean BuscarCaminoTest(Point lugar, Point destino){
        interfaz.PonerNumero(BuscarDistancia(destino, lugar), lugar);
        if (lugar.equals(destino))
            found = true;

        if (BuscarDistancia(lugar, destino) > BuscarDistancia(new Point (lugar.x - 1, lugar.y),destino) && mapa.mapa[lugar.x - 1][lugar.y] instanceof Llanura && !found){
            BuscarCaminoTest(new Point (lugar.x - 1, lugar.y),destino);
        }
        if (BuscarDistancia(lugar, destino) > BuscarDistancia(new Point (lugar.x + 1, lugar.y),destino) && mapa.mapa[lugar.x + 1][lugar.y] instanceof Llanura && !found){
            BuscarCaminoTest(new Point (lugar.x + 1, lugar.y),destino);
        }
        if (BuscarDistancia(lugar, destino) > BuscarDistancia(new Point (lugar.x, lugar.y - 1),destino ) && mapa.mapa[lugar.x][lugar.y - 1] instanceof Llanura && !found){
            BuscarCaminoTest(new Point (lugar.x , lugar.y - 1),destino);
        }
        if (BuscarDistancia(lugar, destino) > BuscarDistancia(new Point (lugar.x, lugar.y + 1),destino) && mapa.mapa[lugar.x][lugar.y + 1] instanceof Llanura && !found){
            BuscarCaminoTest(new Point (lugar.x , lugar.y + 1),destino);


        }

        return found;
    }


    public void Refound(Point lugar, Point destino){
        if (found)
            return;

        if (BuscarDistancia(lugar, destino) > BuscarDistancia(new Point (lugar.x - 1, lugar.y),destino) && mapa.mapa[lugar.x - 1][lugar.y] instanceof Llanura && !found)
            BuscarCaminoTest(new Point (lugar.x - 1, lugar.y),destino);

        if (BuscarDistancia(lugar, destino) > BuscarDistancia(new Point (lugar.x + 1, lugar.y),destino) && mapa.mapa[lugar.x + 1][lugar.y] instanceof Llanura && !found)
            BuscarCaminoTest(new Point (lugar.x + 1, lugar.y),destino);

        if (BuscarDistancia(lugar, destino) > BuscarDistancia(new Point (lugar.x, lugar.y - 1),destino ) && mapa.mapa[lugar.x][lugar.y - 1] instanceof Llanura && !found)
            BuscarCaminoTest(new Point (lugar.x , lugar.y - 1),destino);

        if (BuscarDistancia(lugar, destino) > BuscarDistancia(new Point (lugar.x, lugar.y + 1),destino) && mapa.mapa[lugar.x][lugar.y + 1] instanceof Llanura && !found)
            BuscarCaminoTest(new Point (lugar.x , lugar.y + 1),destino);



    }

    public int BuscarDistancia(Point destino){
        int distancia = 0;
        if (destino.x == tropa.posicion.x && destino.y == tropa.posicion.y)
            return 0;

        if (destino.x < tropa.posicion.x )
            distancia += tropa.posicion.x - destino.x;
        else
            distancia += destino.x - tropa.posicion.x;

        if (destino.y < tropa.posicion.y )
            distancia += tropa.posicion.y - destino.y;
        else
            distancia += destino.y - tropa.posicion.y;

        return distancia;
    }

    public int BuscarDistancia(Point punto, Point destino){
        int distancia = 0;
        if (destino.x == punto.x && destino.y == punto.y)
            return 0;

        if (destino.x < punto.x )
            distancia += punto.x - destino.x;
        else
            distancia += destino.x - punto.x;

        if (destino.y < punto.y )
            distancia += punto.y - destino.y;
        else
            distancia += destino.y - punto.y;

        return distancia;
    }

}
