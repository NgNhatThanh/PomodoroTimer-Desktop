import main.Main;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class Image extends JComponent {
    BufferedImage img;
    public Image() {
        InputStream inputStream = Main.class.getResourceAsStream("/logo.png");
        try {
            img = ImageIO.read(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    protected void paintComponent(Graphics g){
        System.out.printf("1");
        g.drawImage(img, 0, 0, 200, 200, null);
    }
}
