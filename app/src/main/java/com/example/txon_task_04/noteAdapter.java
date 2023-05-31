package com.example.txon_task_04;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class noteAdapter extends RecyclerView.Adapter< noteAdapter .ViewHolder> {

    private ArrayList<NoteModel> noteModalArrayList;
    private Context context;

    // constructor
    public  noteAdapter (ArrayList<NoteModel> noteModalArrayList, Context context) {
        this.noteModalArrayList = noteModalArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_note_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        NoteModel modal = noteModalArrayList.get(position);
        holder.titlea.setText(modal.getTitle());
        holder.desca.setText(modal.getTime());
        holder.timea.setText(modal.getDate() );
        holder.aTracks.setText(modal.getDescription() );

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // on below line we are calling an intent.
                Intent i = new Intent(context, updatenotes.class);

                // below we are passing all our values.
                i.putExtra("name", modal.getTitle());
                i.putExtra("description", modal.getDescription() );
                i.putExtra("duration", modal.getTime());
                i.putExtra("tracks", modal.getDate());

                // starting our activity.
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        // returning the size of our array list
        return noteModalArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        // creating variables for our text views.
        private TextView titlea, desca,timea, aTracks;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // initializing our text views
            titlea= itemView.findViewById(R.id.idtitle);
            desca = itemView.findViewById(R.id.iddescription);
            timea = itemView.findViewById(R.id.idtime);
            aTracks = itemView.findViewById(R.id.idTracks);
        }
    }
}
