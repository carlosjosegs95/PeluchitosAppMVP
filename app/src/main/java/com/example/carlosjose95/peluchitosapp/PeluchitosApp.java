package com.example.carlosjose95.peluchitosapp;

import android.app.Application;
import android.content.Context;

public class PeluchitosApp extends Application {

    private static Context mContext;

    public static Context getmContext() {
        return mContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
    }
}
