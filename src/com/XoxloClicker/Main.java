package com.XoxloClicker;

import android.app.Activity;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.Window;
import android.view.WindowManager;
import com.XoxloClicker.framework.DrawObject;
import com.XoxloClicker.framework.View;

import java.util.ArrayList;

public class Main extends Activity {
    private View view;
    private OnTouchListener touchListener = new OnTouchListener();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        view = new View(this);
        view.setOnTouchListener(touchListener);

        DrawObject drawObject = new DrawObject(new Rect(100, 100,
                this.getWindowManager().getDefaultDisplay().getWidth()-100,
                this.getWindowManager().getDefaultDisplay().getHeight()-100)) {
            @Override
            public void draw(Canvas canvas) {
                Paint paint = new Paint();
                paint.setColor(Color.CYAN);
                paint.setStyle(Paint.Style.FILL_AND_STROKE);
                canvas.drawRect(getBounds(), paint);
            }
        };

        view.drawObjects.add(drawObject);
        touchListener.respodents.add(drawObject);
        setContentView(view);
    }
}

class OnTouchListener implements android.view.View.OnTouchListener {
    public final ArrayList<DrawObject> respodents = new ArrayList<>();

    @Override
    public boolean onTouch(android.view.View view, MotionEvent motionEvent) {
        for (int i = 0; i < respodents.size(); ++i) {
            DrawObject drawObject = respodents.get(i);
            if (isThisBounds(motionEvent, drawObject.getBounds())) {
                drawObject.onTouch();
            }
        }
        return true;
    }

    final boolean isThisBounds(MotionEvent motionEvent, Rect rect) {
        int x = (int)motionEvent.getX(), y = (int)motionEvent.getY();
        return rect.contains(x, y);
    }
}
