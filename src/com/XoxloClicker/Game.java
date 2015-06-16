package com.XoxloClicker;

import android.graphics.Rect;
import com.XoxloClicker.framework.Signal;


/**
 * Created by dakue_000 on 12.06.2015.
 */
public final class Game implements Signal.Listener {
    final public Signal signal = new Signal();
    long value = 0;

    public final static Game instance = new Game();
    public static Main main;
    public static Rect displayBounds;

    public static long getValue() { return instance.value; }

    public void init() {}

    @Override
    public void signalReceived(Signal.Event event) {
        if (event.string.equals("click")) {
            ++value;
//            value = (long)Math.pow(value, 2);
            signal.emit(new Signal.Event("valueChanged", this));
        }
    }
}