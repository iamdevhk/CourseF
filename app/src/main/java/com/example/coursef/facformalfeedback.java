package com.example.coursef;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class facformalfeedback extends AppCompatActivity {
    ListView listView;
    TextView textView;
    public static int hk=0;
    public static String ans1,ans2,ans3,course;

    String[] listItem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facformalfeedback);
        listView=(ListView)findViewById(R.id.listView);
        textView=(TextView)findViewById(R.id.textView);
        TextView txtProduct = (TextView) findViewById(R.id.coursename);

        String passedArg = getIntent().getExtras().getString("course");
        course=passedArg;
        // displaying selected product name
        txtProduct.setText(passedArg);
        listItem = getResources().getStringArray(R.array.ffquestions);
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, listItem);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                String course = ((TextView) view).getText().toString();
                if (position == 0) {
                    hk=0;
                    Intent dbms = new Intent(facformalfeedback.this, facformalfeedbackdisp.class);
                    dbms.putExtra("course", course);
                    startActivity(dbms);

                }
                else if (position == 1) {
                    hk=1;
                    Intent cc = new Intent(facformalfeedback.this,facformalfeedbackdisp.class);
                    cc.putExtra("course", course);
                    startActivity(cc);
                }
                else if (position == 2) {
                    hk=2;
                    Intent a = new Intent(facformalfeedback.this,  facformalfeedbackdisp.class);
                    a.putExtra("course", course);
                    startActivity(a);
                }



            }
        });
    }
}
