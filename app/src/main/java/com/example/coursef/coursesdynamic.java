package com.example.coursef;

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

public class coursesdynamic extends AppCompatActivity {
    public ListView listView;
    public String email = loginscreen.emails;
    TextView textView;
    public String freak=Second.url;
    public int ch=Component.choice;
   public static String course="";
    List<String> listItem=new ArrayList<String>();
     ArrayAdapter<String> adapter;
    //String[] listItem;
    RequestQueue rq;
    public String titl="",author="",credits="",sno="",mail="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coursesdynamic);
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
                 course = ((TextView) view).getText().toString();
                if (position == 0) {
                    if(ch==2){
                    Intent dbms = new Intent( coursesdynamic.this, formalFeedback.class);
                    dbms.putExtra("course", course);
                    startActivity(dbms);}
                    else if(ch==1)
                    {
                        Intent dbms = new Intent( coursesdynamic.this, discussion_forum.class);
                        dbms.putExtra("course", course);
                        startActivity(dbms);

                    }

                    else if(ch==3)
                    {
                        Intent dbms = new Intent( coursesdynamic.this, htEmoticons.class);
                        dbms.putExtra("course", course);
                        startActivity(dbms);

                    }

                }
                else if (position == 1) {
                    if(ch==2){
                        Intent dbms = new Intent( coursesdynamic.this, formalFeedback.class);
                        dbms.putExtra("course", course);
                        startActivity(dbms);}
                    else if(ch==1)
                    {
                        Intent dbms = new Intent( coursesdynamic.this, discussion_forum.class);
                        dbms.putExtra("course", course);
                        startActivity(dbms);

                    }

                    else if(ch==3)
                    {
                        Intent dbms = new Intent( coursesdynamic.this, htEmoticons.class);
                        dbms.putExtra("course", course);
                        startActivity(dbms);

                    }
                }
                else if (position == 2) {
                    if(ch==2){
                        Intent dbms = new Intent( coursesdynamic.this, formalFeedback.class);
                        dbms.putExtra("course", course);
                        startActivity(dbms);}
                    else if(ch==1)
                    {
                        Intent dbms = new Intent( coursesdynamic.this, discussion_forum.class);
                        dbms.putExtra("course", course);
                        startActivity(dbms);

                    }

                    else if(ch==3)
                    {
                        Intent dbms = new Intent( coursesdynamic.this, htEmoticons.class);
                        dbms.putExtra("course", course);
                        startActivity(dbms);

                    }
                }
                else if (position == 3) {
                    if(ch==2){
                        Intent dbms = new Intent( coursesdynamic.this, formalFeedback.class);
                        dbms.putExtra("course", course);
                        startActivity(dbms);}
                    else if(ch==1)
                    {
                        Intent dbms = new Intent( coursesdynamic.this, discussion_forum.class);
                        dbms.putExtra("course", course);
                        startActivity(dbms);

                    }

                    else if(ch==3)
                    {
                        Intent dbms = new Intent( coursesdynamic.this, htEmoticons.class);
                        dbms.putExtra("course", course);
                        startActivity(dbms);

                    }
                }
                else if (position == 4) {
                    if(ch==2){
                        Intent dbms = new Intent( coursesdynamic.this, formalFeedback.class);
                        dbms.putExtra("course", course);
                        startActivity(dbms);}
                    else if(ch==1)
                    {
                        Intent dbms = new Intent( coursesdynamic.this, discussion_forum.class);
                        dbms.putExtra("course", course);
                        startActivity(dbms);

                    }

                    else if(ch==3)
                    {
                        Intent dbms = new Intent( coursesdynamic.this, htEmoticons.class);
                        dbms.putExtra("course", course);
                        startActivity(dbms);

                    }
                }
                else if (position == 5) {
                    if(ch==2){
                        Intent dbms = new Intent( coursesdynamic.this, formalFeedback.class);
                        dbms.putExtra("course", course);
                        startActivity(dbms);}
                    else if(ch==1)
                    {
                        Intent dbms = new Intent( coursesdynamic.this, discussion_forum.class);
                        dbms.putExtra("course", course);
                        startActivity(dbms);

                    }

                    else if(ch==3)
                    {
                        Intent dbms = new Intent( coursesdynamic.this, htEmoticons.class);
                        dbms.putExtra("course", course);
                        startActivity(dbms);

                    }
                }
                else if (position == 6) {
                    if(ch==2){
                        Intent dbms = new Intent( coursesdynamic.this, formalFeedback.class);
                        dbms.putExtra("course", course);
                        startActivity(dbms);}
                    else if(ch==1)
                    {
                        Intent dbms = new Intent( coursesdynamic.this, discussion_forum.class);
                        dbms.putExtra("course", course);
                        startActivity(dbms);

                    }

                    else if(ch==3)
                    {
                        Intent dbms = new Intent( coursesdynamic.this, htEmoticons.class);
                        dbms.putExtra("course", course);
                        startActivity(dbms);

                    }
                }
                else if (position == 7) {
                    if(ch==2){
                        Intent dbms = new Intent( coursesdynamic.this, formalFeedback.class);
                        dbms.putExtra("course", course);
                        startActivity(dbms);}
                    else if(ch==1)
                    {
                        Intent dbms = new Intent( coursesdynamic.this, discussion_forum.class);
                        dbms.putExtra("course", course);
                        startActivity(dbms);

                    }

                    else if(ch==3)
                    {
                        Intent dbms = new Intent( coursesdynamic.this, htEmoticons.class);
                        dbms.putExtra("course", course);
                        startActivity(dbms);

                    }
                }


            }
        });

    }
    public void sendRequest(){

        String request_url = freak+"api/getcourse?email="+email;
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, request_url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                for(int i = 0; i < response.length(); i++){

                    //Product personUtils = new Product();

                    try {
                        JSONObject jsonObject = response.getJSONObject(i);
                        titl=jsonObject.getString("coursename");
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
