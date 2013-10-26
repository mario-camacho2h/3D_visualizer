/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mario.project2A;

import mario.geometric.space.Cubo;
import mario.geometric.matrix.Rotation;
import mario.geometric.matrix.PerspectivProjection;
import mario.geometric.matrix.OrthographicProjection;
import mario.geometric.linear.Vertice;
import mario.geometric.matrix.Scaling;
import mario.geometric.matrix.Translation;
import mario.geometric.matrix.Matrix;
import mario.geometric.linear.Vector;

/**
 *
 * @author Mario
 */
public class Pruebas {
    public static void main(String mario[]){
        Matrix m=new Matrix(new Vector(1, 0, 0), new Vector(0, 1, 0), new Vector(0, 0, 1));
        Matrix k=new Matrix(new Vector(0.5, 0, 0), new Vector(0, 0.5, 0), new Vector(0, 0, 2));
        Matrix n=new Matrix(new Vector(0, 0, 0), new Vector(0, 1, 0), new Vector(0, 0, 1));

        Vertice v=new Vertice(10, 20, 30);

        System.out.println(v.toString());
        m.aplicar(v);
        System.out.println(v.toString());
        k.aplicar(v);
        System.out.println(v.toString());
        n.aplicar(v);
        System.out.println(v.toString());
        m.setValores(new Vector(1, 1, 1), new Vector(1, 1, 1), new Vector(1, 1, 1));
        m.aplicar(v);
        System.out.println(v.toString());

        OrthographicProjection mpo=new OrthographicProjection();
        mpo.establecerProyX();
        mpo.aplicar(v);
        System.out.println(v.toString());
        mpo.establecerProyY();
        mpo.aplicar(v);
        System.out.println(v.toString()); //Matriz de proyeccion ortografica OK

        v.setX(2);
        v.setY(3);
        v.setZ(1);
        System.out.println(v.toString());

        Translation mt=new Translation();
        mt.trasladarEnX(5);
        mt.aplicar(v);
        System.out.println(v.toString());
        mt.trasladarEnElEspacio(-7, -3, -10);
        mt.aplicar(v);
        System.out.println(v.toString()); //Matriz de traslacion OK

        Rotation mr=new Rotation();
        mr.establecerRotacionZ();
        /*mr.aplicar(v);
        System.out.println(v.toString());
        mr.aplicar(v);
        System.out.println(v.toString());*/ //Matriz de rotacion OK

        /*System.out.println(mt.toString());
        Vector vm=new Vector(1, 2, 3);
        vm.multiplicar(100);
        System.out.println(vm.toString());
        vm.dividir(10);
        System.out.println(vm.toString());*/

        PerspectivProjection mpp=new PerspectivProjection(30);
        mpp.establecerProyZ();
        mt.trasladarEnElEspacio(10, 20, 110);

        Scaling ms=new Scaling();
        ms.escalarEnElEspacio(2, 2, 2);

        System.out.println("COMENZAMOS CON LOS CUERPOS...para escalar y rotar llevar primero al origen");

        Cubo cu=new Cubo();
        cu.crearUnCuerpo();
        Vertice aux=new Vertice(0, 0, 0);
        aux.copiar(cu.getCentroMasa());
        mt.trasladarEnElEspacio(-aux.getX(),-aux.getY(),-aux.getZ());
        cu.aplicarMatriz(mt); //lleva al origen
        cu.aplicarMatriz(ms); //escala
        mt.trasladarEnElEspacio(aux.getX(), aux.getY(), aux.getZ());
        cu.aplicarMatriz(mt);  //lleva al punto original
        mt.trasladarEnElEspacio(15, 15, 60);
        cu.aplicarMatriz(mt);
        System.out.println("Este es el centro: "+aux.toString());
        //cu.aplicarMatriz(mpp);
        cu.mostrarse();

        cu.aplicarMatriz(mpp);
        System.out.println("Proyectamos en perspectiva sobre z");
        System.out.println("Este es el centro: "+aux.toString());
        cu.mostrarse();
    }
}
