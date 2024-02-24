package sample;

/*
You may wonder "why this class exist ?", or "why don't you just run the code with the InitApp
class ?" ...
I know this class looks weird at first sight, but it's not.
It exists because of one "feature" in Java/JavaFX Module System
You can find a good explanation here:
https://stackoverflow.com/questions/52569724/javafx-11-create-a-jar-file-with-gradle
 */

public class App {
    public static void main(String[] args){
        HelloApplication.main(args);
    }
}
