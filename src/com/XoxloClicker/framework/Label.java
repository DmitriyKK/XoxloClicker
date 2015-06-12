package com.XoxloClicker.framework;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

/**
 * Created by dakue_000 on 12.06.2015.
 */
public abstract class Label extends DrawObject {
    protected String drawText = new String();
    protected Paint paint = new Paint();

    public Label(Rect bounds) {
        super(bounds);

        paint.setAntiAlias(true);
        paint.setColor(Color.WHITE);
        paint.setTextSize(45.0f);
        paint.setStrokeWidth(2.0f);
        paint.setStyle(Paint.Style.STROKE);
        paint.setShadowLayer(5.0f, 5.0f, 5.0f, Color.BLACK);
    }

    @Override
    public void draw(Canvas canvas) {
        int q = (int)paint.measureText(drawText)/2;
        canvas.drawText(drawText, getBounds().centerX()-q, getBounds().top, paint);
    }
}
