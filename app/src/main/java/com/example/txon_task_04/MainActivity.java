package com.example.txon_task_04;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

      EditText title,time,date,description;
      Button note,readnote;
    private DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        title=findViewById(R.id.Title);
        time=findViewById(R.id.time);
        date=findViewById(R.id.date);
        description=findViewById(R.id.Description);
        note=findViewById(R.id.addnotes);
        readnote=findViewById(R.id.readnotes);
        dbHandler = new DBHandler(MainActivity.this);

       note.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String titlee = title.getText().toString();
                String timee= time.getText().toString();
                String datee= date.getText().toString();
                String descriptione = description.getText().toString();

                if (titlee.isEmpty() && timee.isEmpty() && datee.isEmpty() &&  descriptione.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter the data..", Toast.LENGTH_SHORT).show();
                    return;
                }

                dbHandler.addNewnote(titlee, timee, datee, descriptione);

                Toast.makeText(MainActivity.this, "Note has been added.", Toast.LENGTH_SHORT).show();
                title.setText("");
                time.setText("");
                date.setText("");
               description.setText("");
            }
        });

       readnote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MainActivity.this, viewnotes.class);
                startActivity(i);
            }
        });
    }


}
