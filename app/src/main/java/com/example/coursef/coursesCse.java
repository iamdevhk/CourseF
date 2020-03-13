package com.example.coursef;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class coursesCse extends AppCompatActivity {
    ListView listView;
    TextView textView;
    String[] listItem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses_cse);
        listView=(ListView)findViewById(R.id.listView);
        textView=(TextView)findViewById(R.id.textView);
        listItem = getResources().getStringArray(R.array.courses);
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, listItem);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                String course = ((TextView) view).getText().toString();
                if (position == 0) {
                    Intent dbms = new Intent(coursesCse.this, formalFeedback.class);
                    dbms.putExtra("course", course);
                    startActivity(dbms);

                }
                else if (position == 1) {
                    Intent cc = new Intent(coursesCse.this, formalFeedback.class);
                    cc.putExtra("course", course);
                    startActivity(cc);
                }
                else if (position == 2) {
                    Intent a = new Intent(coursesCse.this,  formalFeedback.class);
                    a.putExtra("course", course);
                    startActivity(a);
                }
                else if (position == 3) {
                    Intent se= new Intent(coursesCse.this, formalFeedback.class);
                    se.putExtra("course", course);
                    startActivity(se);
                }
                else if (position == 4) {
                    Intent cd= new Intent(coursesCse.this,  formalFeedback.class);
                    cd.putExtra("course", course);
                    startActivity(cd);
                }
                else if (position == 5) {
                    Intent ml= new Intent(coursesCse.this,  formalFeedback.class);
                    ml.putExtra("course", course);
                    startActivity(ml);
                }
                else if (position == 6) {
                    Intent ol = new Intent(coursesCse.this,  formalFeedback.class);
                    ol.putExtra("course", course);
                    startActivity(ol);
                }
                else if (position == 7) {
                    Intent n= new Intent(coursesCse.this,  formalFeedback.class);
                    n.putExtra("course", course);
                    startActivity(n);
                }


            }
        });
    }
}
