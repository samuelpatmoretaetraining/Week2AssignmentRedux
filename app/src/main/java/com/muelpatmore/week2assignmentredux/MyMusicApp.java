package com.muelpatmore.week2assignmentredux;

import android.app.Application;
import android.content.Context;

/**
 * Created by Samuel on 27/11/2017.
 */

public class MyMusicApp extends Application {

    private static MyMusicApp sApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        sApplication = this;
    }

    public static Application getApplication() {
        return sApplication;
    }

    public static Context getContext() {
        return getApplication().getApplicationContext();
    }
}
