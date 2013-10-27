package mario.geometric.matrix;

import mario.geometric.linear.Vertice;
import mario.geometric.linear.Vector;

/**
 *
 * @author Mario
 */
public class Matrix {

    private double values[][];

    public Matrix(Vector v1, Vector v2, Vector v3, Vector v4) {
        values = new double[4][4];
        values[0] = v1.getValues();
        values[1] = v2.getValues();
        values[2] = v3.getValues();
        values[3] = v4.getValues();
    }

    public Matrix(Vector v1, Vector v2, Vector v3) {
        values = new double[4][4];
        values[0] = v1.getValues();
        values[1] = v2.getValues();
        values[2] = v3.getValues();
        values[3] = new Vector(0, 0, 0, 1).getValues();
    }

    public Vertice apply(Vertice vertex) {
        double resp[] = new double[4];

        resp[0] = vertex.getX() * values[0][0]
                + vertex.getY() * values[1][0]
                + vertex.getZ() * values[2][0]
                + vertex.getW() * values[3][0];

        resp[1] = vertex.getX() * values[0][1]
                + vertex.getY() * values[1][1]
                + vertex.getZ() * values[2][1]
                + vertex.getW() * values[3][1];

        resp[2] = vertex.getX() * values[0][2]
                + vertex.getY() * values[1][2]
                + vertex.getZ() * values[2][2]
                + vertex.getW() * values[3][2];

        resp[3] = vertex.getX() * values[0][3]
                + vertex.getY() * values[1][3]
                + vertex.getZ() * values[2][3]
                + vertex.getW() * values[3][3];

        return new Vertice(resp[0], resp[1], resp[2], resp[3]);
    }

    public void applyAndSet(Vertice vertex) {
        vertex.setValues(apply(vertex));
    }

    public double[][] getValues() {
        return values;
    }

    public void setValues(Vector v1, Vector v2, Vector v3) {
        setValues(v1, v2, v3, new Vector(0, 0, 0, 1));
    }

    public void setValues(Vector v1, Vector v2, Vector v3, Vector v4) {
        values[0] = v1.getValues();
        values[1] = v2.getValues();
        values[2] = v3.getValues();
        values[3] = v4.getValues();
    }

    @Override
    public String toString() {
        String cad = "Matriz:\n\t";
        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < values[0].length; j++) {
                cad = cad + values[i][j] + "\t";
            }
            cad = cad + "\n\t";
        }
        return cad;
    }
}
