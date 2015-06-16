package com.XoxloClicker.framework;

import android.content.Context;
import android.graphics.Canvas;
import android.util.Log;
import android.view.SurfaceHolder;
import com.XoxloClicker.Main;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by dakue_000 on 09.06.2015.
 */
public class View extends android.view.SurfaceView {
    private Main main;
    private SurfaceHolder holder;
    private Thread thread;

    class DrawThread extends Thread {
        @Override
        public void run() {
            Canvas canvas = null;
            while(!Thread.interrupted()) {
                try {
                    canvas = holder.lockCanvas();
                    main.getScreen().update(canvas);
                } catch (Exception e) {
                    Log.d("View canvas" ,canvas != null ? "exist" : "not exist");
//                throw e;
                } finally {
                    if (canvas != null)
                        holder.unlockCanvasAndPost(canvas);
                }
            }
            Log.d("View", "DrawThread stopped");
        }
    }

    public View(Main context) {
        super(context);
        this.main = context;
        this.holder = getHolder();
//        holder.addCallback(this);
    }

    public void onStart() {
        thread = new DrawThread();
        thread.start();
        Log.d("View", "surfaceCreated()");
    }

    public void onPause() {
        thread.interrupt();
        do {
            try {
                thread.join();
            } catch (InterruptedException ex) { }
        } while(thread.isAlive());
        Log.d("View", "surfaceDestroyed()");
    }
}