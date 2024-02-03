package util;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class AlarmSound {
    Clip clip;
    AudioInputStream audioStream;
    File file = new File("src\\alarm.wav");
    public AlarmSound() throws LineUnavailableException, UnsupportedAudioFileException, IOException {
        clip = AudioSystem.getClip();
        audioStream = AudioSystem.getAudioInputStream(file);
        clip.open(audioStream);
    }
    void start(){
        clip.start();
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    void reset(){
        clip.stop();
        clip.setMicrosecondPosition(0);
    }
}
