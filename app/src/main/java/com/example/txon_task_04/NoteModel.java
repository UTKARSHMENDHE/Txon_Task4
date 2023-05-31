package com.example.txon_task_04;


public class NoteModel {


    private String title;
    private String time;
    private String date;
    private String description;
    private int id;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public NoteModel(String title, String time, String date, String description) {
        this.title = title;
        this.time = time;
        this.date = date;
        this.description = description;
    }
}


