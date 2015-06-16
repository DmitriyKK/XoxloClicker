package com.XoxloClicker.graphics;

import android.graphics.Canvas;
import android.graphics.Rect;
import com.XoxloClicker.Game;
import com.XoxloClicker.framework.Label;
import com.XoxloClicker.framework.Signal;

/**
 * Created by dakue_000 on 12.06.2015.
 */
public class CountLabel extends Label {
    public CountLabel(Rect bounds) {
        super(bounds);
        drawText = "Draw TEXT 1234567890";
    }

    @Override
    public void signalReceived(Signal.Event event) {
//        if (event.string.equals("valueChanged")) {
//            drawText = Long.toString(((Game)event.obj).getValue());
//        }
    }

    @Override
    public void draw(Canvas canvas) {
        drawText = Long.toString(Game.getValue());
        super.draw(canvas);
    }

    @Override
    public void animate(boolean always) {

    }
}
