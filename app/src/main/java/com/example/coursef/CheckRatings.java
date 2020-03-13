package com.example.coursef;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.SearchView;

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

public class CheckRatings extends AppCompatActivity {
    RatingAdapter adapter;
    //a list to store all the products
    public List<ratings> productList;
    public List<ratings> productLists;
    //the recyclerview
    public int vj = Second.user;
    public String freak=Second.url;
    int id1=1;
    int r1=3;
    public String email = loginscreen.emails;
    String dist="45";
    String query="";
    SearchView searchView;
    RecyclerView recyclerView;
    RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager layoutManager;
    RequestQueue rq;
    public String titl="",author="",credits="",sno="",mail="",rating="",request_url="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_ratings);
        rq = Volley.newRequestQueue(this);
        //getting the recyclerview from xml
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        layoutManager = new LinearLayoutManager(this);
        //searchView = (SearchView) findViewById(R.id.searchView);
        recyclerView.setLayoutManager(layoutManager);
        //initializing the productlist
        //productList = new ArrayList<>();
        productLists = new ArrayList<>();
        call();
    }



    public void sendRequest(){
        productList = new ArrayList<ratings>();
        if(vj==1){
         request_url = freak+"api/checkrating?email="+email;}
        else if(vj==0)
        {
            request_url = freak+"api/checkratingFac?email="+email;

        }
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
                        //sno=jsonObject.getString("sno");
                        rating=jsonObject.getString("rating");

                        productList.add(
                                new ratings(
                                        String.valueOf(i),
                                        titl,
                                        rating
                                        ));
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
    public void call(){
        sendRequest();
        adapter = new RatingAdapter(this, productList);
        // Log.v("kk",productList.get(0).getTitle());
        //setting adapter to recyclerview
        recyclerView.setAdapter(adapter);

    }
}