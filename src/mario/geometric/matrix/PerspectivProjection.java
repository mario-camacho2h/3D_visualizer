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
        setValues(
                new Vector(1, 0, 0, 1 / distancia),
                new Vector(0, 1, 0, 0),
                new Vector(0, 0, 1, 0),
                new Vector(0, 0, 0, 0));
    }

    public void establecerProyY() {
        setValues(
                new Vector(1, 0, 0, 0),
                new Vector(0, 1, 0, 1 / distancia),
                new Vector(0, 0, 1, 0),
                new Vector(0, 0, 0, 0));
    }

    public void establecerProyZ() {
        setValues(
                new Vector(1, 0, 0, 0),
                new Vector(0, 1, 0, 0),
                new Vector(0, 0, 1, 1 / distancia),
                new Vector(0, 0, 0, 0));
    }

    public void setDistancia(double d) {
        distancia = d;
    }

    @Override
    public void applyAndSet(Vertice v) {
        super.applyAndSet(v);
        v.dividedBy(v.getW());
    }

    @Override
    public Vertice apply(Vertice v) {
        Vertice otro = super.apply(v);
        otro.dividedBy(otro.getW());
        return otro; //TESTEADO TODO OK!
    }
}
