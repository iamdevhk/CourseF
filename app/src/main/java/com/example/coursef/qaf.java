package com.example.coursef;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;



import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;



public class qaf extends AppCompatActivity {
    ProductAdapter adapter;
    //a list to store all the products
    public  String result="";
    public int hk=0;
    public List<Product> productList;
    public List<Product> productLists;
    //the recyclerview
    int id1=1;
    int r1=3;
    String dist="45";
    String query="";
    SearchView searchView;
    RecyclerView recyclerView;
    RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager layoutManager;
    // RequestQueue rq;
    public String titl="",author="",credits="",mail="";
    public int sno;
    //private qrDbHelper mDbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qaf);
        // To access our database, we instantiate our subclass of SQLiteOpenHelper
        // and pass the context, which is the current activity.
        //mDbHelper = new qrDbHelper(this);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        layoutManager = new LinearLayoutManager(this);
        //searchView = (SearchView) findViewById(R.id.searchView);
        recyclerView.setLayoutManager(layoutManager);
        //initializing the productlist
        //productList = new ArrayList<>();
        productLists = new ArrayList<>();
        //addsin();
        call();

    }
    public void addsin()
    {productList = new ArrayList<>();
        productList.add(
                new Product(
                        1,
                        "1.What is CourseF?",
                        "CourseF is an AEF (Assessment, Evaluation, Feedback) ,an online tool for creating, distributing, and managing digital course evaluation surveys. At university level, it is primarily for conducting end of semester and midterm course evaluations."
                ));
        productList.add(
                new Product(
                        2,
                        "2.When can I fill out my reviews?",
                        "In most instances, course evaluations will be released two weeks before the end of the semester. You will receive a notice when your course evaluations are available.    Some courses also conduct midterm evaluations in AEF. Midterm evaluations usually happen around weeks five to seven of the semester. You will be notified  when midterm evaluations are available."
                ));
        productList.add(
                new Product(
                        3,
                        "3.Where do I fill my evaluations?",
                        "Log into the CourseF app (Downloaded from playstore or https://CourseF.edu) with your ID credentials to fill out your course evaluations. Your courses can be found under your department and section respectively."
                ));
        productList.add(
                new Product(
                        4,
                        "4.I have logged into CourseF and why cant I find the evaluations for my courses?",
                        "Not all departments conduct their course evaluations at the same time period. Confirm with your instructor that you should be accessing your course evaluation in CourseF.If your instructor confirms that you should see the evaluation in CourseF or if you have received an notification stating that your evaluation is available in CourseF, clear your app cache and cookies and try logging in again. If you still don't see the evaluation, contact the  Help Desk at CourseFoffc@gmail.com."
                )

        );
        productList.add(
                new Product(
                        5,
                        "5.I have completed my course evaluation but why cant I submit it?" ,
                        "Questions marked by a red asterisk are required. You will not be able to submit your survey until you have answered all of the required questions.If you have answered all of the required questions and are still unable to submit, try clearing your app cache and cookies . You may want to copy your evaluation responses into a blank document before clearing your cache, to ensure that you don't lose your work. And if the issue still persists then please contact the Help Desk at CourseFoffc@gmail.com."
                )
        );
        productList.add(
                new Product(
                        6,
                        "6.I have submitted my evaluation to a wrong course, how do iI delete it?" ,
                        "Only CourseF administrators can delete survey responses once they have been submitted. If you have submitted a survey response in error, contact the Help Desk at CourseFoffc@gmail.com."
                )
        );
        productList.add(
                new Product(
                        7,
                        "7.Are CourseF evaluations anonymous?" ,
                        "Yes, CourseF course evaluation responses are anonymous to instructors.However, keep in mind these limits to anonymity\n" +
                                "If you provide identifying information in comment fields, your instructor will be able to see it.\n" +
                                "CourseF survey results are aggregated by course section. If you are in a very small course section, your instructor may be able to determine who submitted which evaluation.\n" +
                                "Your name will be attached to your survey on the back-end and can be viewed by CourseF admins. However, CourseF admins will not access your survey results without due cause.\""
                )
        );
        productList.add(
                new Product(
                        8,
                        "8.When will my instructor see my evaluations?" ,
                        "Your instructor will not be able to view results from end-of-term evaluations until after final grades have been submitted. In most instances, they will also have to wait until final grades have been submitted to view midterm evaluation results."
                )
        );

    }




    public void call(){
        addsin();
        adapter = new ProductAdapter(this, productList);
        // Log.v("kk",productList.get(0).getTitle());
        //setting adapter to recyclerview
        recyclerView.setAdapter(adapter);

    }

}
