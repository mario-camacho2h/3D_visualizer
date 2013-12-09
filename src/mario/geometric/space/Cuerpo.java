/*
 * [Graficacion por Computadora]
 * This was a University project
 * U.M.S.S.
 */
package mario.geometric.space;

import mario.geometric.plane.Poligono;
import mario.geometric.matrix.Rotation;
import mario.geometric.matrix.OrthographicProjection;
import mario.geometric.matrix.PerspectivProjection;
import mario.geometric.linear.Vertice;
import mario.geometric.matrix.Scaling;
import mario.geometric.matrix.Translation;
import mario.geometric.matrix.Matrix;
import mario.geometric.linear.Arista;
import mario.pattern.prototype.ClonableBody;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mario
 */
public class Cuerpo implements ClonableBody {

    private List<Vertice> vertices;
    private List<Arista> aristas;
    private List<Poligono> poligonos;
    private Vertice centroMasa;
    private OrthographicProjection orthographicProjectionMatrix;
    private PerspectivProjection perspectivProjectionMatrix;
    private Rotation rotationMatrix;
    private Scaling scalingMatrix;
    private Translation translationMatrix;
    int[][] estructuraAristas;

    public Cuerpo() {
        vertices = new ArrayList<Vertice>();
        aristas = new ArrayList<Arista>();
        poligonos = new ArrayList<Poligono>();

        centroMasa = new Vertice(0, 0, 0);

        orthographicProjectionMatrix = new OrthographicProjection();
        perspectivProjectionMatrix = new PerspectivProjection(25);
        rotationMatrix = new Rotation();
        scalingMatrix = new Scaling();
        translationMatrix = new Translation();
    }

    public void setCentroMasa(Vertice v2) {
        centroMasa = v2;
    }

    public Vertice getCentroMasa() {
        return centroMasa;
    }

    public List<Arista> getAristas() {
        return aristas;
    }

    public List<Vertice> getVertices() {
        return vertices;
    }

    public List<Poligono> getPoligonos() {
        return poligonos;
    }

    public void aplicarMatriz(Matrix m) {
        for (int i = 0; i < vertices.size(); i++) {
            m.applyAndSet(vertices.get(i));
        }
        m.applyAndSet(centroMasa);
    }

    public Cuerpo aplicarMatriz2(Matrix m) {
        Cuerpo copy = new Cuerpo();
        for (int i = 0; i < vertices.size(); i++) {
            Vertice aux = m.apply(vertices.get(i));
            //System.out.println(aux.toString());//******************************+ TODO OK
            copy.vertices.add(aux);
        }
        copy.setCentroMasa(m.apply(centroMasa));
        return copy;
    }

    public void moverEspacio(double x, double y, double z) {
        translationMatrix.trasladarEnElEspacio(x, y, z);
        aplicarMatriz(translationMatrix);
    }

    public void dibujarsePersp(int persp, Graphics g) {
        Cuerpo res = new Cuerpo();
        switch (persp) {
            case 0:
                perspectivProjectionMatrix.establecerProyX();
                break;
            case 1:
                perspectivProjectionMatrix.establecerProyY();
                break;
            case 2:
                perspectivProjectionMatrix.establecerProyZ();
                break;
        }
        try {
            res = (Cuerpo) this.duplicate();
            res.aplicarMatriz(perspectivProjectionMatrix);
        } catch (Exception e) {
            System.out.println("No se pudo realizar la operacion requerida");
        }
    }

    public void dibujarse(Graphics g) {

        orthographicProjectionMatrix.establecerProyX();
        Cuerpo clon = aplicarMatriz2(orthographicProjectionMatrix);
        clon.setEstructuraAristas(getEstructuraAristas());
        clon.reformarAristas(); //esto corrije la refernecia a los vertices del cubo original
        clon.paint(0, g, 140, -630);
        g.drawString("Proyección Ortográfica sobre el plano YZ", 100, 230);
        g.drawString("CARA LATERAL DEL CUERPO GEOMETRICO", 90, 245);

        orthographicProjectionMatrix.establecerProyY();
        Cuerpo clon2 = aplicarMatriz2(orthographicProjectionMatrix);
        clon2.setEstructuraAristas(getEstructuraAristas());
        clon2.reformarAristas(); //esto corrije la refernecia a los vertices del cubo original
        clon2.paint(1, g, 210, 0);
        g.drawString("Proyección Ortográfica sobre el plano XZ", 100, 480);
        g.drawString("CARA SUPERIOR DEL CUERPO GEOMETRICO", 90, 495);

        orthographicProjectionMatrix.establecerProyZ();
        Cuerpo clon3 = aplicarMatriz2(orthographicProjectionMatrix);
        clon3.setEstructuraAristas(getEstructuraAristas());
        clon3.reformarAristas(); //esto corrije la refernecia a los vertices del cubo original
        clon3.paint(2, g, 210, 140);
        g.drawString("Proyección Ortográfica sobre el plano XY", 100, 730);
        g.drawString("CARA FRONTAL DEL CUERPO GEOMETRICO", 93, 745);
    }

