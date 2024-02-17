package sample;

import javafx.scene.control.Alert;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;

public class MyAlert {
    private final Alert saveST = new Alert(Alert.AlertType.INFORMATION);
    private final Alert ivlST = new Alert(Alert.AlertType.ERROR);
    private final Alert endSS = new Alert(Alert.AlertType.INFORMATION);
    private final MediaPlayer mediaPlayer;
    public MyAlert(){
        Media media = new Media(new File("src/main/resources/alarm.wav").toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        saveST.setContentText("Saved successfully!");
        ivlST.setContentText("Invalid input!");
        endSS.setContentText("End Session.");
        endSS.setOnHidden(dialogEvent ->{
            mediaPlayer.stop();
            MainStage.timeLabel.reset(MainStage.timeLabel.getCurrentTab());
        });
    }

    public void saveSetting(){
        saveST.showAndWait();
    }
    public void invalidSetting(){
        ivlST.showAndWait();
    }
    public void endSession(){
        endSS.show();
        mediaPlayer.play();
    }
}
