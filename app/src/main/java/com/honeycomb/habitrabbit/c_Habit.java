package com.honeycomb.habitrabbit;

/**
 * Created by Jason on 09/03/2016.
 */
public class c_Habit {

    public c_Habit() {
        this.name = "";
        this.desc = "";
        this.colour = "";
        this.metric = "";
    }

    public c_Habit(String n, String d, String c, String m) {
        this.name = n;
        this.desc = d;
        this.colour = c;
        this.metric = m;
    }

    public String name;
    public String desc;
    public String colour;
    public String metric;

    @Override
    public String toString() {
        return this.name;
    }
}
