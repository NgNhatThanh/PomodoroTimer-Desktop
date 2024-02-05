package util;

import main.MainFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class FunctionButton extends JButton {
    static private final String[] contentList = {"Focus", "Short Break", "Long Break", "Start", "Pause", "Setting"};
    static public final int FOCUS_TAB = 1;
    static public final int SHORTBREAK_TAB = 2;
    static public final int LONGBREAK_TAB = 3;
    static public final int START = 4;
    static public final int PAUSE = 5;
    static public final int SETTING = 6;
    int yPos = 0;
    public FunctionButton(MainFrame mainFrame, TimeLabel label, int function){
        setBackground(new Color(1,1,1,0.1f));
        setForeground(Color.white);
        setText(contentList[function - 1]);
        setHorizontalTextPosition(JButton.CENTER);
        setVerticalTextPosition(JButton.CENTER);
        setFont(new Font("Calibri", Font.BOLD, 25));
        setFocusable(false);
        setBorder(BorderFactory.createEmptyBorder());
        setContentAreaFilled(false);
        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                 switch(function){
                     case PAUSE -> TimeLabel.isRunning = false;
                     case START -> TimeLabel.isRunning = true;
                     case SETTING -> MainFrame.st.setVisible(true);
                     default -> {
                         mainFrame.changeTabColor(function);
                         label.changeSession(function);
                     }
                 }
            }
            @Override
            public void mousePressed(MouseEvent e) {
                yPos += 5;
            }
            @Override
            public void mouseReleased(MouseEvent e) {
                yPos -= 5;
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                setBackground(new Color(0,0,0f,0.2f));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                setBackground(new Color(1,1,1,0.1f ));
            }
        });
        int buttonWidth = 130;
        int buttonHeigth = 70;
        setPreferredSize(new Dimension(buttonWidth, buttonHeigth + 5));
    }
    public void paintComponent(Graphics g){
        g.setColor(getBackground());
        g.fillRoundRect(0, yPos, 130, 70, 20, 20);
        super.paintComponent(g);
    }
}
