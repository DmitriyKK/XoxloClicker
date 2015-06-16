package com.XoxloClicker.framework;

import android.graphics.*;
import com.XoxloClicker.Game;


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

    public static Rect centered(int x, int y, int radius) {
        return new Rect(x - radius, y - radius, x + radius, y + radius);
    }

    public static Rect topLeft(int x, int y, int radius) {
        return new Rect(x, y, x+radius, y+radius);
    }

    public static Rect topRight(int x, int y, int raduis) {
        return new Rect(Game.displayBounds.right-raduis-x, y, Game.displayBounds.right-x, raduis);
    }

    public static Rect bottomLeft(int x, int y, int raduis) {
        return new Rect(x, Game.displayBounds.bottom-raduis-y, x+raduis, Game.displayBounds.bottom-y);
    }

    public static Rect bottomRight(int x, int y, int raduis) {
        Rect r = Game.displayBounds;
        return new Rect(r.right-raduis-x, r.bottom-raduis-y, r.right-x, r.bottom-y);
    }
}