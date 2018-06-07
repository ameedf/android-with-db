package com.ameed.firstdb;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;

import com.ameed.firstdb.events.Event;
import com.ameed.firstdb.events.EventsAdapter;
import com.ameed.firstdb.events.EventsDao;

public class MainActivity extends AppCompatActivity {
    private EventsDao dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.dao = new EventsDao(getApplicationContext());

        final EditText startDateInput = findViewById(R.id.startDateInput);
        startDateInput.setOnClickListener(v -> {
            DatePickerDialog dialog = new DatePickerDialog(
                    this, //context
                    (view, year, month, dayOfMonth) ->
                            ((EditText) v).setText(String.format("%02d/%02d/%04d", dayOfMonth, (month + 1), year)),
                    2018, // year
                    0, // month
                    1);
            dialog.show();
        });

        final EventsAdapter adapter = new EventsAdapter(this, dao);

        final Button addBtn = findViewById(R.id.addBtn);
        addBtn.setOnClickListener(v -> {
            EditText description = findViewById(R.id.descriptionInput);
            EditText startDate = findViewById(R.id.startDateInput);
            Event event = new Event();
            event.setDescription(description.getText().toString());
            event.setStart(startDate.getText().toString());
            dao.addEvent(event);
            adapter.add(event);
        });

        GridView events = findViewById(R.id.eventsView);
        events.setAdapter(adapter);

    }
}
