package com.XoxloClicker.framework;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

/**
 * Created by dakue_000 on 10.06.2015.
 */
public class Sprite extends DrawObject {
    protected int spriteRows = 1, spriteCols = 1, spriteSpeed = 50;
    protected int x = 0, y = 0;
    protected Bitmap sprite;

    public Sprite(Bitmap sprite) {
        this.sprite = sprite;
    }

    public Sprite(Rect bounds, Bitmap sprite) {
        super(bounds);
        this.sprite = sprite;
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawBitmap(sprite, null, (Rect)null, null);
    }
}
