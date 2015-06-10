package com.XoxloClicker.framework;

import android.graphics.Canvas;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by dakue_000 on 10.06.2015.
 */
public class Container extends DrawObject {
    public final CopyOnWriteArrayList<DrawObject> drawObjects = new CopyOnWriteArrayList<>();

    @Override
    public void draw(Canvas canvas) {
        for (int i = 0; i < drawObjects.size(); ++i) {
            drawObjects.get(i).draw(canvas);
        }
    }
}
