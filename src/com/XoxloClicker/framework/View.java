package com.XoxloClicker.framework;

import android.content.Context;
import android.graphics.Canvas;
import android.util.Log;
import android.view.SurfaceHolder;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by dakue_000 on 09.06.2015.
 */
public class View extends android.view.SurfaceView implements SurfaceHolder.Callback, Runnable {
    Thread thread;
    SurfaceHolder holder;
    public final CopyOnWriteArrayList<DrawObject> drawObjects = new CopyOnWriteArrayList<>();

    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        thread = new Thread(this);
        thread.start();
        Log.d("View", "surfaceCreated()");
    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) { }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        thread.interrupt();
        do {
            try {
                thread.join();
            } catch (InterruptedException ex) { }
        } while(thread.isAlive());
        Log.d("View", "surfaceDestroyed()");
    }

    @Override
    public void run() {
        Canvas canvas = null;
//        while(!thread.isInterrupted()) {
        while(!Thread.interrupted()) {
            try {
                canvas = holder.lockCanvas();

                for (int i = 0, count = drawObjects.size(); i < count; ++i) {
                    drawObjects.get(i).draw(canvas);
                }

            } catch (Exception e) {
                Log.d("View canvas" ,canvas != null ? "exist" : "not exist");
                throw e;
            } finally {
                if (canvas != null)
                    holder.unlockCanvasAndPost(canvas);
            }
        }
        Log.d("View", "Thread stopped");
    }

    public View(Context context) {
        super(context);
        this.holder = getHolder();
        holder.addCallback(this);
    }
}