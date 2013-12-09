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
public class Scaling extends Matrix{
    public Scaling(){
        super(new Vector(1, 0, 0), new Vector(0, 1, 0), new Vector(0, 0, 1));
    }
    public void escalarEnX(double sx){
        setValues(new Vector(sx, 0, 0), new Vector(0, 1, 0), new Vector(0, 0, 1));
    }
    public void escalarEnY(double sy){
        setValues(new Vector(1, 0, 0), new Vector(0, sy, 0), new Vector(0, 0, 1));
    }
    public void escalarEnZ(double sz){
        setValues(new Vector(1, 0, 0), new Vector(0, 1, 0), new Vector(0, 0, sz));
    }
    public void escalarEnElEspacio(double sx, double sy, double sz){
        setValues(new Vector(sx, 0, 0), new Vector(0, sy, 0), new Vector(0, 0, sz));
    }
}
