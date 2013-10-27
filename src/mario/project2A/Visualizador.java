package mario.project2A;

import mario.geometric.space.Cuerpo;
import mario.geometric.space.Cubo;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
/**
 *
 * @author mario
 */
public class Visualizador extends JFrame implements WindowListener,ActionListener,KeyListener{
   JPanel panel=new JPanel();
   Timer timer=new Timer(100,this);
   Graphics g;
   Image img;
   Cubo cube1;
   final int X_PERSP=0, Y_PERSP=1, Z_PERSP=2;

   public Visualizador(){
      super("Visualizador");
      setSize(1280,770);
      setLayout(null);
      g=this.getGraphics();
      panel.setLayout(null);
      setContentPane(panel);
      timer.start();
      panel.setSize(1280,770);
      cube1=new Cubo();
      cube1.createVertices();

      addWindowListener(this);
      addKeyListener(this);

      repaint();
    }

   public void reiniciar(){
      setSize(1280,770);
      g=this.getGraphics();
      panel.setLayout(null);
      setContentPane(panel);
      timer.start();
      panel.setSize(1280,770);
      cube1=(Cubo) new Cuerpo();
      cube1.createVertices();

      addWindowListener(this);
      addKeyListener(this);

      repaint();
   }

    public void windowOpened(WindowEvent e) {    
    }

    public void windowClosing(WindowEvent e) {
        System.exit(3);
    }

    public void windowClosed(WindowEvent e) {
       System.exit(3);
    }

    public void windowIconified(WindowEvent e) {        
    }

    public void windowDeiconified(WindowEvent e) {        
    }

    public void windowActivated(WindowEvent e) {      
    }

    public void windowDeactivated(WindowEvent e) {       
    }
    public void actionPerformed(ActionEvent e){
      
       img=this.createImage(1280,770);
       g=img.getGraphics();

       cube1.dibujarse(g);
       Cuerpo aux=cube1.proyectarseEnPerspectiva();
       aux.dibujate(g);
       this.getGraphics().drawImage(img,0,0,this);
    }
    public void keyTyped(KeyEvent e) {
    }
    public void keyPressed(KeyEvent e) {
        if(e.VK_UP==e.getKeyCode()){
            cube1.dibujarse( g);
        }
        else if(e.VK_DOWN==e.getKeyCode()){
            cube1.dibujarse(g);
        }
        else if(e.VK_LEFT==e.getKeyCode()){
            cube1.scalarEspacio(false);
            cube1.dibujarse(g);
        }
        else if(e.VK_RIGHT==e.getKeyCode()){
            cube1.scalarEspacio(true);
            cube1.dibujarse(g);
        }
        else if(e.VK_Q==e.getKeyCode()){
            cube1.scalarX(true);
            cube1.dibujarse(g);
        }
        else if(e.VK_W==e.getKeyCode()){
            cube1.scalarX(false);
            cube1.dibujarse(g);
        }
        else if(e.VK_A==e.getKeyCode()){
            cube1.scalarY(true);
            cube1.dibujarse(g);
        }
        else if(e.VK_S==e.getKeyCode()){
            cube1.scalarY(false);
            cube1.dibujarse(g);
        }
        else if(e.VK_Z==e.getKeyCode()){
            cube1.scalarZ(true);
            cube1.dibujarse(g);
        }
        else if(e.VK_X==e.getKeyCode()){
            cube1.scalarZ(false);
            cube1.dibujarse(g);
        }
        else if(e.VK_E==e.getKeyCode()){
            cube1.rotarX(true);
            cube1.dibujarse(g);
        }
        else if(e.VK_R==e.getKeyCode()){
            cube1.rotarX(false);
            cube1.dibujarse(g);
        }
        else if(e.VK_D==e.getKeyCode()){
            cube1.rotarY(true);
            cube1.dibujarse(g);
        }
        else if(e.VK_F==e.getKeyCode()){
            cube1.rotarY(false);
            cube1.dibujarse(g);
        }
        else if(e.VK_C==e.getKeyCode()){
            cube1.rotarZ(true);
            cube1.dibujarse(g);
        }
        else if(e.VK_V==e.getKeyCode()){
            cube1.rotarZ(false);
            cube1.dibujarse(g);
        }
        else if(e.VK_T==e.getKeyCode()){
            cube1.moverX(true);
            cube1.dibujarse(g);
        }
        else if(e.VK_Y==e.getKeyCode()){
            cube1.moverX(false);
            cube1.dibujarse(g);
        }
        else if(e.VK_G==e.getKeyCode()){
            cube1.moverY(true);
            cube1.dibujarse(g);
        }
        else if(e.VK_H==e.getKeyCode()){
            cube1.moverY(false);
            cube1.dibujarse(g);
        }
        else if(e.VK_B==e.getKeyCode()){
            cube1.moverZ(true);
            cube1.dibujarse(g);
        }
        else if(e.VK_N==e.getKeyCode()){
            cube1.moverZ(false);
            cube1.dibujarse(g);
        }
        //System.out.println(e.getKeyChar());
    }
    public void keyReleased(KeyEvent e) {
        
    }
    public static void main(String[] mario) {
        Visualizador v1=new Visualizador();
        v1.setVisible(true);
    }
}
