package com.honeycomb.habitrabbit;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

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

    // habit fields
    private static final String KEY_HABIT_NAME = "name";
    private static final String KEY_HABIT_METRIC = "metric";
    private static final String KEY_HABIT_COLOUR = "colour";
    private static final String KEY_HABIT_DESC = "description";


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
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_HABITS);
        onCreate(db);
    }
}
