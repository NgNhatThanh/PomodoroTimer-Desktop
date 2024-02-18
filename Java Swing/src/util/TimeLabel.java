package util;

import main.MainFrame;
import javax.swing.*;
import java.awt.*;
import java.util.TimerTask;
import java.util.Timer;

public class TimeLabel extends JLabel {
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
    TimerTask tick;
    Timer countDown = new Timer();
    public TimeLabel(){
        setForeground(Color.white);
        setPreferredSize(new Dimension(400, 180));
        setFont(new Font("Calibri", Font.BOLD, 160));
        setHorizontalAlignment(JLabel.CENTER);
        setTimeDisplay();
    }
    public int getCurrentStatus(){return currentStatus;}
    public void setSessionTime(int mins, int status){
        switch (status){
            case FunctionButton.FOCUS_TAB -> focusMins = mins;
            case FunctionButton.LONGBREAK_TAB -> lBreakMins = mins;
            case FunctionButton.SHORTBREAK_TAB -> sBreakMins = mins;
        }
    }
    public void reset(int status){
        pause();
        switch (status){
            case FunctionButton.FOCUS_TAB -> currentMin = focusMins;
            case FunctionButton.SHORTBREAK_TAB -> currentMin = sBreakMins;
            case FunctionButton.LONGBREAK_TAB -> currentMin = lBreakMins;
        }
        currentSec = 0;
        setTimeDisplay();
    }
    public void changeSession(int status){
        if(status != currentStatus) {
            pause();
            switch (status){
                case FunctionButton.FOCUS_TAB -> currentMin = focusMins;
                case FunctionButton.SHORTBREAK_TAB -> currentMin = sBreakMins;
                case FunctionButton.LONGBREAK_TAB -> currentMin = lBreakMins;
            }
            currentSec = 0;
            currentStatus = status;
            setTimeDisplay();
        }
    }
    private void setTimeDisplay(){
        setText(String.format("%02d:%02d", currentMin, currentSec));
    }
    public void alarm(){
        MainFrame.sound.alarm();
        JOptionPane.showMessageDialog(null, "End session", "", JOptionPane.INFORMATION_MESSAGE);
        MainFrame.sound.resetAlarm();
        reset(currentStatus);
    }
    public void pause(){
        countDown.cancel();
        countDown.purge();
    }
    public void start(){
        tick = new TimerTask() {
            @Override
            public void run() {
                --currentSec;
                if(currentSec < 0){
                    --currentMin;
                    currentSec = 59;
                }
                setTimeDisplay();
                if(currentSec == 0 && currentMin == 0){
                    pause();
                    alarm();
                }
            }
        };
        countDown = new Timer();
        countDown.schedule(tick, 500, 1000);
    }
}