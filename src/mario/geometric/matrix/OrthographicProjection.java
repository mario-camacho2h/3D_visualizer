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
public class OrthographicProjection extends Matrix{
    public OrthographicProjection(){
        super(new Vector(1, 0, 0), new Vector(0, 1, 0), new Vector(0, 0, 1));
    }
    public void establecerProyX(){
        setValues(new Vector(0, 0, 0), new Vector(0, 1, 0), new Vector(0, 0, 1));
    }
    public void establecerProyY(){
        setValues(new Vector(1, 0, 0), new Vector(0, 0, 0), new Vector(0, 0, 1));
    }
    public void establecerProyZ(){
        setValues(new Vector(1, 0, 0), new Vector(0, 1, 0), new Vector(0, 0, 0));
    }
}
