package util;

import inputs.MouseInputs;
import main.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyButton extends JButton {
    static private final String[] contentList = {"Focus", "Short Break", "Long Break", "Start", "Pause", "Setting"};
    private final int buttonWidth = 130, buttonHeigth = 70;
    static public final int FOCUS_TAB = 1;
    static public final int SHORTBREAK_TAB = 2;
    static public final int LONGBREAK_TAB = 3;
    static public final int START = 4;
    static public final int PAUSE = 5;
    static public final int SETTING = 6;
    int textX = 0, textY = 0;
    public MyButton(MyLabel label, int function){
        setForeground(Color.white);
        setText(contentList[function - 1]);
        setHorizontalTextPosition(JButton.CENTER);
        setVerticalTextPosition(JButton.CENTER);
        setFont(new Font("Calibri", Font.BOLD, 25));
        setFocusable(false);
        setBorder(BorderFactory.createEmptyBorder());
        setBackground(new Color(240, 119, 134));
        setContentAreaFilled(false);
        setHorizontalTextPosition(JButton.CENTER);
        setVerticalTextPosition(JButton.CENTER);
        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                 switch(function){
                     case PAUSE -> MyLabel.isRunning = false;
                     case START -> MyLabel.isRunning = true;
                     case SETTING -> {
                        Main.st.setVisible(true);
                     }
                     default -> label.changeTab(function);
                 }

            }

            @Override
            public void mousePressed(MouseEvent e) {
                textY += 5;
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                textY -= 5;
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                setBackground(new Color(210, 119, 134));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setBackground(new Color(240, 119, 134));
            }
        });
        setPreferredSize(new Dimension(buttonWidth, buttonHeigth + 5));
//        setBounds(100, 100, 100, 100);
    }
//    private int alignContentX(){
//        return
//    }

    public void paintComponent(Graphics g){
//        System.out.println("ok");
        g.setColor(new Color(0,0,0,0.2f ));
        g.fillRoundRect(textX, textY, 130, 70, 20, 20);
        super.paintComponent(g);
//        g.drawString(this.content, 30 + textX, 30 + textY);
    }
}
