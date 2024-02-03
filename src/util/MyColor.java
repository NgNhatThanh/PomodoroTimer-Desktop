package util;

import java.awt.*;

public class MyColor extends Color {
    public MyColor(int r, int g, int b) {
        super(r, g, b);
    }
    static public void fade(Color color1, Color color2, MyButton button){
        float[] get1 = new float[3], get2 = new float[3];
        color1.getRGBColorComponents(get1);
        color2.getRGBColorComponents(get2);
        for(int i = 0; i < 3; ++i){
            get1[i] *= 255;
            get2[i] *= 255;
        }

    }
}
