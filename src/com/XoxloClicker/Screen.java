package com.XoxloClicker;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import com.XoxloClicker.framework.DrawObject;
import com.XoxloClicker.framework.Signal;

/**
 * Created by dakue_000 on 15.06.2015.
 */
public abstract class Screen implements Signal.Listener, View.OnTouchListener {

    protected DrawObject[] drawObjects;

    public void update(Canvas canvas) {
        for (int i = 0; i < drawObjects.length; ++i) {
            drawObjects[i].draw(canvas);
        }
    }

    @Override
    public void signalReceived(Signal.Event event) {

    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        for (int i = 0; i < drawObjects.length; ++i) {
            DrawObject drawObject = drawObjects[i];
            if (isThisBounds(motionEvent, drawObject.getBounds())) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
//                        onTouchDownEvent(drawObject);
                        drawObject.signalReceived(new Signal.Event("touchEvent", motionEvent));
                    } break;
                    default:
                        break;
                }
            }
        }
        return true;
    }

    protected void onTouchDownEvent(DrawObject drawObject) {};

    final boolean isThisBounds(MotionEvent motionEvent, Rect rect) {
        int x = (int)motionEvent.getX(), y = (int)motionEvent.getY();
        return rect.contains(x, y);
    }
}
