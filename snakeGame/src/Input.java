import java.awt.*;
import java.awt.event.*;

// Creates a Frame to validate input from.
public class Input extends Frame implements KeyListener {
    public Point direction;
    private TextArea area;

    Input() {
        direction = new Point(0, -1);
        area = new TextArea();
        area.addKeyListener(this);
        setSize(100, 100);
        add(area);
        setLayout(null);
        setVisible(true);
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            if(direction.y != 1){
                direction.x = 0;
                direction.y = -1;
            }
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            if(direction.y != -1){
                direction.x = 0;
                direction.y = 1;
            }
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            if(direction.x != 1){
                direction.x = -1;
                direction.y = 0;
            }

        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            if(direction.x != -1){
                direction.x = 1;
                direction.y = 0;
            }
        }
    }

    public void keyReleased(KeyEvent e) {
    }

    public void keyTyped(KeyEvent e) {
    }
}
