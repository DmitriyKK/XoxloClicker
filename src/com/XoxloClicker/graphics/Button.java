package com.XoxloClicker.graphics;

import android.graphics.Rect;
import com.XoxloClicker.framework.Signal;
import com.XoxloClicker.framework.Sprite;

/**
 * Created by dakue_000 on 12.06.2015.
 */
public abstract class Button extends Sprite {
    public final Signal signal = new Signal();

    public Button(Rect bounds) {
        super(bounds);
    }
}