    public Cuerpo proyectarseEnPerspectiva() {
        perspectivProjectionMatrix.setDistancia(70);
        perspectivProjectionMatrix.establecerProyZ();
        scalingMatrix.escalarEnElEspacio(8, 8, 8);
        Cuerpo clonp = aplicarMatriz2(perspectivProjectionMatrix);
        clonp.setEstructuraAristas(getEstructuraAristas());
        clonp.reformarAristas(); //esto corrije la refernecia a los vertices del cubo original
        clonp.aplicarMatriz(scalingMatrix);
        return clonp;
    }

    public void dibujate(Graphics g) {
        paint(2, g, 800, 380);
        g.drawString("Proyección en Persepctiva a 30 pixeles del plano XY", 665, 600);
        g.drawString("CARA FRONTAL CON PERSPECTIVA", 705, 615);
    }

    public void scalarEspacio(boolean crecer) {
        if (crecer) {
            scalingMatrix.escalarEnElEspacio(1.2, 1.2, 1.2);
            Vertice aux = new Vertice(0, 0, 0);
            aux.setValues(getCentroMasa());
            translationMatrix.trasladarEnElEspacio(-aux.getX(), -aux.getY(), -aux.getZ());
            aplicarMatriz(translationMatrix); //lleva al origen
            aplicarMatriz(scalingMatrix); //escala
            translationMatrix.trasladarEnElEspacio(aux.getX(), aux.getY(), aux.getZ());
            aplicarMatriz(translationMatrix);  //lleva al punto original
        } else {
            scalingMatrix.escalarEnElEspacio(0.8, 0.8, 0.8);
            Vertice aux = new Vertice(0, 0, 0);
            aux.setValues(getCentroMasa());
            translationMatrix.trasladarEnElEspacio(-aux.getX(), -aux.getY(), -aux.getZ());
            aplicarMatriz(translationMatrix); //lleva al origen
            aplicarMatriz(scalingMatrix); //escala
            translationMatrix.trasladarEnElEspacio(aux.getX(), aux.getY(), aux.getZ());
            aplicarMatriz(translationMatrix);  //lleva al punto original
        }
    }

    public void scalarX(boolean crecer) {
        if (crecer) {
            scalingMatrix.escalarEnElEspacio(1.2, 1, 1);
            Vertice aux = new Vertice(0, 0, 0);
            aux.setValues(getCentroMasa());
            translationMatrix.trasladarEnElEspacio(-aux.getX(), -aux.getY(), -aux.getZ());
            aplicarMatriz(translationMatrix); //lleva al origen
            aplicarMatriz(scalingMatrix); //escala
            translationMatrix.trasladarEnElEspacio(aux.getX(), aux.getY(), aux.getZ());
            aplicarMatriz(translationMatrix);  //lleva al punto original
        } else {
            scalingMatrix.escalarEnElEspacio(0.8, 1, 1);
            Vertice aux = new Vertice(0, 0, 0);
            aux.setValues(getCentroMasa());
            translationMatrix.trasladarEnElEspacio(-aux.getX(), -aux.getY(), -aux.getZ());
            aplicarMatriz(translationMatrix); //lleva al origen
            aplicarMatriz(scalingMatrix); //escala
            translationMatrix.trasladarEnElEspacio(aux.getX(), aux.getY(), aux.getZ());
            aplicarMatriz(translationMatrix);  //lleva al punto original
        }
    }

