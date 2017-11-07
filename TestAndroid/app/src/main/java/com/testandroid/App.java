package com.testandroid;

import android.app.Application;

import com.photolibrary.photo.Awen;

/**
 * Created by Administrator on 2017/11/7 0007.
 */

public class App extends Application {
    private static App app;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        Awen.init(this);
    }

    public static App getInstance() {
        return app;
    }
}
