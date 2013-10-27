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
public abstract class Tupla {
    
    protected static final String POINT_FORMAT = "(x,y,z):(%s,%s,%s) %s";
    protected static final String TUPLA_FORMAT = "(x,y,z,w):(%s,%s,%s,%s)";
    protected static final String POINT_VALUE = "POINT";
    protected static final String VECTOR_VALUE = "VECTOR";
    private double values[];
    
    public Tupla(double x, double y, double z, double w) {
        values = new double[4];
        values[0] = x;
        values[1] = y;
        values[2] = z;
        values[3] = w;
    }
    
    public void setX(double x) {
        values[0] = x;
    }
    
    public void setY(double y) {
        values[1] = y;
    }
    
    public void setZ(double z) {
        values[2] = z;
    }
    
    public void setW(double w) {
        values[3] = w;
    }
    
    public double getX() {
        return values[0];
    }
    
    public double getY() {
        return values[1];
    }
    
    public double getZ() {
        return values[2];
    }
    
    public double getW() {
        return values[3];
    }
    
    public void setValues(Tupla tupla) {
        for (int i = 0; i < values.length; i++) {
            values[i] = tupla.getValues()[i];
        }
    }
    
    public double[] getValues() {
        return values;
    }
    
    public void multipliedBy(double k) {
        for (int i = 0; i < values.length; i++) {
            values[i] = values[i] * k;
        }
    }
    
    public Vertice multiply(Matrix matrix) {
        double res[] = new double[4];
        
        res[0] = getX() * matrix.getValues()[0][0]
                + getY() * matrix.getValues()[1][0]
                + getZ() * matrix.getValues()[2][0]
                + getW() * matrix.getValues()[3][0];
        
        res[1] = getX() * matrix.getValues()[0][1]
                + getY() * matrix.getValues()[1][1]
                + getZ() * matrix.getValues()[2][1]
                + getW() * matrix.getValues()[3][1];
        
        res[2] = getX() * matrix.getValues()[0][2]
                + getY() * matrix.getValues()[1][2]
                + getZ() * matrix.getValues()[2][2]
                + getW() * matrix.getValues()[3][2];
        
        res[3] = getX() * matrix.getValues()[0][3]
                + getY() * matrix.getValues()[1][3]
                + getZ() * matrix.getValues()[2][3]
                + getW() * matrix.getValues()[3][3];
        
        return new Vertice(res[0], res[1], res[2], res[3]);
    }
    
    public void multiplyAndSet(Matrix matrix) {
        Vertice vertice = multiply(matrix);
        setValues(vertice);
    }
    
    public void dividedBy(double k) {
        for (int i = 0; i < values.length; i++) {
            values[i] = values[i] / k;
        }
    }
    
    @Override
    public String toString() {
        if (values[3] == 1) {
            return String.format(POINT_FORMAT, values[0], values[1], values[2], POINT_VALUE);
        } else {
            if (values[3] == 0) {
                return String.format(POINT_FORMAT, values[0], values[1], values[2], VECTOR_VALUE);
            } else {
                return String.format(TUPLA_FORMAT, values[0], values[1], values[2]);
            }
        }
    }
    
    @Override
    public boolean equals(Object other) {
        if (other instanceof Tupla) {
            Tupla tupla = (Tupla) other;
            return getX() == tupla.getX() && getY() == tupla.getY()
                    && getZ() == tupla.getZ() && getW() == tupla.getW();
        }
        return false;
    }
}
