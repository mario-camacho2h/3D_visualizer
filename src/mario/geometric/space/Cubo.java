/*
 * [Graficacion por Computadora]
 * This was a University project
 * U.M.S.S.
 */
package mario.geometric.space;

import mario.geometric.linear.Vertice;

/**
 *
 * @author mario
 */
public class Cubo extends Cuerpo {

    public Cubo() {
        super();
        estructuraAristas = new int[16][2];
        estructuraAristas[0][0] = 0; //un cuadrado
        estructuraAristas[0][1] = 1; 
        estructuraAristas[1][0] = 1;
        estructuraAristas[1][1] = 2;
        estructuraAristas[2][0] = 2;
        estructuraAristas[2][1] = 3;
        estructuraAristas[3][0] = 0;
        estructuraAristas[3][1] = 3;

        estructuraAristas[4][0] = 4; //otro cuadrado parte posterior
        estructuraAristas[4][1] = 5; 
        estructuraAristas[5][0] = 5;
        estructuraAristas[5][1] = 6;
        estructuraAristas[6][0] = 6;
        estructuraAristas[6][1] = 7;
        estructuraAristas[7][0] = 4;
        estructuraAristas[7][1] = 7;

        estructuraAristas[8][0] = 0; //las lineas k unen los dos cuadrados
        estructuraAristas[8][1] = 4; 
        estructuraAristas[9][0] = 1;
        estructuraAristas[9][1] = 5;
        estructuraAristas[10][0] = 2;
        estructuraAristas[10][1] = 6;
        estructuraAristas[11][0] = 3;
        estructuraAristas[11][1] = 7;

        estructuraAristas[12][0] = 1; //las lineas k forman la cupula
        estructuraAristas[12][1] = 8; 
        estructuraAristas[13][0] = 2;
        estructuraAristas[13][1] = 8;
        estructuraAristas[14][0] = 5;
        estructuraAristas[14][1] = 8;
        estructuraAristas[15][0] = 6;
        estructuraAristas[15][1] = 8;
    }

    public void createVertices() {
        getVertices().add(new Vertice(-50, -50, 300)); //0
        getVertices().add(new Vertice(-50, 50, 300)); //1
        getVertices().add(new Vertice(50, 50, 300)); //2
        getVertices().add(new Vertice(50, -50, 300)); //3
        getVertices().add(new Vertice(-50, -50, 400)); //4
        getVertices().add(new Vertice(-50, 50, 400)); //5
        getVertices().add(new Vertice(50, 50, 400)); //6
        getVertices().add(new Vertice(50, -50, 400)); //7
        getVertices().add(new Vertice(0, 100, 350)); //8 punta superior

        formarAristas();
        setCentroMasa(new Vertice(0, 0, 350));
    }
}