package mario.geometric.plane;

import javax.swing.JComponent;

public abstract class Figura extends JComponent {

    private int x;
    private int y;

    public Figura(int x1, int y2) {
        super();
        x = x1;
        y = y2;
    }

    public abstract double area();

    @Override
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
