package com.ameed.firstdb.events;

public class Event {
    public static final String TABLE_NAME = "EVENTS";
    public static final String ID = "ID";
    public static final String DESCRIPTION = "DESCRIPTION";
    public static final String START = "START";

    private Integer id;
    private String start;
    private String description;

    public Event() {
    }

    public Event(Integer id, String start, String description) {
        this.id = id;
        this.start = start;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return String.format("The event %s will start at %s", description, start);
    }
}
