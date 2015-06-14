package com.XoxloClicker;

import android.app.Activity;
import android.graphics.*;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.Window;
import android.view.WindowManager;
import com.XoxloClicker.framework.DrawObject;
import com.XoxloClicker.framework.Signal;
import com.XoxloClicker.framework.View;
import com.XoxloClicker.graphics.Background;
import com.XoxloClicker.framework.Button;
import com.XoxloClicker.graphics.CountLabel;

import java.io.IOException;
import java.util.ArrayList;

public class Main extends Activity {
    private View view;
    private OnTouchListener touchListener = new OnTouchListener();
    Signal signal = new Signal();

    Game game = new Game();
    FileIO fileIO;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("Activity", "onCreate()");

        fileIO = new FileIO(getAssets());

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        view = new View(this);
        view.setOnTouchListener(touchListener);

        Display display = this.getWindowManager().getDefaultDisplay();

        createGraphics(display.getWidth(), display.getHeight());

        setContentView(view);
    }

    void createGraphics(int width, int height) {
        final int centerX = width/2, centerY = height/2;

        try {
            Button centralBtn = new Button(fileIO.getAssetImage("salo.png"),
                    DrawObject.getCenteredRect(centerX, centerY, 75));
            CountLabel countLbl = new CountLabel(new Rect(20, 50, width - 20, 150));

            DrawObject[] drawObjects = {
                    new Background(this.getWindowManager().getDefaultDisplay()),
                    centralBtn,
                    countLbl
            };

            signal.addListener(drawObjects[0]);
            centralBtn.signal.addListener(game);
            game.signal.addListener(countLbl);

            for (int i = 0; i < drawObjects.length; ++i)
                view.drawObjects.add(drawObjects[i]);

            for (int i = 1; i < drawObjects.length; ++i)
                touchListener.respodents.add(drawObjects[i]);
        } catch (IOException e) {
            Log.e("Exception", e.getMessage(), e);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        signal.emit("resume");
        Log.d("Activity", "onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        signal.emit("pause");
        Log.d("Activity", "onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Activity", "onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Activity", "onDestroy()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Activity", "onRestart()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Activity", "onStart()");
    }
}

class OnTouchListener implements android.view.View.OnTouchListener {
    public final ArrayList<DrawObject> respodents = new ArrayList<>();

    @Override
    public boolean onTouch(android.view.View view, MotionEvent motionEvent) {
        for (int i = 0; i < respodents.size(); ++i) {
            DrawObject drawObject = respodents.get(i);
            if (isThisBounds(motionEvent, drawObject.getBounds())) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        drawObject.signalReceived(new Signal.Event("touchEvent", motionEvent));
                    } break;
                    default:
                        break;
                }
            }
        }
        return true;
    }

    final boolean isThisBounds(MotionEvent motionEvent, Rect rect) {
        int x = (int)motionEvent.getX(), y = (int)motionEvent.getY();
        return rect.contains(x, y);
    }
}