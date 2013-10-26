package mario.geometric.plane;

import mario.geometric.linear.Arista;

/**
 *
 * @author Mario
 */
public class Poligono {

    private Arista a1, a2, a3, a4;

    public Poligono(Arista a11, Arista a22, Arista a33) {
        a1 = a11;
        a2 = a22;
        a3 = a33;
    }

    public Poligono(Arista a11, Arista a22, Arista a33, Arista a44) {
        a1 = a11;
        a2 = a22;
        a3 = a33;
        a4 = a44;
    }

    public void setA1(Arista a11) {
        a1 = a11;
    }

    public void setA2(Arista a22) {
        a2 = a22;
    }

    public void setA3(Arista a33) {
        a3 = a33;
    }

    public void setA4(Arista a44) {
        a4 = a44;
    }

    public Arista getA1() {
        return a1;
    }

    public Arista getA2() {
        return a2;
    }

    public Arista getA3() {
        return a3;
    }

    public Arista getA4() {
        return a4;
    }

    public String toString() {
        if (a4 == null) {
            return "Poligono:\n" + a1.toString() + "\n" + a2.toString() + "\n" + a3.toString() + "\n";
        } else {
            return "Poligono:\n" + a1.toString() + "\n" + a2.toString() + "\n" + a3.toString() + "\n" + a4.toString() + "\n";
        }
    }
}
