package com.XoxloClicker.graphics;

import android.graphics.Canvas;
import android.graphics.Color;
import android.util.Log;
import com.XoxloClicker.Game;
import com.XoxloClicker.Screen;
import com.XoxloClicker.framework.Button;
import com.XoxloClicker.framework.DrawObject;
import com.XoxloClicker.framework.FileIO;
import com.XoxloClicker.framework.Signal;

/**
 * Created by dakue_000 on 16.06.2015.
 */
public class UpgradeScreen extends Screen {

    private DrawObject upgradeBtn;

    public UpgradeScreen() {
        try {
            upgradeBtn = new Button(FileIO.getAssetImage("workkey-128.png"), DrawObject.bottomRight(0, 0, 50));

            this.drawObjects = new DrawObject[] {upgradeBtn};

            ((Button)upgradeBtn).signal.addListeger(new Signal.Listener() {
                @Override
                public void signalReceived(Signal.Event event) {
                    Game.main.setScreen(new GameScreen());
                }
            });
        } catch (Exception e) {
            Log.d("UpgradeScreen", e.getMessage(), e);
        }
    }

    @Override
    public void update(Canvas canvas) {
        canvas.drawColor(Color.GRAY);
        super.update(canvas);
    }
}
