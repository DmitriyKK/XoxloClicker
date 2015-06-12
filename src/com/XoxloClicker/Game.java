package com.XoxloClicker;

import com.XoxloClicker.framework.Signal;

/**
 * Created by dakue_000 on 12.06.2015.
 */
public class Game implements Signal.Listener {
    final Signal signal = new Signal();

    long value = 0;


    @Override
    public void signalReceived(Signal.Event event) {
        if (event.ev.equals("click")) {
            ++value;
            value = (long)Math.pow(value, 2);
            signal.emit(new Signal.Event("valueChanged", null, value));
        }
    }
}

