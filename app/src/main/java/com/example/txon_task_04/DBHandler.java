package com.example.txon_task_04;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBHandler extends SQLiteOpenHelper {

    private static final String DB_NAME = "notedb";
    private static final int DB_VERSION = 1;
    private static final String TABLE_NAME = "mynotes";
    private static final String ID_COL = "id";
    private static final String NAME_COL = "name";
    private static final String DURATION_COL = "duration";
    private static final String DESCRIPTION_COL = "description";
    private static final String TRACKS_COL = "tracks";
    public DBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + NAME_COL + " TEXT,"
                + DURATION_COL + " TEXT,"
                + DESCRIPTION_COL + " TEXT,"
                + TRACKS_COL + " TEXT)";
        db.execSQL(query);
    }
    public void addNewnote(String noteName, String noteDuration, String noteDescription, String noteTracks) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(NAME_COL, noteName);
        values.put(DURATION_COL, noteDuration);
        values.put(DESCRIPTION_COL, noteDescription);
        values.put(TRACKS_COL, noteTracks);

        db.insert(TABLE_NAME, null, values);

        db.close();
    }

    public ArrayList<NoteModel> readnotes() {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursorCourses = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);


        ArrayList<NoteModel> courseModalArrayList = new ArrayList<>();


        if (cursorCourses.moveToFirst()) {
            do {

                courseModalArrayList.add(new NoteModel(cursorCourses.getString(1),
                        cursorCourses.getString(4),
                        cursorCourses.getString(2),
                        cursorCourses.getString(3)));
            } while (cursorCourses.moveToNext());

        }

        cursorCourses.close();
        return courseModalArrayList;
    }

    public void updatenote(String originalCourseName, String courseName, String courseDuration,
                             String courseTracks, String courseDescription) {


        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NAME_COL, courseName);
        values.put(DURATION_COL, courseDuration);
        values.put(TRACKS_COL, courseTracks);
        values.put(DESCRIPTION_COL, courseDescription);

        db.update(TABLE_NAME, values, "name=?", new String[]{originalCourseName});
        db.close();
    }

    public void deletenote(String courseName) {


        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(TABLE_NAME, "name=?", new String[]{courseName});
        db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
