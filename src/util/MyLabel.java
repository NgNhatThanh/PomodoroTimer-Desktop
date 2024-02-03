package util;
import main.Main;

import javax.swing.*;
import java.awt.*;
import java.sql.PreparedStatement;

public class MyLabel extends JLabel implements Runnable {
    static public boolean isRunning = false;
    static public int focusMins = 25;
    static public int sBreakMins = 5;
    static public int lBreakMins = 10;
    public int currentStatus = MyButton.FOCUS_TAB;
    public MyLabel(String content){
        setForeground(Color.white);
        setPreferredSize(new Dimension(400, 180));
        setFont(new Font("Calibri", Font.BOLD, 160));
        setHorizontalAlignment(JLabel.CENTER);
        setTimeDisplay();
    }
    public void setFocusMins(int mins){
        focusMins = mins;
        reset(currentStatus);
        repaint();
    }
    public void setsBreakMins(int mins){
        sBreakMins = mins;
        reset(currentStatus);
        repaint();
    }
    public void setlBreakMins(int mins){
        lBreakMins = mins;
        reset(currentStatus);
        repaint();
    }
    int currentMin = 0, currentSec = 5;
    public void reset(int status){
        switch (status){
            case MyButton.FOCUS_TAB -> currentMin = focusMins;
            case MyButton.SHORTBREAK_TAB -> currentMin = sBreakMins;
            case MyButton.LONGBREAK_TAB -> currentMin = lBreakMins;
        }
        currentSec = 0;
        isRunning = false;
        repaint();
    }
    public void changeTab(int status){
        if(status != currentStatus) {
            switch (status){
                case MyButton.FOCUS_TAB -> currentMin = focusMins;
                case MyButton.SHORTBREAK_TAB -> currentMin = sBreakMins;
                case MyButton.LONGBREAK_TAB -> currentMin = lBreakMins;
            }
            currentSec = 0;
            isRunning = false;
            currentStatus = status;
            repaint();
        }
    }
    String timeDisplay;
    private void setTimeDisplay(){
        String timeDisplay = String.format("%02d:%02d", currentMin, currentSec);
        setText(timeDisplay);
    }
    public void alarm(){
        Main.alarm.start();
        JOptionPane.showMessageDialog(null, "End session", "", JOptionPane.INFORMATION_MESSAGE);
        Main.alarm.reset();
    }
    public void countDown(){
        long now = System.currentTimeMillis();
        long lastCheck = 0;
        while(isRunning && (currentMin > 0 || currentSec > 0)){
            if(now - lastCheck >= 1000){
                lastCheck = now;
                --currentSec;
                if(currentSec < 0){
                    --currentMin;
                    currentSec = 59;
                }
                repaint();
                if(currentSec == 0 && currentMin == 0){
                    isRunning = false;
                    alarm();
                }
            }
            now = System.currentTimeMillis();
        }
    }
    public void paintComponent(Graphics g){
        setTimeDisplay();
        super.paintComponent(g);
    }

    @Override
    public void run() {
        int cnt = 1;
        while(true){
//            System.out.println(cnt++);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            countDown();
        }
    }
}
