package mario.geometric.linear;

import mario.geometric.linear.Tupla;

/**
 *
 * @author Mario
 */
public class Vertice extends Tupla{
    public Vertice(double x1,double y1, double z1){ //antes eran enteros
        super(x1,y1,z1,1);
    }
    public Vertice(double x1,double y1, double z1, double w1){ //antes eran enteros
        super(x1,y1,z1,w1);
    }
}
