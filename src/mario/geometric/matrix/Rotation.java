/*
 * [Graficacion por Computadora]
 * This was a University project
 * U.M.S.S.
 */
package mario.geometric.matrix;

import mario.geometric.commons.Axis;
import mario.geometric.linear.Vector;

/**
 *
 * @author Mario
 */
public class Rotation extends Matrix {

    private double angle;

    public Rotation() {
        super(new Vector(1, 0, 0), new Vector(0, 1, 0), new Vector(0, 0, 1));
        angle = Math.toRadians(6);
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }

    public double getAngle() {
        return angle;
    }

    public void setRotationAxisAsX() {
        setValues(
                new Vector(1, 0, 0),
                new Vector(0, Math.cos(angle), Math.sin(angle)),
                new Vector(0, -Math.sin(angle), Math.cos(angle)));
    }

    public void setRotationAxisAsY() {
        setValues(
                new Vector(Math.cos(angle), 0, -Math.sin(angle)),
                new Vector(0, 1, 0),
                new Vector(Math.sin(angle), 0, Math.cos(angle)));
    }

    public void setRotationAxisAsZ() {
        setValues(
                new Vector(Math.cos(angle), Math.sin(angle), 0),
                new Vector(-Math.sin(angle), Math.cos(angle), 0),
                new Vector(0, 0, 1));
    }

    public void setRotationAxis(Axis axis) {
        switch (axis) {
            case X:
                setRotationAxisAsX();
                break;
            case Y:
                setRotationAxisAsY();
                break;
            case Z:
                setRotationAxisAsZ();
                break;
        }
    }
}
