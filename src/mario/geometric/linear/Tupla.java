package mario.geometric.linear;
/**
 *
 * @author Mario
 */
public abstract class Tupla {
    private double valores[];
    public Tupla(double x2, double y2, double z2, double w2){
        valores=new double[4];
        valores[0]=x2;
        valores[1]=y2;
        valores[2]=z2;
        valores[3]=w2;
    }
    public void setX(double x1){
        valores[0]=x1;
    }
    public void setY(double y1){
        valores[1]=y1;
    }
    public void setZ(double z1){
        valores[2]=z1;
    }
    public void setW(double w1){
        valores[3]=w1;
    }
    public double getX(){
        return valores[0];
    }
    public double getY(){
        return valores[1];
    }
    public double getZ(){
        return valores[2];
    }
    public double getW(){
        return valores[3];
    }
    public double[] getValores(){
        return valores;
    }
    public void multiplicar(double k){
        for(int i=0;i<valores.length;i++){
            valores[i]=valores[i]*k;
        }
    }
    public void dividir(double k){
        for(int i=0;i<valores.length;i++){
            valores[i]=valores[i]/k;
        }
    }
    public void copiar(Tupla t){
        for(int i=0;i<valores.length;i++){
            valores[i]=t.getValores()[i];
        }
    }
    @Override
    public String toString(){
        String res;
        if(valores[3]==1){
            res= "X="+valores[0]+"\t Y="+valores[1]+"\t Z="+valores[2]+"\t POINT";
        }else{
            if(valores[3]==0){
                res= "X="+valores[0]+"\t Y="+valores[1]+"\t Z="+valores[2]+"\t VECTOR";
            }else{
                res= "X="+valores[0]+"\t Y="+valores[1]+"\t Z="+valores[2]+"\t W="+valores[3];
            }
        }
        return res;
    }
}
