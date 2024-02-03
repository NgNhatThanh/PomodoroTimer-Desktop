package util;

import main.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class FunctionButton extends JButton {
    BufferedImage img;
    public FunctionButton(){
        setBackground(Color.green);

        InputStream ip = Main.class.getResourceAsStream("/reset.png");
        try {
            img = ImageIO.read(ip);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        setPreferredSize(new Dimension(100, 100));
        setContentAreaFilled(false);
        setBorder(BorderFactory.createEmptyBorder());
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(getBackground());
        g.fillRoundRect(0, 0, 100, 100, 50, 50);
        g.drawImage(img, 0, 0,100,100, null);
    }
}
