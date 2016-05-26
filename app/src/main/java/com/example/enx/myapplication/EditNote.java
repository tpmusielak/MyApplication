package com.example.enx.myapplication;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.EditText;

public class EditNote extends AppCompatActivity {

    private String m_noteText = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_note);

        Intent i = getIntent();
        if(i != null)
        {
            long noteId = i.getIntExtra("NoteId", 0);
            setTitle(String.format("Note" + noteId));

            String noteText = i.getStringExtra("Note");
            if(noteText != null) {
                m_noteText = noteText;
            }
        }

        EditText editText = (EditText) findViewById(R.id.editText);
        editText.setText(m_noteText);

        ActionBar ab = getSupportActionBar();
        if(ab != null)
        {
            ab.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_add:
                NavUtils.navigateUpFromSameTask(this);
                return true;

            case R.id.action_delete:
                // User chose the "Favorite" action, mark the current item
                // as a favorite...
                NavUtils.navigateUpFromSameTask(this);
                return true;
            default:
                return false;

        }
    }
}
