package com.XoxloClicker.graphics;

import android.graphics.Rect;
import android.util.Log;
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
        if (event.ev.equals("valueChanged")) {
            drawText = Long.toString(event.integer);
        }
    }

    @Override
    public void animate(boolean always) {

    }
}
