package com.honeycomb.habitrabbit;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jason on 08/03/2016.
 */
public class dbConnection extends SQLiteOpenHelper {
    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "HoneyComb_DB";

    // table names
    private static final String TABLE_HABITS = "tblhabits";
    private static final String TABLE_METRICS = "tblmetrics";
    // habit fields
    private static final String KEY_HABIT_NAME = "name";
    private static final String KEY_HABIT_METRIC = "metric";
    private static final String KEY_HABIT_COLOUR = "colour";
    private static final String KEY_HABIT_DESC = "description";

    //metric fieds
    private static final String KEY_METRIC_VAL = "metric";


    public dbConnection(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_HABIT_TABLE = "CREATE TABLE " + TABLE_HABITS + "("
                + KEY_HABIT_NAME + " TEXT," + KEY_HABIT_METRIC + " TEXT,"
                + KEY_HABIT_COLOUR + " TEXT," + KEY_HABIT_DESC + " TEXT" + ")";
        db.execSQL(CREATE_HABIT_TABLE);
        String CREATE_METRIC_TABLE = "CREATE TABLE " + TABLE_METRICS + "("
                + KEY_HABIT_NAME + " TEXT," + KEY_METRIC_VAL + " INTEGER)";
        db.execSQL(CREATE_METRIC_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_HABITS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_METRICS);
        onCreate(db);
    }

    public boolean AddHabit(c_Habit h) {
        int ret = 0; //aka. failed
        SQLiteDatabase db = this.getWritableDatabase();
        try {

            ContentValues values = new ContentValues();
            values.put(KEY_HABIT_NAME, h.name);
            values.put(KEY_HABIT_DESC, h.desc);
            values.put(KEY_HABIT_COLOUR, h.colour);
            values.put(KEY_HABIT_METRIC, h.metric);
            long val = db.insert(TABLE_HABITS, null, values);
            if (val > 0) {
                ret++;
            }
        }
        catch (Exception ex) {

        }
        finally {
            db.close();
        }
        return (ret > 0);
    }

    public List<c_Habit> GetAllHabits() {
        List<c_Habit> ret = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_HABITS;
        Cursor c = db.rawQuery(query, new String[]{});
        try {
            if (c != null)
                c.moveToFirst();

            do {
                c_Habit h = new c_Habit();
                h.name = c.getString(c.getColumnIndex(KEY_HABIT_NAME));
                h.desc = c.getString(c.getColumnIndex(KEY_HABIT_DESC));
                h.colour = c.getString(c.getColumnIndex(KEY_HABIT_COLOUR));
                h.metric = c.getString(c.getColumnIndex(KEY_HABIT_METRIC));
                ret.add(h);
            } while (c.moveToNext());
        }
        catch (Exception ex) {

        }
        finally {
            c.close();
            db.close();
        }
        return ret;
    }

    public boolean AddMetric(String habitName, int metric) {
        int ret = 0; //aka. failed
        SQLiteDatabase db = this.getWritableDatabase();
        try {
            ContentValues values = new ContentValues();
            values.put(KEY_HABIT_NAME, habitName);
            values.put(KEY_METRIC_VAL, metric);
            long val = db.insert(TABLE_METRICS, null, values);
            if (val > 0) {
                ret++;
            }
        }
        catch (Exception ex) {

        }
        finally {
            db.close();
        }
        return (ret > 0);
    }

    public List<Integer> GetMetrics(String habitName) {
        List<Integer> metrics = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_METRICS + " WHERE " + KEY_HABIT_NAME + " = ?";
        Cursor c = db.rawQuery(query, new String[]{habitName}); //one parameter
        try {
            if (c != null)
                c.moveToFirst();

            do {
                Integer i = c.getInt(c.getColumnIndex(KEY_METRIC_VAL));
                metrics.add(i);
            } while (c.moveToNext());
        }
        catch (Exception ex) {

        }
        finally {
            c.close();
            db.close();
        }
        return metrics;
    }
}
