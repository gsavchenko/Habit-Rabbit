package com.honeycomb.habitrabbit;

import android.app.Application;

/**
 * Created by Jason on 08/03/2016.
 */
public class MyApp extends Application {
    public MainController _mController = new MainController(new dbConnection(this));
    public c_Habit currentHabit;
}

