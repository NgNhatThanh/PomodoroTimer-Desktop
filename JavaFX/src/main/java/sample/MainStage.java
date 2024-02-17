package sample;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.image.Image;

public class MainStage extends Stage {
    static public TimeLabel timeLabel = new TimeLabel();
    static public SettingStage settingStage = new SettingStage();
    static public MyAlert alert = new MyAlert();
    static Scene scene;
    static public final Color[] bgCol = {
            new Color(186.0/255, 73.0/255, 73.0/255, 1),
            new Color(81.0/255, 138.0/255, 88.0/255, 1),
            new Color(57.0/255, 112.0/255, 151.0/255, 1)
    };
    MainStage(){
        Image icon = new Image("logo.png");
        getIcons().add(icon);
        Group root = new Group();
        scene = new Scene(root, 450, 420);
        root.getChildren().add(timeLabel);
        root.getChildren().addAll(FunctionButton.getList());
        setResizable(false);
        setTitle("Pomodoro Timer");
        setScene(scene);
        scene.setFill(bgCol[0]);
        show();
    }

    public static void changeBackground(Color col){
        scene.setFill(col);
    }
}
