package com.XoxloClicker.framework;

import android.graphics.*;
import android.util.Log;


/**
 * Created by dakue_000 on 09.06.2015.
 */
public abstract class DrawObject extends android.graphics.drawable.Drawable implements Signal.Listener {
    public DrawObject() {
        this(new Rect(100, 100, 200, 200));
    }

    public DrawObject(Rect bounds) {
        setBounds(bounds);
    }

    @Override
    public void setAlpha(int i) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setColorFilter(ColorFilter colorFilter) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getOpacity() {
        return 0;
    }

    @Override
    public abstract void signalReceived(Signal.Event event);

    public abstract void animate(boolean always);
}
