/*
 * [Graficacion por Computadora]
 * This was a University project
 * U.M.S.S.
 */
package mario.geometric.linear;

import java.awt.Graphics;

/**
 *
 * @author Mario Camacho
 */
public class Arista {

    private Vertice init, end;

    public Arista(Vertice init, Vertice end) {
        this.init = init;
        this.end = end;
    }

    public void setInit(Vertice init) {
        this.init = init;
    }

    public void setEnd(Vertice end) {
        this.end = end;
    }

    public Vertice getIni() {
        return init;
    }

    public Vertice getFin() {
        return end;
    }

    public void paint(int eje, Graphics g, int dx, int dy) {
        
        if (eje == 0) {
            g.drawLine(
                    (int) Math.round(init.getZ()) - dx, 
                    (int) Math.round(770 - init.getY()) + dy, 
                    (int) Math.round(end.getZ()) - dx, 
                    (int) Math.round(770 - end.getY()) + dy);
        } else if (eje == 1) {
            g.drawLine(
                    (int) Math.round(init.getX()) + dx, 
                    (int) Math.round(init.getZ()) - dy, 
                    (int) Math.round(end.getX()) + dx, 
                    (int) Math.round(end.getZ()) - dy);
        } else if (eje == 2) {
            g.drawLine(
                    (int) Math.round(init.getX()) + dx, 
                    (int) Math.round(770 - init.getY()) - dy, 
                    (int) Math.round(end.getX()) + dx, 
                    (int) Math.round(770 - end.getY()) - dy);
        }
    }

    @Override
    public String toString() {
        return String.format("Arista: %s => %s", init.toString(),end.toString());
    }
}