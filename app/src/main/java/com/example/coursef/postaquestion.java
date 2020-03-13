package com.example.coursef;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class postaquestion extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    public static String name,choice,desc;
    public static String namee, service, phnum, emails,branch;
    public static String chosen="";
    public int hk=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_postaquestion);

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        choice=adapterView.getItemAtPosition(i).toString();
        if(choice.equals("Question"))
        {
            hk=0;
            chosen="Question";
        }
       else if(choice.equals("Answer"))
        {
            hk=1;
            chosen="Answer";
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
    public void login(View view)
    {
        EditText text2 = (EditText) findViewById(R.id.input_name);
        name = text2.getText().toString();

        if(name.length()==0)
        {
            Toast.makeText(this, "Please enter the Question", Toast.LENGTH_SHORT).show();
        }

        else {
            postaquesresp hu = new postaquesresp(this.getApplicationContext());
            hu.execute();

        }
    }
}
