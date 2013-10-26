package mario.geometric.linear;
import mario.geometric.plane.Figura;
import java.awt.Graphics;
/**
 *
 * @author mario
 */
public class Linea extends Figura {
    private int x2;
    private int y2;
    Graphics g;
    String cadena;
    public Linea(int x,int y,int x2,int y2,String c){
        super(x,y);
        this.x2=x2;
        this.y2=y2;
        cadena=c;
    }
    public Linea(int x,int y,int x2,int y2){
        super(x,y);
        this.x2=x2;
        this.y2=y2;
        cadena="";
    }
    public void setCadena(String cad){
        cadena=cad;
    }
    public double area(){
        return (x2-getX())*(y2-getY());
    }
    public int getx2() {
        return x2;
    }
    public void setx2(int x2) {
        this.x2 = x2;
    }
    public int gety2() {
        return y2;
    }
    public void sety2(int y2) {
        this.y2 = y2;
    }

    @Override
    public  void paint(Graphics gr){
        g=gr;
        g.drawString(cadena, x2, y2);
        //aca debo hacer BRESENHAM.

        int x0,y0,x1,y1;
        x0=getX();
        y0=getY();
        x1=getx2();
        y1=gety2();

        int dx=x1-x0;
        //System.out.println("dx vale: "+dx);
        int dy=y1-y0;
        //System.out.println("dy vale: "+dy);
        if(dx==0 && dy==0){
            dibujarPunto(x1,y1);
        }else{
            if(dx==0){
                if(y0>y1){
                    int x=x0;
                    int y=y0;
                    x0=x1;
                    y0=y1;
                    x1=x;
                    y1=y;
                    //System.out.println("se aha cambiado p0 por p1. p0 ("+x0+","+y0+") y p1("+x1+","+y1+")");
                }
                dibujarLineaParaleloY(x0,y0,x1,y1);
            }else{
                if(dy==0){
                    if(y0>y1){
                        int x=x0;
                        int y=y0;
                        x0=x1;
                        y0=y1;
                        x1=x;
                        y1=y;
                        //System.out.println("se aha cambiado p0 por p1. p0 ("+x0+","+y0+") y p1("+x1+","+y1+")");
                    }
                    dibujarLineaParaleloX(x0,y0,x1,y1);
                }else{
                    double m=new Double(dy)/new Double(dx);
                    //System.out.println("El valor de m es: "+m);
                    if(m>1){
                        if(y0>y1){
                            int x=x0;
                            int y=y0;
                            x0=x1;
                            y0=y1;
                            x1=x;
                            y1=y;
                            dx=-dx;
                            dy=-dy;
                            //System.out.println("se aha cambiado p0 por p1. p0 ("+x0+","+y0+") y p1("+x1+","+y1+")");
                        }
                        drawLineCase1(x0,y0,x1,y1,dx,dy);
                    }else{
                        if(m>0 && m<=1){
                            if(x0>x1){
                                int x=x0;
                                int y=y0;
                                x0=x1;
                                y0=y1;
                                x1=x;
                                y1=y;
                                dx=-dx;
                                dy=-dy;
                                //System.out.println("se aha cambiado p0 por p1. p0 ("+x0+","+y0+") y p1("+x1+","+y1+")");
                            }
                            drawLineCase2(x0,y0,x1,y1,dx,dy);
                        }else{
                            if(m<0 && m>=-1){
                                if(x0>x1){
                                    int x=x0;
                                    int y=y0;
                                    x0=x1;
                                    y0=y1;
                                    x1=x;
                                    y1=y;
                                    dx=-dx;
                                    dy=-dy;
                                    //System.out.println("se aha cambiado p0 por p1. p0 ("+x0+","+y0+") y p1("+x1+","+y1+")");
                                }
                                drawLineCase3(x0,y0,x1,y1,dx,dy);
                            }else{
                                if(y0<y1){
                                    int x=x0;
                                    int y=y0;
                                    x0=x1;
                                    y0=y1;
                                    x1=x;
                                    y1=y;
                                    dx=-dx;
                                    dy=-dy;
                                    //System.out.println("se aha cambiado p0 por p1. p0 ("+x0+","+y0+") y p1("+x1+","+y1+")");
                                }
                                drawLineCase4(x0,y0,x1,y1,dx,dy);
                            }
                        }
                    }
                }
            }
        }
        //aca termina el algoritmo
    }

