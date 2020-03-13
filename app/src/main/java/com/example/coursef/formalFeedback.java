package com.example.coursef;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class formalFeedback extends AppCompatActivity {
    public static String ans1,ans2,ans3,course;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formal_feedback);
        TextView txtProduct = (TextView) findViewById(R.id.coursename);

        String passedArg = getIntent().getExtras().getString("course");
        course=passedArg;
        // displaying selected product name
        txtProduct.setText(passedArg);
    }
    public void login(View view)
    {
        EditText text2 = (EditText) findViewById(R.id.answer1);
        ans1 = text2.getText().toString();
        EditText text3 = (EditText) findViewById(R.id.answer2);
        ans2 = text3.getText().toString();
        EditText text4 = (EditText) findViewById(R.id.answer3);
        ans3 = text4.getText().toString();

        if(ans1.length()==0||ans2.length()==0||ans3.length()==0)
        {
            Toast.makeText(this, "please enter all the fields", Toast.LENGTH_SHORT).show();
        }

        else {
            ffdynamic hu = new ffdynamic(this.getApplicationContext());
            hu.execute();

        }
    }
}
