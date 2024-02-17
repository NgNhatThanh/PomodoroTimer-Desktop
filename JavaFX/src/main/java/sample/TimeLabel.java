package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.util.Duration;

public class TimeLabel extends Label {
    private int focusMin = 25;
    private int sBreakMin = 5;
    private int lBreakMin = 10;
    private int currentMin = 25, currentSec = 0;
    private int currentTab = FunctionButton.FOCUS;
    public int getFocusMin(){return focusMin;}
    public int getsBreakMin(){return sBreakMin;}
    public int getlBreakMin(){return lBreakMin;}
    public int getCurrentTab(){return currentTab;}
    void setSessionTime(int session, int min){
        switch (session){
            case FunctionButton.FOCUS -> focusMin = min;
            case FunctionButton.SBREAK -> sBreakMin = min;
            default -> lBreakMin = min;
        }
    }
    Timeline tick;
    void setTimeDisplay(){
        setText(String.format("%02d:%02d", currentMin, currentSec));
    }
    public TimeLabel(){
        setTextFill(Color.WHITE);
        setLayoutX(41);
        setLayoutY(94);
        setPrefSize(368, 230);
        setAlignment(Pos.CENTER);
        setTextAlignment(TextAlignment.CENTER);
        setFont(new Font("Calibri Bold", 150));
        setTimeDisplay();
        tick = new Timeline(new KeyFrame(Duration.seconds(1), (event) -> {
            --currentSec;
            if(currentSec < 0){
                --currentMin;
                currentSec = 59;
            }
            setTimeDisplay();
        }));
        tick.setOnFinished(actionEvent -> MainStage.alert.endSession());
        tick.setCycleCount(focusMin * 60);
    }
    public void start(){
        tick.play();
    }
    public void pause(){
        tick.pause();
    }
    public void reset(int tab){
        tick.stop();
        currentTab = tab;
        switch (tab) {
            case FunctionButton.FOCUS -> currentMin = focusMin;
            case FunctionButton.SBREAK -> currentMin = sBreakMin;
            case FunctionButton.LBREAK -> currentMin = lBreakMin;
        }
        currentSec = 0;
        tick.setCycleCount(currentMin * 60);
        setTimeDisplay();
    }
}
