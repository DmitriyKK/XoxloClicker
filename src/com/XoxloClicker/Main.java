package com.XoxloClicker;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import com.XoxloClicker.framework.View;

public class Main extends Activity {
    private View view;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        view = new View(this);
        setContentView(view);
    }
}

