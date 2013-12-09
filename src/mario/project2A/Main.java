/*
 * [Graficacion por Computadora]
 * This was a University project
 * U.M.S.S.
 */
package mario.project2A;

import mario.geometric.plane.Poligono;
import mario.geometric.space.Cuerpo;
import mario.geometric.linear.Vertice;
import mario.geometric.linear.Arista;

/**
 *
 * @author Mario
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Cuerpo figura = new Cuerpo();

        figura.getVertices().add(new Vertice(0, 0, 0)); //0
        figura.getVertices().add(new Vertice(5, 0, 0)); //1
        figura.getVertices().add(new Vertice(5, 5, 0)); //2
        figura.getVertices().add(new Vertice(0, 5, 0)); //3
        figura.getVertices().add(new Vertice(0, 0, 5)); //4
        figura.getVertices().add(new Vertice(5, 0, 5)); //5
        figura.getVertices().add(new Vertice(5, 5, 5)); //6
        figura.getVertices().add(new Vertice(0, 5, 5)); //7

        figura.getAristas().add(new Arista(figura.getVertices().get(0), figura.getVertices().get(1))); //un cuadrado
        figura.getAristas().add(new Arista(figura.getVertices().get(1), figura.getVertices().get(2)));
        figura.getAristas().add(new Arista(figura.getVertices().get(2), figura.getVertices().get(3)));
        figura.getAristas().add(new Arista(figura.getVertices().get(3), figura.getVertices().get(0)));

        figura.getAristas().add(new Arista(figura.getVertices().get(4), figura.getVertices().get(5))); //otro cuadrado, parte posterior
        figura.getAristas().add(new Arista(figura.getVertices().get(5), figura.getVertices().get(6)));
        figura.getAristas().add(new Arista(figura.getVertices().get(6), figura.getVertices().get(7)));
        figura.getAristas().add(new Arista(figura.getVertices().get(7), figura.getVertices().get(4)));

        figura.getAristas().add(new Arista(figura.getVertices().get(0), figura.getVertices().get(4))); //las lineas k forman el cubo.
        figura.getAristas().add(new Arista(figura.getVertices().get(1), figura.getVertices().get(5)));
        figura.getAristas().add(new Arista(figura.getVertices().get(2), figura.getVertices().get(6)));
        figura.getAristas().add(new Arista(figura.getVertices().get(3), figura.getVertices().get(7)));

        figura.getPoligonos().add(new Poligono(
                figura.getAristas().get(0), 
                figura.getAristas().get(1), 
                figura.getAristas().get(2), 
                figura.getAristas().get(3)));
        figura.getPoligonos().add(new Poligono(
                figura.getAristas().get(1), 
                figura.getAristas().get(5), 
                figura.getAristas().get(9), 
                figura.getAristas().get(10)));

        figura.getPoligonos().add(new Poligono(
                figura.getAristas().get(2), 
                figura.getAristas().get(6), 
                figura.getAristas().get(10), 
                figura.getAristas().get(11)));
        figura.getPoligonos().add(new Poligono(
                figura.getAristas().get(0), 
                figura.getAristas().get(4), 
                figura.getAristas().get(8), 
                figura.getAristas().get(9)));

        figura.getPoligonos().add(new Poligono(
                figura.getAristas().get(3), 
                figura.getAristas().get(7), 
                figura.getAristas().get(8), 
                figura.getAristas().get(11)));
        figura.getPoligonos().add(new Poligono(
                figura.getAristas().get(4), 
                figura.getAristas().get(5), 
                figura.getAristas().get(6), 
                figura.getAristas().get(7)));

        figura.setCentroMasa(new Vertice(2.5, 2.5, 2.5));

        System.out.println(figura.getPoligonos().get(4).toString());
    }
}
