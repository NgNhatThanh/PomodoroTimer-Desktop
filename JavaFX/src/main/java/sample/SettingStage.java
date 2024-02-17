package sample;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.Button;

public class SettingStage extends Stage{
    Button saveButton = new Button("Save");
    TextField focusText = new TextField();
    TextField sBreakText = new TextField();
    TextField lBreakText = new TextField();
    Label focusLB = new Label("Focus");
    Label sBreakLB = new Label("Short Break");
    Label lBreakLB = new Label("Long Break");
    public SettingStage(){
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(10);
        grid.setHgap(10);
        Scene scene = new Scene(grid, 150, 160);
        setResizable(false);
        setScene(scene);
        focusText.setPrefSize(50, 25);
        sBreakText.setPrefSize(50, 25);
        lBreakText.setPrefSize(50, 25);
        saveButton.setLayoutX(80);
        grid.add(focusLB, 0, 0);
        grid.add(focusText, 1, 0);
        grid.add(sBreakLB, 0, 1);
        grid.add(sBreakText, 1, 1);
        grid.add(lBreakLB, 0, 2);
        grid.add(lBreakText, 1, 2);
        grid.add(saveButton, 1, 3);
        saveButton.setOnAction(actionEvent -> {
            if(checkInput(focusText.getText()) && checkInput(sBreakText.getText()) && checkInput(lBreakText.getText())){
                MainStage.timeLabel.setSessionTime(FunctionButton.FOCUS, Integer.parseInt(focusText.getText()));
                MainStage.timeLabel.setSessionTime(FunctionButton.SBREAK, Integer.parseInt(sBreakText.getText()));
                MainStage.timeLabel.setSessionTime(FunctionButton.LBREAK, Integer.parseInt(lBreakText.getText()));
                MainStage.timeLabel.reset(MainStage.timeLabel.getCurrentTab());
                MainStage.alert.saveSetting();
                this.close();
            }
            else MainStage.alert.invalidSetting();
        });
    }
    boolean checkInput(String s){
        for(int i = 0; i < s.length(); ++i){
            if(!Character.isDigit(s.charAt(i))) return false;
        }
        return !s.isEmpty() && Integer.parseInt(s) > 0;
    }
    public void Show(){
        focusText.setText(Integer.toString(MainStage.timeLabel.getFocusMin()));
        sBreakText.setText(Integer.toString(MainStage.timeLabel.getsBreakMin()));
        lBreakText.setText(Integer.toString(MainStage.timeLabel.getlBreakMin()));
        this.show();
    }
}
