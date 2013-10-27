/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mario.geometric.matrix;

import mario.geometric.linear.Vertice;
import mario.geometric.linear.Vector;

/**
 *
 * @author Mario
 */
public class PerspectivProjection extends Matrix {

    double distancia;

    public PerspectivProjection(double d) {
        super(new Vector(1, 0, 0), new Vector(0, 1, 0), new Vector(0, 0, 1));
        distancia = d;
    }

    public PerspectivProjection() {
        super(new Vector(1, 0, 0), new Vector(0, 1, 0), new Vector(0, 0, 1));
        distancia = 50;
    }

    public void establecerProyX() {
        setValores(
                new Vector(1, 0, 0, 1 / distancia),
                new Vector(0, 1, 0, 0),
                new Vector(0, 0, 1, 0),
                new Vector(0, 0, 0, 0));
    }

    public void establecerProyY() {
        setValores(
                new Vector(1, 0, 0, 0),
                new Vector(0, 1, 0, 1 / distancia),
                new Vector(0, 0, 1, 0),
                new Vector(0, 0, 0, 0));
    }

    public void establecerProyZ() {
        setValores(
                new Vector(1, 0, 0, 0),
                new Vector(0, 1, 0, 0),
                new Vector(0, 0, 1, 1 / distancia),
                new Vector(0, 0, 0, 0));
    }

    public void setDistancia(double d) {
        distancia = d;
    }

    @Override
    public void aplicar(Vertice v) {
        super.aplicar(v);
        v.dividedBy(v.getW());
    }

    @Override
    public Vertice aplicar2(Vertice v) {
        Vertice otro = super.aplicar2(v);
        otro.dividedBy(otro.getW());
        return otro; //TESTEADO TODO OK!
    }
}
