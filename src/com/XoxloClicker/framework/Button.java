package com.XoxloClicker.framework;

import android.graphics.*;
import android.util.Log;
import com.XoxloClicker.framework.Signal;
import com.XoxloClicker.framework.Sprite;

/**
 * Created by dakue_000 on 12.06.2015.
 */
public class Button extends Sprite {
    public final Signal signal = new Signal();

    public Button(Sprite.File sprite) {
        super(sprite, null);
    }

    public Button(Rect rect) {
        this(null, rect);
    }

    public Button(Sprite.File sprite, Rect rect) {
        super(sprite, rect);
        Paint paint = new Paint();
        paint.setColor(Color.GRAY);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
//        canvas.drawRoundRect(new RectF(0, 0, sprite.image.getWidth(), sprite.image.getHeight()), 10, 10, paint);
    }

    @Override
    public void signalReceived(Signal.Event event) {
        if (event.ev.equals("touchEvent")) {
            signal.emit("click");
        }

        Log.d("Button.signal", event.ev);
    }

    @Override
    public void animate(boolean always) {
        Log.d("Button", "animate()");
    }
}
