package inputs;

import main.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyInputs implements KeyListener {
    MyPanel panel;
    public KeyInputs(MyPanel panel){
        this.panel = panel;
    }
    public void keyTyped(KeyEvent e) {

    }
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()){
            case KeyEvent.VK_A:
                panel.changeX(-5);
                break;
            case KeyEvent.VK_W:
                panel.changeY(-5);
                break;
            case KeyEvent.VK_S:
                panel.changeY(5);
                break;
            case KeyEvent.VK_D:
                panel.changeX(5);
                break;
        }
    }
    public void keyReleased(KeyEvent e) {
        System.out.println("pressed");
    }
}
