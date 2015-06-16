package com.XoxloClicker;

import android.app.Activity;
import android.graphics.*;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;
import com.XoxloClicker.framework.*;
import com.XoxloClicker.graphics.GameScreen;


public class Main extends Activity {
    private View view;
    Signal signal = new Signal();
    private volatile Screen screen;

    private Game game;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("Activity", "onCreate()");
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        FileIO.init(getAssets());

        Display display = this.getWindowManager().getDefaultDisplay();
        Game.main = this;
        Game.displayBounds = new Rect(0, 0, display.getWidth(), display.getHeight());

        view = new View(this);
        setScreen(new GameScreen());
        setContentView(view);
    }

    public void setScreen(Screen screen) {
        view.setOnTouchListener(screen);
        this.screen = screen;
    }

    public Screen getScreen() {
        return this.screen;
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
        view.onPause();
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
        view.onStart();
        Log.d("Activity", "onStart()");
    }
}