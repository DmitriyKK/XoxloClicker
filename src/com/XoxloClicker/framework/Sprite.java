package com.XoxloClicker.framework;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

/**
 * Created by dakue_000 on 10.06.2015.
 */
public abstract class Sprite extends DrawObject {
    protected int x = 0, y = 0, w = 1, h = 1, spriteSpeed = 50;
    protected Sprite.File sprite;

    public static class File {
        public Bitmap image;
        public int rows, cols;

        public File(Bitmap image) {
            this(image, 1, 1);
        }

        public File(Bitmap image, int rows, int cols) {
            this.image = image;
            this.rows = rows;
            this.cols = cols;
        }
    }

    public Sprite(Sprite.File sprite) { this(sprite, null); }

    public Sprite(Sprite.File sprite, Rect bounds) {
        super(bounds);
        this.sprite = sprite;

        w = sprite.image.getWidth() / sprite.cols;
        h = sprite.image.getHeight() / sprite.rows;
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawBitmap(sprite.image, new Rect(x, y, w, h), getBounds(), null);
    }
}
