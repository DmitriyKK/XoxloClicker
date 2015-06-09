package com.XoxloClicker.framework;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.SurfaceHolder;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by dakue_000 on 09.06.2015.
 */
public class View extends android.view.SurfaceView implements SurfaceHolder.Callback, Runnable {
    int fps;
    Paint paint = new Paint();
    Random rand = new Random();
    Timer timer = new Timer();
    Thread thread;
    SurfaceHolder holder;
    DrawObject btn = new DrawObject();

    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        thread = new Thread(this);
        thread.start();
        Log.d("View", "surfaceCreated()");
    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

    }

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
        while(!thread.isInterrupted()) {
//        while(!Thread.interrupted()) {
            try {
                canvas = holder.lockCanvas();
                canvas.drawRGB(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
                btn.draw(canvas);
                ++fps;
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

        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.BLACK);
        paint.setTextSize(30);
//        timer.schedule(new TimerTask() {
//            @Override
//            public void run() {
//                Log.v("FPS", Integer.toString(fps));
//                fps = 0;
//            }
//        }, 1000, 1000);
    }
}