package com.example.coursef;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

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

public class facformalfeedbackdisp extends AppCompatActivity {
    public ListView listView;
    public String freak=Second.url;
    public String email = loginscreen.emails;
    public static String ans1,ans2,ans3,course;
    TextView textView;
 public int hk=facformalfeedback.hk;
    public int ch=Component.choice;
    public String courses=facformalfeedback.course;
    List<String> listItem=new ArrayList<String>();
    ArrayAdapter<String> adapter;
    //String[] listItem;
    RequestQueue rq;
    public String titl="",author="",credits="",sno="",mail="", request_url="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facformalfeedbackdisp);
        listView=(ListView)findViewById(R.id.listView);
        textView=(TextView)findViewById(R.id.textView);
        rq = Volley.newRequestQueue(this);
        TextView txtProduct = (TextView) findViewById(R.id.coursename);
        String passedArg = getIntent().getExtras().getString("course");
        course=passedArg;
        // displaying selected product name
        txtProduct.setText(passedArg);
        sendRequest();
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, listItem);
        listView.setAdapter(adapter);

    }
    public void sendRequest(){
        if(hk==0){
         request_url = freak+"api/getfeedback?ques="+"q1"+"&coursename="+courses;}
        else if(hk==1){
            request_url = freak+"api/getfeedback?ques="+"q2"+"&coursename="+courses;
        }
        else if(hk==2){
            request_url = freak+"api/getfeedback?ques="+"q3"+"&coursename="+courses;
        }
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, request_url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                for(int i = 0; i < response.length(); i++){

                    //Product personUtils = new Product();

                    try {
                        JSONObject jsonObject = response.getJSONObject(i);
                        titl=jsonObject.getString("answer");
                        Log.v("h",titl);
                        // Product.getTitle(titl);
                        listItem.add(titl);
                        //jsonObject.getString("credits");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
                adapter.notifyDataSetChanged();


                //  mAdapter = new CustomRecyclerAdapter(MainActivity.this, personUtilsList);

                //recyclerView.setAdapter(mAdapter);

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
