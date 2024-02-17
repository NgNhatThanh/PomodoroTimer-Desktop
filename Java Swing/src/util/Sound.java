package util;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Sound {
    Clip alarmClip;
    AudioInputStream alarmInputStream;
    File alarmFile = new File("res\\alarm.wav");
    public Sound() throws LineUnavailableException, UnsupportedAudioFileException, IOException {
        alarmClip = AudioSystem.getClip();
        alarmInputStream = AudioSystem.getAudioInputStream(alarmFile);
        alarmClip.open(alarmInputStream);
    }
    void alarm(){
        alarmClip.start();
        alarmClip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    void resetAlarm(){
        alarmClip.stop();
        alarmClip.setMicrosecondPosition(0);
    }
}
