package main;

import inputs.*;

import javax.swing.*;
import java.awt.*;

public class MyPanel extends JPanel {
    int xDelta = 100, yDelta = 100;
    int frame = 0;
    long lastCheck = 0;
    public void changeX(int delta){
        xDelta += delta;
//        repaint();
    }
    public void changeY(int delta){
        yDelta += delta;
//        repaint();
    }
    public void setRectPos(int x, int y){
        xDelta = x;
        yDelta = y;
//        repaint();
    }
    public MyPanel(){
        addKeyListener(new KeyInputs(this));
        addMouseMotionListener(new MouseInputs(this));
        addMouseListener(new MouseInputs(this));
    }

    public void paintComponent(Graphics g){
        update();
        super.paintComponent(g);
        g.fillRoundRect(xDelta, yDelta, 100, 100, 50,50);
        ++frame;
        if(System.currentTimeMillis() - lastCheck >= 1000){
            lastCheck = System.currentTimeMillis();
            System.out.println("FPS: " + frame);
            frame = 0;
        }
        repaint();
    }

    void update(){
        ++xDelta; ++yDelta;
    }
}
