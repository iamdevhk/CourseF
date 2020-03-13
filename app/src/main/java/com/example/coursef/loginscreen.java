package com.example.coursef;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class loginscreen extends AppCompatActivity {
    public static String namee, service, phnum, emails, password;
    public int vj = Second.user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginscreen);

    }

    public void login(View view) {
        Log.isLoggable("po", vj);
        EditText text2 = (EditText) findViewById(R.id.input_email);
        emails = text2.getText().toString();
        EditText text3 = (EditText) findViewById(R.id.input_password);
        password = text3.getText().toString();
        if (vj == 0) {
            response hu = new response(this.getApplicationContext());
            hu.execute();
        } else if (vj == 1) {
            //Intent al = new Intent(loginscreen.this, Component.class);

            // Start the new activity
            //startActivity(al);
           response hu = new response(this.getApplicationContext());
            hu.execute();
        }


    }


    public void siggn(View view) {
        if (vj == 1) {
            Intent al = new Intent(loginscreen.this, Signup.class);

            // Start the new activity
            startActivity(al);
        } else if (vj == 0) {
            Intent al = new Intent(loginscreen.this,facsignup.class);
            startActivity(al);
        }
    }
}
