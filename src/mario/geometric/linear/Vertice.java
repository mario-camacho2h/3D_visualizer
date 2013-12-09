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
public class Vertice extends Tupla {

    public Vertice(double x1, double y1, double z1) {
        super(x1, y1, z1, 1);
    }

    public Vertice(double x1, double y1, double z1, double w1) {
        super(x1, y1, z1, w1);
    }
    
    @Override
    public boolean equals(Object other) {
        if (other instanceof Vertice) {
            return super.equals(other);
        }
        return false;
    }
}
