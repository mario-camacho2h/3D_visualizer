/*
 * [Graficacion por Computadora]
 * This was a University project
 * U.M.S.S.
 */
package mario.geometric.linear;

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
    
    @Override
    public boolean equals(Object other) {
        if (other instanceof Vector) {
            return super.equals(other);
        }
        return false;
    }
}
