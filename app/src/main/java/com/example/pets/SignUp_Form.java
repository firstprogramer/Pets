package com.example.pets;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

public class SignUp_Form extends AppCompatActivity {
    private EditText mNID, mFullName, mAddress;
    private RadioButton mMale, mFemale;
    private EditText mTel;
    private EditText mUserName, mPassword, mConfirmPassword;
    private Spinner mReligionSpinner;
    private int mReligion, mGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up__form);
        // to set screen title
        getSupportActionBar().setTitle("Sign up Form");

        // Find all relevant views that we will need to read user input from
        mNID = findViewById(R.id.text_national_id);
        mFullName = findViewById(R.id.text_fullName);
        mAddress = findViewById(R.id.text_address);
        mMale = findViewById(R.id.opMale);
        mFemale = findViewById(R.id.opFemale);
        mTel = findViewById(R.id.text_tel);
        mReligionSpinner = findViewById(R.id.spinner_gender);
        mUserName = findViewById(R.id.text_userName);
        mPassword = findViewById(R.id.text_password);
        mConfirmPassword = findViewById(R.id.text_confirmPassword);

        setupSpinner();
    }

    public void setupSpinner() {
        // Create adapter for spinner. The list options are from the String array it will use
        // the spinner will use the default layout
        ArrayAdapter religionSpinnerAdapter = ArrayAdapter.createFromResource(this,
                R.array.array_religion_options, android.R.layout.simple_spinner_item);

        // Specify dropdown layout style - simple list view with 1 item per line
        religionSpinnerAdapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);

        // Apply the adapter to the spinner
        mReligionSpinner.setAdapter(religionSpinnerAdapter);

        // Set the integer mSelected to the constant values
        mReligionSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selection = (String) parent.getItemAtPosition(position);
                if (!TextUtils.isEmpty(selection)) {
                    if (selection.equals(getString(R.string.spinner_one))) {
                        mReligion = 1; // muslim
                    } else if (selection.equals(getString(R.string.spinner_two))) {
                        mReligion = 2; // christian
                    } else {
                        mReligion = 0; // other
                    }
                }
            }

            // Because AdapterView is an abstract class, onNothingSelected must be defined
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                mReligion = 1; // Muslim
            }
        });
    }

    // to show menu on this screen
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_sons, menu);
        return true;
    }

    // code fire when user click any menu item
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.first:
                Toast.makeText(this, "Doctor Bassem", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(), CatalogActivity.class));
                return true;
            case R.id.second:
                Toast.makeText(this, "Doctor Amr moro", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.third:
                Toast.makeText(this, "Doctor Ramy my sweethheart", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.fourth:
                Toast.makeText(this, "Doctor Malek lokaaa", Toast.LENGTH_SHORT).show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
