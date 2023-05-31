package com.example.txon_task_04;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class updatenotes extends AppCompatActivity {

    private EditText titleNameEdt, titleTracksEdt, titleDurationEdt, titleDescriptionEdt;
    private Button updateBtn, deleteBtn;
    private DBHandler dbHandler;
    String titleName, titleDesc, titleDuration, titleTracks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updatenotes);

        titleNameEdt = findViewById(R.id.idtitleeName);
        titleTracksEdt = findViewById(R.id.idtitleTracks);
        titleDurationEdt = findViewById(R.id.idtitleDuration);
        titleDescriptionEdt = findViewById(R.id.idtitleDescription);
        updateBtn = findViewById(R.id.idBtnUpdate);
        deleteBtn = findViewById(R.id.idBtnDelete);


        dbHandler = new DBHandler(updatenotes.this);

        titleName = getIntent().getStringExtra("name");
        titleDesc = getIntent().getStringExtra("description");
        titleDuration = getIntent().getStringExtra("duration");
        titleTracks= getIntent().getStringExtra("tracks");


        titleNameEdt.setText(titleName);
        titleDescriptionEdt.setText(titleDesc);
        titleTracksEdt.setText(titleTracks);
        titleDurationEdt.setText(titleDuration);


        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                dbHandler.updatenote(titleName, titleNameEdt.getText().toString(), titleTracksEdt.getText().toString(), titleDurationEdt.getText().toString(),titleDescriptionEdt.getText().toString());

                Toast.makeText(updatenotes.this, "Note Updated..", Toast.LENGTH_SHORT).show();

                Intent i = new Intent(updatenotes.this, MainActivity.class);
                startActivity(i);
            }
        });


        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dbHandler.deletenote(titleName);
                Toast.makeText(updatenotes.this, "Deleted the Note", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(updatenotes.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
}
