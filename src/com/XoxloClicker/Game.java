package com.XoxloClicker;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.XoxloClicker.framework.Signal;
import com.XoxloClicker.framework.Sprite;

import java.io.IOException;


/**
 * Created by dakue_000 on 12.06.2015.
 */
public class Game implements Signal.Listener {
    final Signal signal = new Signal();
    long value = 0;

    @Override
    public void signalReceived(Signal.Event event) {
        if (event.ev.equals("click")) {
            ++value;
//            value = (long)Math.pow(value, 2);
            signal.emit(new Signal.Event("valueChanged", null, value));
        }
    }
}

class FileIO {

    AssetManager assetManager;

    public FileIO(AssetManager assetManager) {
        this.assetManager = assetManager;
    }

    public Sprite.File getAssetSprite(String name) throws IOException {
        return null;
    }

    public Sprite.File getAssetImage(String name) throws IOException {
        Bitmap bitmap = BitmapFactory.decodeStream(assetManager.open(name));
        return new Sprite.File(bitmap);
    }
}