// this class to create the database and its columns
package com.example.pets.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.pets.data.PetContract.PetEntry;

public class PetDbHelper extends SQLiteOpenHelper {
    public static final String LOG_TAG = PetDbHelper.class.getSimpleName();
    private static final String DATABASE_NAME = "shelter.db";
    private static final int DATABASE_VERSION = 1;

    // the constructor
    public PetDbHelper( Context context){
        super(context,DATABASE_NAME, null, DATABASE_VERSION);
    }
    //This is called when the database is created for the first time.
    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create a String that contains the SQL statement to create the pets table
        // remember to add the import the next statement
        // import com.example.pets.data.PetContract.PetEntry;
        String SQL_CREATE_PETS_TABLE =  "CREATE TABLE " + PetEntry.TABLE_NAME + " ("
                + PetEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + PetEntry.COL_NAME + " TEXT NOT NULL, "
                + PetEntry.COL_BREED + " TEXT, "
                + PetEntry.COL_GENDER + " INTEGER NOT NULL, "
                + PetEntry.COL_WEIGHT + " INTEGER NOT NULL DEFAULT 0);";
        // Execute the SQL statement
        db.execSQL(SQL_CREATE_PETS_TABLE);
        // the execSQL used only in create or modify database
        // not in select or update or delete or insert
    }

     // This is called when the database needs to be upgraded.
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // The database is still at version 1, so there's nothing to do be done here.
    }
}
