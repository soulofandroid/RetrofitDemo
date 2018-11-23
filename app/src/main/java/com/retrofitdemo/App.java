package com.retrofitdemo;

import android.app.Application;
import android.content.Context;

/**
 * <p>作者   wurui</p>
 * <p>时间   2018/11/23 0023</p>
 * <p>包名   com.retrofitdemo</p>
 * <p>描述   TODO</p>
 */
public class App extends Application {

    private static Context appContext;

    @Override
    public void onCreate() {
        super.onCreate();
        appContext = this.getApplicationContext();
    }

    public static Context getAppContext() {
        return appContext;
    }
}
