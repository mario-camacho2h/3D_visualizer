/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mario.geometric.matrix;

import mario.geometric.linear.Vector;

/**
 *
 * @author Mario
 */
public class Translation extends Matrix {

    public Translation() {
        super(new Vector(1, 0, 0), new Vector(0, 1, 0), new Vector(0, 0, 1));
    }

    public void trasladarEnX(double dx) {
        setValores(
                new Vector(1, 0, 0, 0),
                new Vector(0, 1, 0, 0),
                new Vector(0, 0, 1, 0),
                new Vector(dx, 0, 0, 1));
    }

    public void trasladarEnY(double dy) {
        setValores(
                new Vector(1, 0, 0, 0),
                new Vector(0, 1, 0, 0),
                new Vector(0, 0, 1, 0),
                new Vector(0, dy, 0, 1));
    }

    public void trasladarEnZ(double dz) {
        setValores(
                new Vector(1, 0, 0, 0),
                new Vector(0, 1, 0, 0),
                new Vector(0, 0, 1, 0),
                new Vector(0, 0, dz, 1));
    }

    public void trasladarEnElEspacio(double dx, double dy, double dz) {
        setValores(
                new Vector(1, 0, 0, 0),
                new Vector(0, 1, 0, 0),
                new Vector(0, 0, 1, 0),
                new Vector(dx, dy, dz, 1));
    }
}