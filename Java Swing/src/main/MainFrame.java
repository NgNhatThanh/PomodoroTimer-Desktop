package main;

import net.miginfocom.swing.MigLayout; // you need to configure MigLayout class to use this
import util.*;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class MainFrame extends JFrame{
    static public SettingFrame st = new SettingFrame();
    static public TimeLabel label = new TimeLabel();
    private final Color focusTabColor = new Color(186, 73, 73);
    private final Color sBreakTabColor = new Color(81, 138, 88);
    private final Color lBreakTabColor = new Color(57, 112, 151);
    static public Sound sound;
    static {
        try {
            sound = new Sound();
        } catch (LineUnavailableException | UnsupportedAudioFileException | IOException e) {
            throw new RuntimeException(e);
        }
    }
    public MainFrame(){
        FunctionButton focusButton = new FunctionButton(this, label, FunctionButton.FOCUS_TAB);
        FunctionButton lbreakButton = new FunctionButton(this, label, FunctionButton.LONGBREAK_TAB);
        FunctionButton sbreakButton = new FunctionButton(this, label, FunctionButton.SHORTBREAK_TAB);
        FunctionButton startButton = new FunctionButton(null, label, FunctionButton.START);
        FunctionButton pauseButton = new FunctionButton(null, label, FunctionButton.PAUSE);
        FunctionButton settingButton = new FunctionButton(null, label, FunctionButton.SETTING);

        ImageIcon icon = new ImageIcon("res\\logo.png");
        getContentPane().setBackground(focusTabColor);
        setTitle("Pomodoro Timer");
        setIconImage(icon.getImage());
        setSize(450, 420);
        setResizable(false);
        setLayout(new MigLayout("fillx", "", "[]20[][]"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(focusButton, "center");
        add(sbreakButton, "center");
        add(lbreakButton, "center, wrap");
        add(label, "span, center");
        add(startButton, "center");
        add(pauseButton, "center");
        add(settingButton, "center");
        setLocationRelativeTo(null); // put frame in the middle of screen
        setVisible(true);
    }
    public void changeTabColor(int tab){
        switch (tab){
            case FunctionButton.FOCUS_TAB -> getContentPane().setBackground(focusTabColor);
            case FunctionButton.SHORTBREAK_TAB -> getContentPane().setBackground(sBreakTabColor);
            default -> getContentPane().setBackground(lBreakTabColor);
        }
    }
}
