package com.objectboxstudydemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import java.util.Date;
import java.util.List;

import io.objectbox.Box;

public class ObjectBoxActivity extends AppCompatActivity {

    private Box<Note> notesBox;
    private Note note;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        notesBox = ((MyApp) getApplication()).getBoxStore().boxFor(Note.class);

    }

    public void insert(View view) {
        note = new Note(0, "3D打印宇宙飞船", "666", new Date());
        notesBox.put(note);
        Toast.makeText(this,"Inserted new note, ID: " + note.getId(), Toast.LENGTH_SHORT).show();
    }

    public void delete(View view) {
        if(note!=null){
            notesBox.remove(note);
            Toast.makeText(this,"删除成功", Toast.LENGTH_SHORT).show();
        }
    }

    public void update(View view) {
        if(note!=null){
            note.setText("This note has changed.");
            notesBox.put(note);
            Toast.makeText(this,"更新成功", Toast.LENGTH_SHORT).show();
        }
    }

    public void get(View view) {
        if(note!=null){
            Toast.makeText(this,notesBox.get(note.getId()).toString(), Toast.LENGTH_LONG).show();
        }
    }

    public void getAll(View view) {
        List<Note> notes = notesBox.getAll();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < notes.size(); i++) {
            stringBuilder.append(notes.get(i).toString()).append("\n");
        }
        Toast.makeText(this,stringBuilder.toString(), Toast.LENGTH_LONG).show();
    }

    public void count(View view) {
        Toast.makeText(this,notesBox.count()+"条", Toast.LENGTH_LONG).show();
    }


}
