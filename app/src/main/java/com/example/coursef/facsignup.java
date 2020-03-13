package com.example.coursef;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class facsignup extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    public static String name, email, phnnum, dept,sem,pass;
    public static String namee, service, phnum, emails,branch;
    private Spinner spinner,spinnerone;
    Button btnDatePicker, btnTimePicker, btnservicee;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facsignup);
        // spinner = findViewById(R.id.spinner);
        //ArrayAdapter<CharSequence> bb = ArrayAdapter.createFromResource(this, R.array.Department, android.R.layout.simple_spinner_item);
        //bb.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //spinner.setAdapter(bb);
        //spinner.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);
        //spinnerone = findViewById(R.id.spinnertwo);
        //ArrayAdapter<CharSequence> cc = ArrayAdapter.createFromResource(this, R.array.Year, android.R.layout.simple_spinner_item);
        //cc.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //spinnerone.setAdapter(cc);
        //spinnerone.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);

        Spinner spin = (Spinner) findViewById(R.id.spinner);
        //ArrayAdapter<String> aa = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, Depa);
        ArrayAdapter<CharSequence> bb = ArrayAdapter.createFromResource(this, R.array.Department, android.R.layout.simple_spinner_item);
        bb.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(bb);
        // spin.setOnItemSelectedListener(new CountriesSpinnerClass());
        spin.setOnItemSelectedListener(this);


        // spin2.setOnItemSelectedListener(new CitiesSpinnerClass());
    }
    public void login(View view) {
        EditText text2 = (EditText) findViewById(R.id.input_name);
        name = text2.getText().toString();
        EditText t = (EditText) findViewById(R.id.input_email);
        email = t.getText().toString();
        EditText text3 = (EditText) findViewById(R.id.input_num);
        phnnum = text3.getText().toString();
        EditText text7 = (EditText) findViewById(R.id.input_password);
        pass = text7.getText().toString();
        boolean h=isEmailValid(email);
        if(name.length()==0||email.length()==0||phnnum.length()<10||phnnum.length()>10)
        {
            Toast.makeText(this, "please enter all the fields", Toast.LENGTH_SHORT).show();
        }

        else {
            facsignupresponse hu = new facsignupresponse(this.getApplicationContext());
            hu.execute();

        }
    }




    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        if(adapterView.getId() == R.id.spinner)
        {
            dept=adapterView.getItemAtPosition(i).toString();
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
    public static boolean isEmailValid(String email) {
        boolean isValid = false;

        String expression = "^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]{1}|[\\w-]{2,}))@"
                + "((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
                + "([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])){1}|"
                + "([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$";
        // "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        CharSequence inputStr = email;

        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputStr);
        if (!matcher.matches()) {
            isValid = true;
        }
        return isValid;
    }

}

