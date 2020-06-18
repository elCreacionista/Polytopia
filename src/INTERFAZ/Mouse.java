package INTERFAZ;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Mouse implements MouseMotionListener {
    INTERFAZ interfaz;
    Mouse(INTERFAZ interfaz){
        this.interfaz = interfaz;
    }

    Point now;
    @Override
    public void mouseDragged(MouseEvent e) {
            Point naw = new Point(e.getX(), e.getY());



            if (now.x > naw.x )
                interfaz.initialpos.x += 5;
            else
                interfaz.initialpos.x -= 5;

            if (now.y > naw.y)
                interfaz.initialpos.y += 5;
            else
                interfaz.initialpos.y -= 5;
            interfaz.Panel_mapa.setLocation(interfaz.initialpos);
        System.out.println("x: " + e.getX() + " y: " + e.getY());

            System.out.println("x: " + interfaz.initialpos.x + " y: " + interfaz.initialpos.y);

        if (interfaz.initialpos.x <= -1400)
            interfaz.initialpos.x = -1399;
        if (interfaz.initialpos.x >= 0)
            interfaz.initialpos.x = -1;
        if (interfaz.initialpos.y <= -1400)
            interfaz.initialpos.y = -1399;
        if (interfaz.initialpos.y >= 0)
            interfaz.initialpos.y = -1;

        now = naw;
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        now = new Point(e.getX(),e.getY());
    }
}
