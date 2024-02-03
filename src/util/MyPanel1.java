package util;

import main.MyPanel;

import javax.swing.*;
import java.awt.*;

public class MyPanel1 extends JPanel {
    public MyPanel1(){
        setPreferredSize(new Dimension(400, 400));
    }

    public void paintComponent(Graphics g){
        g.setColor(Color.CYAN);
        g.fillRoundRect(0, 0, 400, 400, 50, 50);
    }
}
