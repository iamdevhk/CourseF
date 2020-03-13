package com.example.coursef;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class Second extends AppCompatActivity {
    public static int user=0;
    public static String url="http://dc032546.ngrok.io/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    public void enter(View view){

        RadioButton stud = (RadioButton) findViewById(R.id.Student);
        boolean s = stud.isChecked();
        RadioButton fac = (RadioButton) findViewById(R.id.faculty);
        boolean f = fac.isChecked();

        if (s == true) {
            user=1;
            Intent log = new Intent(Second.this, loginscreen.class);

            // Start the new activity
            startActivity(log);

        } else if (f == true) {
            user=0;
            Intent log = new Intent(Second.this, loginscreen.class);

            // Start the new activity
            startActivity(log);
        }
        else
            Toast.makeText(this, "select either one", Toast.LENGTH_SHORT).show();
    }


}