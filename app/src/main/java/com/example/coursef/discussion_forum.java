package com.example.coursef;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class discussion_forum extends AppCompatActivity {
    public ListView listView;
    public String email = loginscreen.emails;
    TextView textView;
    public int vj = Second.user;
    public String freak=Second.url;
    public String course="";
    public int ch=Component.choice;
    List<String> listItem=new ArrayList<String>();
    ArrayAdapter<String> adapter;
    public static String question="";
    //String[] listItem;
    RequestQueue rq;
    public String titl="",author="",credits="",sno="",mail="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discussion_forum);
        FloatingActionButton FAB = (FloatingActionButton) findViewById(R.id.fab);
        if(vj==1)
        {
            course=coursesdynamic.course;
        }
        else if(vj==0)
        {
            course=faccoursesdynamic.course;
        }
        FAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (vj==1){
                    Intent al = new Intent(discussion_forum.this, postananswer.class);
                    startActivity(al);}
                else if (vj==0){
                    Toast.makeText(discussion_forum.this, "You dont have access to this section", Toast.LENGTH_SHORT).show();

                }
            }
        });
        listView=(ListView)findViewById(R.id.listView);
        textView=(TextView)findViewById(R.id.textView);
        rq = Volley.newRequestQueue(this);
        sendRequest();
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, listItem);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                question  = ((TextView) view).getText().toString();
                Intent dbms = new Intent( discussion_forum.this,dfanswers.class);
                dbms.putExtra("course", course);
                startActivity(dbms);

            }
        });
    }
    public void sendRequest(){

        String request_url = freak+"api/getquestion?course="+course;
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, request_url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                for(int i = 0; i < response.length(); i++){

                    //Product personUtils = new Product();

                    try {
                        JSONObject jsonObject = response.getJSONObject(i);
                        titl=jsonObject.getString("question");
                        Log.v("h",titl);
                        // Product.getTitle(titl);
                        listItem.add(titl);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapter.notifyDataSetChanged();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("Volley Error: ", String.valueOf(error));
            }
        });

        rq.add(jsonArrayRequest);


    }

}


