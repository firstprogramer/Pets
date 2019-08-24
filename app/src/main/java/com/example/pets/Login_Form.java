package com.example.pets;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Login_Form extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login__form);
        getSupportActionBar().setTitle("Login Form");
    }

    public void btn_signup_form(View view) {
        // open sign up screen with Intent in one line of code
        startActivity(new Intent(getApplicationContext(),SignUp_Form.class));
    }

    public void btn_login(View view) {
        startActivity(new Intent(getApplicationContext(),Choose_category.class));
    }
}
