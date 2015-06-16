package com.XoxloClicker.framework;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.IOException;

/**
 * Created by dakue_000 on 16.06.2015.
 */

public class FileIO {

    static AssetManager assetManager;

    public static void init(AssetManager asset) {
        assetManager = asset;
    }

    public static Sprite.File getAssetSprite(String name) throws IOException {
        return null;
    }

    public static Sprite.File getAssetImage(String name) throws IOException {
        Bitmap bitmap = BitmapFactory.decodeStream(assetManager.open(name));
        return new Sprite.File(bitmap);
    }
}