    public void scalarY(boolean crecer) {
        if (crecer) {
            scalingMatrix.escalarEnElEspacio(1, 1.2, 1);
            Vertice aux = new Vertice(0, 0, 0);
            aux.setValues(getCentroMasa());
            translationMatrix.trasladarEnElEspacio(-aux.getX(), -aux.getY(), -aux.getZ());
            aplicarMatriz(translationMatrix); //lleva al origen
            aplicarMatriz(scalingMatrix); //escala
            translationMatrix.trasladarEnElEspacio(aux.getX(), aux.getY(), aux.getZ());
            aplicarMatriz(translationMatrix);  //lleva al punto original
        } else {
            scalingMatrix.escalarEnElEspacio(1, 0.8, 1);
            Vertice aux = new Vertice(0, 0, 0);
            aux.setValues(getCentroMasa());
            translationMatrix.trasladarEnElEspacio(-aux.getX(), -aux.getY(), -aux.getZ());
            aplicarMatriz(translationMatrix); //lleva al origen
            aplicarMatriz(scalingMatrix); //escala
            translationMatrix.trasladarEnElEspacio(aux.getX(), aux.getY(), aux.getZ());
            aplicarMatriz(translationMatrix);  //lleva al punto original
        }
    }

    public void scalarZ(boolean crecer) {
        if (crecer) {
            scalingMatrix.escalarEnElEspacio(1, 1, 1.2);
            Vertice aux = new Vertice(0, 0, 0);
            aux.setValues(getCentroMasa());
            translationMatrix.trasladarEnElEspacio(-aux.getX(), -aux.getY(), -aux.getZ());
            aplicarMatriz(translationMatrix); //lleva al origen
            aplicarMatriz(scalingMatrix); //escala
            translationMatrix.trasladarEnElEspacio(aux.getX(), aux.getY(), aux.getZ());
            aplicarMatriz(translationMatrix);  //lleva al punto original
        } else {
            scalingMatrix.escalarEnElEspacio(1, 1, 0.8);
            Vertice aux = new Vertice(0, 0, 0);
            aux.setValues(getCentroMasa());
            translationMatrix.trasladarEnElEspacio(-aux.getX(), -aux.getY(), -aux.getZ());
            aplicarMatriz(translationMatrix); //lleva al origen
            aplicarMatriz(scalingMatrix); //escala
            translationMatrix.trasladarEnElEspacio(aux.getX(), aux.getY(), aux.getZ());
            aplicarMatriz(translationMatrix);  //lleva al punto original
        }
    }

    public void moverX(boolean positivo) {
        if (positivo) {
            translationMatrix.trasladarEnElEspacio(3, 0, 0);
            aplicarMatriz(translationMatrix);
        } else {
            translationMatrix.trasladarEnElEspacio(-3, 0, 0);
            aplicarMatriz(translationMatrix);
        }
    }

    public void moverY(boolean positivo) {
        if (positivo) {
            translationMatrix.trasladarEnElEspacio(0, 3, 0);
            aplicarMatriz(translationMatrix);
        } else {
            translationMatrix.trasladarEnElEspacio(0, -3, 0);
            aplicarMatriz(translationMatrix);
        }
    }

    public void moverZ(boolean positivo) {
        if (positivo) {
            translationMatrix.trasladarEnElEspacio(0, 0, 3);
            aplicarMatriz(translationMatrix);
        } else {
            translationMatrix.trasladarEnElEspacio(0, 0, -3);
            aplicarMatriz(translationMatrix);
        }
    }

    private void paint(int persp, Graphics g, int dx, int dy) {
        for (int i = 0; i < aristas.size(); i++) {
            aristas.get(i).paint(persp, g, dx, dy);
        }
    }

    public void rotarX(boolean positivo) {
        if (positivo) {
            rotationMatrix.setAngle(Math.abs(rotationMatrix.getAngle()));
            rotationMatrix.setRotationAxisAsX();
            Vertice aux = new Vertice(0, 0, 0);
            aux.setValues(getCentroMasa());
            translationMatrix.trasladarEnElEspacio(-aux.getX(), -aux.getY(), -aux.getZ());
            aplicarMatriz(translationMatrix); //lleva al origen
            aplicarMatriz(rotationMatrix); //escala
            translationMatrix.trasladarEnElEspacio(aux.getX(), aux.getY(), aux.getZ());
            aplicarMatriz(translationMatrix);  //lleva al punto original
        } else {
            rotationMatrix.setAngle(-Math.abs(rotationMatrix.getAngle()));
            rotationMatrix.setRotationAxisAsX();
            Vertice aux = new Vertice(0, 0, 0);
            aux.setValues(getCentroMasa());
            translationMatrix.trasladarEnElEspacio(-aux.getX(), -aux.getY(), -aux.getZ());
            aplicarMatriz(translationMatrix); //lleva al origen
            aplicarMatriz(rotationMatrix); //escala
            translationMatrix.trasladarEnElEspacio(aux.getX(), aux.getY(), aux.getZ());
            aplicarMatriz(translationMatrix);  //lleva al punto original
        }
    }

