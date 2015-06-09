package com.XoxloClicker.framework;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.Log;

import java.util.Random;


/**
 * Created by dakue_000 on 09.06.2015.
 */
public class DrawObject extends android.graphics.drawable.AnimationDrawable {
    protected Paint paint = new Paint();
    protected Random rand = new Random();

    public DrawObject() {
        setBounds(100, 100, 300, 200);
        paint.setStyle(Paint.Style.FILL);
        Log.v("DrawObject", this.getBounds().toString());
    }

    @Override
    public void draw(Canvas canvas) {
        paint.setARGB(255 ,rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
        canvas.drawRect(getBounds(), paint);
    }

}
