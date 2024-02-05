package util;

import main.MainFrame;
import javax.swing.*;
import java.awt.*;

public class TimeLabel extends JLabel {
    static public boolean isRunning = false;
    static private int focusMins = 25;
    static private int sBreakMins = 5;
    static private int lBreakMins = 10;
    public static int getFocusMins() {
        return focusMins;
    }

    public static int getsBreakMins() {
        return sBreakMins;
    }

    public static int getlBreakMins() {
        return lBreakMins;
    }
    private int currentMin = focusMins, currentSec = 0;
    private int currentStatus = FunctionButton.FOCUS_TAB;

    public TimeLabel(){
        setForeground(Color.white);
        setPreferredSize(new Dimension(400, 180));
        setFont(new Font("Calibri", Font.BOLD, 160));
        setHorizontalAlignment(JLabel.CENTER);
        setTimeDisplay();
    }
    public void setSessionTime(int mins, int status){
        switch (status){
            case FunctionButton.FOCUS_TAB -> focusMins = mins;
            case FunctionButton.LONGBREAK_TAB -> lBreakMins = mins;
            case FunctionButton.SHORTBREAK_TAB -> sBreakMins = mins;
        }
        reset(currentStatus);
        setTimeDisplay();
    }
    public void reset(int status){
        switch (status){
            case FunctionButton.FOCUS_TAB -> currentMin = focusMins;
            case FunctionButton.SHORTBREAK_TAB -> currentMin = sBreakMins;
            case FunctionButton.LONGBREAK_TAB -> currentMin = lBreakMins;
        }
        currentSec = 0;
        isRunning = false;
        setTimeDisplay();
    }
    public void changeSession(int status){
        if(status != currentStatus) {
            switch (status){
                case FunctionButton.FOCUS_TAB -> currentMin = focusMins;
                case FunctionButton.SHORTBREAK_TAB -> currentMin = sBreakMins;
                case FunctionButton.LONGBREAK_TAB -> currentMin = lBreakMins;
            }
            currentSec = 0;
            isRunning = false;
            currentStatus = status;
            setTimeDisplay();
        }
    }
    private void setTimeDisplay(){
        String timeDisplay = String.format("%02d:%02d", currentMin, currentSec);
        setText(timeDisplay);
    }
    public void alarm(){
        MainFrame.sound.alarm();
        JOptionPane.showMessageDialog(null, "End session", "", JOptionPane.INFORMATION_MESSAGE);
        MainFrame.sound.resetAlarm();
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
                setTimeDisplay();
                if(currentSec == 0 && currentMin == 0){
                    isRunning = false;
                    alarm();
                }
            }
            now = System.currentTimeMillis();
        }
    }
    public void run() {
        while(true){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            countDown();
        }
    }
}
