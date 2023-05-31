package com.example.txon_task_04;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class viewnotes extends AppCompatActivity {

    // creating variables for our array list,
    // dbhandler, adapter and recycler view.
    private ArrayList<NoteModel> NOTEModalArrayList;
    private DBHandler dbHandler;
    private noteAdapter NOTESRVAdapter;
    private RecyclerView NOTESRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_notes);

        NOTEModalArrayList = new ArrayList<>();
        dbHandler = new DBHandler(viewnotes.this);

        NOTEModalArrayList = dbHandler.readnotes();

        NOTESRVAdapter = new noteAdapter(NOTEModalArrayList, viewnotes.this);
        NOTESRV = findViewById(R.id.idRVCourses);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(viewnotes.this, RecyclerView.VERTICAL, false);
        NOTESRV.setLayoutManager(linearLayoutManager);

        NOTESRV.setAdapter(NOTESRVAdapter);
    }
}
