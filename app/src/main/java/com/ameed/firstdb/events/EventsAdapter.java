package com.ameed.firstdb.events;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.ArrayAdapter;

public class EventsAdapter extends ArrayAdapter<Event> {

    public EventsAdapter(@NonNull Context context, EventsDao dao) {
        super(context, android.R.layout.simple_list_item_1);
        super.addAll(dao.getAll());
    }
}
