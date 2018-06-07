package com.ameed.firstdb.events;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class EventsDBHelper extends SQLiteOpenHelper {
    public static final String DB_NAME = "MY_FIRST_DB";
    private static final String CREATE_BOOKS_TABLE =
            "CREATE TABLE " + Event.TABLE_NAME + "("
                    + Event.ID + " INTEGER PRIMARY KEY,"
                    + Event.DESCRIPTION + " TEXT,"
                    + Event.START + " INTEGER)";

    public EventsDBHelper(Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.w(getClass().getSimpleName(), "Creating all the tables");

        try {
            db.execSQL(CREATE_BOOKS_TABLE);
        } catch (SQLiteException ex) {
            Log.e(getClass().getSimpleName(), "Create table exception: " + ex.getMessage());
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
