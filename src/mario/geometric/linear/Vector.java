/*
 * [Graficacion por Computadora]
 * This was a University project
 * U.M.S.S.
 */
package mario.geometric.linear;

import mario.geometric.matrix.Matrix;

/**
 *
 * @author Mario Camacho
 */
public class Vector extends Tupla {

    public Vector(double x2, double y2, double z2) {
        super(x2, y2, z2, 0);
    }

    public Vector(double x2, double y2, double z2, double w2) {
        super(x2, y2, z2, w2);
    }

    public Vector(Vector vector) {
        super(vector.getX(), vector.getY(), vector.getZ(), vector.getW());
    }

    public Vector multiply(Matrix matrix) {
        double resp[] = new double[4];

        resp[0] = getX() * matrix.getValues()[0][0]
                + getY() * matrix.getValues()[1][0]
                + getZ() * matrix.getValues()[2][0]
                + getW() * matrix.getValues()[3][0];

        resp[1] = getX() * matrix.getValues()[0][1]
                + getY() * matrix.getValues()[1][1]
                + getZ() * matrix.getValues()[2][1]
                + getW() * matrix.getValues()[3][1];

        resp[2] = getX() * matrix.getValues()[0][2]
                + getY() * matrix.getValues()[1][2]
                + getZ() * matrix.getValues()[2][2]
                + getW() * matrix.getValues()[3][2];

        resp[3] = getX() * matrix.getValues()[0][3]
                + getY() * matrix.getValues()[1][3]
                + getZ() * matrix.getValues()[2][3]
                + getW() * matrix.getValues()[3][3];

        return new Vector(resp[0], resp[1], resp[2], resp[3]);
    }

    public void multiplyAndSet(Matrix matrix) {
        Vector vector = multiply(matrix);
        setValues(vector);
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof Vector) {
            return super.equals(other);
        }
        return false;
    }
}
