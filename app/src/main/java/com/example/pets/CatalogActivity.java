package com.example.pets;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.example.pets.data.PetContract.PetEntry;

import com.example.pets.data.PetDbHelper;

/**
 * Displays list of pets that were entered and stored in the app.
 */
public class CatalogActivity extends AppCompatActivity {
    private PetDbHelper mDbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalog);

        // Setup FAB to open EditorActivity
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CatalogActivity.this, EditorActivity.class);
                startActivity(intent);
            }
        });
        mDbHelper = new PetDbHelper(this);
        /// new code
        displayDatabaseInfo();
    }

    @Override
    protected void onStart() {
        super.onStart();
        // to update textView after insert new pet from the EditorActivity
        displayDatabaseInfo();
    }

    private void displayDatabaseInfo() {
        // To access our database, we instantiate our subclass of SQLiteOpenHelper
        // and pass the context, which is the current activity.
        ////////mDbHelper = new PetDbHelper(this);

        // Create and/or open a database to read from it
        // notice we use getWritableDatabase for insertion
        // where we use getReadableDatabase() for select data from the tables
        SQLiteDatabase db = mDbHelper.getReadableDatabase();
        ////////////// new code
        //define projection to hold returned columns name
        String[] projection = {PetEntry._ID,
                PetEntry.COL_NAME,
                PetEntry.COL_BREED,
                PetEntry.COL_GENDER,
                PetEntry.COL_WEIGHT};
        //define selection to hold condition statement "where"
        String selection = PetEntry.COL_GENDER + "=?";
        // use next array instead of writing "=?" to avoid sql injection
        String[] selectionArgs = new String[] { String.valueOf(PetEntry.GENDER_MALE) };

        Cursor cursor = db.query(PetEntry.TABLE_NAME,projection,null,null,null,null,null);

        //////// end of new code
        /*/////////////////old code
        // Perform this raw SQL query "SELECT * FROM pets"
        // to get a Cursor that contains all rows from the pets table.
        Cursor cursor = db.rawQuery("SELECT * FROM " + PetEntry.TABLE_NAME, null);
        /////////////////end of old code*/
        try {
            TextView displayView = (TextView) findViewById(R.id.text_view_pet);
            // Display the number of rows in the Cursor (which reflects the number of rows in the
            // pets table in the database).and display name of columns
            displayView.setText("The pets table contains: " + cursor.getCount() + "pets.\n\n");
            displayView.append(PetEntry._ID + "--" + PetEntry.COL_NAME + "--" +
                     PetEntry.COL_BREED + "--" + PetEntry.COL_GENDER + "--" + PetEntry.COL_NAME +"\n");
            // this line to check commit to github
            // obtain the index of each column
            int idColumnIndex = cursor.getColumnIndex(PetEntry._ID);
            int nameColumnIndex = cursor.getColumnIndex(PetEntry.COL_NAME);
            int breedColumnIndex = cursor.getColumnIndex(PetEntry.COL_BREED);
            int genderColumnIndex = cursor.getColumnIndex(PetEntry.COL_GENDER);
            int weightColumnIndex = cursor.getColumnIndex(PetEntry.COL_WEIGHT);
            while (cursor.moveToNext()){
                // get data from current row
                int currentID = cursor.getInt(idColumnIndex);
                String currentName = cursor.getString(nameColumnIndex);
                String currentBreed = cursor.getString(breedColumnIndex);
                int currentGender = cursor.getInt(genderColumnIndex);
                int currentWeight = cursor.getInt(weightColumnIndex);
                // Display the values from each column of the current row in the TextView
                displayView.append(("\n" + currentID + " -- " +
                        currentName + " -- " +
                        currentBreed + " -- " +
                        currentGender + " -- " +
                        currentWeight));
            }

        } finally {
            // Always close the cursor when you're done reading from it. This releases all its
            // resources and makes it invalid.
            cursor.close();
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu options from the res/menu/menu_catalog.xml file.
        // This adds menu items to the app bar.
        getMenuInflater().inflate(R.menu.menu_catalog, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // User clicked on a menu option in the app bar overflow menu
        switch (item.getItemId()) {
            // Respond to a click on the "Insert dummy data" menu option
            case R.id.action_insert_dummy_data:
                /////insertPet();
                displayDatabaseInfo();
                return true;
            // Respond to a click on the "Delete all entries" menu option
            case R.id.action_delete_all_entries:
                // Do nothing for now
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
