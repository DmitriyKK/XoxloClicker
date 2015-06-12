package com.XoxloClicker.graphics;

import android.graphics.*;
import android.util.Log;
import com.XoxloClicker.framework.Signal;
import com.XoxloClicker.framework.Sprite;

/**
 * Created by dakue_000 on 12.06.2015.
 */

/**
 * Main button. Emit "click"
 */

public class CentralButton extends Button {


    public CentralButton(Rect rect) {
        super(rect);

        sprite = Bitmap.createBitmap(rect.width(), rect.height(), Bitmap.Config.ARGB_4444);
        Canvas canvas = new Canvas(sprite);
        Paint paint = new Paint();
        paint.setColor(Color.GRAY);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        canvas.drawRoundRect(new RectF(0, 0, sprite.getWidth(), sprite.getHeight()), 10, 10, paint);
    }

    @Override
    public void signalReceived(Signal.Event event) {
        if (event.ev.equals("touchEvent")) {
            signal.emit("click");
        }

        Log.d("CentralButton.signal", event.ev);
    }

    @Override
    public void animate(boolean always) {
        Log.d("CentralButton", "animate()");
    }
}
