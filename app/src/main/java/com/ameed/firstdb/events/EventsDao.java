package com.ameed.firstdb.events;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import static com.ameed.firstdb.events.Event.TABLE_NAME;

public class EventsDao {
    private EventsDBHelper helper;

    public EventsDao(Context context) {
        this.helper = new EventsDBHelper(context);
    }

    public void addEvent(Event event) {
        final SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues eventRecord = new ContentValues();
        eventRecord.put(Event.DESCRIPTION, event.getDescription());
        eventRecord.put(Event.START, event.getStart());
        try {
            db.insert(TABLE_NAME, null, eventRecord);
        } catch (Exception e) {
            Log.e(getClass().getSimpleName(), "Error inserting record", e);
        }
    }

    public List<Event> getAll() {
        final SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = db.query(
                TABLE_NAME,
                new String[]{Event.ID, Event.DESCRIPTION, Event.START},
                null,
                null,
                null,
                null,
                null);
        List<Event> events = new ArrayList<>();
        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String description = cursor.getString(2);
            String start = cursor.getString(1);
            events.add(new Event(id, start, description));
        }
        cursor.close();
        db.close();
        return events;
    }

    public void deleteAll() {
        final SQLiteDatabase db = helper.getWritableDatabase();
        db.execSQL("delete from " + TABLE_NAME);
        db.close();
    }
}
