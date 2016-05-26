package com.example.enx.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by enx on 25/05/2016.
 */
public class NotesStorageHelper extends SQLiteOpenHelper {

    private static final int DB_VERSION = 1;
    private static final String NOTES_TABLE_NAME = "notes";
    private static final String NOTES_TABLE_CREATE =
            "CREATE TABLE " + NOTES_TABLE_NAME + "(" +
                    "note_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                    "note TEXT);";

    public NotesStorageHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(NOTES_TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        throw new UnsupportedOperationException(); // TODO: implement
    }
}
