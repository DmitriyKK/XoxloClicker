package com.XoxloClicker.graphics;

import android.graphics.*;
import android.view.Display;
import com.XoxloClicker.framework.DrawObject;
import com.XoxloClicker.framework.Signal;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by dakue_000 on 12.06.2015.
 */
public class Background  extends DrawObject implements Signal.Listener {
    Paint paint = new Paint();
    Random rand = new Random();
    Timer timer;
    float[] hsv1 = {0, (float)0.8, 1}, hsv2 = {0, (float)0.4, 1};
    final int x = getBounds().centerX(), y = getBounds().centerY(), r = getBounds().centerX()*3;
    int color1, color2;

    class TimerTask1 extends TimerTask {
        boolean b = false;
        @Override
        public void run() {
            float[] hsv;
            if (b = !b)
                hsv = hsv1;
            else
                hsv = hsv2;

            int r = rand.nextInt(15)-5;
            float c = hsv[0] + r;

            if (c >= 0 && c < 360)
                hsv[0] = c;
            else
                hsv[0] -= r;

            color1 = Color.HSVToColor(hsv1);
            color2 = Color.HSVToColor(hsv2);
        }
    };

    public Background(Display display) {
        super(new Rect(0, 0, display.getWidth(), display.getHeight()));
    }

    @Override
    public void signalReceived(Signal.Event event) {
        if (event.string.equals("pause")) {
            timer.cancel();
        } else if (event.string.equals("resume")) {
            timer = new Timer();
            timer.schedule(new TimerTask1(), 0, 50);
        }
    }

    @Override
    public void draw(Canvas canvas) {
        RadialGradient grad = new RadialGradient(x, y, r, color1, color2, Shader.TileMode.CLAMP);
        paint.setShader(grad);
        paint.setDither(true);
        canvas.drawRect(getBounds(), paint);
    }

    @Override
    public void animate(boolean always) {}
}