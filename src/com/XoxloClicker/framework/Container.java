package com.XoxloClicker.framework;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.Log;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by dakue_000 on 10.06.2015.
 */
public abstract class Container extends DrawObject {
    private final CopyOnWriteArrayList<DrawObject> drawObjects = new CopyOnWriteArrayList<>();
    private final Rect rect = new Rect();

    public void add(DrawObject obj) {
        drawObjects.add(obj);
        resetRect();
    }

    @Override
    public void draw(Canvas canvas) {
        for (int i = 0; i < drawObjects.size(); ++i) {
            drawObjects.get(i).draw(canvas);
        }
    }

    private final void resetRect() {
        Rect r = new Rect(drawObjects.get(0).getBounds());

        for (int i = 1; i < drawObjects.size(); ++i) {
            Rect r1 = drawObjects.get(i).getBounds();
            r.union(r1);
        }
    }
}
