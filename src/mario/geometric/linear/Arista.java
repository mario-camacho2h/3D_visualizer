package mario.geometric.linear;

import java.awt.Graphics;

/**
 *
 * @author mario
 */
public class Arista{
    Vertice ini,fin;
    Linea lin;
    public Arista(Vertice ini2, Vertice fin2){
        ini=ini2;
        fin=fin2;
    }
    public void setIni(Vertice otro){
        ini=otro;
    }
    public void setFin(Vertice otro){
        fin=otro;
    }
    public Vertice getIni(){
        return ini;
    }
    public Vertice getFin(){
        return fin;
    }
    public void paint(int eje,Graphics g,int dx, int dy){
        if(eje==0){
           lin=new Linea((int)Math.round(ini.getZ())-dx, (int)Math.round(770-ini.getY())+dy,(int)Math.round(fin.getZ())-dx, (int)Math.round(770-fin.getY())+dy);
        }else if(eje==1){
            lin=new Linea((int)Math.round(ini.getX())+dx,(int)Math.round(ini.getZ())-dy,(int)Math.round(fin.getX())+dx,(int)Math.round(fin.getZ())-dy);
        }else if(eje==2){
            lin=new Linea((int)Math.round(ini.getX())+dx,(int)Math.round(770-ini.getY())-dy,(int)Math.round(fin.getX())+dx,(int)Math.round(770-fin.getY())-dy);
        }
        lin.paint(g);
    }
    public String toString(){
        return "Vertice ini: "+ini.toString()+" --> fin:"+fin.toString();
    }
}