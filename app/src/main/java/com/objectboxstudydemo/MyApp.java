package com.objectboxstudydemo;

import android.app.Application;

import io.objectbox.BoxStore;

public class MyApp extends Application {

    private BoxStore boxStore;

    @Override
    public void onCreate() {
        super.onCreate();
        boxStore = MyObjectBox.builder().androidContext(MyApp.this).build();
    }

    public BoxStore getBoxStore() {
        return boxStore;
    }
}
