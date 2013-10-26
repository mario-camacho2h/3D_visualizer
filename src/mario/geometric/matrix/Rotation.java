/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mario.geometric.matrix;

import mario.geometric.matrix.Matrix;
import mario.geometric.linear.Vector;

/**
 *
 * @author Mario
 */
public class Rotation extends Matrix {

    private double angulo;

    public Rotation() {
        super(new Vector(1, 0, 0), new Vector(0, 1, 0), new Vector(0, 0, 1));
        angulo = Math.toRadians(6);
    }

    public void setAngulo(double a) {
        angulo = a;
    }

    public double getAngulo() {
        return angulo;
    }

    public void establecerRotacionX() {
        setValores(
                new Vector(1, 0, 0),
                new Vector(0, Math.cos(angulo), Math.sin(angulo)),
                new Vector(0, -Math.sin(angulo), Math.cos(angulo)));
    }

    public void establecerRotacionY() {
        setValores(
                new Vector(Math.cos(angulo), 0, -Math.sin(angulo)),
                new Vector(0, 1, 0),
                new Vector(Math.sin(angulo), 0, Math.cos(angulo)));
    }

    public void establecerRotacionZ() {
        setValores(
                new Vector(Math.cos(angulo), Math.sin(angulo), 0),
                new Vector(-Math.sin(angulo), Math.cos(angulo), 0),
                new Vector(0, 0, 1));
    }
}
