package com.XoxloClicker.graphics;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.util.Log;
import com.XoxloClicker.Game;
import com.XoxloClicker.Screen;
import com.XoxloClicker.framework.Button;
import com.XoxloClicker.framework.DrawObject;
import com.XoxloClicker.framework.FileIO;
import com.XoxloClicker.framework.Signal;

import java.io.IOException;

/**
 * Created by dakue_000 on 15.06.2015.
 */
public class GameScreen extends Screen {

    DrawObject centralButton, upgradeBtn, countLbl;

    public GameScreen() {
        try {

            centralButton = new Button(FileIO.getAssetImage("salo.png"),
                    DrawObject.centered(Game.displayBounds.width() / 2, Game.displayBounds.height() / 2, 75));
            upgradeBtn = new Button(FileIO.getAssetImage("workkey-128.png"), DrawObject.bottomRight(0, 0, 50));
            countLbl = new CountLabel(new Rect(20, 50, Game.displayBounds.width() - 20, 150));

            this.drawObjects = new DrawObject[] {centralButton, upgradeBtn, countLbl};

            ((Button)centralButton).signal.addListeger(Game.instance);

            ((Button)upgradeBtn).signal.addListeger(new Signal.Listener() {
                @Override
                public void signalReceived(Signal.Event event) {
                    Game.main.setScreen(new UpgradeScreen());
                }
            });
        } catch (IOException e) {
            Log.d("GameScreen", e.getMessage(), e);
        }
    }

    @Override
    public void update(Canvas canvas) {
        canvas.drawColor(Color.CYAN);
        super.update(canvas);
    }

    @Override
    protected void onTouchDownEvent(DrawObject drawObject) {
//        drawObject.signalReceived(new Signal.Event("touch"));
    }
}
