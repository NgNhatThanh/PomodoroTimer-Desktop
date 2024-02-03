package main;

import util.*;
import main.MyPanel;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import javax.swing.plaf.multi.MultiViewportUI;
import java.awt.*;
import java.io.IOException;

import net.miginfocom.swing.MigLayout;

public class Main {
    static public SettingFrame st = new SettingFrame();
    static public MyLabel label = new MyLabel("ok");
    static public AlarmSound alarm;

    static {
        try {
            alarm = new AlarmSound();
        } catch (LineUnavailableException e) {
            throw new RuntimeException(e);
        } catch (UnsupportedAudioFileException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        MyPanel panel = new MyPanel();
//        MyLabel label = new MyLabel("ok");

        MyButton focusButton = new MyButton(label, MyButton.FOCUS_TAB);
        MyButton lbreakButton = new MyButton(label, MyButton.LONGBREAK_TAB);
        MyButton sbreakButton = new MyButton(label, MyButton.SHORTBREAK_TAB);
        MyButton startButton = new MyButton(label, MyButton.START);
        MyButton pauseButton = new MyButton(label, MyButton.PAUSE);
        MyButton settingButton = new MyButton(label, MyButton.SETTING);


        Thread clockThread = new Thread(label);

        FunctionButton res = new FunctionButton();
        FunctionButton res1 = new FunctionButton();

        MyPanel1 panel1 = new MyPanel1();
        panel1.add(pauseButton);

        ImageIcon icon = new ImageIcon("src\\logo.png");

        JFrame frame = new JFrame();
        frame.setTitle("Pomodoro timer");
        frame.setIconImage(icon.getImage());
        frame.setSize(450, 420);
        frame.getContentPane().setBackground(new Color(186, 73, 73));
        frame.setResizable(false);
        frame.setLayout(new MigLayout("fillx", "", "[]20[][]"));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(focusButton, "center");
        frame.add(sbreakButton, "center");
        frame.add(lbreakButton, "center, wrap");
        frame.add(label, "span, center");
        frame.add(startButton, "center");
        frame.add(pauseButton, "center");
        frame.add(settingButton, "center");
        frame.setLocationRelativeTo(null); // put frame in the middle of screen
        frame.setVisible(true);
        clockThread.start();
//        try {
//            clockThread.sleep(1000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        fade(frame, Color.red, Color.yellow);
//        button.requestFocus(); // put after setVisible because it needs components are displayable

    }
//    static void fade(JFrame frame, Color begin, Color end){
//        if(!begin.equals(end)){
//            int totalTime = 500;
//            long nn = System.currentTimeMillis();
//            float dif = (float)nn / totalTime;
//            int r = (int)(dif * begin.getRed() + (1 - dif) * end.getRed());
//            int g = (int)(dif * begin.getGreen() + (1 - dif) * end.getGreen());
//            int b = (int)(dif * begin.getBlue() + (1 - dif) * end.getBlue());
//            begin = new Color(r, g, b);
//            frame.setBackground(begin);
//            fade(frame, begin, end);
//        }
//    }
}