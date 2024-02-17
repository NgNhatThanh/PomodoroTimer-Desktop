package sample;

import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import java.util.ArrayList;
import java.util.List;

public class FunctionButton extends Button {
    static public final int FOCUS = 1,
                            SBREAK = 2,
                            LBREAK = 3,
                            START = 4,
                            PAUSE = 5,
                            SETTING = 6;
    final String[] text = {"Focus", "Short Break", "Long Break", "Start", "Pause", "Setting"};
    FunctionButton(double x, double y, int function){
        setTextFill(Color.WHITE);
        setStyle("-fx-background-color: rgba(255, 255, 255, 0.2)");
        setLayoutX(x);
        setLayoutY(y);
        setOnAction(actionEvent -> {
            switch (function){
                case START -> MainStage.timeLabel.start();
                case PAUSE -> MainStage.timeLabel.pause();
                case SETTING -> MainStage.settingStage.Show();
                default ->{
                    MainStage.timeLabel.reset(function);
                    MainStage.changeBackground(MainStage.bgCol[function - 1]);
                }
            }
        });
        setOnMouseEntered(mouseEvent -> setStyle("-fx-background-color: rgba(0, 0, 0, 0.3)"));
        setOnMouseExited(mouseEvent -> setStyle("-fx-background-color: rgba(255, 255, 255, 0.2)"));
        setOnMousePressed(mouseEvent -> setLayoutY(getLayoutY() + 5));
        setOnMouseReleased(mouseEvent -> setLayoutY(getLayoutY() - 5));
        setPrefSize(130, 70);
        setFont(new Font("Calibri Bold", 20));
        setText(text[function - 1]);
    }
    public static List<Button> getList(){
        List<Button> buttonList = new ArrayList<>();
        buttonList.add(new FunctionButton(14, 28, FunctionButton.FOCUS));
        buttonList.add(new FunctionButton(159, 28, FunctionButton.SBREAK));
        buttonList.add(new FunctionButton(305, 28, FunctionButton.LBREAK));
        buttonList.add(new FunctionButton(14, 328, FunctionButton.START));
        buttonList.add(new FunctionButton(159, 328, FunctionButton.PAUSE));
        buttonList.add(new FunctionButton(305, 328, FunctionButton.SETTING));
        return buttonList;
    }
}