    private void dibujarLineaParaleloX(int x0, int y0, int x1, int y1) {
        //System.out.println("Ha ingreado al caso PARALELO AL EJE X");
        int x,y;
        x=x0;
        y=y0;
        g.drawLine(x, y, x, y); //equivale a dibujar un pixel en (x,y)
        while(x<x1){
            x=x+1;
            g.drawLine(x, y, x, y); //equivale a dibujar un pixel en (x,y)
        }
    }

    private void dibujarLineaParaleloY(int x0, int y0,int x1,int y1){
       //System.out.println("Ha ingreado al caso PARALELO AL EJE Y");
        int x,y;
        x=x0;
        y=y0;
        g.drawLine(x, y, x, y); //equivale a dibujar un pixel en (x,y)
        while(y<y1){
            y=y+1;
            g.drawLine(x, y, x, y); //equivale a dibujar un pixel en (x,y)
        }
    }

    private void dibujarPunto(int x, int y) {
        //System.out.println("No se trata de una linea, es un punto");
        g.drawLine(x, y, x, y);
    }

    private void drawLineCase1(int x0, int y0, int x1, int y1, int dx, int dy) {
        //System.out.println("Ha ingreado al caso 1");
        int d,dn,dne,x,y;
        d=dy-2*dx;
        dn=-2*dx;
        dne=2*(dy-dx);
        x=x0;
        y=y0;
        g.drawLine(x, y, x, y); //equivale a dibujar un pixel en (x,y)
        while(y<y1){
            if(d<=0){ // NE
                d=d+dne;
                x=x+1;
                y=y+1;
            }else{ // N
                d=d+dn;
                y=y+1;
            }
            g.drawLine(x, y, x, y); //equivale a dibujar un pixel en (x,y)
        }
    }

    private void drawLineCase2(int x0, int y0, int x1, int y1, int dx, int dy) {
        //System.out.println("Ha ingreado al caso 2");
        int d,de,dne,x,y;
        d=2*dy-dx;
        de=2*dy;
        dne=2*(dy-dx);
        x=x0;
        y=y0;
        g.drawLine(x, y, x, y); //equivale a dibujar un pixel en (x,y)
        while(x<x1){
            if(d<=0){  // E
                d=d+de;
                x=x+1;
            }else{  // NE
                d=d+dne;
                x=x+1;
                y=y+1;
            }
            g.drawLine(x, y, x, y); //equivale a dibujar un pixel en (x,y)
        }
    }

    private void drawLineCase3(int x0, int y0, int x1, int y1, int dx, int dy) {
        //System.out.println("Ha ingreado al caso 3");
        int d,de,dse,x,y;
        d=2*dy+dx;
        de=2*dy;
        dse=2*(dy+dx);
        x=x0;
        y=y0;
        g.drawLine(x, y, x, y); //equivale a dibujar un pixel en (x,y)
        while(x<x1){
            if(d<=0){ // SE
                d=d+dse;
                x=x+1;
                y=y-1;
            }else{ // E
                d=d+de;
                x=x+1;
            }
            g.drawLine(x, y, x, y); //equivale a dibujar un pixel en (x,y)
        }
    }

    private void drawLineCase4(int x0, int y0, int x1, int y1, int dx, int dy) {
        //System.out.println("Ha ingreado al caso 4");
        int d,ds,dse,x,y;
        d=dy+2*dx;
        ds=2*dx;
        dse=2*(dy+dx);
        x=x0;
        y=y0;
        g.drawLine(x, y, x, y); //equivale a dibujar un pixel en (x,y)
        while(y>y1){
            if(d<=0){ // S
                d=d+ds;
                y=y-1;
            }else{ // SE
                d=d+dse;
                x=x+1;
                y=y-1;
            }
            g.drawLine(x, y, x, y); //equivale a dibujar un pixel en (x,y)
        }
    }

}