    public void rotarY(boolean positivo) {
        if (positivo) {
            rotationMatrix.setAngle(Math.abs(rotationMatrix.getAngle()));
            rotationMatrix.setRotationAxisAsY();
            Vertice aux = new Vertice(0, 0, 0);
            aux.setValues(getCentroMasa());
            translationMatrix.trasladarEnElEspacio(-aux.getX(), -aux.getY(), -aux.getZ());
            aplicarMatriz(translationMatrix); //lleva al origen
            aplicarMatriz(rotationMatrix); //escala
            translationMatrix.trasladarEnElEspacio(aux.getX(), aux.getY(), aux.getZ());
            aplicarMatriz(translationMatrix);  //lleva al punto original
        } else {
            rotationMatrix.setAngle(-Math.abs(rotationMatrix.getAngle()));
            rotationMatrix.setRotationAxisAsY();
            Vertice aux = new Vertice(0, 0, 0);
            aux.setValues(getCentroMasa());
            translationMatrix.trasladarEnElEspacio(-aux.getX(), -aux.getY(), -aux.getZ());
            aplicarMatriz(translationMatrix); //lleva al origen
            aplicarMatriz(rotationMatrix); //escala
            translationMatrix.trasladarEnElEspacio(aux.getX(), aux.getY(), aux.getZ());
            aplicarMatriz(translationMatrix);  //lleva al punto original
        }
    }

    public void rotarZ(boolean positivo) {
        if (positivo) {
            rotationMatrix.setAngle(Math.abs(rotationMatrix.getAngle()));
            rotationMatrix.setRotationAxisAsZ();
            Vertice aux = new Vertice(0, 0, 0);
            aux.setValues(getCentroMasa());
            translationMatrix.trasladarEnElEspacio(-aux.getX(), -aux.getY(), -aux.getZ());
            aplicarMatriz(translationMatrix); //lleva al origen
            aplicarMatriz(rotationMatrix); //escala
            translationMatrix.trasladarEnElEspacio(aux.getX(), aux.getY(), aux.getZ());
            aplicarMatriz(translationMatrix);  //lleva al punto original
        } else {
            rotationMatrix.setAngle(-Math.abs(rotationMatrix.getAngle()));
            rotationMatrix.setRotationAxisAsZ();
            Vertice aux = new Vertice(0, 0, 0);
            aux.setValues(getCentroMasa());
            translationMatrix.trasladarEnElEspacio(-aux.getX(), -aux.getY(), -aux.getZ());
            aplicarMatriz(translationMatrix); //lleva al origen
            aplicarMatriz(rotationMatrix); //escala
            translationMatrix.trasladarEnElEspacio(aux.getX(), aux.getY(), aux.getZ());
            aplicarMatriz(translationMatrix);  //lleva al punto original
        }
    }

    public ClonableBody duplicate() {
        ClonableBody returnValue = null;
        try {
            returnValue = (ClonableBody) super.clone();
        } catch (Exception e) {
            System.out.println("Error al clonar el cuerpo");
        }
        return returnValue;
    }

    public void mostrarse() {
        for (int i = 0; i < vertices.size(); i++) {
            System.out.println(vertices.get(i).toString());
        }
    }

    protected void formarAristas() {
        for (int j = 0; j < 16; j++) {
            aristas.add(
                    new Arista(vertices.get(estructuraAristas[j][0]), vertices.get(estructuraAristas[j][1])));
        }
    }

    public void reformarAristas() {
        formarAristas();
    }

    public int[][] getEstructuraAristas() {
        return estructuraAristas;
    }

    public void setEstructuraAristas(int[][] a) {
        estructuraAristas = a;
    }
}