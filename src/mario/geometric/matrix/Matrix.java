package mario.geometric.matrix;

import mario.geometric.linear.Vertice;
import mario.geometric.linear.Vector;

/**
 *
 * @author Mario
 */
public class Matrix {

    private double valores[][];

    public Matrix(Vector v1, Vector v2, Vector v3, Vector v4) {
        valores = new double[4][4];
        valores[0] = v1.getValues();
        valores[1] = v2.getValues();
        valores[2] = v3.getValues();
        valores[3] = v4.getValues();
    }

    public Matrix(Vector v1, Vector v2, Vector v3) {
        valores = new double[4][4];
        valores[0] = v1.getValues();
        valores[1] = v2.getValues();
        valores[2] = v3.getValues();
        double aux[] = {0, 0, 0, 1};
        valores[3] = aux;
    }

    public void aplicar(Vertice v) {
        double res[] = new double[4];
        res[0] = v.getX() * valores[0][0] + v.getY() * valores[1][0] + v.getZ() * valores[2][0] + v.getW() * valores[3][0];
        res[1] = v.getX() * valores[0][1] + v.getY() * valores[1][1] + v.getZ() * valores[2][1] + v.getW() * valores[3][1];
        res[2] = v.getX() * valores[0][2] + v.getY() * valores[1][2] + v.getZ() * valores[2][2] + v.getW() * valores[3][2];
        res[3] = v.getX() * valores[0][3] + v.getY() * valores[1][3] + v.getZ() * valores[2][3] + v.getW() * valores[3][3];
        v.setX(res[0]);
        v.setY(res[1]);
        v.setZ(res[2]);
        v.setW(res[3]);
    }

    public Vertice aplicar2(Vertice v) {
        double res[] = new double[4];
        res[0] = v.getX() * valores[0][0] + v.getY() * valores[1][0] + v.getZ() * valores[2][0] + v.getW() * valores[3][0];
        res[1] = v.getX() * valores[0][1] + v.getY() * valores[1][1] + v.getZ() * valores[2][1] + v.getW() * valores[3][1];
        res[2] = v.getX() * valores[0][2] + v.getY() * valores[1][2] + v.getZ() * valores[2][2] + v.getW() * valores[3][2];
        res[3] = v.getX() * valores[0][3] + v.getY() * valores[1][3] + v.getZ() * valores[2][3] + v.getW() * valores[3][3];
        Vertice resp = new Vertice(res[0], res[1], res[2], res[3]);
        return resp;
    }

    public void setValores(Vector v1, Vector v2, Vector v3, Vector v4) {
        valores[0] = v1.getValues();
        valores[1] = v2.getValues();
        valores[2] = v3.getValues();
        valores[3] = v4.getValues();
    }

    public void setValores(Vector v1, Vector v2, Vector v3) {
        valores[0] = v1.getValues();
        valores[1] = v2.getValues();
        valores[2] = v3.getValues();
        double aux[] = {0, 0, 0, 1};
        valores[3] = aux;
    }

    public String toString() {
        String cad = "Matriz:\n\t";
        for (int i = 0; i < valores.length; i++) {
            for (int j = 0; j < valores[0].length; j++) {
                cad = cad + valores[i][j] + "\t";
            }
            cad = cad + "\n\t";
        }
        return cad;
    }
}
